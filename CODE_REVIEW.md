# Code Review: Phần Mềm Quản Lý Cửa Hàng Kính (QLCHK)

**Reviewer:** Hermes Agent  
**Branch:** `main`  
**Date:** 2026-06-14  
**Focus:** Scalability, architecture, security, and production-readiness

---

## Verdict

**MAJOR RESTRUCTURE REQUIRED** — the project is in an early/prototype stage (~15% complete) and is not production-ready at any scale. The entity modeling shows good domain understanding, but critical gaps in security, architecture layering, database access patterns, and frontend completeness must be addressed before scaling.

---

## 🔴 Critical Issues

### 1. Hardcoded Database Credentials
**File:** [`application.properties`](src/main/resources/application.properties#L5-L6)
```properties
spring.datasource.username=sa
spring.datasource.password=123
```
- **Impact:** Blocks multi-environment deployment (dev/staging/prod). Requires recompilation to change environments.
- **Fix:** Use environment variables with Spring's `${...}` syntax.

### 2. Vietnamese Hardcoded in SQL
**File:** [`HoaDonRepo.java`](src/main/java/qlchkinh/demo/repo/HoaDonRepo.java#L17)
```sql
WHERE Status = N'Đã thanh toán'
```
- **Impact:** If status text changes in DB, query silently breaks. Blocks internationalization.
- **Fix:** Use enum constants (e.g., `PAID`, `PENDING`, `CANCELLED`).

### 3. No Authentication
**File:** [`AccountController.java`](src/main/java/qlchkinh/demo/controller/AccountController.java#L19-L27)
- Login endpoint accepts username+password, adds username to model, **does nothing else**. No session, no Spring Security, no password hashing.
- `NguoiDungRepo.findByUsernameAndPasswordHash` implies hashing but doesn't implement it.
- **Impact:** Complete lack of user isolation. Cannot support multi-store/multi-role scaling.

### 4. Copy-Paste Contamination from Car Project
**File:** [`khachhang.html`](src/main/resources/templates/khachhang.html#L22-L31)
```html
<tr th:each="c : ${xe}">       <!-- "xe" = car, not customer -->
    <td th:text="${c.maXe}">    <!-- car ID -->
    <td th:text="${c.tenXe}">   <!-- car name -->
    <td th:text="${c.mauSac}">  <!-- color -->
    <td th:text="${c.NSX}">     <!-- manufacturer -->
    <td th:text="${c.giaBan}">  <!-- price -->
    <td th:text="${c.maHangXe}"><!-- brand ID -->
```
- Fields do not match `KhachHang` entity at all (`fullName`, `phone`, `email`, `address`, `createdAt`).
- **Impact:** This bug multiplies if templates are copied further.

---

## 🏗️ Architecture & Layering

### 5. Missing Service Layer
- **Current:** Controller → Repository (direct). **No `@Service` classes exist.**
- `DashboardController` is an **empty class** with no methods (`DashboardController.java:1-4`).
- No `@Transactional` boundary management.
- **Scalability impact:** No place for business logic, caching, async processing, or event publishing.

**Needed architecture:**
```
Controller → Service (@Transactional) → Repository
                        ↓
                   DTO / Mapper
```

### 6. No REST API — Monolithic Server Rendering
- All UI is server-side Thymeleaf (full page reloads).
- Frontend and backend are inseparable.
- No API for mobile apps, POS systems, or third-party integrations.
- Cannot independently scale read vs write traffic.

**Fix for scale:**
```java
@RestController
@RequestMapping("/api/v1/products")
public class ProductApiController {
    @GetMapping
    public ResponseEntity<Page<ProductDTO>> getProducts(...) { }
}
```

### 7. No Pagination
- Every repository query returns `List<T>` — unbounded.
- **Affected:** `SanPhamRepo`, `HoaDonRepo`, `EyeMeasurementRepo`, `InventoryTransactionRepo`, `KhachHangRepo`
- **Impact:** With 10,000+ products/customers/invoices, every list query loads ALL rows into memory → OOM at scale.

**Fix:**
```java
Page<SanPham> findByProductNameContainingIgnoreCase(String name, Pageable pageable);
```

### 8. DTO.java is Dead Code
**File:** [`DTO.java`](src/main/java/qlchkinh/demo/model/DTO.java)
- Defines aggregation fields (`tongDoanhThu`, `tongHoaDon`, etc.) but is **never referenced** anywhere in the codebase.

---

## 💾 Data Layer

### 9. No Database Schema / Migrations
- No `schema.sql`, no Flyway/Liquibase migrations.
- `spring.jpa.hibernate.ddl-auto=none` — schema must be created manually.
- **Impact:** Every environment deployment requires manual DB setup. No version-controlled schema history.

### 10. Inefficient Search
- `findByProductNameContainingIgnoreCase` → `WHERE LOWER(name) LIKE LOWER(CONCAT('%', ?, '%'))`: **Full table scan** on every search.
- **Fix:** Full-text indexes (`CREATE FULLTEXT INDEX ...`) or dedicated search engine.

### 11. Lazy Loading N+1 Risk
- `@ManyToOne` associations use default `FetchType.LAZY`.
- No `@EntityGraph` or `JOIN FETCH` in queries.
- **Impact:** Each list view generates N extra queries (N = number of rows).

---

## 🎨 Presentation Layer

### 12. 5/8 Templates Empty
| Template | Status |
|---|---|
| `login.html` | ✅ Functional |
| `dashboard.html` | ⚠️ Buttons only, no data |
| `khachhang.html` | ❌ Copied from car project |
| `sanpham.html` | ❌ Empty |
| `hoadon.html` | ❌ Empty |
| `kho.html` | ❌ Empty |
| `baocao.html` | ❌ Empty |
| `nhacungcap.html` | ❌ Empty |
| `chatbot.html` | ❌ Empty |

### 13. No Layout Reuse
- No Thymeleaf Layout Dialect or fragment reuse.

---

## ⚙️ Configuration & Deployment

### 14. No Profile-Based Config
- Single `application.properties` — no `application-dev.properties`, `application-prod.properties`.

### 15. SQL Server Lock-In
- Native queries (`nativeQuery=true`) bypass Hibernate dialect abstraction.
- Switching DB (PostgreSQL, MySQL, Azure SQL) requires rewriting every query.

### 16. No Connection Pool Tuning
- Default HikariCP settings (max pool = 10) are too small for concurrent users.
- Missing: `spring.datasource.hikari.maximum-pool-size`, `minimum-idle`, `connection-timeout`.

### 17. No Application Logging
- Only Hibernate SQL logging is configured. No SLF4J, no log rotation, no structured logging.

---

## 🧪 Testing

### 18. Single Stub Test
- `QlchkApplicationTests.contextLoads()` — the default Spring Boot starter.
- **No unit, integration, or repository tests.**
- **Impact:** Cannot refactor or scale code that can't be tested.

---

## 📋 Prioritized Action Plan

### Phase 1: Foundation (Blockers)
| Priority | Action | Files |
|---|---|---|
| 🔴 P0 | Rewrite `khachhang.html` with correct `KhachHang` fields | `khachhang.html` |
| 🔴 P0 | Add Spring Security (auth + password hashing) | New: `SecurityConfig`, `UserDetailsService` |
| 🔴 P0 | Externalize credentials to env vars | `application.properties` |

### Phase 2: Architecture (For Scalability)
| Priority | Action | Files |
|---|---|---|
| 🟠 P1 | Add Service layer with `@Transactional` | New package: `service/` |
| 🟠 P1 | Add pagination to all repository queries | All `*Repo.java` |
| 🟠 P1 | Replace Vietnamese status strings with enums | `HoaDonRepo`, `SanPham` |
| 🟠 P1 | Add Flyway for DB migration management | New: `db/migration/` |
| 🟠 P1 | Add caching (Caffeine/Redis) | Config + `@Cacheable` |

### Phase 3: API & Frontend
| Priority | Action |
|---|---|
| 🟡 P2 | Add REST API controllers (JSON, paginated) |
| 🟡 P2 | Extract frontend to SPA or add HTMX |
| 🟡 P2 | Add full-text search indexes |
| 🟡 P2 | Async report generation (`@Async`) |

### Phase 4: Operations
| Priority | Action |
|---|---|
| 🟢 P3 | Profile-based config (dev/staging/prod) |
| 🟢 P3 | Connection pool tuning |
| 🟢 P3 | Structured logging (SLF4J + Logback JSON) |
| 🟢 P3 | Health checks + metrics (Actuator + Micrometer) |
| 🟢 P3 | Integration tests for all layers |
| 🟢 P3 | `docker-compose.yml` for local dev |

---

## 📊 Scalability Scorecard

| Dimension | Current State | Target State |
|---|---|---|
| **Architecture** | Monolithic, 2 layers | Clean 4-layer (Controller → Service → Repository → DB) |
| **API** | None (server-only Thymeleaf) | RESTful JSON, versioned (`/api/v1/`) |
| **Pagination** | ❌ Unbounded list queries | `Pageable` on all list endpoints |
| **Search** | `LIKE %value%` (FTS) | Full-text index or Elasticsearch |
| **Caching** | ❌ None | Redis for hot data, HTTP caching for static |
| **Async** | ❌ All synchronous | `@Async` for reports, chatbot, exports |
| **Auth** | ❌ Plaintext, no sessions | Spring Security + JWT + role-based access |
| **DB** | Hardcoded SQL Server, no migrations | Flyway, portable JPA queries, connection pooling |
| **Config** | Single file, hardcoded secrets | Env-based profiles, externalized secrets |
| **Testing** | 1 stub test | Unit + integration + API contract tests |
| **Frontend** | Monolithic Thymeleaf | SPA or HTMX, API-driven |

---

*Reviewed by Hermes Agent*

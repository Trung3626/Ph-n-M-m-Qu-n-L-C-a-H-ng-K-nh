package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.HoaDon;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon, Integer> {
    List<HoaDon> findByStatus(String status);
    @Query(value = """
            SELECT COALESCE(SUM(FinalAmount), 0)
            FROM Invoices
            WHERE Status = N'Đã thanh toán'
            """, nativeQuery = true)
    BigDecimal getTongDoanhThu();
}

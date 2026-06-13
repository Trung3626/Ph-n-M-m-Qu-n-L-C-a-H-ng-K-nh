package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.SanPham;

import java.util.List;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, Integer> {
    List<SanPham> findByProductNameContainingIgnoreCase(String productName);
    List<SanPham> findByStatus(String status);
    @Query(value = """
            SELECT COUNT(*)
            FROM Products
            WHERE Quantity <= MinQuantity
            """, nativeQuery = true)
    Long demSanPhamSapHet();
    @Query(value = """
            SELECT *
            FROM Products
            WHERE Quantity <= MinQuantity
            ORDER BY Quantity ASC
            """, nativeQuery = true)
    List<SanPham> getSanPhamSapHet();
}
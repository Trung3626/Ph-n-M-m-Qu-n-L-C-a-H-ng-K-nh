package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.SanPham;

@Repository
public interface SanPhamRepo extends JpaRepository<SanPham, Integer> {
}
package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.KhachHang;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang, Integer> {
}
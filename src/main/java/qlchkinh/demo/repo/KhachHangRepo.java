package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.KhachHang;

import java.util.List;

@Repository
public interface KhachHangRepo extends JpaRepository<KhachHang, Integer> {
    List<KhachHang> findByFullNameContainingIgnoreCase(String fullName);
    KhachHang findByPhone(String phone);
}
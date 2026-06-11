package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.LoaiKinh;

@Repository
public interface LoaiKinhRepo extends JpaRepository<LoaiKinh, Integer> {
}

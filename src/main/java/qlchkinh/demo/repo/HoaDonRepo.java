package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.HoaDon;

@Repository
public interface HoaDonRepo extends JpaRepository<HoaDon, Integer> {
}

package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.NhaCungCap;

@Repository
public interface NhaCungCapRepo extends JpaRepository<NhaCungCap, Integer> {
}

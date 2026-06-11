package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.CTHD;

@Repository
public interface CTHDRepo extends JpaRepository<CTHD, Integer> {
}

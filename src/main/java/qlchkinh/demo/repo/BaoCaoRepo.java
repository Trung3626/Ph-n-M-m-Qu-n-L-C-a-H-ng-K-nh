package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.BaoCao;

@Repository
public interface BaoCaoRepo extends JpaRepository<BaoCao, Integer> {
}

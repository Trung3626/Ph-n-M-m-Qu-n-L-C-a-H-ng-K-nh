package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.VaiTro;

@Repository
public interface VaiTroRepo extends JpaRepository<VaiTro, Integer> {

}

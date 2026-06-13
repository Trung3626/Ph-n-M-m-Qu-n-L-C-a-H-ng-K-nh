package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.NguoiDung;

@Repository
public interface NguoiDungRepo extends JpaRepository<NguoiDung, Integer> {
    NguoiDung findByUsernameAndPasswordHash(String username, String passwordHash);
    NguoiDung findByUsername(String username);
}

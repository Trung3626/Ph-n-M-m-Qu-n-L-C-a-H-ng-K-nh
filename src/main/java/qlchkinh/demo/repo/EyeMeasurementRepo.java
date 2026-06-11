package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.EyeMeasurement;

@Repository
public interface EyeMeasurementRepo extends JpaRepository<EyeMeasurement, Integer> {
}

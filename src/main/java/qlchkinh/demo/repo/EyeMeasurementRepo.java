package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.EyeMeasurement;

import java.util.List;

@Repository
public interface EyeMeasurementRepo extends JpaRepository<EyeMeasurement, Integer> {
    @Query(value = """
            SELECT *
            FROM EyeMeasurements
            WHERE CustomerID = ?1
            ORDER BY MeasurementDate DESC
            """, nativeQuery = true)
    List<EyeMeasurement> findByCustomerID(Integer customerID);
}

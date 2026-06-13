package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.CTHD;

import java.util.List;

@Repository
public interface CTHDRepo extends JpaRepository<CTHD, Integer> {
    @Query(value = """
            SELECT *
            FROM InvoiceDetails
            WHERE InvoiceID = ?1
            """, nativeQuery = true)
    List<CTHD> findByInvoiceID(Integer invoiceID);
}

package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.InventoryTransaction;

import java.util.List;

@Repository
public interface InventoryTransactionRepo extends JpaRepository<InventoryTransaction, Integer> {
    @Query(value = """
            SELECT *
            FROM InventoryTransactions
            WHERE ProductID = ?1
            ORDER BY CreatedAt DESC
            """, nativeQuery = true)
    List<InventoryTransaction> findByProductID(Integer productID);
}
package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.InventoryTransaction;

@Repository
public interface InventoryTransactionRepo extends JpaRepository<InventoryTransaction, Integer> {
}
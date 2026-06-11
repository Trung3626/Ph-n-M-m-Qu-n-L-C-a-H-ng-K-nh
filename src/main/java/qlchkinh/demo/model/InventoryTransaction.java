package qlchkinh.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "InventoryTransactions")
public class InventoryTransaction {
    @Id
    @Column(name = "TransactionID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer transactionID;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false)
    private SanPham sanPham;

    @Column(name = "TransactionType", nullable = false)
    private String transactionType;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Note")
    private String note;

    @Column(name = "CreatedAt")
    private Integer createdAt;

    @Override
    public String toString() {
        return "InventoryTransaction{" +
                "transactionID=" + transactionID +
                ", sanPham=" + sanPham +
                ", transactionType='" + transactionType + '\'' +
                ", quantity=" + quantity +
                ", note='" + note + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

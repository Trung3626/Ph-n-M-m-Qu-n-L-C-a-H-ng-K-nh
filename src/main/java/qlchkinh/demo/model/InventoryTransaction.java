package qlchkinh.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "InventoryTransactions")
public class InventoryTransaction {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TransactionID")
    private Integer transactionID;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false)
    private SanPham sanPham;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private NguoiDung nguoiDung;

    @Column(name = "TransactionType", nullable = false)
    private String transactionType;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "Note")
    private String note;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "InventoryTransaction{" +
                "transactionID=" + transactionID +
                ", productID=" + (sanPham != null ? sanPham.getProductID() : null) +
                ", userID=" + (nguoiDung != null ? nguoiDung.getUserID() : null) +
                ", transactionType='" + transactionType + '\'' +
                ", quantity=" + quantity +
                ", note='" + note + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

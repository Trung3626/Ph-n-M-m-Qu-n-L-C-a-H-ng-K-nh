package qlchkinh.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Products")
public class SanPham {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ProductID")
    private Integer productID;

    @Column(name = "ProductName", nullable = false)
    private String productName;

    @ManyToOne
    @JoinColumn(name = "CategoryID", nullable = false)
    private LoaiKinh loaiKinh;

    @ManyToOne
    @JoinColumn(name = "SupplierID")
    private NhaCungCap nhaCungCap;

    @Column(name = "Brand")
    private String brand;

    @Column(name = "ImportPrice", precision = 18, scale = 2)
    private BigDecimal importPrice = BigDecimal.ZERO;

    @Column(name = "SellingPrice", nullable = false, precision = 18, scale = 2)
    private BigDecimal sellingPrice;

    @Column(name = "Quantity")
    private Integer quantity = 0;

    @Column(name = "MinQuantity")
    private Integer minQuantity = 5;

    @Column(name = "ImageURL")
    private String imageURL;

    @Column(name = "Description", columnDefinition = "NVARCHAR(MAX)")
    private String description;

    @Column(name = "Status")
    private String status;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Column(name = "UpdatedAt")
    private LocalDateTime updatedAt;

    @Override
    public String toString() {
        return "SanPham{" +
                "productID=" + productID +
                ", productName='" + productName + '\'' +
                ", categoryID=" + (loaiKinh != null ? loaiKinh.getCategoryID() : null) +
                ", supplierID=" + (nhaCungCap != null ? nhaCungCap.getSupplierID() : null) +
                ", brand='" + brand + '\'' +
                ", importPrice=" + importPrice +
                ", sellingPrice=" + sellingPrice +
                ", quantity=" + quantity +
                ", minQuantity=" + minQuantity +
                ", imageURL='" + imageURL + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                ", createdAt=" + createdAt +
                ", updatedAt=" + updatedAt +
                '}';
    }
}

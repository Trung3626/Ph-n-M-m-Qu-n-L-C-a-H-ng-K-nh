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
@Table(name = "Products")
public class SanPham {
    @Id
    @Column(name = "ProductID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "Price", nullable = false)
    private Integer price;

    @Column(name = "Quantity")
    private Integer quantity = 0;

    @Column(name = "ImageURL")
    private String imageURL;

    @Column(name = "Description")
    private String description;

    @Column(name = "Status")
    private String status;

    @Column(name = "CreatedAt")
    private Integer createdAt;
}

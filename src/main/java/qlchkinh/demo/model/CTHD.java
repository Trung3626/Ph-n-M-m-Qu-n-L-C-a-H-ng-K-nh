package qlchkinh.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "InvoiceDetails")
public class CTHD {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InvoiceDetailID")
    private Integer invoiceDetailID;

    @ManyToOne
    @JoinColumn(name = "InvoiceID", nullable = false)
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false)
    private SanPham sanPham;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "UnitPrice", nullable = false, precision = 18, scale = 2)
    private BigDecimal unitPrice;

    @Column(name = "Subtotal", nullable = false, precision = 18, scale = 2)
    private BigDecimal subtotal;

    @Override
    public String toString() {
        return "CTHD{" +
                "invoiceDetailID=" + invoiceDetailID +
                ", invoiceID=" + (hoaDon != null ? hoaDon.getInvoiceID() : null) +
                ", productID=" + (sanPham != null ? sanPham.getProductID() : null) +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", subtotal=" + subtotal +
                '}';
    }
}

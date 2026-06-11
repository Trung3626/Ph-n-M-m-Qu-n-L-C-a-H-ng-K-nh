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
@Table(name = "InvoiceDetails")
public class CTHD {
    @Id
    @Column(name = "InvoiceDetailID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceDetailID;

    @ManyToOne
    @JoinColumn(name = "InvoiceID", nullable = false)
    private HoaDon hoaDon;

    @ManyToOne
    @JoinColumn(name = "ProductID", nullable = false)
    private SanPham sanPham;

    @Column(name = "Quantity", nullable = false)
    private Integer quantity;

    @Column(name = "UnitPrice", nullable = false)
    private Integer unitPrice;

    @Column(name = "Subtotal", nullable = false)
    private Integer subtotal;

    @Override
    public String toString() {
        return "CTHD{" +
                "invoiceDetailID=" + invoiceDetailID +
                ", hoaDon=" + hoaDon +
                ", sanPham=" + sanPham +
                ", quantity=" + quantity +
                ", unitPrice=" + unitPrice +
                ", subtotal=" + subtotal +
                '}';
    }
}

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
@Table(name = "Invoices")
public class HoaDon {
    @Id
    @Column(name = "InvoiceID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceID;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private NguoiDung nguoiDung;

    @Column(name = "InvoiceDate")
    private Integer invoiceDate;

    @Column(name = "TotalAmount")
    private Integer totalAmount = 0;

    @Column(name = "DiscountPercent")
    private Integer discountPercent = 0;

    @Column(name = "FinalAmount")
    private Integer finalAmount = 0;

    @Column(name = "PaymentMethod")
    private String paymentMethod;

    @Column(name = "Status")
    private String status;

    @Override
    public String toString() {
        return "HoaDon{" +
                "invoiceID=" + invoiceID +
                ", khachHang=" + khachHang +
                ", nguoiDung=" + nguoiDung +
                ", invoiceDate=" + invoiceDate +
                ", totalAmount=" + totalAmount +
                ", discountPercent=" + discountPercent +
                ", finalAmount=" + finalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}

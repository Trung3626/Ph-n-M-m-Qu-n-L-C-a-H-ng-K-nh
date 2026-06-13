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
@Table(name = "Invoices")
public class HoaDon {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "InvoiceID")
    private Integer invoiceID;

    @ManyToOne
    @JoinColumn(name = "CustomerID")
    private KhachHang khachHang;

    @ManyToOne
    @JoinColumn(name = "UserID", nullable = false)
    private NguoiDung nguoiDung;

    @Column(name = "InvoiceDate")
    private LocalDateTime invoiceDate;

    @Column(name = "TotalAmount", precision = 18, scale = 2)
    private BigDecimal totalAmount = BigDecimal.ZERO;

    @Column(name = "DiscountPercent", precision = 5, scale = 2)
    private BigDecimal discountPercent = BigDecimal.ZERO;

    @Column(name = "DiscountAmount", precision = 18, scale = 2)
    private BigDecimal discountAmount = BigDecimal.ZERO;

    @Column(name = "FinalAmount", precision = 18, scale = 2)
    private BigDecimal finalAmount = BigDecimal.ZERO;

    @Column(name = "PaymentMethod")
    private String paymentMethod;

    @Column(name = "Status")
    private String status;

    @Override
    public String toString() {
        return "HoaDon{" +
                "invoiceID=" + invoiceID +
                ", customerID=" + (khachHang != null ? khachHang.getCustomerID() : null) +
                ", userID=" + (nguoiDung != null ? nguoiDung.getUserID() : null) +
                ", invoiceDate=" + invoiceDate +
                ", totalAmount=" + totalAmount +
                ", discountPercent=" + discountPercent +
                ", discountAmount=" + discountAmount +
                ", finalAmount=" + finalAmount +
                ", paymentMethod='" + paymentMethod + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
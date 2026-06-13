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
@Table(name = "EyeMeasurements")
public class EyeMeasurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "MeasurementID")
    private Integer measurementID;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private KhachHang khachHang;

    @Column(name = "LeftSphere", precision = 4, scale = 2)
    private BigDecimal leftSphere;

    @Column(name = "RightSphere", precision = 4, scale = 2)
    private BigDecimal rightSphere;

    @Column(name = "LeftCylinder", precision = 4, scale = 2)
    private BigDecimal leftCylinder;

    @Column(name = "RightCylinder", precision = 4, scale = 2)
    private BigDecimal rightCylinder;

    @Column(name = "LeftAxis")
    private Integer leftAxis;

    @Column(name = "RightAxis")
    private Integer rightAxis;

    @Column(name = "PD", precision = 5, scale = 2)
    private BigDecimal pd;

    @Column(name = "Note")
    private String note;

    @Column(name = "MeasurementDate")
    private LocalDateTime measurementDate;

    @Override
    public String toString() {
        return "EyeMeasurement{" +
                "measurementID=" + measurementID +
                ", customerID=" + (khachHang != null ? khachHang.getCustomerID() : null) +
                ", leftSphere=" + leftSphere +
                ", rightSphere=" + rightSphere +
                ", leftCylinder=" + leftCylinder +
                ", rightCylinder=" + rightCylinder +
                ", leftAxis=" + leftAxis +
                ", rightAxis=" + rightAxis +
                ", pd=" + pd +
                ", note='" + note + '\'' +
                ", measurementDate=" + measurementDate +
                '}';
    }
}

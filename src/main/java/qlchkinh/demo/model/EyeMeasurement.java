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
@Table(name = "EyeMeasurements ")
public class EyeMeasurement {
    @Id
    @Column(name = "MeasurementID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer measurementID;

    @ManyToOne
    @JoinColumn(name = "CustomerID", nullable = false)
    private KhachHang khachHang;

    @Column(name = "LeftEyeNearSight")
    private Integer leftEyeNearSight;

    @Column(name = "RightEyeNearSight")
    private Integer rightEyeNearSight;

    @Column(name = "LeftEyeAstigmatism")
    private Integer leftEyeAstigmatism;

    @Column(name = "RightEyeAstigmatism")
    private Integer rightEyeAstigmatism;

    @Column(name = "LeftEyeFarSight")
    private Integer leftEyeFarSight;

    @Column(name = "RightEyeFarSight")
    private Integer rightEyeFarSight;

    @Column(name = "MeasurementDate")
    private Integer measurementDate;

    @Override
    public String toString() {
        return "EyeMeasurement{" +
                "measurementID=" + measurementID +
                ", khachHang=" + khachHang +
                ", leftEyeNearSight=" + leftEyeNearSight +
                ", rightEyeNearSight=" + rightEyeNearSight +
                ", leftEyeAstigmatism=" + leftEyeAstigmatism +
                ", rightEyeAstigmatism=" + rightEyeAstigmatism +
                ", leftEyeFarSight=" + leftEyeFarSight +
                ", rightEyeFarSight=" + rightEyeFarSight +
                ", measurementDate=" + measurementDate +
                '}';
    }
}

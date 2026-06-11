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
@Table(name = "Reports")
public class BaoCao {
    @Id
    @Column(name = "ReportID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer reportID;

    @Column(name = "ReportName")
    private String reportName;

    @Column(name = "ReportType")
    private String reportType;

    @Column(name = "GeneratedDate")
    private Integer generatedDate;

    @Override
    public String toString() {
        return "BaoCao{" +
                "reportID=" + reportID +
                ", reportName='" + reportName + '\'' +
                ", reportType='" + reportType + '\'' +
                ", generatedDate=" + generatedDate +
                '}';
    }
}



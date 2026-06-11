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
@Table(name = "Categories")
public class LoaiKinh {
    @Id
    @Column(name = "CategoryID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer cateID;

    @Column(name = "CategoryName", nullable = false)
    private String cateName;

    @Override
    public String toString() {
        return "LoaiKinh{" +
                "cateID=" + cateID +
                ", cateName='" + cateName + '\'' +
                '}';
    }
}

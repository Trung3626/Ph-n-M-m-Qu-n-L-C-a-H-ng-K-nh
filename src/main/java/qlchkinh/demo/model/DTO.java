package qlchkinh.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DTO {
    private BigDecimal tongDoanhThu;
    private Long tongHoaDon;
    private Long tongKhachHang;
    private Long sanPhamSapHet;
}

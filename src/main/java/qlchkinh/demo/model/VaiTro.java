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
@Table(name = "Roles")
public class VaiTro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RoleID")
    private Integer roleID;

    @Column(name = "RoleName", nullable = false, unique = true)
    private String roleName;

    @Override
    public String toString() {
        return "VaiTro{" +
                "roleID=" + roleID +
                ", roleName='" + roleName + '\'' +
                '}';
    }
}

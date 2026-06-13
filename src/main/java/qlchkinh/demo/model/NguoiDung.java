package qlchkinh.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Users")
public class NguoiDung {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "UserID")
    private Integer userID;

    @Column(name = "Username", nullable = false, unique = true)
    private String username;

    @Column(name = "PasswordHash", nullable = false)
    private String passwordHash;

    @Column(name = "FullName", nullable = false)
    private String fullName;

    @Column(name = "Email")
    private String email;

    @Column(name = "Phone")
    private String phone;

    @ManyToOne
    @JoinColumn(name = "RoleID", nullable = false)
    private VaiTro vaiTro;

    @Column(name = "IsActive")
    private Boolean isActive = true;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "NguoiDung{" +
                "userID=" + userID +
                ", username='" + username + '\'' +
                ", fullName='" + fullName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", roleID=" + (vaiTro != null ? vaiTro.getRoleID() : null) +
                ", isActive=" + isActive +
                ", createdAt=" + createdAt +
                '}';
    }
}
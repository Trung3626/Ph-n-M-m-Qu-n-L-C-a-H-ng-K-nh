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
@Table(name = "ChatbotLogs")
public class ChatbotLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ChatID")
    private Integer chatID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private NguoiDung nguoiDung;

    @Column(name = "Question", columnDefinition = "NVARCHAR(MAX)")
    private String question;

    @Column(name = "Response", columnDefinition = "NVARCHAR(MAX)")
    private String response;

    @Column(name = "CreatedAt")
    private LocalDateTime createdAt;

    @Override
    public String toString() {
        return "ChatbotLog{" +
                "chatID=" + chatID +
                ", userID=" + (nguoiDung != null ? nguoiDung.getUserID() : null) +
                ", question='" + question + '\'' +
                ", response='" + response + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

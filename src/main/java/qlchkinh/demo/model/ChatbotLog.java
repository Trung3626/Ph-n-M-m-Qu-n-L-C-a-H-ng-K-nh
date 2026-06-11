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
@Table(name = "ChatbotLogs")
public class ChatbotLog {
    @Id
    @Column(name = "ChatID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer chatID;

    @ManyToOne
    @JoinColumn(name = "UserID")
    private NguoiDung nguoiDung;

    @Column(name = "Question")
    private String question;

    @Column(name = "Response")
    private String response;

    @Column(name = "CreatedAt")
    private Integer createdAt;

    @Override
    public String toString() {
        return "ChatbotLog{" +
                "chatID=" + chatID +
                ", nguoiDung=" + nguoiDung +
                ", question='" + question + '\'' +
                ", response='" + response + '\'' +
                ", createdAt=" + createdAt +
                '}';
    }
}

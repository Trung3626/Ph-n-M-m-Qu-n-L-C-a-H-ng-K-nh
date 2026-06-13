package qlchkinh.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import qlchkinh.demo.model.ChatbotLog;

@Repository
public interface ChatbotLogRepo extends JpaRepository<ChatbotLog, Integer> {

}

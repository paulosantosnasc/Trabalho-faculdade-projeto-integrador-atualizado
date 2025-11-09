package repository;

import org.springframework.data.jpa.repository.JpaRepository;
import model.ChatMensagem;

public interface ChatMensagemRepository extends JpaRepository<ChatMensagem, Integer> { }

package com.smoly.chatapi.repository;

import com.smoly.chatapi.entity.ChatMessage;
import com.smoly.chatapi.entity.MessageId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatMessageRepository extends JpaRepository<ChatMessage, MessageId> {

}

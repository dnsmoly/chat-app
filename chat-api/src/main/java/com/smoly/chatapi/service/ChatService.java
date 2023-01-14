package com.smoly.chatapi.service;

import com.smoly.chatapi.entity.Chat;
import com.smoly.chatapi.repository.ChatRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public boolean existsById(long id) {
        return chatRepository.existsById(id);
    }

    public Chat saveWithExistsCheck(Chat chat) {
        if (!existsById(chat.getId())) {
            return chatRepository.save(chat);
        }
        return chat;
    }

    public Chat save(Chat chat) {
        return chatRepository.save(chat);
    }
}

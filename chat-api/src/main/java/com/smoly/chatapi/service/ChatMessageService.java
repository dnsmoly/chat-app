package com.smoly.chatapi.service;

import com.smoly.chatapi.dto.ChatMessageDto;
import com.smoly.chatapi.entity.Chat;
import com.smoly.chatapi.entity.ChatMessage;
import com.smoly.chatapi.entity.MessageId;
import com.smoly.chatapi.entity.User;
import com.smoly.chatapi.repository.ChatMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ChatMessageService {

    private final ChatMessageRepository chatMessageRepository;
    private final ChatService chatService;
    private final UserService userService;

    @Transactional
    public ChatMessage save(ChatMessageDto messageDto) {
        Chat chat = new Chat()
                .setId(messageDto.getChatId());
        chat = chatService.saveWithExistsCheck(chat);

        User user = new User()
                .setId(messageDto.getUser().getId())
                .setUsername(messageDto.getUser().getUsername());
        user = userService.saveWithExistsCheck(user);

        ChatMessage message = new ChatMessage()
                .setMessageId(new MessageId()
                        .setMessageId(messageDto.getMessageId())
                        .setChatId(chat.getId()))
                .setChat(chat)
                .setDate(new Date(messageDto.getDate()))
                .setUser(user)
                .setText(messageDto.getText());
        return chatMessageRepository.save(message);
    }

    public Iterable<ChatMessage> getAll() {
        return chatMessageRepository.findAll();
    }

}

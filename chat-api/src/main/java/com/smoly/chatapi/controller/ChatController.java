package com.smoly.chatapi.controller;

import com.smoly.chatapi.dto.ChatMessageDto;
import com.smoly.chatapi.entity.ChatMessage;
import com.smoly.chatapi.service.ChatMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/chat")
@RequiredArgsConstructor
public class ChatController {

    private final ChatMessageService chatMessageService;

    @PostMapping
    public ChatMessage save(@RequestBody ChatMessageDto messageDto) {
        return chatMessageService.save(messageDto);
    }

    @GetMapping
    public Iterable<ChatMessage> getAll() {
        return chatMessageService.getAll();
    }
}

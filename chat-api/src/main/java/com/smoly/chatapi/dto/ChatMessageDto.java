package com.smoly.chatapi.dto;

import lombok.Data;

@Data
public class ChatMessageDto {
    private int messageId;
    private UserDto user;
    private long chatId;
    private String text;
    private long date;
}

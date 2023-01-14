package com.smoly.chatapi.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
//@IdClass(MessageId.class)
@RequiredArgsConstructor
@Getter
@Setter
@ToString
@Accessors(chain = true)
public class ChatMessage implements Serializable {

    @EmbeddedId
    private MessageId messageId;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    @JsonManagedReference
    private User user;

    @MapsId("chatId")
    @ManyToOne
    @JoinColumn(name = "chat_id", referencedColumnName = "id")
    private Chat chat;

    private String text;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
}

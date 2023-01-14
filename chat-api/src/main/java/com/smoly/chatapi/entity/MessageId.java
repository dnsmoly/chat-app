package com.smoly.chatapi.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Setter
@Getter
@Accessors(chain = true)
public class MessageId implements Serializable {

    private int messageId;
    private long chatId;
}

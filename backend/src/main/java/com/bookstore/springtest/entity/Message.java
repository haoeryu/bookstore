package com.bookstore.springtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//用户发送的消息
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Message {
    private String toName;
    private String message;
}

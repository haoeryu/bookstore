package com.bookstore.springtest.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ResultMessage {
    private boolean isSystem;//判断是不是系统消息
    private String fromName;//系统消息为null
    private Object message;//系统消息是数组
}

package com.sist.web.vo;

import lombok.Data;

@Data
public class ChatMessage {
	private String type,sender,reciver,message,time;
}

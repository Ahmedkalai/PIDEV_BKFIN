package com.BKFIN.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class ChatMessage {
	@Id 
	@GeneratedValue (strategy = GenerationType.IDENTITY)
	@Column(name="idM")
	private Long idM;
	    private String content;
	    private String sender;
	    
	    private MessageType type;
	    private String recipient;
	    public ChatMessage(String content, String sender,String recipient, MessageType type) {
			super();
			this.content = content;
			this.sender = sender;
			this.type = type;
			this.recipient = recipient;
		}
		public ChatMessage() {
			super();
			// recipientDO Aurecipient-generated construcrecipientr stub
		}
		
		public String getRecipient() {
			return recipient;
		}
		public void setRecipient(String recipient) {
			recipient = recipient;
		}
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getSender() {
			return sender;
		}
		public void setSender(String sender) {
			this.sender = sender;
		}
		public MessageType getType() {
			return type;
		}
		public void setType(MessageType type) {
			this.type = type;
		}
	    
}

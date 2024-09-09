package com.practice.Notification_Service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailDto {

	private String toRecipient;
	private String subject;
	private String body;
	public String getToRecipient() {
		return toRecipient;
	}
	public void setToRecipient(String toRecipient) {
		this.toRecipient = toRecipient;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
}

package com.practice.Notification_Service.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmailNotificationDetailsDto {

	private String toRecipient;
	private String subject;
	private String body;

}

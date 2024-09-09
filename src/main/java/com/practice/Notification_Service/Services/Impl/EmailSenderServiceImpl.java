package com.practice.Notification_Service.Services.Impl;

import org.slf4j.Logger;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.practice.Notification_Service.DTO.EmailDto;
import com.practice.Notification_Service.Services.EmailSenderService;

import jakarta.activation.DataSource;
import jakarta.mail.internet.MimeMessage;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class EmailSenderServiceImpl implements EmailSenderService{

	@Autowired
    private JavaMailSender javaMailSender;
	@Autowired
	private TemplateEngine templateEngine;
	
    @Value("${spring.mail.username}")
    private String fromEmail;
    
    private Logger logger = LoggerFactory.getLogger(EmailSenderServiceImpl.class);
    
    @Override
    public String sendMail(EmailDto emailDetailsDto) {
        try {
            Context context = new Context();
            context.setVariable("email", emailDetailsDto);
            
            String htmlMailContent = templateEngine.process("welcome.html", context);
        	MimeMessage mimeMessage = javaMailSender.createMimeMessage();

            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage, true);
            
            mimeMessageHelper.setFrom(fromEmail);
            mimeMessageHelper.setTo(emailDetailsDto.getToRecipient());
            mimeMessageHelper.setSubject(emailDetailsDto.getSubject());
            mimeMessageHelper.setText(htmlMailContent, true);
            FileSystemResource imageSource = new FileSystemResource("src/main/resources/static/logo.png");
			mimeMessageHelper.addInline("logo.png", imageSource);
			mimeMessageHelper.setText("<img src=", false);

            javaMailSender.send(mimeMessage);

            logger.info("Message Sent Successfully to: {}", emailDetailsDto.getToRecipient());
            return (String.format("Email Sent Successfully to {}", emailDetailsDto.getToRecipient()));
        }
          catch (Exception e) {
            logger.error("sendEmail() | Error : {}", e.getMessage());
            throw new RuntimeException(e);
        }


    }
}

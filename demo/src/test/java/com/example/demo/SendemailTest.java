package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;

@SpringBootTest
@EnableAutoConfiguration(exclude = {
        DataSourceAutoConfiguration.class,
        HibernateJpaAutoConfiguration.class
})
public class SendemailTest {

	@Autowired
	private JavaMailSender mailSender;
	

	@Test
	public void sendSimpleMail() throws Exception {
	    try {
	        SimpleMailMessage message = new SimpleMailMessage();
	        message.setFrom("forps40218@gmail.com");
	        message.setTo("mark29737148mark@gmail.com");
	        message.setSubject("主旨：Hello Tom");
	        message.setText("內容：這是一封測試信件，恭喜您成功發送了唷");

	        mailSender.send(message);
	        System.out.println("發送中...");
	    } catch (Exception e) {
	        System.out.println("發送郵件失敗: " + e.getMessage());
	        e.printStackTrace();
	    }
	}
}

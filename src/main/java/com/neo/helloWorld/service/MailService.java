package com.neo.helloWorld.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class MailService
{
    @Value("${spring.mail.username}")//将配置文件中属性注入到字段中
    private String from;//邮件发送人

    @Autowired
    private JavaMailSender mailSender;

    public void sayHello(){
        System.out.println("Hello World");
    }
    public void sendSimpleMail(String to,String subject,String content){
        SimpleMailMessage message = new SimpleMailMessage();
        message.setTo(to);//发送给谁
        message.setSubject(subject);//主题
        message.setText(content);//邮件内容
        message.setFrom(from);//邮件发送人

        mailSender.send(message);

    }
}

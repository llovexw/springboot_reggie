package com.itlr.reggie.service.Impl;

import com.itlr.reggie.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-23-22:31
 */
@Service
public class EmailServiceImpl implements EmailService {

    @Autowired
    private JavaMailSender javaMailSender;


    @Override
    public void sendSimpleMail(String to, String content) {
        SimpleMailMessage message = new SimpleMailMessage();
        //发件人
        message.setFrom("2542590210@qq.com");
        //收件人
        message.setTo(to);
        //邮件主题
        message.setSubject("[菩提阁验证码]");
        //邮件内容
        message.setText("验证码:"+content);
        //发送邮件
        javaMailSender.send(message);
    }
}


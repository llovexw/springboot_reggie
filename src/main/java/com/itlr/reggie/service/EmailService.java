package com.itlr.reggie.service;

/**
 * @author luorui
 * @company SCUT
 * @create 2022-05-23-22:30
 */
public interface EmailService {

    /**
     * 发送文本邮件
     * @param to 收件人
     * @param content 内容
     */
    void sendSimpleMail(String to, String content);
}

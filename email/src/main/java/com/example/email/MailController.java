package com.example.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@RestController
public class MailController {
    private final static Logger logger = LoggerFactory.getLogger(MailController.class);
    @Autowired
    private JavaMailSender sender;

    //发送方
    @Value("${spring.mail.from}")
    private String from;

    //接受方
    @Value("${sendmails.touser}")
    private String[] touser;

    //标题
    @Value("${title.name}")
    private String title;

    @GetMapping("/sends")
    public String sendmail() {

        MimeMessage message = null;
//        message = sender.createMimeMessage();
//        MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
        try {
            message = sender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true, "utf-8");
            helper.setFrom(from);
            helper.setTo(touser);
            helper.setSubject("标题：" + title);
            helper.setText("发送的内容", true);
        } catch (MessagingException e) {
            logger.debug("系统发送邮件 异常");
            e.printStackTrace();
        }
        sender.send(message);
        return "系统发送邮件成功。。。";


    }
}
package com.example.demo.util;

import com.example.demo.entity.bo.MailBO;
import freemarker.template.Configuration;
import freemarker.template.Template;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Component;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Component
public class MailUtil {

    @Value("${my.mail.sender}")
    private String MAIL_SENDER; //邮件发送者

    @Autowired
    private JavaMailSender javaMailSender;


    @Autowired
    private Configuration configuration; //freemarker

    public void sendSimpleMail(MailBO mailBO) {
        try {
            SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
            //邮件发送人
            simpleMailMessage.setFrom(MAIL_SENDER);
            //邮件接收人
            simpleMailMessage.setTo((String[]) mailBO.getReceives().toArray());
            simpleMailMessage.setCc((String[]) mailBO.getCcReceives().toArray());
            //邮件主题
            simpleMailMessage.setSubject(mailBO.getSubject());
            //邮件内容
            simpleMailMessage.setText(mailBO.getContent());
            javaMailSender.send(simpleMailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败 {}", e.getMessage());
        }
    }

    /**
     * 发送一个HTML格式的邮件
     *
     * @param mailBean
     */
    public void sendHTMLMail(MailBO mailBean) {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(MAIL_SENDER);
            mimeMessageHelper.setTo((String[]) mailBean.getReceives().toArray());
            mimeMessageHelper.setCc((String[]) mailBean.getCcReceives().toArray());
            mimeMessageHelper.setSubject(mailBean.getSubject());
            StringBuilder sb = new StringBuilder();
            sb.append("<h1>SpirngBoot测试邮件HTML</h1>")
                    .append("<p style='color:#F00'>你是真的太棒了！</p>")
                    .append("<p style='text-align:right'>右对齐</p>");
            mimeMessageHelper.setText(sb.toString(), true);
            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败 {}", e.getMessage());
        }
    }

    /**
     * 发送带附件格式的邮件
     *
     * @param mailBean
     */
    public void sendAttachmentMail(MailBO mailBean) {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(MAIL_SENDER);
            mimeMessageHelper.setTo((String[]) mailBean.getReceives().toArray());
            mimeMessageHelper.setCc((String[]) mailBean.getCcReceives().toArray());
            mimeMessageHelper.setSubject(mailBean.getSubject());
            mimeMessageHelper.setText(mailBean.getContent());
            //文件路径
            FileSystemResource file = new FileSystemResource(new File("E:\\icon\\0602_2.jpg"));
            FileSystemResource file2 = new FileSystemResource(new File("D:\\Users.xls"));
            mimeMessageHelper.addAttachment("mail.jpg", file);
            mimeMessageHelper.addAttachment("users.xls", file2);
            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败 {}", e.getMessage());
        }
    }

    /**
     * 发送带静态资源的邮件
     *
     * @param mailBean
     */
    public void sendInlineMail(MailBO mailBean) {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(MAIL_SENDER);
            mimeMessageHelper.setTo((String[]) mailBean.getReceives().toArray());
            mimeMessageHelper.setCc((String[]) mailBean.getCcReceives().toArray());
            mimeMessageHelper.setSubject(mailBean.getSubject());
            mimeMessageHelper.setText("<html><body>带静态资源的邮件内容，这个一张IDEA配置的照片:<img src='cid:picture' /></body></html>", true);
            //文件路径
            FileSystemResource file = new FileSystemResource(new File("E:\\icon\\0602_4.jpg"));
            mimeMessageHelper.addInline("picture", file);
            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败 {}", e.getMessage());
        }
    }

    /**
     * 发送基于Freemarker模板的邮件
     *
     * @param mailBean
     */
    public void sendTemplateMail(MailBO mailBean) {
        MimeMessage mimeMailMessage = null;
        try {
            mimeMailMessage = javaMailSender.createMimeMessage();
            MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMailMessage, true);
            mimeMessageHelper.setFrom(MAIL_SENDER);
            mimeMessageHelper.setTo((String[]) mailBean.getReceives().toArray());
            mimeMessageHelper.setCc((String[]) mailBean.getCcReceives().toArray());
            mimeMessageHelper.setSubject(mailBean.getSubject());

            Map<String, Object> model = new HashMap<String, Object>();
            model.put("content", mailBean.getContent());
            model.put("title", "标题Mail中使用了FreeMarker");
            model.put("dburl", mailBean.getUrl());
            Template template = configuration.getTemplate("mail.ftl");
            String text = FreeMarkerTemplateUtils.processTemplateIntoString(template, model);
            mimeMessageHelper.setText(text, true);

            javaMailSender.send(mimeMailMessage);
        } catch (Exception e) {
            log.error("邮件发送失败 {}", e.getMessage());
        }

    }


}

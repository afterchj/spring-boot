package com.example.demo.entity.bo;

import lombok.Data;

import java.util.List;


@Data
public class MailBO {

    private String sender;//邮件发送人
    private List<String> receives;//邮件接收人
    private List<String> ccReceives;//邮件抄送人
    private String subject; //邮件主题
    private String content; //邮件内容
    private String url; //超链接地址

}

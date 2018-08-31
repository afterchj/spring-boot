package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by hongjian.chen on 2018/8/30.
 */

@RestController
@ConfigurationProperties(prefix = "book")
@PropertySource(value = "classpath:test.properties")
public class PropertiesController {

    @Value("${book.name}")
    private String bookName;
    @Value("${book.author}")
    private String bookAuthor;

    @RequestMapping(value = "/index")
    public String index() {
        return "The book name is " + bookName + " and book author is " + bookAuthor;
    }

}

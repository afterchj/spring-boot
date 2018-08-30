package com.tp.demo.converter;

import com.tp.demo.model.User;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.util.StreamUtils;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * Created by hongjian.chen on 2018/8/24.
 */
public class MyMessageConverter extends AbstractHttpMessageConverter<User> {

    public MyMessageConverter() {
        super(new MediaType("application", "x-wisely", Charset.forName("UTF-8")));
    }

    @Override
    protected boolean supports(Class<?> aClass) {
        return User.class.isAssignableFrom(aClass);
    }

    @Override
    protected User readInternal(Class<? extends User> aClass, HttpInputMessage httpInputMessage) throws IOException, HttpMessageNotReadableException {
        String temp = StreamUtils.copyToString(httpInputMessage.getBody(), Charset.forName("UTF-8"));
        String[] tempArr = temp.split("-");
        return new User(new Integer(tempArr[0]), tempArr[1]);
    }

    @Override
    protected void writeInternal(User user, HttpOutputMessage httpOutputMessage) throws IOException, HttpMessageNotWritableException {

        String str = "Hello:" + user.getId() + "-" + user.getLoginName();
        httpOutputMessage.getBody().write(str.getBytes());
    }
}

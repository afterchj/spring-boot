package com.chj.tpadsz.convent;

import com.alibaba.fastjson.JSON;
import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import java.io.Serializable;

@Component
public class InnerMessageConverter implements MessageConverter {

	@Override
	public Object fromMessage(Message message) throws JMSException,
            MessageConversionException {
//		ObjectMessage objMessage = (ObjectMessage) message;
		return JSON.toJSONString(message);

	}

	@Override
	public Message toMessage(Object object, Session session)
			throws JMSException, MessageConversionException {
		return session.createObjectMessage((Serializable) object);
	}

}

package com.chj.tpadsz.convent;

import com.alibaba.fastjson.JSONObject;

import org.springframework.jms.support.converter.MessageConversionException;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.stereotype.Component;

import javax.jms.BytesMessage;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

@Component
public class JsonMessageConverter implements MessageConverter {

	@Override
	public Object fromMessage(Message message) throws JMSException,
            MessageConversionException {
		org.apache.activemq.command.ActiveMQBytesMessage bytesMessage = (org.apache.activemq.command.ActiveMQBytesMessage) message;  
		String value = new String(bytesMessage.getMessage().getContent().getData());
		JSONObject jsonObject = new JSONObject();
		try {
			jsonObject = JSONObject.parseObject(value);
		} catch (Exception e) {
			jsonObject.put("result",200);
		}
		return jsonObject;
	}

	@Override
	public Message toMessage(Object object, Session session)
			throws JMSException, MessageConversionException {
		byte[] bs = JSONObject.toJSONBytes(object);
		BytesMessage message = session.createBytesMessage();
		message.writeBytes(bs);
		return message;
	}

}

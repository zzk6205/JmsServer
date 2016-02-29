package net.web.jms.receiver;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;

import org.springframework.stereotype.Component;

@Component
public class TopicReceiver implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			MapMessage map = (MapMessage) message;
			System.out.println("TopicReceiver接收到消息:" + map.getString("userId") + "|" + map.getString("userName"));
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}

}
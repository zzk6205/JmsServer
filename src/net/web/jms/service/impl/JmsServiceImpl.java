package net.web.jms.service.impl;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.Session;

import net.web.jms.service.IJmsService;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service("jmsService")
public class JmsServiceImpl implements IJmsService {

	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;

	@Resource(name = "queueDestination")
	private Destination queueDestination;

	@Resource(name = "topicDestination")
	private Destination topicDestination;

	public void sendQueue() {
		jmsTemplate.send(queueDestination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				MapMessage map = session.createMapMessage();
				map.setString("userId", "1234");
				map.setString("userName", "5678");
				return map;
			}
		});
	}

	public void sendTopic() {
		jmsTemplate.send(topicDestination, new MessageCreator() {
			public Message createMessage(Session session) throws JMSException {
				MapMessage map = session.createMapMessage();
				map.setString("userId", "1234");
				map.setString("userName", "5678");
				return map;
			}
		});
	}

}

package net.web.test;

import javax.annotation.Resource;

import net.web.jms.service.IJmsService;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class JUnitTest extends AbstractJUnit4SpringContextTests {

	@Resource(name = "jmsService")
	private IJmsService jmsService;

	@Test
	public void testJms() {
		jmsService.sendQueue();
		jmsService.sendTopic();
	}

}

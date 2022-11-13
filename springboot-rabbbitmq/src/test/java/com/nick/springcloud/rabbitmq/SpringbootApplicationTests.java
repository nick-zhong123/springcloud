package com.nick.springcloud.rabbitmq;

import com.nick.springcloud.rabbitmq.service.ReceiveService;
import com.nick.springcloud.rabbitmq.service.SendService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootApplicationTests {

	@Autowired
	private SendService sendService;

	@Autowired
	private ReceiveService receiveService;

	@Test
	void contextLoads() {
	}

	@Test
	void sendMessage() {
		sendService.sendMessage("My message");
	}

	@Test
	void receiveMessage() {
		receiveService.receiveMessage();
	}

}

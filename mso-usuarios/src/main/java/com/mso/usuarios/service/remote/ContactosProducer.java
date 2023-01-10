package com.mso.usuarios.service.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.mso.usuarios.RabbitConfigConsumer;

@Component
public class ContactosProducer {
	
	public static final Logger logger = LoggerFactory.getLogger(ContactosProducer.class);
	private RabbitTemplate rabbitTemplate;

	public ContactosProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendAgregaContacto(String contractEvent) {
		rabbitTemplate.convertAndSend(RabbitConfigConsumer.QUEUE_AGREGA_CONTACTO, contractEvent);
		logger.info("====== Envio de peticion agregar contacto ======");
	}
}

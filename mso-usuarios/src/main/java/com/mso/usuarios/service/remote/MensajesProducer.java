package com.mso.usuarios.service.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import com.mso.usuarios.RabbitConfigConsumer;

@Component
public class MensajesProducer {
	
	public static final Logger logger = LoggerFactory.getLogger(MensajesProducer.class);
	private RabbitTemplate rabbitTemplate;

	public MensajesProducer(RabbitTemplate rabbitTemplate) {
		this.rabbitTemplate = rabbitTemplate;
	}
	
	public void sendDelete(String contractEvent) {
		rabbitTemplate.convertAndSend(RabbitConfigConsumer.QUEUE_ELIMINA_MENSAJES, contractEvent);
		logger.info("====== Envio de peticion eliminacion mensajes ======");
	}
}

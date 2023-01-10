package com.mso.contactos.service.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.mso.contactos.RabbitConfigConsumer;
import com.mso.contactos.model.ContactoDto;
import com.mso.contactos.service.ContactosService;


@Component
public class ContactosRabbitListener{

	public static final Logger logger = LoggerFactory.getLogger(ContactosRabbitListener.class);
	private Gson json = new Gson();
	private ContactosService contactosService;

	public ContactosRabbitListener(ContactosService contactosService) {
		this.contactosService = contactosService;
	}
	
	/*
	 * Listener para la cola de contactos
	 * */
	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_AGREGA_CONTACTO)
	public void listenerAgregaContactos(Message message) {
		String body = new String(message.getBody());
		logger.info("=== Event Agregar contacto ===" + body);

		ContactoDto dto = json.fromJson(body, ContactoDto.class);
		
		contactosService.crearContacto(dto);
	}
}
package com.mso.mensajes.service.remote;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import com. mso.mensajes.RabbitConfigConsumer;
import com.mso.mensajes.model.UsuarioDto;
import com.mso.mensajes.service.MensajesService;
import com.google.gson.Gson;


@Component
public class MensajesRabbitListener{

	public static final Logger logger = LoggerFactory.getLogger(MensajesRabbitListener.class);
	private Gson json = new Gson();
	private MensajesService mensajesService;

	public MensajesRabbitListener(MensajesService mensajesService) {
		this.mensajesService = mensajesService;
	}

	/*
	 * Listener para la cola de eliminacion de mensajes
	 * */
	@RabbitListener(queues = RabbitConfigConsumer.QUEUE_ELIMINA_MENSAJES)
	public void listenerEliminaMensajes(Message message) {
		String body = new String(message.getBody());
		logger.info("========= Peticion en listener de eliminacion de mensajes ========" + body);
		UsuarioDto dto = json.fromJson(body, UsuarioDto.class);
		mensajesService.eliminaConversacionUser(dto.getIdUsuario());
	}
}
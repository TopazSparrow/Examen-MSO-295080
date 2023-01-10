package com.mso.mensajes.service;

import com.mso.mensajes.model.ConversacionDto;
import com.mso.mensajes.model.MensajeDto;
import com.mso.mensajes.model.RespuestaApi;

public interface MensajesService {
	RespuestaApi guardaConversacion(ConversacionDto chatDto);
	RespuestaApi mostrarAllConversaciones();
	RespuestaApi mostrarConversacion(int idUsuarioOrigen,int idUsuarioDestino );
	RespuestaApi eliminaConversacionUser(int idUsuarioOrigen);
	RespuestaApi guardaMensaje(MensajeDto mensajeDto);
    RespuestaApi mostrarAllMensajesConversacion();
    RespuestaApi mostrarAllMensajesConversacion(MensajeDto mensajeDto);
    RespuestaApi eliminaMensaje(MensajeDto mensajeDto);
    RespuestaApi actualizaMensaje(MensajeDto mensajeDto);
}

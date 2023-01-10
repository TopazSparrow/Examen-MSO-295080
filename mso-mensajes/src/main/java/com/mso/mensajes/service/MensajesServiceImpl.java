package com.mso.mensajes.service;


import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mso.mensajes.model.ConversacionDto;
import com.mso.mensajes.model.MensajeDto;
import com.mso.mensajes.model.RespuestaApi;
import com.mso.mensajes.repository.MensajesRepositoryImpl;
import com.mso.mensajes.repository.MensajesRepository;

@Service
public class MensajesServiceImpl implements MensajesService{

    @Autowired
    private MensajesRepositoryImpl mensajesRepositoryImpl;

    @Autowired
    private MensajesRepository mensajesRepository;

	public static final Logger logger = LoggerFactory.getLogger(MensajesServiceImpl.class);

	@Override
    public RespuestaApi guardaConversacion(ConversacionDto conversacionDto){
	    RespuestaApi respuestaApi= new RespuestaApi();
	    ConversacionDto chatDtoResult=mensajesRepositoryImpl.save(conversacionDto);
	    respuestaApi.setResultado(chatDtoResult);
	    respuestaApi.setMensaje("Operacion exitosa");
	    return respuestaApi;
    }
	@Override
    public RespuestaApi mostrarAllConversaciones(){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(mensajesRepositoryImpl.findAll());
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }
	@Override
    public RespuestaApi mostrarConversacion (int idUsuarioOrigen,int idUsuarioDestino ){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(mensajesRepositoryImpl.findByConversacion(idUsuarioOrigen,idUsuarioDestino));
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }

    @Transactional
	@Override
    public RespuestaApi eliminaConversacionUser(int idUsuarioOrigen){
    	logger.info("=============== Incia eliminacion de chat del usuario: "+idUsuarioOrigen+" ===============");
        RespuestaApi respuestaApi= new RespuestaApi();
        mensajesRepositoryImpl.deleteConversacionUser(idUsuarioOrigen);
        respuestaApi.setResultado("");
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }

	@Override
    public RespuestaApi guardaMensaje(MensajeDto mensajeDto){
        RespuestaApi respuestaApi= new RespuestaApi();
        MensajeDto mensajeDtoRespuesta=mensajesRepository.save(mensajeDto);
        respuestaApi.setResultado(mensajeDtoRespuesta);
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }
	@Override
    public RespuestaApi mostrarAllMensajesConversacion(){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(mensajesRepositoryImpl.findAll());
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }
	@Override
    public RespuestaApi mostrarAllMensajesConversacion(MensajeDto mensajeDto){
        RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(mensajesRepositoryImpl.findByIdConver(mensajeDto.getIdConversacion()));
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }
	@Override
    public RespuestaApi eliminaMensaje(MensajeDto mensajeDto){
        RespuestaApi respuestaApi= new RespuestaApi();
        mensajesRepository.delete(mensajeDto);
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }
	@Override
    public RespuestaApi actualizaMensaje(MensajeDto mensajeDto){
        RespuestaApi respuestaApi= new RespuestaApi();
        MensajeDto mensajeDtoRespuesta=mensajesRepository.save(mensajeDto);
        respuestaApi.setResultado(mensajeDtoRespuesta);
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
    }

}

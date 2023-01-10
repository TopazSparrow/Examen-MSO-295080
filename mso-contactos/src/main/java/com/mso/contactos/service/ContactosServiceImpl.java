package com.mso.contactos.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mso.contactos.model.ContactoDto;
import com.mso.contactos.model.RespuestaApi;
import com.mso.contactos.repository.ContactosRepository;


@Service
public class ContactosServiceImpl implements ContactosService{
	
	@Autowired
    private ContactosRepository contactosRepository;

	@Transactional
	@Override
	public RespuestaApi crearContacto(ContactoDto contactoDto) {
		RespuestaApi respuestaApi = new RespuestaApi();
		ContactoDto respuestaContactos = contactosRepository.save(contactoDto);
		respuestaApi.setResultado(respuestaContactos);
		respuestaApi.setMensaje("Operacion Exitosa");
		return respuestaApi;
	}
	@Override
	public RespuestaApi consultaContacto(int idUsuarioOrigen) {
		RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(contactosRepository.findByUser(idUsuarioOrigen));
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
	}
	@Override
	public RespuestaApi consultaContactos() {
		RespuestaApi respuestaApi= new RespuestaApi();
        respuestaApi.setResultado(contactosRepository.findAll());
        respuestaApi.setMensaje("Operacion exitosa");
        return respuestaApi;
	}
	@Override
	public RespuestaApi actualizaContacto(ContactoDto contactoDto) {
		RespuestaApi respuestaApi = new RespuestaApi();
		respuestaApi.setResultado(contactosRepository.save(contactoDto));
		respuestaApi.setMensaje("Operacion Exitosa");
		return respuestaApi;
	}
	@Override
	public RespuestaApi eliminaContacto(ContactoDto contactoDto) {
		RespuestaApi respuestaApi = new RespuestaApi();
		contactosRepository.delete(contactoDto);
		respuestaApi.setMensaje("Operacion Exitosa");
		return respuestaApi;
	}

}

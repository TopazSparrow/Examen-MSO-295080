package com.mso.contactos.service;

import com.mso.contactos.model.ContactoDto;
import com.mso.contactos.model.RespuestaApi;

public interface ContactosService {
	RespuestaApi crearContacto(ContactoDto contactoDto);
	RespuestaApi consultaContacto(int idUsuarioOrigen);
	RespuestaApi consultaContactos();
	RespuestaApi actualizaContacto(ContactoDto contactoDto);
	RespuestaApi eliminaContacto(ContactoDto contactoDto);
}

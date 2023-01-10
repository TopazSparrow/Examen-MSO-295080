package com.mso.usuarios.service;

import com.mso.usuarios.model.RespuestaApi;
import com.mso.usuarios.model.UsuarioDto;

public interface UsuariosService {
	RespuestaApi consultarUsuarios();
	RespuestaApi consultarUsuario(int idUsuario);
	RespuestaApi crearUsuario(UsuarioDto usuarioDto);
	RespuestaApi agregarContacto(int idContactoOrigen, int idContactoDestino);
	RespuestaApi actualizaUsuario(UsuarioDto usuarioDto);
	RespuestaApi eliminaUsuario(UsuarioDto usuarioDto);
}

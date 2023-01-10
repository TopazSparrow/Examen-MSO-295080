


package com.mso.usuarios.service;

import com.google.gson.Gson;
import com.mso.usuarios.model.ContactoDto;
import com.mso.usuarios.model.RespuestaApi;
import com.mso.usuarios.model.UsuarioDto;
import com.mso.usuarios.repository.UsuariosRepository;
import com.mso.usuarios.service.remote.ContactosProducer;
import com.mso.usuarios.service.remote.MensajesProducer;

import java.util.List;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuariosServiceImpl implements UsuariosService{

    @Autowired
    private UsuariosRepository usuariosRepository;
    
    @Autowired
    private MensajesProducer mensajesProducer;
    
    @Autowired
    private ContactosProducer contactosProducer;
	
    private Gson json = new Gson();
    
    public static final Logger logger = LoggerFactory.getLogger(UsuariosServiceImpl.class);

    @Override
	public RespuestaApi crearUsuario(UsuarioDto usuarioDto) {
		RespuestaApi respuestaApi = new RespuestaApi();
		UsuarioDto rspBd = usuariosRepository.save(usuarioDto);
		respuestaApi.setResultado(rspBd);
		respuestaApi.setMensaje("Operacion Exitosa");
		return respuestaApi;
	}

    @Override
	public RespuestaApi consultarUsuarios() {
		RespuestaApi respuestaApi = new RespuestaApi();
		respuestaApi.setResultado(usuariosRepository.findAll());
		respuestaApi.setMensaje("Operacion Exitosa");
		return respuestaApi;
	}

    @Override
	public RespuestaApi actualizaUsuario(UsuarioDto usuarioDto) {
		RespuestaApi respuestaApi = new RespuestaApi();
		respuestaApi.setResultado(usuariosRepository.save(usuarioDto));
		respuestaApi.setMensaje("Operacion Exitosa");
		return respuestaApi;
	}

	@Transactional
	@Override
	public RespuestaApi eliminaUsuario(UsuarioDto usuarioDto) {
		logger.info("======= Se esta eliminando el usuario: "+usuarioDto.getIdUsuario()+" ======");
		RespuestaApi respuestaApi = new RespuestaApi();
		usuariosRepository.delete(usuarioDto);
		respuestaApi.setMensaje("Operacion Exitosa");
		mensajesProducer.sendDelete(json.toJson(usuarioDto));		
		return respuestaApi;
	}
	
	@Override
	public RespuestaApi consultarUsuario(int idUsuario) {
		RespuestaApi respuestaApi = new RespuestaApi();
		UsuarioDto usuario= buscarPorId(usuariosRepository.findAll(),idUsuario);
		
		if(usuario!= null) {
			respuestaApi.setResultado(usuario);
			respuestaApi.setMensaje("Operacion Exitosa");
			return respuestaApi;
		}
		else{
			respuestaApi.setMensaje("No se encontro informacion");
			respuestaApi.setResultado(null);
			return respuestaApi;
		}
	}

	@Transactional
	@Override
	public RespuestaApi agregarContacto(int idContactoOrigen, int idContactoDestino) {
		RespuestaApi rspConsulta = consultarUsuario(idContactoDestino);
		
		if(rspConsulta.getResultado() != null) {
			ContactoDto peticion = new ContactoDto(0,
					idContactoOrigen, 
					idContactoDestino);
			contactosProducer.sendAgregaContacto(json.toJson(peticion));
			rspConsulta.setMensaje("Se agrego correctamente el contacto a la lista");
		}
		else {
			rspConsulta.setMensaje("No se agrego el contacto ya que no existe");
			rspConsulta.setResultado(null);
		}
		
		
		return rspConsulta;
	}
	
	private UsuarioDto buscarPorId(List<UsuarioDto> lista, int id) {
		UsuarioDto userFind = lista.stream().filter( element -> element.getIdUsuario() == id).findFirst().orElse(null);
		return userFind;
	}


}

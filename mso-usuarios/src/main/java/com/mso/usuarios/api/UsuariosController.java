package com.mso.usuarios.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mso.usuarios.model.UsuarioDto;
import com.mso.usuarios.service.UsuariosService;

@RestController
@RequestMapping("/v1")
public class UsuariosController {
	
	@Autowired
	private UsuariosService usuariosService;
	
	@PostMapping("/crear")
    public ResponseEntity<Object> creaUsuario(@RequestBody UsuarioDto usuarioDto) {
        return new ResponseEntity<>(usuariosService.crearUsuario(usuarioDto),HttpStatus.OK);
    }
	
	@GetMapping("/agregarContacto/{idContactoOrigen}/{idContactoDestino}")
    public ResponseEntity<Object> agregarContacto(@PathVariable(value="idContactoOrigen")int contactoOrigen,
        @PathVariable(value="idContactoDestino")int contactoDestino) {
        return new ResponseEntity<>(usuariosService.agregarContacto(contactoOrigen, contactoDestino),HttpStatus.OK);
    }

    @GetMapping("/consulta")
    public ResponseEntity<Object> consultarUsuarios() {
        return new ResponseEntity<>(usuariosService.consultarUsuarios(),HttpStatus.OK);
    }
    @GetMapping("/consultaUsuario/{idUsuario}")
    public ResponseEntity<Object> consultarUsuario(@PathVariable(value="idUsuario")int idUsuario) {
        return new ResponseEntity<>(usuariosService.consultarUsuario(idUsuario) ,HttpStatus.OK);
    }

    @PatchMapping("/actualiza")
    public ResponseEntity<Object> actualizaUsuario(@RequestBody UsuarioDto usuarioDto) {
        return new ResponseEntity<>(usuariosService.actualizaUsuario(usuarioDto),HttpStatus.OK);
    }

    @DeleteMapping("/elimina")
    public ResponseEntity<Object> eliminaUsuario(@RequestBody UsuarioDto usuarioDto) {
        return new ResponseEntity<>(usuariosService.eliminaUsuario(usuarioDto),HttpStatus.OK);
    }

}

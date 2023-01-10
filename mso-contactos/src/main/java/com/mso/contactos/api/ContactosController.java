package com.mso.contactos.api;

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

import com.mso.contactos.model.ContactoDto;
import com.mso.contactos.service.ContactosService;

@RestController
@RequestMapping("/v1")
public class ContactosController {

	
	@Autowired
	private ContactosService contactosService;
	
	@PostMapping("/crear")
    public ResponseEntity<Object> crearContacto(@RequestBody ContactoDto contactoDto) {
		
        return new ResponseEntity<>(contactosService.crearContacto(contactoDto),HttpStatus.OK);
    }

    @GetMapping("/consulta/{idUsuarioOrigen}")
    public ResponseEntity<Object> consultaContacto(@PathVariable(value="idUsuarioOrigen") int idUsuarioOrigen) {
        return new ResponseEntity<>(contactosService.consultaContacto(idUsuarioOrigen),HttpStatus.OK);
    }
    @GetMapping("/consultaContactos")
    public ResponseEntity<Object> consultaContactos() {
        return new ResponseEntity<>(contactosService.consultaContactos(),HttpStatus.OK);
    }

    @PatchMapping("/actualizar")
    public ResponseEntity<Object> actualizaContacto(@RequestBody ContactoDto contactoDto) {
    	
        return new ResponseEntity<>(contactosService.actualizaContacto(contactoDto),HttpStatus.OK);
    }

    @DeleteMapping("/elimina")
    public ResponseEntity<Object> eliminaContacto(@RequestBody ContactoDto contactoDto) {
    	
        return new ResponseEntity<>(contactosService.eliminaContacto(contactoDto),HttpStatus.OK);
    }

}

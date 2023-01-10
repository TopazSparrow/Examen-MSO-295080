package com.mso.mensajes.api;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.mso.mensajes.model.ConversacionDto;
import com.mso.mensajes.model.MensajeDto;
import com.mso.mensajes.service.MensajesService;

@RestController
@RequestMapping("/v1")
public class MensajesController {

    @Autowired
    private MensajesService mensajesService;

    @PostMapping("/crearConversacion")
    public ResponseEntity<Object> creaChat(@RequestBody ConversacionDto conversacion) {
        return new ResponseEntity<>(mensajesService.guardaConversacion(conversacion),HttpStatus.OK);
    }

    @GetMapping("/consultaConversaciones")
    public ResponseEntity<Object> consultaConversaciones() {
        return new ResponseEntity<>(mensajesService.mostrarAllConversaciones(),HttpStatus.OK);
    }

    @DeleteMapping("/eliminaConversacion")
    public ResponseEntity<Object> eliminaConversacion(@RequestBody ConversacionDto conversacionDto) {
        return new ResponseEntity<>(mensajesService.guardaConversacion(conversacionDto),HttpStatus.OK);
    }

    @PostMapping("/crearMensaje")
    public ResponseEntity<Object> creaMensaje(@RequestBody MensajeDto mensajeDto) {
        return new ResponseEntity<>(mensajesService.guardaMensaje(mensajeDto),HttpStatus.OK);
    }

    @GetMapping("/consultaMensajes")
    public ResponseEntity<Object> consultarMensajes() {
        return new ResponseEntity<>(mensajesService.mostrarAllMensajesConversacion(),HttpStatus.OK);
    }

    @GetMapping("/consultaMensajesConversacion")
    public ResponseEntity<Object> consultaMensajesConversacion(@RequestBody MensajeDto mensajeDto) {
        return new ResponseEntity<>(mensajesService.mostrarAllMensajesConversacion(mensajeDto),HttpStatus.OK);
    }

    @PatchMapping("/actualizaMensaje")
    public ResponseEntity<Object> actualizarMensaje(@RequestBody MensajeDto mensajeDto) {
        return new ResponseEntity<>(mensajesService.actualizaMensaje(mensajeDto),HttpStatus.OK);
    }

    @DeleteMapping("/eliminaMensaje")
    public ResponseEntity<Object> eliminaMensaje(@RequestBody MensajeDto mensajeDto) {
        return new ResponseEntity<>(mensajesService.eliminaMensaje(mensajeDto),HttpStatus.OK);
    }

    @GetMapping("/consultaConversacionUsuario/{idUsuarioOrigen}/{idUsuarioDestino}")
    public ResponseEntity<Object> consultaConversacionUsuario(@PathVariable(value = "idUsuarioOrigen") int idUsuarioOrigen
            ,@PathVariable(value = "idUsuarioDestino") int idUsuarioDestino) {
        return new ResponseEntity<>(mensajesService.mostrarConversacion(idUsuarioOrigen,idUsuarioDestino),HttpStatus.OK);
    }

    @DeleteMapping("/eliminaConversacionUsuario/{idUsuarioOrigen}")
    public ResponseEntity<Object> eliminaConversacionUsuario(@PathVariable(value = "idUsuarioOrigen") int idUsuarioOrigen) {
        return new ResponseEntity<>(mensajesService.eliminaConversacionUser(idUsuarioOrigen),HttpStatus.OK);
    }

}

package com.mso.mensajes.model;


import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "conversacion", schema = "public")
public class ConversacionDto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idconversacion", updatable=false)
    private int idConversacion;
    @Column(name = "idusuarioorigen")
    private int idUsuarioOrigen;
    @Column(name = "idusuariodestino")
    private int idUsuarioDestino;

    public ConversacionDto() {
    }

    public int getIdConversacion() {
        return idConversacion;
    }

    public void setIdConversacion(int idConversacion) {
        this.idConversacion = idConversacion;
    }

    public int getIdUsuarioOrigen() {
        return idUsuarioOrigen;
    }

    public void setIdUsuarioOrigen(int idUsuarioOrigen) {
        this.idUsuarioOrigen = idUsuarioOrigen;
    }

    public int getIdUsuarioDestino() {
        return idUsuarioDestino;
    }

    public void setIdUsuarioDestino(int idUsuarioDestino) {
        this.idUsuarioDestino = idUsuarioDestino;
    }
}

package com.mso.mensajes.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "mensaje", schema = "public")
public class MensajeDto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idmensaje", updatable=false)
    private int idMensaje;
    @Column(name = "idconversacion")
    private int idConversacion;
    @Column(name = "fechahora")
    private String fechaHora;
    @Column(name = "texto")
    private String texto;
    @Column(name = "visto")
    private boolean visto;

    public MensajeDto() {
    }

    public int getIdMensaje() {
        return idMensaje;
    }

    public void setIdMensaje(int idMensaje) {
        this.idMensaje = idMensaje;
    }
    
    public int getIdConversacion() {
		return idConversacion;
	}

	public void setIdConversacion(int idConversacion) {
		this.idConversacion = idConversacion;
	}

	public String  getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isVisto() {
        return visto;
    }

    public void setVisto(boolean visto) {
        this.visto = visto;
    }
}

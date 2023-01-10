package com.mso.contactos.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "contacto", schema = "public")
public class ContactoDto {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable=false)
	private int id;
    @Column(name = "idusuarioorigen")	
    private int idUsuarioOrigen;
    @Column(name = "idusuariocontacto")	
    private int idUsuarioContacto;
	
	public ContactoDto() {
	}

	public ContactoDto(int idUsuarioOrigen, int idUsuarioContacto) {
		super();
		this.idUsuarioOrigen = idUsuarioOrigen;
		this.idUsuarioContacto = idUsuarioContacto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getIdUsuarioOrigen() {
		return idUsuarioOrigen;
	}

	public void setIdUsuarioOrigen(int idUsuarioOrigen) {
		this.idUsuarioOrigen = idUsuarioOrigen;
	}

	public int getIdUsuarioContacto() {
		return idUsuarioContacto;
	}

	public void setIdUsuarioContacto(int idUsuarioContacto) {
		this.idUsuarioContacto = idUsuarioContacto;
	}

}

package com.mso.usuarios.model;

public class ContactoDto {
	private int id;
	private int idUsuarioOrigen;
	private int idUsuarioContacto;
	
	public ContactoDto() {}
	
	public ContactoDto(int id, int idUsuarioOrigen, int idUsuarioContacto) {
		this.id = id;
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

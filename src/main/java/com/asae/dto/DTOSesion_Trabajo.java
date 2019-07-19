package com.asae.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "objusuario", eager = true) 
@RequestScoped 
public class DTOSesion_Trabajo  {

	private int idSesion;
	private String fechaSesion;
	private String imrTotal;

	
	
	public DTOSesion_Trabajo() {
		
	}
	public int getIdSesion() {
		return idSesion;
	}
	public void setIdUsuario(int idUsuario) {
		this.idSesion = idUsuario;
	}
	public int getFechaSesion() {
		return idSesion;
	}
	public void setFechaSesion(int idUsuario) {
		this.idSesion = idUsuario;
	}
	public int getImrSesion() {
		return idSesion;
	}
	public void setImrSesion(int idUsuario) {
		this.idSesion = idUsuario;
	}
	
	
	
}

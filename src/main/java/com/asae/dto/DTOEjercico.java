package com.asae.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "objEjercio", eager = true) 
@RequestScoped 
public class DTOEjercico  {

	private int ejeId;
	private String ejeNombre;

	public DTOEjercico() {
		
	}
	public int getIdUsuario() {
		return ejeId;
	}
	public void setEjeId(int ejeId) {
		this.ejeId = ejeId;
	}
	public String getEjeNombre() {
		return ejeNombre;
	}
	public void setEjeNombre(String ejeNombre) {
		this.ejeNombre = ejeNombre;
	}
	
	
	
	
}

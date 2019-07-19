package com.asae.dto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "objEvalucaion", eager = true) 
@RequestScoped 
public class DTOEvaluacion  {

	int idEvaluacion;
	int imrEvaluacion;
	int tonelajeEvaluacion;
	
	
	
	
	public DTOEvaluacion() {
		
	}
	public int getIdEvaluacion() {
		return idEvaluacion;
	}
	public void setIdEvaluacion(int idEvaluacion) {
		this.idEvaluacion = idEvaluacion;
	}
	public int geTonelajeEvaluacion() {
		return imrEvaluacion;
	}
	public void setTonelajeEvaluacion(int tonelajeEvaluacion) {
		this.tonelajeEvaluacion = tonelajeEvaluacion;
	}
	public int getImrEvaluacion() {
		return tonelajeEvaluacion;
	}
	public void setImrEvaluacion(int tonelajeEvaluacion) {
		this.tonelajeEvaluacion = tonelajeEvaluacion;
	}
	
	
	
}

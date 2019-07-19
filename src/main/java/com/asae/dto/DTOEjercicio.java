package com.asae.dto;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "objejercicio", eager = true) 
@RequestScoped 
public class DTOEjercicio {
	  private int idEjercicio;
	  private String nombre;
	    
	  public DTOEjercicio() {  	
	  }
	  public int getIdEjercicio() {
			return idEjercicio;
      }
	  public void setIdEjercicio(int idEjercicio) {
			this.idEjercicio = idEjercicio;
	  }
	  public String getNombre() {
			return nombre;
	  }
	  public void setNombre(String nombre) {
			this.nombre = nombre;
	  }
	 
}

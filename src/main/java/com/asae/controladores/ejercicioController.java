package com.asae.controladores;

import java.util.ArrayList;
import java.util.Map;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import com.asae.dto.DTOEjercicio;
import com.asae.ejbinterface.IEjbEjercicio;

@ManagedBean(name = "ejercicioController")
@RequestScoped 
public class ejercicioController {
 @ManagedProperty(value="#{objejercicio}")
 private DTOEjercicio objEjercicio;
 private ArrayList<DTOEjercicio> listaEjercicio;
 private static final String EJBGestionEjercicios_SESION_KEY="EJBSesionEjercicios";
 private IEjbEjercicio iEjbEjercicio;
 
  public void init() {
	 System.out.println("creando ejb");
	 consultarRefernciaEJB();
	 listaEjercicio = new ArrayList<DTOEjercicio>();
  }
  public DTOEjercicio getObjEjercicio(){
	  return objEjercicio;
  }
  public void setObjEjercicio(DTOEjercicio objEjercicio) {
  
     this.objEjercicio = objEjercicio;
  }
  public  ArrayList<DTOEjercicio> getListaEjercicio() {
<<<<<<< HEAD
=======
	  if(listaEjercicio.isEmpty())
		  this.listarEjercicios();
>>>>>>> ec79e34a694efa487f745759e14a8c46dc77273b
	  return listaEjercicio;
  }
  public void setListaEjercicio(ArrayList<DTOEjercicio> listaEjercicio) {
	  this.listaEjercicio = listaEjercicio;
	  
  }
  public String guardarEjercicio() {
	  try {
		  iEjbEjercicio.insert(this.objEjercicio);
			this.addMessage("Registro exitoso", "Registro exitoso del ejercicio");
	    }
		catch(Exception ex)
		{
			System.out.println("Error en insertar: "+ex.getMessage());
			this.addMessage("Error al registrar el ejercicio", "Error al registrar el usuario");
		}
		
		return "registrar";
  }
  public String listarEjercicios()
  {		
		this.listaEjercicio= (ArrayList<DTOEjercicio>)iEjbEjercicio.getListaEjercicios();		
		return "/ejercicio/listar";
  }
  public String eliminarEjercicio()
  {
		try
		{				
			
			iEjbEjercicio.eliminarEjercicio(this.objEjercicio);
			this.addMessage("Eliminación exitosa", "Eliminación exitosa del ejercicio");
	    }
		catch(Exception ex)
		{			
			this.addMessage("Error al eliminar el ejercicio", "Error al eliminar el ejercicio");
		}
		
		
		return "/ejercicio/listar";
  }
  public void consultarRefernciaEJB()
  {
		Map<String, Object> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		this.iEjbEjercicio = (IEjbEjercicio) requestMap.get("EJBGestionEjercicios_SESSION_KEY");
		 
       if(this.iEjbEjercicio == null){
	                         
	        	
				try {
					InitialContext ic = new InitialContext();
					this.iEjbEjercicio = (IEjbEjercicio) ic.lookup("java:global/gestionUsuariosPrimeFacesV2-1/EjbUsuarioImpl!com.asae.ejbinterface.IEjbUsuario");
			        	 
					
					requestMap.putIfAbsent(EJBGestionEjercicios_SESION_KEY, this.iEjbEjercicio);
								        
			        System.out.println("ejb para la gestión de ejercicios creado");
			        
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
       }
  }
  public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
}
}


package com.asae.controladores;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import org.primefaces.event.RowEditEvent;

import com.asae.dto.DTOUsuario;
import com.asae.ejbinterface.IEjbUsuario;


@ManagedBean(name = "usuarioController")
@RequestScoped
public class usuarioController {

	@ManagedProperty(value="#{objusuario}")
	private DTOUsuario objusuario;
	
	private List<DTOUsuario> listaUsuario;
	
	private static final String EJBGestionUsuarios_SESSION_KEY = "EJBSesionUsuarios";  
	
	private IEjbUsuario iEjbUsuario;
	
	 @PostConstruct
    public void init() {
		 System.out.println("creando ejb");
		 consultarReferenciaEJB();
		 listaUsuario= new ArrayList<DTOUsuario>();
    }
		 
	public DTOUsuario getObjusuario() {
		return objusuario;
	}

	public void setObjusuario(DTOUsuario objusuario) {
		this.objusuario = objusuario;
	}

	public List<DTOUsuario> getListaUsuario() {
		if(listaUsuario.isEmpty())
			this.listarUsuarios();
		return listaUsuario;
	}

	public void setListaUsuario(ArrayList<DTOUsuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	}

	public String guardarUsuario() {		
		try
		{				
			iEjbUsuario.insert(this.objusuario);
			this.addMessage("Registro exitoso", "Registro exitoso del usuario");
	    }
		catch(Exception ex)
		{
			System.out.println("Error en insertar: "+ex.getMessage());
			this.addMessage("Error al registrar el usuario", "Error al registrar el usuario");
		}
		
		return "registrar";
	}
	
	public String listarUsuarios()
	{		
		this.listaUsuario= (ArrayList<DTOUsuario>)iEjbUsuario.getListaUsuarios();		
		return "/usuario/listar";
	}
	
	public String eliminarUsuario()
	{
		try
		{				
			
			iEjbUsuario.eliminarUsuario(this.objusuario);
			this.addMessage("Eliminación exitosa", "Eliminación exitosa del usuario");
	    }
		catch(Exception ex)
		{			
			this.addMessage("Error al eliminar el usuario", "Error al eliminar el usuario");
		}
		
		
		return "/usuario/listar";
	}

	public void onRowEdit(RowEditEvent event) {
		DTOUsuario objUsuario = (DTOUsuario) event.getObject();
		try
		{				
			iEjbUsuario.edit(objUsuario);
			this.addMessage("Actualizacion exitoso", "Actualizacion exitosa del usuario");
	    }
		catch(Exception ex)
		{
			System.out.println("Error en editar: "+ex.getMessage());
			this.addMessage("Error al actualizar el usuario", "Error al actualizar el usuario");
		}					
    }
     
    public void onRowCancel(RowEditEvent event) {
        FacesMessage msg = new FacesMessage("Edit Cancelled", ""+((DTOUsuario) event.getObject()).getIdUsuario());
        FacesContext.getCurrentInstance().addMessage(null, msg);
    }
	
	public void addMessage(String summary, String detail) {
		FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, summary, detail);
		FacesContext.getCurrentInstance().addMessage(null, message);
	}
	
	public void consultarReferenciaEJB()
	{
		Map<String, Object> requestMap = FacesContext.getCurrentInstance().getExternalContext().getRequestMap();
		this.iEjbUsuario = (IEjbUsuario) requestMap.get("EJBGestionUsuarios_SESSION_KEY");
		 
         if(this.iEjbUsuario == null){
	                         
	        	
				try {
					InitialContext ic = new InitialContext();
					this.iEjbUsuario = (IEjbUsuario) ic.lookup("java:global/gestionUsuariosPrimeFacesV2-1/EjbUsuarioImpl!com.asae.ejbinterface.IEjbUsuario");
			        	 
					
					requestMap.putIfAbsent(EJBGestionUsuarios_SESSION_KEY, this.iEjbUsuario);
								        
			        System.out.println("ejb para la gestión de usuarios creado");
			        
				} catch (NamingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
         }
	}
}

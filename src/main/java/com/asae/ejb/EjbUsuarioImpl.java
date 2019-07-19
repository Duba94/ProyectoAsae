package com.asae.ejb;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.asae.dao.DaoUsuario;
import com.asae.daointerface.IDaoUsuario;
import com.asae.dto.DTOUsuario;
import com.asae.ejbinterface.IEjbUsuario;
import com.asae.entity.Tusuario;

@Stateful
public class EjbUsuarioImpl implements IEjbUsuario {
	private EntityManagerFactory emf=null;
	private EntityManager em=null;
	private EntityTransaction et=null;
	

	@PostConstruct	
	public void inicializarEJB() 
	{
		System.out.println("En EjbUsuario: Entrando de inicializarEJB()...");
		emf=Persistence.createEntityManagerFactory("webappagenda");
		em=emf.createEntityManager();
		System.out.println("En EjbUsuario: Saliendo de inicializarEJB()...");
	}
	
	@PreDestroy 
	public void finalizarEJB()
	{
		System.out.println("En EjbUsuario: Finalizando EJB");

		em.close();
		emf.close();
		
	}
	
	
	
	@Override
	public boolean insert(DTOUsuario ObjUsuario) {
		try
		{
			Tusuario usuario=new Tusuario();
			usuario.setNombre(ObjUsuario.getNombre());
			usuario.setApellido(ObjUsuario.getApellido());
			usuario.setContrasenia(ObjUsuario.getContrasenia());
			usuario.setFechaNacimiento(ObjUsuario.getFechaNacimiento());
			usuario.setCorreoElectronico(ObjUsuario.getCorreoElectronico());
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			
			String fechaActual=sdf.format(new Date());
			
			usuario.setFechaRegistro(fechaActual);
			usuario.setFechaModificacion(fechaActual);
			
			IDaoUsuario iDaoUsuario=new DaoUsuario();
			
			et=em.getTransaction();
			
			et.begin();
			iDaoUsuario.insert(em, usuario);
			et.commit();
			
			return true;
		}
		catch(Exception ex)
		{
			if(et!=null)
			{
				et.rollback();
			}
			
			System.out.println("Error: "+ex.getMessage());
			
			return false;
		}
	}


	@Override
	public List<DTOUsuario> getListaUsuarios() {
		List<Tusuario> lista=null;
		List<DTOUsuario> listaUsuarios= new ArrayList<DTOUsuario>();
		try {
			
			IDaoUsuario iDaoUsuario=new DaoUsuario();			
			et=em.getTransaction();			
			et.begin();
				
			lista = iDaoUsuario.getByIdUsuarioList(em);
			System.out.println("cantidad de usuarios:ds " + lista.size());
			for (int i = 0; i < lista.size(); i++) {
				DTOUsuario objusuario= new DTOUsuario();
				objusuario.setIdUsuario(lista.get(i).getIdUsuario());
				objusuario.setNombre(lista.get(i).getNombre());
				objusuario.setApellido(lista.get(i).getApellido());
				objusuario.setContrasenia(lista.get(i).getContrasenia());
				objusuario.setCorreoElectronico(lista.get(i).getCorreoElectronico());
				objusuario.setFechaRegistro(lista.get(i).getFechaRegistro());
				objusuario.setFechaNacimiento(lista.get(i).getFechaNacimiento());
				listaUsuarios.add(objusuario);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		et.commit();
		
		return listaUsuarios;
	}
	
	public boolean eliminarUsuario(DTOUsuario objUsuario)
	{
		boolean bandera=false;
		try
		{
			IDaoUsuario iDaoUsuario=new DaoUsuario();
			int idUsuario;
			idUsuario=objUsuario.getIdUsuario();
			
			et=em.getTransaction();
			
			et.begin();
			
			iDaoUsuario.remove(em, idUsuario);
			
			et.commit();
			bandera=true;
		}
		catch(Exception ex)
		{
			if(et!=null)
			{
				et.rollback();
			}
			
			System.out.println("Error en la actualizacion: "+ex.getMessage());
			
			//return null;
		}
		
		return bandera;
	}

	@Override
	public boolean edit(DTOUsuario ObjUsuario) {		
		try{			
			IDaoUsuario iDaoUsuario=new DaoUsuario();		
			Tusuario usuario = iDaoUsuario.getByIdUsuario(em, ObjUsuario.getIdUsuario());
			usuario.setNombre(ObjUsuario.getNombre());
			usuario.setApellido(ObjUsuario.getApellido());
			usuario.setContrasenia(ObjUsuario.getContrasenia());
			usuario.setFechaNacimiento(ObjUsuario.getFechaNacimiento());
			usuario.setCorreoElectronico(ObjUsuario.getCorreoElectronico());
			
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
			
			String fechaActual=sdf.format(new Date());
			
			usuario.setFechaRegistro(fechaActual);
			usuario.setFechaModificacion(fechaActual);					
			
			et=em.getTransaction();
			
			et.begin();
			iDaoUsuario.update(em, usuario);
			et.commit();
			
			return true;
		}
		catch(Exception ex)
		{
			if(et!=null)
			{
				et.rollback();
			}
			
			System.out.println("Error: "+ex.getMessage());
			
			return false;
		}
	}
}


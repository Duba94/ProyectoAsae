package com.asae.ejb;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Stateful;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import com.asae.dao.DaoEjercicio;
import com.asae.daointerface.IDaoEjercicio;
import com.asae.dto.DTOEjercicio;
import com.asae.ejbinterface.IEjbEjercicio;
import com.asae.entity.Ejercicio;

@Stateful
public class EjbEjercicioImpl implements IEjbEjercicio {
	private EntityManagerFactory emf=null;
	private EntityManager em=null;
	private EntityTransaction et=null;
	
	@PostConstruct	
	public void inicializarEJB() 
	{
		System.out.println("En EjbEjercicio: Entrando de inicializarEJB()...");
		emf=Persistence.createEntityManagerFactory("horaSaludable");
		em=emf.createEntityManager();
		System.out.println("En EjbEjercicio: Saliendo de inicializarEJB()...");
	}
	
	@PreDestroy 
	public void finalizarEJB()
	{
		System.out.println("En EjbUsuario: Finalizando EJB");

		em.close();
		emf.close();
		
	}
	
	@Override
	public boolean insert(DTOEjercicio ObjEjercicio)  {
		try
		{
		Ejercicio ejercicio=new Ejercicio();
		ejercicio.setEjenombre(ObjEjercicio.getNombre());
		IDaoEjercicio iDaoEjercicio=new DaoEjercicio();
		
		et=em.getTransaction();
		
		et.begin();
		iDaoEjercicio.insert(em, ejercicio);
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

	public List<DTOEjercicio> getListaEjercicios() {
		List<Ejercicio> lista=null;
		List<DTOEjercicio> listaEjercicios= new ArrayList<DTOEjercicio>();
		try {
			
			IDaoEjercicio iDaoEjercicio=new DaoEjercicio();			
			et=em.getTransaction();			
			et.begin();
				
			lista = iDaoEjercicio.getByIdEjercicioList(em);
			System.out.println("cantidad de usuarios:ds " + lista.size());
			for (int i = 0; i < lista.size(); i++) {
				DTOEjercicio objEjercicio= new DTOEjercicio();
				objEjercicio.setIdEjercicio(Integer.parseInt(lista.get(i).getEjeid()));
				objEjercicio.setNombre(lista.get(i).getEjenombre());
				
				listaEjercicios.add(objEjercicio);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		et.commit();
		
		return listaEjercicios;
	}

	@Override
	public boolean edit(DTOEjercicio ObjEjercicio) {		
		try{			
			IDaoEjercicio iDaoEjercicio=new DaoEjercicio();		
			Ejercicio ejercicio = iDaoEjercicio.getByIdEjercicio(em, ObjEjercicio.getIdEjercicio());
			ejercicio.setEjeid(""+ObjEjercicio.getIdEjercicio());
			ejercicio.setEjenombre(ObjEjercicio.getNombre());				
			
			et=em.getTransaction();
			
			et.begin();
			iDaoEjercicio.update(em, ejercicio);
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
	
	public boolean eliminarEjercicio(DTOEjercicio objEjercicio) {
		boolean bandera=false;
		try
		{
			IDaoEjercicio iDaoUsuario=new DaoEjercicio();
			int idUsuario;
			idUsuario=objEjercicio.getIdEjercicio();
			
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
}

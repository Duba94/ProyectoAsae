package com.asae.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.asae.daointerface.IDaoEjercicio;
import com.asae.entity.Ejercicio;


public  class DaoEjercicio implements IDaoEjercicio{

	@Override
	public boolean insert(EntityManager em, Ejercicio ejercicio) throws Exception {
		em.persist(ejercicio);
		return false;
	}


	@Override
	public void remove(EntityManager em, int idEjercicio) throws Exception {
        Ejercicio tUsuario=em.find(Ejercicio.class, idEjercicio);
		
		em.remove(tUsuario);
		
	}

	@Override
	public Ejercicio getByIdEjercicio(EntityManager em, int idEjercicio) throws Exception {
		return em.find(Ejercicio.class, idEjercicio);
		
	}

	@Override
	public List<Ejercicio> getByIdEjercicioList(EntityManager em) throws Exception {
      TypedQuery<Ejercicio> query=em.createNamedQuery("Ejercicio.findAll",Ejercicio.class);	
		return query.getResultList();
	}


	@Override
	public boolean update(EntityManager em, Ejercicio ejercicio) throws Exception {
		em.merge(ejercicio);
		return true;
	}
  
    
}

package com.asae.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

import com.asae.daointerface.IDaoUsuario;
import com.asae.entity.Tusuario;

public class DaoUsuario implements IDaoUsuario {

	@Override
	public boolean insert(EntityManager em, Tusuario usuario) throws Exception {
		em.persist(usuario);

		
		return true;
	}

	@Override
	public Tusuario getByIdUsuario(EntityManager em, int idUsuario) throws Exception {
		
		return em.find(Tusuario.class, idUsuario);
	}

	@Override
	public boolean update(EntityManager em, Tusuario usuario) throws Exception {
		em.merge(usuario);
		return true;
	}

	@Override
	public List<Tusuario> getByIdUsuarioList(EntityManager em) throws Exception {
		TypedQuery<Tusuario> query=em.createNamedQuery("Tusuario.findAll", Tusuario.class);

		
		return query.getResultList();
	}

	@Override
	public void remove(EntityManager em, int idUsuario) throws Exception {
		Tusuario tUsuario=em.find(Tusuario.class, idUsuario);
		
		em.remove(tUsuario);
		
		
	}

	@Override
	public Tusuario getByCorreoElectronico(EntityManager em, String correoElectronico) throws Exception {
		TypedQuery<Tusuario> query=em.createNamedQuery("Tusuario.getByCorreoElectronico", Tusuario.class);

		query.setParameter("correoElectronico", correoElectronico);
		
		return query.getSingleResult();
	}

}

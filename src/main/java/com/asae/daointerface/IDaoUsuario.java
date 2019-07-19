package com.asae.daointerface;

import java.util.List;

import javax.persistence.EntityManager;

import com.asae.entity.Tusuario;

public interface IDaoUsuario {
	public boolean insert(EntityManager em, Tusuario usuario) throws Exception;
	public Tusuario getByIdUsuario(EntityManager em, int idUsuario) throws Exception;
	public boolean update(EntityManager em, Tusuario usuario) throws Exception;
	public List<Tusuario> getByIdUsuarioList(EntityManager em) throws Exception;
	public void remove(EntityManager em,int idUsuario) throws Exception;
	public Tusuario getByCorreoElectronico(EntityManager em, String correoElectronico) throws Exception;
}

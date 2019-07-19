package com.asae.daointerface;

import java.util.List;

import javax.persistence.EntityManager;

import com.asae.entity.Ejercicio;



public interface IDaoEjercicio {
	public boolean insert(EntityManager em, Ejercicio  ejercicio) throws Exception;
	public Ejercicio getByIdEjercicio(EntityManager em, int idEjercicio) throws Exception;
	public boolean update(EntityManager em, Ejercicio ejercicio) throws Exception;
	public List<Ejercicio> getByIdEjercicioList(EntityManager em) throws Exception;
	public void remove(EntityManager em,int idEjercicio) throws Exception;
	
}

package com.asae.ejbinterface;

import java.util.List;

import javax.ejb.Local;

import com.asae.dto.DTOEjercicio;

@Local
public interface IEjbEjercicio {
	public boolean insert(DTOEjercicio ObjEjercicio);
	public List<DTOEjercicio> getListaEjercicios();
	public boolean edit(DTOEjercicio ObjUsuario);
	public boolean eliminarEjercicio(DTOEjercicio objEjercicio);
}

package com.asae.ejbinterface;

import java.util.List;

import javax.ejb.Local;

import com.asae.dto.DTOUsuario;

@Local
public interface IEjbUsuario {
	public boolean insert(DTOUsuario ObjUsuario);
	public boolean edit(DTOUsuario ObjUsuario);
	public List<DTOUsuario> getListaUsuarios();
	public boolean eliminarUsuario(DTOUsuario objUsuario);
}

package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tusuario database table.
 * 
 */
@Entity
@NamedQuery(name="Tusuario.findAll", query="SELECT t FROM Tusuario t")

public class Tusuario implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idUsuario;

	private String apellido;

	private String contrasenia;

	private String correoElectronico;

	private String fechaModificacion;

	private String fechaNacimiento;

	private String fechaRegistro;

	private String nombre;

	//bi-directional many-to-one association to Tactividad
	@OneToMany(mappedBy="tusuario")
	private List<Tactividad> tactividads;

	public Tusuario() {
	}

	public int getIdUsuario() {
		return this.idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getApellido() {
		return this.apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getContrasenia() {
		return this.contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

	public String getCorreoElectronico() {
		return this.correoElectronico;
	}

	public void setCorreoElectronico(String correoElectronico) {
		this.correoElectronico = correoElectronico;
	}

	public String getFechaModificacion() {
		return this.fechaModificacion;
	}

	public void setFechaModificacion(String fechaModificacion) {
		this.fechaModificacion = fechaModificacion;
	}

	public String getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}

	public String getFechaRegistro() {
		return this.fechaRegistro;
	}

	public void setFechaRegistro(String fechaRegistro) {
		this.fechaRegistro = fechaRegistro;
	}

	public String getNombre() {
		return this.nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Tactividad> getTactividads() {
		return this.tactividads;
	}

	public void setTactividads(List<Tactividad> tactividads) {
		this.tactividads = tactividads;
	}

	public Tactividad addTactividad(Tactividad tactividad) {
		getTactividads().add(tactividad);
		tactividad.setTusuario(this);

		return tactividad;
	}

	public Tactividad removeTactividad(Tactividad tactividad) {
		getTactividads().remove(tactividad);
		tactividad.setTusuario(null);

		return tactividad;
	}

}
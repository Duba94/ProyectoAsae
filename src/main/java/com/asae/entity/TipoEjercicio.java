package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the tipo_ejercicio database table.
 * 
 */
@Entity
@Table(name="tipo_ejercicio")
@NamedQuery(name="TipoEjercicio.findAll", query="SELECT t FROM TipoEjercicio t")
public class TipoEjercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String tipid;

	private String tipcategoriaprimaria;

	private String tipcategoriasecundaria;

	//bi-directional many-to-one association to EjercicioTipoEjercicio
	@OneToMany(mappedBy="tipoEjercicio")
	private List<EjercicioTipoEjercicio> ejercicioTipoEjercicios;

	public TipoEjercicio() {
	}

	public String getTipid() {
		return this.tipid;
	}

	public void setTipid(String tipid) {
		this.tipid = tipid;
	}

	public String getTipcategoriaprimaria() {
		return this.tipcategoriaprimaria;
	}

	public void setTipcategoriaprimaria(String tipcategoriaprimaria) {
		this.tipcategoriaprimaria = tipcategoriaprimaria;
	}

	public String getTipcategoriasecundaria() {
		return this.tipcategoriasecundaria;
	}

	public void setTipcategoriasecundaria(String tipcategoriasecundaria) {
		this.tipcategoriasecundaria = tipcategoriasecundaria;
	}

	public List<EjercicioTipoEjercicio> getEjercicioTipoEjercicios() {
		return this.ejercicioTipoEjercicios;
	}

	public void setEjercicioTipoEjercicios(List<EjercicioTipoEjercicio> ejercicioTipoEjercicios) {
		this.ejercicioTipoEjercicios = ejercicioTipoEjercicios;
	}

	public EjercicioTipoEjercicio addEjercicioTipoEjercicio(EjercicioTipoEjercicio ejercicioTipoEjercicio) {
		getEjercicioTipoEjercicios().add(ejercicioTipoEjercicio);
		ejercicioTipoEjercicio.setTipoEjercicio(this);

		return ejercicioTipoEjercicio;
	}

	public EjercicioTipoEjercicio removeEjercicioTipoEjercicio(EjercicioTipoEjercicio ejercicioTipoEjercicio) {
		getEjercicioTipoEjercicios().remove(ejercicioTipoEjercicio);
		ejercicioTipoEjercicio.setTipoEjercicio(null);

		return ejercicioTipoEjercicio;
	}

}
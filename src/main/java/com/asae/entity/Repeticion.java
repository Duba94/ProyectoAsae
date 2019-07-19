package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the repeticion database table.
 * 
 */
@Entity
@NamedQuery(name="Repeticion.findAll", query="SELECT r FROM Repeticion r")
public class Repeticion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String repid;

	private int repcantidad;

	private int reppeso;

	//bi-directional many-to-one association to EvaluacionEjercicio
	@ManyToOne
	@JoinColumn(name="EVALEJERCICIO_ID")
	private EvaluacionEjercicio evaluacionEjercicio;

	public Repeticion() {
	}

	public String getRepid() {
		return this.repid;
	}

	public void setRepid(String repid) {
		this.repid = repid;
	}

	public int getRepcantidad() {
		return this.repcantidad;
	}

	public void setRepcantidad(int repcantidad) {
		this.repcantidad = repcantidad;
	}

	public int getReppeso() {
		return this.reppeso;
	}

	public void setReppeso(int reppeso) {
		this.reppeso = reppeso;
	}

	public EvaluacionEjercicio getEvaluacionEjercicio() {
		return this.evaluacionEjercicio;
	}

	public void setEvaluacionEjercicio(EvaluacionEjercicio evaluacionEjercicio) {
		this.evaluacionEjercicio = evaluacionEjercicio;
	}

}
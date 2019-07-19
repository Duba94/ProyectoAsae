package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the programa_ejercicio database table.
 * 
 */
@Entity
@Table(name="programa_ejercicio")
@NamedQuery(name="ProgramaEjercicio.findAll", query="SELECT p FROM ProgramaEjercicio p")
public class ProgramaEjercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String proejeid;

	//bi-directional many-to-one association to Ejercicio
	@ManyToOne
	@JoinColumn(name="EJERCICIO_ID")
	private Ejercicio ejercicio;

	//bi-directional many-to-one association to Programa
	@ManyToOne
	@JoinColumn(name="PROGRAMA_ID")
	private Programa programa;

	public ProgramaEjercicio() {
	}

	public String getProejeid() {
		return this.proejeid;
	}

	public void setProejeid(String proejeid) {
		this.proejeid = proejeid;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public Programa getPrograma() {
		return this.programa;
	}

	public void setPrograma(Programa programa) {
		this.programa = programa;
	}

}
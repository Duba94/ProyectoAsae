package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the ejercicio database table.
 * 
 */
@Entity
@NamedQuery(name="Ejercicio.findAll", query="SELECT e FROM Ejercicio e")
public class Ejercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String ejeid;

	private String ejenombre;

	//bi-directional many-to-one association to EjercicioTipoEjercicio
	@OneToMany(mappedBy="ejercicio")
	private List<EjercicioTipoEjercicio> ejercicioTipoEjercicios;

	//bi-directional many-to-one association to EvaluacionEjercicio
	@OneToMany(mappedBy="ejercicio")
	private List<EvaluacionEjercicio> evaluacionEjercicios;

	//bi-directional many-to-one association to ProgramaEjercicio
	@OneToMany(mappedBy="ejercicio")
	private List<ProgramaEjercicio> programaEjercicios;

	public Ejercicio() {
	}

	public String getEjeid() {
		return this.ejeid;
	}

	public void setEjeid(String ejeid) {
		this.ejeid = ejeid;
	}

	public String getEjenombre() {
		return this.ejenombre;
	}

	public void setEjenombre(String ejenombre) {
		this.ejenombre = ejenombre;
	}

	public List<EjercicioTipoEjercicio> getEjercicioTipoEjercicios() {
		return this.ejercicioTipoEjercicios;
	}

	public void setEjercicioTipoEjercicios(List<EjercicioTipoEjercicio> ejercicioTipoEjercicios) {
		this.ejercicioTipoEjercicios = ejercicioTipoEjercicios;
	}

	public EjercicioTipoEjercicio addEjercicioTipoEjercicio(EjercicioTipoEjercicio ejercicioTipoEjercicio) {
		getEjercicioTipoEjercicios().add(ejercicioTipoEjercicio);
		ejercicioTipoEjercicio.setEjercicio(this);

		return ejercicioTipoEjercicio;
	}

	public EjercicioTipoEjercicio removeEjercicioTipoEjercicio(EjercicioTipoEjercicio ejercicioTipoEjercicio) {
		getEjercicioTipoEjercicios().remove(ejercicioTipoEjercicio);
		ejercicioTipoEjercicio.setEjercicio(null);

		return ejercicioTipoEjercicio;
	}

	public List<EvaluacionEjercicio> getEvaluacionEjercicios() {
		return this.evaluacionEjercicios;
	}

	public void setEvaluacionEjercicios(List<EvaluacionEjercicio> evaluacionEjercicios) {
		this.evaluacionEjercicios = evaluacionEjercicios;
	}

	public EvaluacionEjercicio addEvaluacionEjercicio(EvaluacionEjercicio evaluacionEjercicio) {
		getEvaluacionEjercicios().add(evaluacionEjercicio);
		evaluacionEjercicio.setEjercicio(this);

		return evaluacionEjercicio;
	}

	public EvaluacionEjercicio removeEvaluacionEjercicio(EvaluacionEjercicio evaluacionEjercicio) {
		getEvaluacionEjercicios().remove(evaluacionEjercicio);
		evaluacionEjercicio.setEjercicio(null);

		return evaluacionEjercicio;
	}

	public List<ProgramaEjercicio> getProgramaEjercicios() {
		return this.programaEjercicios;
	}

	public void setProgramaEjercicios(List<ProgramaEjercicio> programaEjercicios) {
		this.programaEjercicios = programaEjercicios;
	}

	public ProgramaEjercicio addProgramaEjercicio(ProgramaEjercicio programaEjercicio) {
		getProgramaEjercicios().add(programaEjercicio);
		programaEjercicio.setEjercicio(this);

		return programaEjercicio;
	}

	public ProgramaEjercicio removeProgramaEjercicio(ProgramaEjercicio programaEjercicio) {
		getProgramaEjercicios().remove(programaEjercicio);
		programaEjercicio.setEjercicio(null);

		return programaEjercicio;
	}

}
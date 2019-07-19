package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the evaluacion_ejercicio database table.
 * 
 */
@Entity
@Table(name="evaluacion_ejercicio")
@NamedQuery(name="EvaluacionEjercicio.findAll", query="SELECT e FROM EvaluacionEjercicio e")
public class EvaluacionEjercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String evaid;

	private double evaimr;

	private double evatonelaje;

	private double evavolumen;

	//bi-directional many-to-one association to Ejercicio
	@ManyToOne
	@JoinColumn(name="EJERCICIO_ID")
	private Ejercicio ejercicio;

	//bi-directional many-to-one association to Repeticion
	@OneToMany(mappedBy="evaluacionEjercicio")
	private List<Repeticion> repeticions;

	public EvaluacionEjercicio() {
	}

	public String getEvaid() {
		return this.evaid;
	}

	public void setEvaid(String evaid) {
		this.evaid = evaid;
	}

	public double getEvaimr() {
		return this.evaimr;
	}

	public void setEvaimr(double evaimr) {
		this.evaimr = evaimr;
	}

	public double getEvatonelaje() {
		return this.evatonelaje;
	}

	public void setEvatonelaje(double evatonelaje) {
		this.evatonelaje = evatonelaje;
	}

	public double getEvavolumen() {
		return this.evavolumen;
	}

	public void setEvavolumen(double evavolumen) {
		this.evavolumen = evavolumen;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public List<Repeticion> getRepeticions() {
		return this.repeticions;
	}

	public void setRepeticions(List<Repeticion> repeticions) {
		this.repeticions = repeticions;
	}

	public Repeticion addRepeticion(Repeticion repeticion) {
		getRepeticions().add(repeticion);
		repeticion.setEvaluacionEjercicio(this);

		return repeticion;
	}

	public Repeticion removeRepeticion(Repeticion repeticion) {
		getRepeticions().remove(repeticion);
		repeticion.setEvaluacionEjercicio(null);

		return repeticion;
	}

}
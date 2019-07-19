package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the ejercicio_tipo_ejercicio database table.
 * 
 */
@Entity
@Table(name="ejercicio_tipo_ejercicio")
@NamedQuery(name="EjercicioTipoEjercicio.findAll", query="SELECT e FROM EjercicioTipoEjercicio e")
public class EjercicioTipoEjercicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int eteid;

	//bi-directional many-to-one association to Ejercicio
	@ManyToOne
	@JoinColumn(name="EJERCICIO_ID")
	private Ejercicio ejercicio;

	//bi-directional many-to-one association to TipoEjercicio
	@ManyToOne
	@JoinColumn(name="TIPEJERCICIO_ID")
	private TipoEjercicio tipoEjercicio;

	public EjercicioTipoEjercicio() {
	}

	public int getEteid() {
		return this.eteid;
	}

	public void setEteid(int eteid) {
		this.eteid = eteid;
	}

	public Ejercicio getEjercicio() {
		return this.ejercicio;
	}

	public void setEjercicio(Ejercicio ejercicio) {
		this.ejercicio = ejercicio;
	}

	public TipoEjercicio getTipoEjercicio() {
		return this.tipoEjercicio;
	}

	public void setTipoEjercicio(TipoEjercicio tipoEjercicio) {
		this.tipoEjercicio = tipoEjercicio;
	}

}
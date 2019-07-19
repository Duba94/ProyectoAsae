package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigInteger;


/**
 * The persistent class for the evaluacion database table.
 * 
 */
@Entity
@NamedQuery(name="Evaluacion.findAll", query="SELECT e FROM Evaluacion e")
public class Evaluacion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String evaid;

	@Column(name="FK_USUIDENTIFICACION")
	private BigInteger fkUsuidentificacion;

	public Evaluacion() {
	}

	public String getEvaid() {
		return this.evaid;
	}

	public void setEvaid(String evaid) {
		this.evaid = evaid;
	}

	public BigInteger getFkUsuidentificacion() {
		return this.fkUsuidentificacion;
	}

	public void setFkUsuidentificacion(BigInteger fkUsuidentificacion) {
		this.fkUsuidentificacion = fkUsuidentificacion;
	}

}
package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.math.BigInteger;


/**
 * The persistent class for the sesion database table.
 * 
 */
@Entity
@NamedQuery(name="Sesion.findAll", query="SELECT s FROM Sesion s")
public class Sesion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String sesid;

	@Temporal(TemporalType.DATE)
	private Date sesfecha;

	private double sesimrtotal;

	@Column(name="USUARIO_ID")
	private BigInteger usuarioId;

	public Sesion() {
	}

	public String getSesid() {
		return this.sesid;
	}

	public void setSesid(String sesid) {
		this.sesid = sesid;
	}

	public Date getSesfecha() {
		return this.sesfecha;
	}

	public void setSesfecha(Date sesfecha) {
		this.sesfecha = sesfecha;
	}

	public double getSesimrtotal() {
		return this.sesimrtotal;
	}

	public void setSesimrtotal(double sesimrtotal) {
		this.sesimrtotal = sesimrtotal;
	}

	public BigInteger getUsuarioId() {
		return this.usuarioId;
	}

	public void setUsuarioId(BigInteger usuarioId) {
		this.usuarioId = usuarioId;
	}

}
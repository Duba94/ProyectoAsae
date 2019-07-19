package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the asistencia database table.
 * 
 */
@Entity
@NamedQuery(name="Asistencia.findAll", query="SELECT a FROM Asistencia a")
public class Asistencia implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String asiid;

	@Temporal(TemporalType.TIMESTAMP)
	private Date asifecha;

	private String asiobservaciones;

	//bi-directional many-to-one association to Detalleasistencia
	@OneToMany(mappedBy="asistencia")
	private List<Detalleasistencia> detalleasistencias;

	public Asistencia() {
	}

	public String getAsiid() {
		return this.asiid;
	}

	public void setAsiid(String asiid) {
		this.asiid = asiid;
	}

	public Date getAsifecha() {
		return this.asifecha;
	}

	public void setAsifecha(Date asifecha) {
		this.asifecha = asifecha;
	}

	public String getAsiobservaciones() {
		return this.asiobservaciones;
	}

	public void setAsiobservaciones(String asiobservaciones) {
		this.asiobservaciones = asiobservaciones;
	}

	public List<Detalleasistencia> getDetalleasistencias() {
		return this.detalleasistencias;
	}

	public void setDetalleasistencias(List<Detalleasistencia> detalleasistencias) {
		this.detalleasistencias = detalleasistencias;
	}

	public Detalleasistencia addDetalleasistencia(Detalleasistencia detalleasistencia) {
		getDetalleasistencias().add(detalleasistencia);
		detalleasistencia.setAsistencia(this);

		return detalleasistencia;
	}

	public Detalleasistencia removeDetalleasistencia(Detalleasistencia detalleasistencia) {
		getDetalleasistencias().remove(detalleasistencia);
		detalleasistencia.setAsistencia(null);

		return detalleasistencia;
	}

}
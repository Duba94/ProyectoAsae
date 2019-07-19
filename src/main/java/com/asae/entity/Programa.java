package com.asae.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the programa database table.
 * 
 */
@Entity
@NamedQuery(name="Programa.findAll", query="SELECT p FROM Programa p")
public class Programa implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String proid;

	//bi-directional many-to-one association to ProgramaEjercicio
	@OneToMany(mappedBy="programa")
	private List<ProgramaEjercicio> programaEjercicios;

	public Programa() {
	}

	public String getProid() {
		return this.proid;
	}

	public void setProid(String proid) {
		this.proid = proid;
	}

	public List<ProgramaEjercicio> getProgramaEjercicios() {
		return this.programaEjercicios;
	}

	public void setProgramaEjercicios(List<ProgramaEjercicio> programaEjercicios) {
		this.programaEjercicios = programaEjercicios;
	}

	public ProgramaEjercicio addProgramaEjercicio(ProgramaEjercicio programaEjercicio) {
		getProgramaEjercicios().add(programaEjercicio);
		programaEjercicio.setPrograma(this);

		return programaEjercicio;
	}

	public ProgramaEjercicio removeProgramaEjercicio(ProgramaEjercicio programaEjercicio) {
		getProgramaEjercicios().remove(programaEjercicio);
		programaEjercicio.setPrograma(null);

		return programaEjercicio;
	}

}
package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Festival {
	private int id;
	private String nombre;
	private String temporada;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private Costos costos;
	private List<UnidadVenta> lstUnidadesDelFestival;
	
	
	
	public Festival(int id, String nombre, String temporada, LocalDate fechaInicio, LocalDate fechaFin, 
			float costoSuperficie, float costoMontaje, float costoUsoElectricidad, float costoSueldoBase) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		setCostos(costoSuperficie, costoMontaje, costoUsoElectricidad, costoSueldoBase);
		this.lstUnidadesDelFestival = new ArrayList<>(); //No manejar IDs, lo maneja el sistema.
	}

	//GETTERS Y SETTERS ---------------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTemporada() {
		return temporada;
	}
	public void setTemporada(String temporada) {
		this.temporada = temporada;
	}
	public LocalDate getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(LocalDate fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public LocalDate getFechaFin() {
		return fechaFin;
	}
	public void setFechaFin(LocalDate fechaFin) {
		this.fechaFin = fechaFin;
	}
	public Costos getCostos() {
		return costos;
	}
	public void setCostos(float costoSuperficie, float costoMontaje, float costoUsoElectricidad, float costoSueldoBase) {
		this.costos = new Costos(costoSuperficie, costoMontaje, costoUsoElectricidad, costoSueldoBase);
	}
	public List<UnidadVenta> getLstUnidadesDelFestival() {
		return lstUnidadesDelFestival;
	}
	//------------------------------------------------------------
	
}

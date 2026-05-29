package modelo;

import java.time.LocalDate;

public class Cajero extends Empleado {
	
	private String turnoTrabajo;

	// CONSTRUCTOR 
	public Cajero(int id, String nombre, String apellido, long dni, LocalDate fechaDeNacimiento,
			LocalDate fechaDeIngreso, String turnoTrabajo) {
		
		super(id, nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		this.turnoTrabajo = turnoTrabajo;
	}

	// GETTERS Y SETTERS
	public String getTurnoTrabajo() {
		return turnoTrabajo;
	}
	public void setTurnoTrabajo(String turnoTrabajo) {
		this.turnoTrabajo = turnoTrabajo;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Cajero [turnoTrabajo : " + turnoTrabajo + "]";
	}
	
	

}

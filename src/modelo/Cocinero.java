package modelo;

import java.time.LocalDate;

public class Cocinero extends Empleado {
	
	private CategoriaCocinero especialidad;
	
	// CONSTRUCTOR
	public Cocinero(int id, String nombre, String apellido, long dni, LocalDate fechaDeNacimiento,
			LocalDate fechaDeIngreso, CategoriaCocinero especialidad) {
		
		super(id, nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		this.especialidad = especialidad;
	}
	
	// METODOS

	
	// GETTERS Y SETTERS
	public CategoriaCocinero getEspecialidad() {
		return especialidad;
	}

	public void setEspecialidad(CategoriaCocinero especialidad) {
		this.especialidad = especialidad;
	}
	
	// TO STRING 
	@Override
	public String toString() {
		return "Cocinero:"+super.toString()+"Especialidad : " + especialidad + ", Plus : " + especialidad.getPlus() + "]";
	}

	
}

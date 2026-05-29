package modelo;

import java.time.LocalDate;

public class Cocinero extends Empleado {
	
	private String especialidad;
	private float plus;
	
	// CONSTRUCTOR
	public Cocinero(int id, String nombre, String apellido, long dni, LocalDate fechaDeNacimiento,
			LocalDate fechaDeIngreso, String especialidad, float plus) {
		
		super(id, nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso);
		this.especialidad = especialidad;
		this.plus = plus;
	}
	
	// GETTERS Y SETTERS
	public String getEspecialidad() {
		return especialidad;
	}
	public void setEspecialidad(String especialidad) {
		this.especialidad = especialidad;
	}
	public float getPlus() {
		return plus;
	}
	public void setPlus(float plus) {
		this.plus = plus;
	}
	
	// TO STRING 
	@Override
	public String toString() {
		return "Cocinero:"+super.toString()+"especialidad : " + especialidad + ", plus : " + plus + "]";
	}

	
}

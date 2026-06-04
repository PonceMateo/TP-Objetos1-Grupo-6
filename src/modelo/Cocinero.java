package modelo;

import java.time.LocalDate;

public class Cocinero extends Empleado {
	
	private CategoriaCocinero especialidad;
	
	// CONSTRUCTOR
	public Cocinero(int id, String nombre, String apellido, long dni, LocalDate fechaDeNacimiento,
			LocalDate fechaDeIngreso, float sueldoBase ,CategoriaCocinero especialidad) {
		
		super(id, nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso, sueldoBase);
		this.especialidad = especialidad;
	}
	
	// METODOS
	public void modificar(String nombre, String apellido, float sueldoBase ,CategoriaCocinero especialidad) {
		
		setNombre(nombre);
		setApellido(apellido);
		setSueldoBase(sueldoBase);
		this.setEspecialidad(especialidad);
	}
	
	public float calcularSueldo() {
		
		float sueldoFinal = sueldoBase + this.especialidad.getPlus();
		
		return sueldoFinal;
	}
	
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

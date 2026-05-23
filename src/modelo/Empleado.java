package modelo;

import java.time.LocalDate;

public class Empleado {

	private int id;
	private String nombre;
	private String apellido;
	private long dni;
	private LocalDate fechaDeNacimiento;
	private LocalDate fechaDeIngreso;
	private float sueldoBase;
	
	// CONSTRUCTOR 
	public Empleado(int id, String nombre, String apellido, long dni, LocalDate fechaDeNacimiento,
			LocalDate fechaDeIngreso, float sueldoBase) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.dni = dni;
		this.fechaDeNacimiento = fechaDeNacimiento;
		this.fechaDeIngreso = fechaDeIngreso;
		this.sueldoBase = sueldoBase;
	}
	
	// GETTERS Y SETTERS
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
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public long getDni() {
		return dni;
	}
	public void setDni(long dni) {
		this.dni = dni;
	}
	public LocalDate getFechaDeNacimiento() {
		return fechaDeNacimiento;
	}
	public void setFechaDeNacimiento(LocalDate fechaDeNacimiento) {
		this.fechaDeNacimiento = fechaDeNacimiento;
	}
	public LocalDate getFechaDeIngreso() {
		return fechaDeIngreso;
	}
	public void setFechaDeIngreso(LocalDate fechaDeIngreso) {
		this.fechaDeIngreso = fechaDeIngreso;
	}
	public float getSueldoBase() {
		return sueldoBase;
	}
	public void setSueldoBase(float sueldoBase) {
		this.sueldoBase = sueldoBase;
	}
	
	// TO STRING 
	@Override
	public String toString() {
		return "Empleado [id : " + id + ", nombre : " + nombre + ", apellido : " + apellido + ", dni : " + dni
				+ ", fechaDeNacimiento : " + fechaDeNacimiento + ", fechaDeIngreso : " + fechaDeIngreso + ", sueldoBase : "
				+ sueldoBase + "]";
	}
	
	
	
}

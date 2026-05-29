package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	
	private List<Empleado> lstStaff;

	// COSNTRUCTOR
	public Sistema() {
		//super();
		this.lstStaff = new ArrayList<Empleado>();
	}
	
	// METODOS
	public boolean agregarCocinero(String nombre, String apellido, long dni, LocalDate fechaDeNacimiento,
			LocalDate fechaDeIngreso, String especialidad, float plus) throws Exception {
		
		if (this.traerEmpleado(dni) != null) {
			throw new Exception("ERROR el empleado ya existe en el Staff\n");
		}
		
		int id;
		if (lstStaff.isEmpty()) {
			id = 1;
		} else {
			id = lstStaff.get(lstStaff.size() -1).getId() +1;
		}
		
		Cocinero c = new Cocinero(id, nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso, especialidad, plus);
		
		int edad = c.calcularEdad(LocalDate.now());
		
		if (edad < 18) {
			throw new Exception("ERROR el empleado es menor de 18 anios\n");
		}
		
		return lstStaff.add(c);
	}
	
	public boolean agregarCajero(String nombre, String apellido, long dni, LocalDate fechaDeNacimiento,
			LocalDate fechaDeIngreso, String turnoTrabajo) throws Exception { 
		
		if (this.traerEmpleado(dni) != null) {
			throw new Exception("ERROR el empleado ya existe en el Staff\n");
		}
		
		int id;
		if (lstStaff.isEmpty()) {
			id = 1; 
		} else {
			id = lstStaff.get(lstStaff.size() -1).getId() +1;
		}
		
		Cajero c = new Cajero(id, nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso, turnoTrabajo);
		
		int edad = c.calcularEdad(LocalDate.now());
		
		if (edad < 18) {
			throw new Exception("ERROR el empleado es menor de 18 anios\n");
		}
		
		return lstStaff.add(c);
	}
	
	public void modificarCajero(long DNI, String nombre, String apellido,String turnoTrabajo) throws Exception{
		
		Empleado e = this.traerEmpleado(DNI);
		
		if (e == null) {
			throw new Exception("ERROR el Empleado a modificar no existe\n");
		}
		
		if(e instanceof Cajero) {
			Cajero c = (Cajero)e;
			c.modificar(nombre, apellido, turnoTrabajo);
		}
	}
	
	public void modificarCocinero(long DNI, String nombre, String apellido,String especialidad, float plus) throws Exception {
		
		Empleado e = this.traerEmpleado(DNI);
		
		if (e == null) {
			throw new Exception("ERROR el Empleado a modificar no existe\n");
		}
		
		if(e instanceof Cocinero) {
			Cocinero c = (Cocinero)e;
			c.modificar(nombre, apellido, especialidad, plus);
		}
	}
	
	public void eliminarEmpleado(long DNI) throws Exception {
		
		Empleado e = this.traerEmpleado(DNI);
		
		if (e == null) {
			throw new Exception("ERROR el Empleado a eliminar no existe\n");
		}
		
		lstStaff.remove(e);
	}
	
	public float calcularSueldo(long DNI) throws Exception {
		
		Empleado e = this.traerEmpleado(DNI);
		float resultado = 0;
		
		if (e == null) {
			throw new Exception("ERROR el Empleado no existe\n");
		}
		
		if (e instanceof Cajero) {
			Cajero c = (Cajero)e;
			
			resultado = c.calcularSueldo();
		}
		
		if (e instanceof Cocinero) {
			Cocinero co = (Cocinero)e;
			
			resultado = co.calcularSueldo();
		}
		
		return resultado;
	}
		
	public Empleado traerEmpleado(long DNI) {
		
		Empleado e = null;
		int i = 0;
		
		while (e == null && i < lstStaff.size()) {
			
			if (lstStaff.get(i).getDni() == DNI) {
				e = lstStaff.get(i);
			}
			i++;
		}
		return e;
	}
	
	public List<Empleado> traerEmpleadosEntreDosFechas(LocalDate fechaInicio, LocalDate FechaFin) {
		
		List<Empleado> aux = new ArrayList<Empleado>();
		
		for (Empleado e : lstStaff) {
			
			if ((e.getFechaDeNacimiento().isAfter(fechaInicio) || e.getFechaDeNacimiento().isEqual(fechaInicio))
					&& (e.getFechaDeNacimiento().isBefore(FechaFin) || e.getFechaDeNacimiento().isEqual(FechaFin))) {
				
				aux.add(e);
			}
		}
		return aux;
	}
	
	// GETTERS
	public List<Empleado> getLstStaff() {
		return lstStaff;
	}

	// TO STRING
	@Override
	public String toString() {
		return "Sistema [lstStaff : " + lstStaff + "]";
	}


}

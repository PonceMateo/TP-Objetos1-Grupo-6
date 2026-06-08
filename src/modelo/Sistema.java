package modelo;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
	private List<Festival> lstFestival;
	private List<Empleado> lstStaff;
	private List<UnidadVenta> lstUnidadVenta;

	// COSNTRUCTOR
	public Sistema() {
		//super();
		this.lstStaff = new ArrayList<Empleado>();
		this.lstFestival = new ArrayList<>();
		this.lstUnidadVenta = new ArrayList<>();
	}
	
	// METODOS
	
	// EMPLEADO
	public boolean altaEmpladoStaff(String nombre, String apellido, long dni, LocalDate fechaDeNacimiento,
			LocalDate fechaDeIngreso , CategoriaCocinero especialidad) throws Exception {
		
		if (this.traerEmpleado(dni) != null) {
			throw new Exception("ERROR el empleado ya existe en el Staff\n");
		}
		
		int id;
		if (lstStaff.isEmpty()) {
			id = 1;
		} else {
			id = lstStaff.get(lstStaff.size() -1).getId() +1;
		}
		
		Cocinero c = new Cocinero(id, nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso, especialidad);
		
		int edad = c.calcularEdad(LocalDate.now());
		
		if (edad < 18) {
			throw new Exception("ERROR el empleado es menor de 18 anios\n");
		}
		
		return lstStaff.add(c);
	}
	
	public boolean altaEmpladoStaff(String nombre, String apellido, long dni, LocalDate fechaDeNacimiento,
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
	
	public void bajaEmpleado(long DNI) throws Exception {
		
		Empleado e = this.traerEmpleado(DNI);
		
		if (e == null) {
			throw new Exception("ERROR el Empleado a eliminar no existe\n");
		}
		
		lstStaff.remove(e);
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
	
	public List<Empleado> filtrarEdadEmpelado(LocalDate fechaDesde, LocalDate FechaHasta) {
		
		List<Empleado> aux = new ArrayList<Empleado>();
		
		for (Empleado e : lstStaff) {
			
			if (Funciones.fechaEntreFechas(e.getFechaDeNacimiento(), fechaDesde, FechaHasta)) {
				
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

	//FoodTruck
	public boolean altaUnidadVenta(String codigo, String nombreComercial, float superficieEnM2, Empleado responsable, String patente, Boolean requiereElectricidad) throws Exception {
		if(traerUnidadVenta(codigo) != null) {
			throw new Exception("La unidad de venta con código "+ codigo + "ya existe");
		}
		int id = 1;
		if(!lstUnidadVenta.isEmpty()) {
			id = lstUnidadVenta.get(lstUnidadVenta.size()-1).getId() +1;
		}
		
		UnidadVenta u = new FoodTruck(id, codigo, nombreComercial, superficieEnM2, responsable, patente, requiereElectricidad);
		return lstUnidadVenta.add(u);
	}
	
	//PuestoDesarmable
	public boolean altaUnidadVenta(String codigo, String nombreComercial, float superficieEnM2, Empleado responsable, int cantCarpas, float tiempoMontaje) throws Exception {
		if(this.traerUnidadVenta(codigo) != null) {
			throw new Exception("La unidad de venta con código "+ codigo + "ya existe");
		}
		int id = 1;
		if(!lstUnidadVenta.isEmpty()) {
			id = lstUnidadVenta.get(lstUnidadVenta.size()-1).getId() +1;
		}
		
		UnidadVenta u = new PuestoDesarmable(id, codigo, nombreComercial, superficieEnM2, responsable, cantCarpas, tiempoMontaje);
		return lstUnidadVenta.add(u);
	}
	
	public UnidadVenta traerUnidadVenta(String codigo) {
		UnidadVenta u = null;
		
		boolean existe = false;
		int i = 0;
		
		while(!existe && i<lstUnidadVenta.size()) {
			if(lstUnidadVenta.get(i).getCodigo().equals(codigo)){
				existe = true;
				u = lstUnidadVenta.get(i);
			}
			i++;
		}
		
		return u;
	}
	
	public boolean bajaUnidadVenta(String codigo) throws Exception {
		UnidadVenta u = this.traerUnidadVenta(codigo);
		if (u == null) {
			throw new Exception("ERROR la Unidad de Venta a eliminar no existe\n");
		}
		
		return lstUnidadVenta.remove(u);
		//TODO: Debería removerse de la lista del festival tambien?
		
		// en teoria si esta con agregacion en festival se deberia de eliminar creo ?
	}
	
	//======================================================================================
	
	public boolean agregarPedido(String codigoUnidad, Festival festi,LocalDate fecha) throws Exception {

		UnidadVenta unidad = traerUnidadVenta(codigoUnidad);

		if(unidad == null) {
			throw new Exception("La unidad de venta no existe");
		}

		Festival festival = traerFestival(festi.getNombre(), festi.getTemporada());

		if(festival == null) {
			throw new Exception("El festival no existe");
		}

		return unidad.agregarPedido(festival, fecha);
	}
	
	public double calculoRentabilidadNeta(UnidadVenta unidad,Festival festival) throws Exception {

	    double ingresos = 0;
	    double costoPlatos = 0;
	    double sueldos = 0;

	    for(Pedido p : unidad.getLstPedidos()) {
	        ingresos += p.calcularTotal();
	        for(ItemPedido item : p.getLstItems()) {
	            costoPlatos += item.getCantidad() * item.getPlato().getCostoProduccion();
	        }
	    }

	    for(Empleado e : unidad.getLstEmpleados()) {
	        sueldos += festival.calcularSueldo(e.getDni());
	    }

	    double canon = festival.calcularCanon(unidad);

	    return ingresos - costoPlatos - sueldos - canon;
	}
	
	public double calculoRentabilidadNeta(UnidadVenta unidad, Festival festival, LocalDate fechaDesde, LocalDate fechaHasta) throws Exception {

	    double ingresos = 0;
	    double costoPlatos = 0;
	    double sueldos = 0;

	    for(Pedido p : unidad.getLstPedidos()) {
	        if(Funciones.fechaEntreFechas(p.getFecha(),fechaDesde,fechaHasta)) {
	            ingresos += p.calcularTotal();
	            for(ItemPedido item : p.getLstItems()) {
	                costoPlatos += item.getCantidad() * item.getPlato().getCostoProduccion();
	            }
	        }
	    }

	    for(Empleado e : unidad.getLstEmpleados()) {
	        sueldos += festival.calcularSueldo(e.getDni());
	    }

	    double canon = festival.calcularCanon(unidad);

	    return ingresos - costoPlatos - sueldos - canon;
	}
	
}

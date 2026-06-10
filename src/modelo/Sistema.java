package modelo;

import java.time.LocalDate;
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
			LocalDate fechaDeIngreso,  CategoriaCocinero especialidad) throws Exception {
		
		if (this.traerEmpleado(dni) != null) {
			throw new Exception("ERROR el empleado ya existe en el Staff\n");
		}
		
		int id;
		if (lstStaff.isEmpty()) {
			id = 1;
		} else {
			id = lstStaff.get(lstStaff.size() -1).getId() +1;
		}
		
		Cocinero c = new Cocinero(id, nombre, apellido, dni, fechaDeNacimiento, fechaDeIngreso,especialidad);
		
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

	public void bajaUnidadVenta(String codigo) throws Exception {
		UnidadVenta u = this.traerUnidadVenta(codigo);
		if (u == null) {
			throw new Exception("ERROR la Unidad de Venta a eliminar no existe\n");
		}
		
		lstUnidadVenta.remove(u);
		
		for(Festival f : lstFestival) {
			 if (f.traerUnidadVenta(codigo) != null) {
		            f.quitarUnidadVenta(codigo);
		        }
		}
	}
	

	public boolean AltaFestival(String nombre, String temporada, LocalDate fechaInicio 
			,LocalDate fechaFin, float costoPorSuperficie, float costoMontaje
			, float costoUsoElectricidad,  float sueldoBase,  float costoAntiguedad)throws Exception {
		if(traerFestival(nombre, temporada)!=null) {
			throw new Exception("Error El Festival ingresado ya existe\n");
		}
		int id = 1;
		if(!lstFestival.isEmpty()) {
			id = lstFestival.get(lstFestival.size()-1).getId() +1;
		}
		Festival nuevo = new Festival(id, nombre, temporada, fechaInicio, fechaFin, costoPorSuperficie, costoMontaje, costoUsoElectricidad, sueldoBase, costoAntiguedad);
		return lstFestival.add(nuevo);
	}
	
	public void bajaFestival(String nombre, String temporada)throws Exception {
		Festival festi= this.traerFestival(nombre, temporada);
		if(festi==null) {
			throw new Exception("ERROR El festival a eliminar no existe\n");
		}
		lstFestival.remove(festi);
	}
	
	public Festival traerFestival(String nombre, String temporada) {
	Festival encontrado=null;
	for(Festival f: lstFestival) {
		if(f.getNombre().equalsIgnoreCase(nombre) && f.getTemporada().equalsIgnoreCase(temporada)) {
			encontrado=f;
		}
	}
	return encontrado;
	}
	
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
	
	public ReporteVenta reporteRecaudacion(Festival festival) throws Exception{
		if(traerFestival(festival.getNombre(),festival.getTemporada())==null) {
			throw new Exception("ERROR no se puede calcular la recaudacion porque el festival ingresado no existe");
		}
		double total=0;
		for(UnidadVenta u:festival.getLstUnidadesDelFestival()) {
			for(Pedido p:u.getLstPedidos()) {
				total+=p.calcularTotal();
			}
		}
		ReporteVenta recaudacion= new ReporteVenta(festival.getLstUnidadesDelFestival(), total) ;
		return recaudacion;
	}
	
	public double calcularTotalUnidad(UnidadVenta unidad) {
		double total=0;
		for (Pedido p: unidad.getLstPedidos()) {
			total+=p.calcularTotal();
		}
		return total;
	}
	public List<UnidadVenta> rankingUnidades(Festival festival){
		List<UnidadVenta> ranking = new ArrayList<>(festival.getLstUnidadesDelFestival());
		int i=0;
		    for(i = 0; i < ranking.size() - 1; i++) {
		        for(int j = 0; j < ranking.size() - 1 - i; j++) {
		            if(calcularTotalUnidad(ranking.get(j)) < calcularTotalUnidad(ranking.get(j+1))) {
		                UnidadVenta aux = ranking.get(j);
		                ranking.set(j, ranking.get(j+1));
		                ranking.set(j+1, aux);
		            }
		        }
		    }
		return ranking;
	}
	public Plato platoEstrella(UnidadVenta unidad, Festival festival) {
		List<Plato> todosLosPlatos = new ArrayList<>();

	    for(Pedido p : unidad.getLstPedidos()) {
	        for(ItemPedido item : p.getLstItems()) {
	            for(int i = 0; i < item.getCantidad(); i++) {
	                todosLosPlatos.add(item.getPlato());
	            }
	        }
	    }

	    Plato estrella = null;
	    int maxCantidad = 0;

	    for(int i = 0; i < todosLosPlatos.size(); i++) {
	        int conteo = 0;
	        for(int j = 0; j < todosLosPlatos.size(); j++) {
	            if(todosLosPlatos.get(i).getId() == todosLosPlatos.get(j).getId()) {
	                conteo++;
	            }
	        }
	        if(conteo > maxCantidad) {
	            maxCantidad = conteo;
	            estrella = todosLosPlatos.get(i);
	        }
	    }

	    return estrella;		
	}
	
	public List<ReporteMayoresCanon> traerUnidadesMayorCanon(Festival festival){
		List<ReporteMayoresCanon> reportes = new ArrayList<>();
		double canon = 0;
	    // Armo la lista de reportes
	    for(UnidadVenta u : festival.getLstUnidadesDelFestival()) {
			try {
				canon = festival.calcularCanon(u);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        reportes.add(new ReporteMayoresCanon(u, canon));
	    }

	    // Burbujeo
	    for(int i = 0; i < reportes.size() - 1; i++) {
	        for(int j = 0; j < reportes.size() - 1 - i; j++) {
	            if(reportes.get(j).getCanon() < reportes.get(j+1).getCanon()) {
	                ReporteMayoresCanon aux = reportes.get(j);
	                reportes.set(j, reportes.get(j+1));
	                reportes.set(j+1, aux);
	            }
	        }
	    }
	    // Devuelve solo los primeros 3
	    return reportes.subList(0, Math.min(3, reportes.size()));
	}
	
	public List<Empleado> auditoriaFestival(Festival festival){
		List<Empleado> auditoria=new ArrayList<>();
		for(UnidadVenta U: festival.getLstUnidadesDelFestival()) {
			for(Empleado E: U.getLstEmpleados()) {
				if (!auditoria.contains(E)) {
	                auditoria.add(E);
	            }
			}
		}
		return auditoria;
	}
	
}

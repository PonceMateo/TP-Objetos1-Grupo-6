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
			float costoSuperficie, float costoMontaje, float costoUsoElectricidad, float costoSueldoBase, float costoAntiguedad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.temporada = temporada;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		setCostos(costoSuperficie, costoMontaje, costoUsoElectricidad, costoSueldoBase, costoAntiguedad); //TODO: Agregar CostoAntiguedad
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
	public void setCostos(float costoSuperficie, float costoMontaje, float costoUsoElectricidad, float costoSueldoBase, float costoAntiguedad) {
		this.costos = new Costos(costoSuperficie, costoMontaje, costoUsoElectricidad, costoSueldoBase, costoAntiguedad);
	}
	public List<UnidadVenta> getLstUnidadesDelFestival() {
		return lstUnidadesDelFestival;
	}
	//------------------------------------------------------------

	public double calcularCanon(String codigo) throws Exception {
		UnidadVenta u = this.traerUnidadVenta(codigo);
		if(u == null) {
			throw new Exception("La unidad de venta con codigo "+ codigo+" no existe en este festival");
		}

		return this.calcularCanon(u);
	}

	public double calcularCanon(UnidadVenta u) throws Exception {
		//Validaciones
		if(u == null) {
			throw new Exception("La unidad de venta no existe");
		}
		if(this.traerUnidadVenta(u.getCodigo()) == null) {
			throw new Exception("La unidad de venta con codigo "+ u.getCodigo() +" no existe en este festival");
		}
		
		//Calculo
		double canon = (u.getSuperficieEnM2() * this.getCostos().getCostoPorSuperficie());
		
		
		if(u instanceof FoodTruck) {
			FoodTruck f = (FoodTruck)u;
			if(f.getRequiereElectricidad()) {
				canon += this.getCostos().getCostoUsoElectricidad();
			}
		}else if (u instanceof PuestoDesarmable){ 
			PuestoDesarmable p = (PuestoDesarmable)u;
			canon -= (p.getTiempoMontaje() * this.getCostos().getCostoMontaje());
		}
		
		return canon;
	}

	public boolean agregarUnidadVenta(UnidadVenta u) throws Exception {
		if(u == null) {
			throw new Exception("La unidad de venta ingresada no existe");
		}
		if(this.traerUnidadVenta(u.getCodigo()) != null) {
			throw new Exception("La unidad de venta con código "+ u.getCodigo() + "ya existe en este Festival");
		}
		
		return lstUnidadesDelFestival.add(u);
	}
	
	public UnidadVenta traerUnidadVenta(String codigo) { //Traer una unidad de venta que pertenezca a este festival
		UnidadVenta u = null;
		
		boolean existe = false;
		int i = 0;
		
		while(!existe && i<lstUnidadesDelFestival.size()) {
			if(lstUnidadesDelFestival.get(i).getCodigo().equals(codigo)){
				existe = true;
				u = lstUnidadesDelFestival.get(i);
			}
			i++;
		}
		
		return u;
	}
	
	public Empleado traerEmpleado(long dni) {
		
		Empleado encontrado = null;
		int i = 0;
		
		while (encontrado == null && i < lstUnidadesDelFestival.size()) {
			
			for (Empleado e : lstUnidadesDelFestival.get(i).getLstEmpleados()) {
				
				if (e.getDni() == dni) {
					encontrado = e;
				}
			}
			i++;
		}
		return encontrado;
	}
	
	public double calcularSueldo(long dni) throws Exception {
		
		Empleado e = traerEmpleado(dni);
		double resultado = 0;
		
		if (e == null) {
			throw new Exception("ERROR el empleado no existe, no se puede calcular el sueldo");
		}
		
		if (e instanceof Cocinero) {
			Cocinero c = (Cocinero)e;
			
			resultado = getCostos().getCostoSueldoBase() + c.getEspecialidad().getPlus();
		}
		
		if (e instanceof Cajero) {
			Cajero ca = (Cajero)e;
			
			int anio = ca.calcularAntiguedad(LocalDate.now());
			resultado = getCostos().getCostoSueldoBase() + ( anio * getCostos().getCostoAntiguedad() );
		}
		
		return resultado;
	}

	public boolean AgregarUnidaDeVenta(int id, String codigo, String Nombrecomercial, Float Superficie, Empleado Responsable, int Cantcarpas, float tiempoMontaje){
		UnidadVenta nuevo= new PuestoDesarmable(id, codigo, Nombrecomercial, Superficie, Responsable, Cantcarpas, tiempoMontaje);
		return lstUnidadesDelFestival.add(nuevo);
	}
	public boolean AgregarUnidaDeVenta(int id, String codigo, String Nombrecomercial, Float Superficie, Empleado responsables, String patente, boolean RequiereElectricidad){
		UnidadVenta nuevo= new FoodTruck(id, codigo, Nombrecomercial, Superficie, responsables, patente, RequiereElectricidad);
		return lstUnidadesDelFestival.add(nuevo);

	}
	
}

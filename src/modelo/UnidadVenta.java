package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public abstract class UnidadVenta {
	protected int id;
	protected String Codigo;
	protected String nombreComercial;
	protected float superficieEnM2;
	protected Empleado responsable;
	protected List<Empleado> lstEmpleados;
	protected List<Pedido> lstPedidos;
	protected List<Plato> lstPlatos; //Menu
	
	
	public UnidadVenta(int id, String codigo, String nombreComercial, float superficieEnM2, Empleado responsable){
		super();
		this.id = id;
		this.setCodigo(codigo); //Código de tipo: PD00001 (PuestoDesarmable) || FT00001 (FoodTruck)
		this.nombreComercial = nombreComercial;
		this.superficieEnM2 = superficieEnM2;
		this.lstEmpleados = new ArrayList<>(); //TODO: Agregar el responsable a esta lista
		this.lstPedidos = new ArrayList<>(); //<-- En estos si manejar id
		this.lstPlatos = new ArrayList<>(); // <----'
		
		this.setResponsable(responsable);
	}

	//GETTERS Y SETTERS ------------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return Codigo;
	}
	public void setCodigo(String codigo){
		if(this.validarCodigo(codigo)) {
			this.Codigo = codigo.toUpperCase();
		}else {
			throw new IllegalArgumentException("El código " + codigo + "no es válido");
		}
	}
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public float getSuperficieEnM2() {
		return superficieEnM2;
	}
	public void setSuperficieEnM2(float superficieEnM2) {
		this.superficieEnM2 = superficieEnM2;
	}
	public Empleado getResponsable() {
		return responsable;
	}
	public void setResponsable(Empleado responsable) {
		this.responsable = responsable;
		if(!this.lstEmpleados.contains(responsable)) { //Reviso si el nuevo responsable está en la lista actual, sino lo agrego
			this.lstEmpleados.add(responsable);
		}
	}
	public List<Empleado> getLstEmpleados() {
		return lstEmpleados;
	}
	public List<Pedido> getLstPedidos() {
		return lstPedidos;
	}
	public List<Plato> getLstPlatos() {
		return lstPlatos;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UnidadVenta other = (UnidadVenta) obj;
		return Objects.equals(Codigo, other.Codigo) && id == other.id;
	}
	//------------------------------------------------------------

	
	public abstract String getTipo();
	
	@Override
	public String toString() {
		return "UnidadVenta [id=" + id + ", Codigo=" + Codigo + ", nombreComercial=" + nombreComercial
				+ ", superficieEnM2=" + superficieEnM2 + ", responsable=" + responsable.getNombre()
				 + "]";
	}

	public abstract boolean validarCodigo(String codigo);
	
	public boolean agregarEmpleado(Empleado empleado) throws Exception {
		
		for (Empleado e : lstEmpleados) {
			
			if (e.getDni() == empleado.getDni()) {
				throw new Exception("ERROR el empleado que intenta agregar ya existe en la lista");
			}
		}
		return lstEmpleados.add(empleado);
	}
	
	public boolean agregarPlato(String nombrePlato,float precioVenta,float costoProduccion) throws Exception {

		if(traerPlato(nombrePlato) != null) {
			throw new Exception("El plato ya existe");
		}

		int id = 1;

		if(!lstPlatos.isEmpty()) {
			id = lstPlatos.get(lstPlatos.size()-1).getId() + 1;
		}

		Plato plato = new Plato(id, nombrePlato, precioVenta, costoProduccion);
		return lstPlatos.add(plato);
	}
	
	public Plato traerPlato(String nombre) {

		Plato plato = null;
		int i = 0;

		while(plato == null && i < lstPlatos.size()) {
			if(lstPlatos.get(i).getNombrePlato().equalsIgnoreCase(nombre)) {
				plato = lstPlatos.get(i);
			}
			i++;
		}
		return plato;
	}
	
	public boolean agregarPedido(Festival festival, LocalDate fecha) {

		int id = 1;

		if(!lstPedidos.isEmpty()) {
			id = lstPedidos.get(lstPedidos.size() - 1).getId() + 1;
		}

		Pedido pedido = new Pedido(id, fecha, festival, this);
		
		return lstPedidos.add(pedido);
	}
}

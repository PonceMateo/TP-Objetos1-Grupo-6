package modelo;

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

	public String getTipo() {
		// TODO Auto-generated method stubj
		return null;
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
	
	
	
	
	
}

package modelo;

import java.util.ArrayList;
import java.util.List;

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
		this.responsable = responsable;
		this.lstEmpleados = new ArrayList<>(); //TODO: Agregar el responsable a esta lista
												//No se como se podría hacer sin setter ni sin usar lógica aca
												//NO MANEJAR IDS ACA, LOS IDS SON DEL SISTEMA
		
		this.lstPedidos = new ArrayList<>(); //<-- En estos si manejar id
		this.lstPlatos = new ArrayList<>(); // <----'
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
	//------------------------------------------------------------

	public String getTipo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public abstract boolean validarCodigo(String codigo);
	
}

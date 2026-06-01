package modelo;

public class PuestoDesarmable extends UnidadVenta {
	private int cantCarpas;
	private Boolean requiereElectricidad;
	
	

	public PuestoDesarmable(int id, String codigo, String nombreComercial, float superficieEnM2, Empleado responsable,
			int cantCarpas, Boolean requiereElectricidad) {
		super(id, codigo, nombreComercial, superficieEnM2, responsable);
		this.cantCarpas = cantCarpas;
		this.requiereElectricidad = requiereElectricidad;
	}
	
	//GETTERS Y SETTERS ------------------------------------------
	public int getCantCarpas() {
		return cantCarpas;
	}
	public void setCantCarpas(int cantCarpas) {
		this.cantCarpas = cantCarpas;
	}
	public Boolean getRequiereElectricidad() {
		return requiereElectricidad;
	}
	public void setRequiereElectricidad(Boolean requiereElectricidad) {
		this.requiereElectricidad = requiereElectricidad;
	}
	//------------------------------------------------------------
	
	
	
}

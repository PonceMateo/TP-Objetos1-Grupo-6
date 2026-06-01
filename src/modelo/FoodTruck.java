package modelo;

public class FoodTruck extends UnidadVenta{
	private String patente;
	private Boolean requiereElectricidad;

	public FoodTruck(int id, String codigo, String nombreComercial, float superficieEnM2, Empleado responsable,
			String patente, Boolean requiereElectricidad) {
		super(id, codigo, nombreComercial, superficieEnM2, responsable);
		this.patente = patente;
		this.requiereElectricidad = requiereElectricidad;
	}

	//GETTERS Y SETTERS ------------------------------------------
	public String getPatente() {
		return patente;
	}
	public void setPatente(String patente) {
		this.patente = patente;
	}
	public Boolean getRequiereElectricidad() {
		return requiereElectricidad;
	}
	public void setRequiereElectricidad(Boolean requiereElectricidad) {
		this.requiereElectricidad = requiereElectricidad;
	}
	//------------------------------------------------------------
	
	
}

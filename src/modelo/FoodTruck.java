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
	
	@Override
	public boolean validarCodigo(String codigo) {
		boolean valido = false;
		
	    if (codigo != null && codigo.length() == 7) { //Evitamos nullPointer antes de crear SubString
	      
	        String letrasCodigo = codigo.substring(0, 2); //FT
	        String numerosCodigo = codigo.substring(2); //XXXXX
	        
	        if (Funciones.verificarStringsNumericos(numerosCodigo) && letrasCodigo.equalsIgnoreCase("FT")) {
	            valido = true;
	        }
	        
	    } 

	    return valido;
	}
	
	
}

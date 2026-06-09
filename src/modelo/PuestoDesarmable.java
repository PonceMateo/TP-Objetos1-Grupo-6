package modelo;

public class PuestoDesarmable extends UnidadVenta {
	private int cantCarpas;
	private float tiempoMontaje;
	
	

	public PuestoDesarmable(int id, String codigo, String nombreComercial, float superficieEnM2, Empleado responsable,
			int cantCarpas, float tiempoMontaje) {
		super(id, codigo, nombreComercial, superficieEnM2, responsable);
		this.cantCarpas = cantCarpas;
		this.tiempoMontaje = tiempoMontaje;
	}

	
	//GETTERS Y SETTERS ------------------------------------------
	public int getCantCarpas() {
		return cantCarpas;
	}
	public void setCantCarpas(int cantCarpas) {
		this.cantCarpas = cantCarpas;
	}

	public float getTiempoMontaje() {
		return tiempoMontaje;
	}
	public void setTiempoMontaje(float tiempoMontaje) {
		this.tiempoMontaje = tiempoMontaje;
	}

	//------------------------------------------------------------
	

	@Override
	public boolean validarCodigo(String codigo) {
		boolean valido = false;
		
	    if (codigo != null && codigo.length() == 7) { //Evitamos nullPointer antes de crear SubString
	      
	        String letrasCodigo = codigo.substring(0, 2); //PD
	        String numerosCodigo = codigo.substring(2); //XXXXX
	        
	        if (Funciones.verificarStringsNumericos(numerosCodigo) && letrasCodigo.equalsIgnoreCase("PD")) {
	            valido = true;
	        }
	        
	    } 

	    return valido;
	}


	@Override
	public String toString() {
		return "PuestoDesarmable [cantCarpas=" + cantCarpas + ", tiempoMontaje=" + tiempoMontaje + "\nid=" + id
				+ ", Codigo=" + Codigo + ", nombreComercial=" + nombreComercial + ", superficieEnM2=" + superficieEnM2
				+ ", responsable=" + responsable + ", lstPedidos=" + lstPedidos
				+ ", lstPlatos=" + lstPlatos + "]";
	}
	
}

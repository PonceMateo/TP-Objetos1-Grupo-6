package modelo;

//Clase no persistente
public class ReporteMayoresCanon {
	private String nombreComercial;
	private String codigo;
	private String tipoUnidad;
	private Double canon;
	
	
	public ReporteMayoresCanon(UnidadVenta unidad, Double canon) {
		super();
		this.nombreComercial = unidad.getNombreComercial();
		this.codigo = unidad.getCodigo();
		this.tipoUnidad = unidad.getTipo();
		this.canon = canon;
	}


	//GETTERS Y SETTERS ------------------------------------------
	public String getNombreComercial() {
		return nombreComercial;
	}
	public void setNombreComercial(String nombreComercial) {
		this.nombreComercial = nombreComercial;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public String getTipoUnidad() {
		return tipoUnidad;
	}
	public void setTipoUnidad(String tipoUnidad) {
		this.tipoUnidad = tipoUnidad;
	}
	public Double getCanon() {
		return canon;
	}
	public void setCanon(Double canon) {
		this.canon = canon;
	}
	//------------------------------------------------------------


	@Override
	public String toString() {
		return "[Nombre: " + nombreComercial + ", Codigo:" + codigo + ", tipo="
				+ tipoUnidad + ", canon=" + canon + "]";
	}
	
	
	
}

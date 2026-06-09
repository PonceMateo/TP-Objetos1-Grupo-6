package modelo;

import java.util.ArrayList;
import java.util.List;

//Clase no persistente
public class ReporteVenta {
	private List<UnidadVenta> lstUnidadVenta;
	private Double recaudacionTotal;
	
	
	
	public ReporteVenta(List<UnidadVenta> lstUnidadVenta, Double recaudacionTotal) {
		super();
		this.lstUnidadVenta = lstUnidadVenta;
		this.recaudacionTotal = recaudacionTotal;
	}
	
	
	public List<UnidadVenta> getLstUnidadVenta() {
		return lstUnidadVenta;
	}
	public Double getRecaudacionTotal() {
		return recaudacionTotal;
	}
	public void setRecaudacionTotal(Double recaudacionTotal) {
		this.recaudacionTotal = recaudacionTotal;
	}
	
	
	
}
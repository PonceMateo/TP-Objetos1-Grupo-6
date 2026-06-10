package modelo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Pedido {
	private int id;
	private LocalDate fecha;
	private Festival festival;
	private UnidadVenta unidadVenta;
	private List<ItemPedido> lstItems;
	
	
	public Pedido(int id, LocalDate fecha, Festival festival, UnidadVenta unidadVenta) {
		super();
		this.id = id;
		this.fecha = fecha;
		this.festival = festival;
		this.unidadVenta = unidadVenta;
		this.lstItems = new ArrayList<>();
	}


	//GETTERS Y SETTERS------------------------------------------
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public Festival getFestival() {
		return festival;
	}
	public void setFestival(Festival festival) {
		this.festival = festival;
	}
	public UnidadVenta getUnidadVenta() {
		return unidadVenta;
	}
	public void setUnidadVenta(UnidadVenta unidadVenta) {
		this.unidadVenta = unidadVenta;
	}
	public List<ItemPedido> getLstItems() {
		return lstItems;
	}

	//------------------------------------------------------------
	
	public boolean agregarItem(int cantidad, Plato plato) {

		if(cantidad <= 0 || plato == null) {
			return false;
		}

		int id = 1;

		if(!lstItems.isEmpty()) {
			id = lstItems.get(lstItems.size() - 1).getId() + 1;
		}

		ItemPedido item = new ItemPedido(id, cantidad, plato);

		return lstItems.add(item);
	}
	
	public double calcularTotal() {

		double total = 0;

		for(ItemPedido item : lstItems) {
			total += item.calcularSubtotal();
		}

		return total;
	}
	
	@Override
	public String toString() {
		return "Pedido [id=" + id + ", fecha=" + fecha + "]";
	}
	
	
}

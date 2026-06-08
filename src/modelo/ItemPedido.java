package modelo;

public class ItemPedido {
	private int id;
	private int cantidad;
	private Plato plato;
	
	
	public ItemPedido(int id, int cantidad, Plato plato) {
		super();
		this.id = id;
		this.cantidad = cantidad;
		this.plato = plato;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Plato getPlato() {
		return plato;
	}
	public void setPlato(Plato plato) {
		this.plato = plato;
	}
	
	public double calcularSubtotal() {
		return cantidad * plato.getPrecioVenta();
	}
	
	
}

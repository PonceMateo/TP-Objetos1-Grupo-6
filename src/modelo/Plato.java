package modelo;

public class Plato {
	private int id;
	private String nombrePlato;
	private float precioVenta;
	private float costoProduccion;

	public Plato(int id, String nombrePlato, float precioVenta, float costoProduccion) {
		super();
		this.id = id;
		this.nombrePlato = nombrePlato;
		this.precioVenta = precioVenta;
		this.costoProduccion = costoProduccion;
	}

	public int getId() {
		return id;
	}

	public String getNombrePlato() {
		return nombrePlato;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public float getCostoProduccion() {
		return costoProduccion;
	}
}

package modelo;

public class Costos {
	private float costoPorSuperficie;
	private float costoMontaje;
	private float costoUsoElectricidad;
	private float costoSueldoBase;
	
	
	public Costos(float costoPorSuperficie, float costoMontaje, float costoUsoElectricidad, float costoSueldoBase) {
		super();
		this.costoPorSuperficie = costoPorSuperficie;
		this.costoMontaje = costoMontaje;
		this.costoUsoElectricidad = costoUsoElectricidad;
		this.costoSueldoBase = costoSueldoBase;
	}

	// GETTERS Y SETTERS ------------------------------------------------------
	public float getCostoPorSuperficie() {
		return costoPorSuperficie;
	}

	public void setCostoPorSuperficie(float costoPorSuperficie) {
		this.costoPorSuperficie = costoPorSuperficie;
	}

	public float getCostoMontaje() {
		return costoMontaje;
	}

	public void setCostoMontaje(float costoMontaje) {
		this.costoMontaje = costoMontaje;
	}

	public float getCostoUsoElectricidad() {
		return costoUsoElectricidad;
	}

	public void setCostoUsoElectricidad(float costoUsoElectricidad) {
		this.costoUsoElectricidad = costoUsoElectricidad;
	}

	public float getCostoSueldoBase() {
		return costoSueldoBase;
	}

	public void setCostoSueldoBase(float costoSueldoBase) {
		this.costoSueldoBase = costoSueldoBase;
	}
	//------------------------------------------------------------------------
}

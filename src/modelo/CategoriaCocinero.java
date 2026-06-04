package modelo;

public enum CategoriaCocinero {

	PASTELERO(10000), 
	PARRILLERO(15000), 
	SUSHI(20000);

	private float plus;

	CategoriaCocinero(float plus) {
		this.plus = plus;
	}

	public float getPlus() {
		return plus;
	}

}

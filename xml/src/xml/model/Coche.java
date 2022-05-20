package xml.model;

public class Coche {
	private int id;
	private String marca;
	private String modelo;
	private String motor;
	
	public Coche() {
		
	}

	public Coche(int id, String marca, String modelo, String motor) {
		super();
		this.id=id;
		this.marca=marca;
		this.modelo=modelo;
		this.motor=motor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMotor() {
		return motor;
	}

	public void setMotor(String motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Coche [id=" + id + ", marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + "]";
	}
	
}

package xml.model;

public class Caseta {

	private String titulo;
	private String calle;
	private Integer numero;
	private Integer modulos;
	private String clase;
	private String entidad;
	private Integer id;
	private Integer id_calle;

	public Caseta() {

	}

	public Caseta(String titulo, String calle, Integer numero, Integer modulos, String clase, String entidad, Integer id,
			Integer id_calle) {
		this.titulo = titulo;
		this.calle = calle;
		this.numero = numero;
		this.modulos = modulos;
		this.clase = clase;
		this.entidad = entidad;
		this.id = id;
		this.id_calle = id_calle;

	}
	public Caseta(String calle, String titulo,Integer id) {
		this.calle=calle;
		this.titulo=titulo;
		this.id=id;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getModulos() {
		return modulos;
	}

	public void setModulos(Integer modulos) {
		this.modulos = modulos;
	}

	public String getClase() {
		return clase;
	}

	public void setClase(String clase) {
		this.clase = clase;
	}

	public String getEntidad() {
		return entidad;
	}

	public void setEntidad(String entidad) {
		this.entidad = entidad;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_calle() {
		return id_calle;
	}

	public void setId_calle(Integer id_calle) {
		this.id_calle = id_calle;
	}

	@Override
	public String toString() {
		return "DatosLeidos [titulo=" + titulo + ", calle=" + calle + ", numero=" + numero + ", modulos=" + modulos
				+ ", clase=" + clase + ", entidad=" + entidad + ", id=" + id + ", id_calle=" + id_calle + "]";
	}

}

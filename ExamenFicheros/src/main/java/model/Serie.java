package main.java.model;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Serie implements Comparable<Serie> {

	private static final Integer ANNO_MINIMO=1900;
	private String nombreSerie;
	private Integer anno;
	private Tema tema;
	private List<Temporada> temporadas;
	
	public Serie(String nombreSerie, int anno, Tema tema) throws SerieException {
		super();
		this.nombreSerie = nombreSerie;
		setAnno(anno);
		this.tema = tema;
		temporadas=new ArrayList<Temporada>();
	}
	
	public Serie(String nombre, Integer anno, Tema tema) {
		if (anno>ANNO_MINIMO) {
			temporadas= new ArrayList<Temporada>();
			this.nombreSerie=nombre;
			this.anno=anno;
			this.tema=tema;
			
		}else {
			throw new SerieException("No se puede crear la serie");
		}
	}
	
	/**
	 * Añade una nueva temporada. Se le pasará el nombre de la nueva temporada y se añadirá al final.
	 * Debe comprobar que no existe un temporada con ese nombre en cuyo caso saltará la excepción.
	 * @param nombreTemporada
	 * @throws SerieException
	 */
	public void annadirTemporada( String nombreTemporada) throws SerieException {
		/*boolean resultado=false;
		if (temporadas.size()==0) {
			Temporada c1 = new Temporada(nombreTemporada);
			temporadas.add(c1);
		}else {
			if (temporadas.get(getNombreSerie()).contains(nombreTemporada)) {
				Temporada c1 = new Temporada(nombreTemporada);
				temporadas.add(c1);
			}
		}*/
		
		
		System.out.println(temporadas);
		
	}
	
	
	/**
	 * Añade un nuevo capítulo a una temporada. Se le pasará el nombre de la temporada y si la temporada no existe
	 * se lanzará una exception
	 * @param nombreTemporada
	 * @param nombreCapitulo
	 * @throws SerieException
	 */
	public void annadirCapituloTemporada( String nombreTemporada, String nombreCapitulo) throws SerieException {
		Temporada temporada = new Temporada(nombreTemporada);
		int pos = temporadas.indexOf(temporada);
		if (pos == -1) {
			throw new SerieException("No existe la temporada");
		}
		temporadas.get(pos).annadirCapitulo(nombreCapitulo);
	}
	
	
	/**
	 * Valorar temporada. Si no exsite la temporada lanza una exception.
	 * @param nombreTemporada
	 * @param valoracion
	 * @throws SerieException
	 */
	
	public void valorarTemporada(String nombreTemporada, int valoracion) throws SerieException {
		Temporada temporada = new Temporada(nombreTemporada);
		int pos = temporadas.indexOf(temporada);
		if (pos == -1) {
			throw new SerieException("No existe la temporada");
		}
		temporadas.get(pos).valorar(valoracion);
		
	}
	/**
	 * Devuelve un listado de las temporadas de una serie ordenadas  de mayor a menor por nota media. 
	 * De cada temporada se mostrará el nombre, número de capítulos y nota media
	 * @return
	 */
	public String listadoTemporadasPorNotaMedia() {
		StringBuilder sb = new StringBuilder();
		temporadas.sort(new ComparadorNotaMedia());
		for (Temporada c: temporadas) {
			sb.append("Nombre: " + c.getNombreTemporada() 
					+ " Numero capitulos: " + c.getCapitulos().size()
					+ "Nota media: " + c.getNotaMedia());
		}
		return sb.toString();
	}
	
	public String listadoTemporadasPorNumeroCapitulos() {
		StringBuilder sb = new StringBuilder();
		temporadas.sort(new ComparadorNotaMedia());
		for (Temporada c: temporadas) {
			sb.append("Nombre: " + c.getNombreTemporada() 
					+ " Numero capitulos: " + c.getCapitulos().size()
					+ "Nota media: " + c.getNotaMedia());
		}
		return sb.toString();
	}

	/**
	 * Devuelve un listado de las temporadas de una serie ordenadas de menor a mayor por número de capítulos. 
	 * De cada temporada se mostrará el nombre, número de capítulos y nota media.
	 * @return
	 */
	public String listadoTemporadasPorNumeroDeCapitulos() {
		return null;
	}

	
	/**
	 * Devuelve el nombre de la Serie
	 * @return
	 */
	public String getNombreSerie() {
		return nombreSerie;
	}


	/** Asigna el nombre de la serie
	 * 
	 * @param nombreSerie
	 */
	public void setNombreSerie(String nombreSerie) {
		this.nombreSerie = nombreSerie;
	}


	/**
	 * Devuelve el año
	 * @return
	 */
	public int getAnno() {
		return anno;
	}


	/**
	 * Asinga el año
	 * @param anno
	 * @throws SerieException
	 */
	public void setAnno(int anno) throws SerieException {
		if ( anno < ANNO_MINIMO) {
			throw new SerieException("Anno incorrecto");
		}
		this.anno = anno;
	}


	/**
	 * Devuelve el tema
	 * @return
	 */

	public int numeroTemporadas() {
		return temporadas.size();
	}

	
	public List<Temporada> getTemporadas() {
		return temporadas;
	}

	public void setTemporadas(List<Temporada> temporadas) {
		this.temporadas = temporadas;
	}

	public Tema getTema() {
		return tema;
	}

	public void setTema(Tema tema) {
		this.tema = tema;
	}

	public static Integer getAnnoMinimo() {
		return ANNO_MINIMO;
	}

	public void setAnno(Integer anno) {
		this.anno = anno;
	}

	/**
	 * toString
	 */
	public String toString() {
		return  "Serie " + nombreSerie + " Anno " + anno  + "Numero temporadadas " + numeroTemporadas();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nombreSerie == null) ? 0 : nombreSerie.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Serie other = (Serie) obj;
		if (nombreSerie == null) {
			if (other.nombreSerie != null)
				return false;
		} else if (!nombreSerie.equals(other.nombreSerie))
			return false;
		return true;
	}

	@Override
	public int compareTo(Serie o) {
		int resultado=0;
		if (this.anno>o.getAnno()) {
			resultado=-1;
		}else if (this.anno<o.getAnno()) {
			resultado=1;
		}
		
		return resultado;
	}
}

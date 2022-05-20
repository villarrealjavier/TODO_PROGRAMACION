package main.java.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Temporada {
	private String nombreTemporada;
	private List<String> capitulos;
	private Integer sumaOpiniones;
	private Integer numeroOpiniones;
	private Integer valoracion;
	
	
	public Temporada(String nombre) {
		if (nombre!=null && !nombre.isBlank()) {
			this.nombreTemporada=nombre;
			sumaOpiniones=0;
			numeroOpiniones=0;
		}
		capitulos= new ArrayList<>();
	}
	
	public void annadirCapitulo(String nombre) {
		this.capitulos.add(nombre);
	}
	
	
	public void eliminarCapitulo(String nombre) {
		if (this.capitulos.contains(nombre)) {
			this.capitulos.remove(nombre);
		}else {
			throw new SerieException("No se encontró la serie");
		}
	}
	
	public void valorar(Integer numero) {
		sumaOpiniones+=numero;
		numeroOpiniones++;
	}
	
	public void annadirCapituloDespues(String capituloAAnnadir, String capituloAnterior) {
		Integer longitud=capitulos.size();
		for (int i=0;i<capitulos.size();i++) {
			if (capitulos.get(i).contains(capituloAnterior)) {
				capitulos.add(i+1, capituloAAnnadir);
			}
		}if (longitud==capitulos.size()) {
			throw new SerieException("No se puede añadir");
		}
		System.out.println(capitulos);
	}
	
	public String primerCapituloQueContieneEstaPalabra(String palabra) {
		boolean salir=false;
		List<String>listaPalabras= new ArrayList<String>() ;
		for (int i=0;i<capitulos.size();i++) {
			if(capitulos.get(i).contains(palabra)) {
				listaPalabras.add(capitulos.get(i));

			}
		}
		if (listaPalabras.size()==0) {
			throw new SerieException("No se ha encontrado ninguna serie");
		}
		
		
		return listaPalabras.get(0);
	}
	
	public Double getNotaMedia() {
		Double resultado=0.0;
		if ((sumaOpiniones!=null && sumaOpiniones>0) && (numeroOpiniones>0 && numeroOpiniones!=null)) {
			resultado=(double) (sumaOpiniones/numeroOpiniones);
		}else {
			throw new SerieException("No se ha podido obtener la media");
		}
		
		return resultado;
	}

	public String getNombreTemporada() {
		return nombreTemporada;
	}

	public void setNombreTemporada(String nombreTemporada) {
		this.nombreTemporada = nombreTemporada;
	}
	
	public List<String> getCapitulos() {
		return capitulos;
	}

	public void setCapitulos(List<String> capitulos) {
		this.capitulos = capitulos;
	}

	@Override
	public String toString() {
		return "Temporada [nombreTemporada=" + nombreTemporada + ", capitulos=" + capitulos + ", sumaOpiniones="
				+ sumaOpiniones + ", numeroOpiniones=" + numeroOpiniones + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(capitulos, nombreTemporada, numeroOpiniones, sumaOpiniones);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Temporada other = (Temporada) obj;
		return Objects.equals(capitulos, other.capitulos) && Objects.equals(nombreTemporada, other.nombreTemporada)
				&& Objects.equals(numeroOpiniones, other.numeroOpiniones)
				&& Objects.equals(sumaOpiniones, other.sumaOpiniones);
	}
	
}

package main.java.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Historial {

	private Map<LocalDate,Combinacion> historial;

	public Historial(Map<LocalDate, Combinacion> historial) {
		this.historial = new HashMap<>();
	}
	
	public boolean addSorteo(LocalDate fecha, Combinacion combinacion) {
		boolean resultado = false;
		if(!this.historial.containsKey(fecha)) {
			resultado=true;
			this.historial.put(fecha, combinacion);
		}
		return resultado;
		
	}
	public boolean addSorteo(int dia,int mes,int anno, Combinacion combinacion) {
			boolean resultado = false;
			
			if(!this.historial.containsKey(LocalDate.of(anno, mes, dia))) {
				resultado=true;
				this.historial.put(LocalDate.of(anno, mes, dia), combinacion);
			}
			return resultado;
	}
	public boolean actualizarSorteo(int dia ,int mes,int anno,Combinacion combinacion) {
		boolean resultado = false;
		
		this.historial.remove(LocalDate.of(anno, mes, dia));
		this.historial.put(LocalDate.of(anno, mes, dia), combinacion);
		if(this.historial.get(LocalDate.of(anno, mes, dia)).equals(combinacion)) {
			resultado = true;
		}
		
		return resultado;
	}
	public boolean actualizarSorteo(LocalDate fecha, Combinacion combinacion) {	
		boolean resultado = false;
		
		this.historial.remove(fecha);
		this.historial.put(fecha, combinacion);
		if(this.historial.get(fecha).equals(combinacion)) {
			resultado = true;
		}
		
		return resultado;
		
	}
	public boolean borrarSorteo(LocalDate fecha) {
		boolean resultado = false;
		this.historial.remove(fecha);
		if(!this.historial.containsKey(fecha)) {
			resultado=true;
		}
		return resultado;
	}
	public Integer comprobarAciertosHistorial(LocalDate fecha, Combinacion combi){
		
		Iterator<Integer> num = combi.getNumeros().iterator();
		Iterator<Integer> estrellasRecibido = combi.getEstrellas().iterator();
		List<Integer> numeros = new ArrayList();
		List<Integer> estrellas = new ArrayList();
		Integer contador= 0;
		if(this.historial.containsKey(fecha)) {
			
			while(num.hasNext() && estrellasRecibido.hasNext()) {
				numeros.add(num.next());
				estrellas.add(estrellasRecibido.next());
			}
			for (Integer i : numeros) {
				if(this.historial.get(fecha).getNumeros().contains(i)) {
					contador++;
				}
			}
			for (Integer i : estrellas) {
				if(this.historial.get(fecha).getEstrellas().contains(i)) {
					contador++;
				}
			}
		}else {
			contador = -1;
		}
		return contador;
	}
	public List<String> mostrarHistorico(){
		List<String> resultado = new ArrayList();
		for (LocalDate i:this.historial.keySet()) {
			resultado.add(this.historial.get(i).toString());
		}
		
		return resultado;
	}
}	


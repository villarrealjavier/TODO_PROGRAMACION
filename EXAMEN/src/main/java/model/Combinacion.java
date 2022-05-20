package main.java.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Combinacion {
		
	protected static final int VALOR_MINIMO = 1;
	protected static final int VALOR_MAXIMO_NUMEROS = 50;
	protected static final int VALOR_MAXIMO_ESTRELLAS = 12;
	protected static final int TOTAL_NUMEROS = 5;
	protected static final int TOTAL_ESTRELLAS = 2;
	private Set<Integer> numeros;
	private Set<Integer> estrellas;
	
	public Combinacion(int num1,int num2,int num3,int num4,int num5,int estrella1,int estrella2) throws CombinacionException {
		this.numeros = new HashSet<>();
		this.estrellas = new HashSet<>();
		if (numeros.size() <= TOTAL_NUMEROS && numeros.size() <= TOTAL_ESTRELLAS) {
			if (num1 > VALOR_MAXIMO_NUMEROS && num2 > VALOR_MAXIMO_NUMEROS 
					&& num3 > VALOR_MAXIMO_NUMEROS && num4 > VALOR_MAXIMO_NUMEROS 
					&& num5 > VALOR_MAXIMO_NUMEROS) {
				throw(new CombinacionException("Uno de los numeros introducidos es mayor que el maximo permitido"));
			}else if(num1<VALOR_MINIMO && num2 < VALOR_MINIMO && num3 < VALOR_MINIMO 
					&& num4 < VALOR_MINIMO && num5 < VALOR_MINIMO){
				throw(new CombinacionException("Uno de los numeros introducidos es menor que el minimo permitido"));

			}else{
				this.numeros.add(num1);
				this.numeros.add(num2);
				this.numeros.add(num3);
				this.numeros.add(num4);
				this.numeros.add(num5);
			}
			if (estrella1 > VALOR_MAXIMO_ESTRELLAS && estrella1 > VALOR_MAXIMO_ESTRELLAS) {
				throw(new CombinacionException("Una de las estrellas introducidas es mayor que el maximo permitido"));
			}else if(estrella1<VALOR_MINIMO && estrella2 < VALOR_MINIMO){
				throw(new CombinacionException("Una de las estrellas introducidas es menor que el minimo permitido"));

			}else {
				this.estrellas.add(estrella1);
				this.estrellas.add(estrella2);
			}
		}else {
			throw(new CombinacionException("La lista esta completa."));
		}
		
		
		
	}
	public Combinacion(int[] numeros,int[] estrellas) {
		this.numeros = new HashSet<>();
		this.estrellas = new HashSet<>();
		for (int i=0; i<5; i++){
			this.numeros.add(numeros[i]);
		}
		for (int i=0; i<2; i++){
			this.numeros.add(estrellas[i]);
		}
	}
	public Combinacion(Set<Integer> numeros2, Set<Integer> estrellas2) {
		this.estrellas=estrellas2;
		this.numeros=numeros2;
	}
	public Combinacion(Set<Integer> numeros2, Set<Integer> estrellas2, Object object) {
		// TODO Auto-generated constructor stub
	}
	public Set<Integer> getNumeros() {
		return numeros;
	}
	public Set<Integer> getEstrellas() {
		return estrellas;
	}
	public boolean averiguarCombinacion(Combinacion combinacionUsuario) {
		boolean resultado = false;
		if(this.numeros.containsAll(combinacionUsuario.getNumeros()) && this.estrellas.containsAll(combinacionUsuario.getEstrellas())) { 
			resultado = true;
		}
		return resultado;
	}
	public String getNumerosCadena() {
		Iterator<Integer> numerosIte = numeros.iterator();
		List<Integer> numeros = new ArrayList();
		while (numerosIte.hasNext()) {
			numeros.add(numerosIte.next());
		}
		return "Los numeros de su cupon son : "+ numeros.get(0)+"-"+ numeros.get(1)+ "-" + numeros.get(2)
				+"-"+ numeros.get(3)+"-"+ numeros.get(4);
	}
	public String getEstrellasCadena() {
		Iterator<Integer> estrellasIte = estrellas.iterator();
		List<Integer> estrellas = new ArrayList();
		while (estrellasIte.hasNext()) {
			estrellas.add(estrellasIte.next());
		}
		return "Las estrellas de su cupon son : "+ estrellas.get(0)+"-"+ estrellas.get(1);
	}
	@Override
	public int hashCode() {
		return Objects.hash(estrellas, numeros);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Combinacion other = (Combinacion) obj;
		return Objects.equals(estrellas, other.estrellas) && Objects.equals(numeros, other.numeros);
	}
	@Override
	public String toString() {
		return "Combinacion de Numeros:" + getNumerosCadena() +" Estrellas: "+ getEstrellasCadena()+"\n";
	}
	


}

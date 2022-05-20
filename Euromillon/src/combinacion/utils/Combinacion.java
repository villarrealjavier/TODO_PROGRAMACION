package combinacion.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Objects;

public class Combinacion {
	
	protected static final int VALOR_MINIMO=1;
	protected static final int VALOR_MAXIMO_NUMEROS=50;
	protected static final int VALOR_MAXIMO_ESTRELLAS=12;
	protected static final int TOTAL_NUMEROS=5;
	protected static final int TOTAL_ESTRELLAS=2;
	
	private Collection<Integer> numeros= new HashSet<Integer>();
	private Collection<Integer> estrellas= new HashSet<Integer>();
	
	

	public Combinacion(int numero1,int numero2, int numero3, int numero4, int numero5,int numero6, int numero7) {
		this.numeros.add(numero1);
		this.numeros.add(numero2);
		this.numeros.add(numero3);
		this.numeros.add(numero4);
		this.numeros.add(numero5);
		this.estrellas.add(numero6);
		this.estrellas.add(numero7);
	}
	



	public Combinacion(Collection<Integer> numeros, Collection<Integer> estrellas) {
		super();
		this.numeros = numeros;
		this.estrellas = estrellas;
	}
	
	public int comprobarCombinacion(Combinacion combinacionNueva) {
		int contador=0;
		for (Integer n: numeros) {
			if(combinacionNueva.getNumeros().contains(n)) {
				contador++;
			}
		}
		for (Integer m: estrellas) {
			if(combinacionNueva.getEstrellas().contains(m)) {
				contador++;
			}
		}
		
		return contador;
		
	}




	public Collection<Integer> getNumeros() {
		return numeros;
	}



	public Collection<Integer> getEstrellas() {
		return estrellas;
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
	
	public String devolverNumeros() {
		return this.numeros+"";
	}
	
	public String devolverEstrellas() {
		return this.estrellas+"";
	}




	@Override
	public String toString() {
		return numeros + " Estrellas: " + estrellas + "\n";
	}
	
	
	

}

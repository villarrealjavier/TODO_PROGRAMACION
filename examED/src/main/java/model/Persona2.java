package main.java.model;

import java.time.LocalDate;

public class Persona2 {

	private String nombre;
	private String apellido;
	private String dni;
	private LocalDate fechaNacimiento;
	private Genero genero;


	
	public Persona2() {
		super();
	}
	
	public Persona2(String nombre, String apellido, String dni) {
		this();
		if(validarDatos(nombre, apellido, dni)) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;

		}else {
			throw new PersonaException();
		}
	}
	
	public Persona2(String nombre, String apellido, String dni, LocalDate fechaNacimiento, String genero) {
		this();
		if(validarDatos(nombre, apellido, dni, fechaNacimiento, genero)) {
			this.nombre = nombre;
			this.apellido = apellido;
			this.dni = dni;
			this.fechaNacimiento = fechaNacimiento;
			this.genero = Genero.valueOf(genero);
		}else {
			throw new PersonaException();
		}
	}
	
	
	public boolean validarDatos(String nombre, String apellido, String dni) {
		boolean resultado=true;
		resultado = validarNombreyApellido(nombre, apellido, resultado);

		if (dni == null || dni.isEmpty() || dni.length() < 9 || !Character.isAlphabetic(dni.charAt(8))) {
			
			resultado=false;
		}else {
			if ("TRWAGMYFPDXBNJZSQVHLCKE".charAt(Integer.valueOf(dni.substring(0, 8))%23)!= dni.toUpperCase().charAt(8))
				resultado=false;
				

		}

		for(int i=0; i<dni.length()-1; i++) 
			if(!Character.isDigit(dni.charAt(i)))
				resultado=false;
			
		
		return resultado;
	}
	
	public boolean validarDatos(String nombre, String apellido, String dni, LocalDate fechaNacimiento, String genero) {
		boolean resultado=true;
		resultado = validarNombreyApellido(nombre, apellido, resultado);

		if (dni == null || dni.isEmpty() || dni.length() < 9 || !Character.isAlphabetic(dni.charAt(8))) {
			
			resultado=false;
		}else {
			if ("TRWAGMYFPDXBNJZSQVHLCKE".charAt(Integer.valueOf(dni.substring(0, 8))%23)!= dni.toUpperCase().charAt(8))
				resultado=false;
				

		}
		
		for(int i=0; i<dni.length()-1; i++) 
			if(!Character.isDigit(dni.charAt(i))) 
				resultado=false;

		if (fechaNacimiento == null || fechaNacimiento.isAfter(LocalDate.now())) {
			resultado=false;
		}
		
		if (genero == null || genero.isEmpty() || !Genero.HOMBRE.equals(Genero.valueOf(genero)) && !Genero.MUJER.equals(Genero.valueOf(genero))) {
			resultado=false;
		}
		
		return resultado;
	}

	public boolean validarNombreyApellido(String nombre, String apellido, boolean resultado) {
		if (nombre == null || nombre.isEmpty()) {
			
			resultado=false;
		}

		if (apellido == null || apellido.isEmpty()) {
			resultado=false;
		}
		return resultado;
	}
	
	
	
	public boolean bonoJovenDisponible() {
		if(LocalDate.now().getYear()-this.fechaNacimiento.getYear()> 18) {
			if(LocalDate.now().getYear()-this.fechaNacimiento.getYear()< 30) {
				return true;
			}
		}

		return false;
		
	}
	
	public int getEdad() {
		return LocalDate.now().compareTo(fechaNacimiento)>=0?
						LocalDate.now().minusYears(this.fechaNacimiento.getYear()).getYear()	:	-1;
	}
	
	public int obtenerEdadPara(int year) {
		if(year>=this.fechaNacimiento.getYear()) {
			return year-this.fechaNacimiento.getYear();
		}
		return -1;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getApellido() {
		return apellido;
	}


	public void setApellido(String apellido) {
		this.apellido = apellido;
	}


	public String getDni() {
		return dni;
	}


	public void setDni(String dni) {
		this.dni = dni;
	}


	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}


	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public Genero getGenero() {
		return genero;
	}


	public void setGenero(Genero genero) {
		this.genero = genero;
	}
}

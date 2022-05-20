package test.java;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.java.model.Persona;
import main.java.model.Persona2;
import main.java.model.PersonaException;

class PersonaTest {

	
	@Test
	void datosValidosTest() {
		
			Persona p1 = new Persona();
			Persona p2 = new Persona();
			Persona p3 = new Persona();
	p1.validarDatos("Javier", "Villarreal", "29581261H");
	p2.validarDatos("Javier", "Villa", "29581261H", LocalDate.of(2003, 4, 28), "HOMBRE");
	p3.validarDatos("Javier", "Villa", "29581261H", LocalDate.of(2003, 4, 28), "MUJER");

		assert(true);
		
	}@Test
	void datosNoValidosTest() {
		
		try {
			Persona p1 = new Persona();
			
			
			p1.validarDatos("Javier", "Villa", "29581H", LocalDate.of(2003, 4, 28), "HOMBRE");
			p1.validarDatos("Javier", "Loco", "295812610", LocalDate.of(2019, 4, 12), "MUJER");
			p1.validarDatos("", "", "", LocalDate.of(2001, 4, 12), "");
			p1.validarDatos("Javier", "Villarreal", "295812610");
			p1.validarDatos("Javier", "Loco", "295812610", LocalDate.of(2023, 4, 12), "MUJER");


		}catch (PersonaException e) {
			
		}

}@Test
	void noDatosVaciosTest() {
	try {
		Persona p1 = new Persona();
		
p1.validarDatos("", "", "");
p1.validarDatos("", "", "", LocalDate.of(2003, 4, 28), "");


	}catch (PersonaException e) {
	
}
}@Test
void DatosNulosTest() {
	try {
		Persona p1 = new Persona();
		
		p1.validarDatos(null, null, null, null, null);


	}catch (PersonaException e) {
	
}

}
	@Test
	void bonoJovenSiTest() {
	
	
	Persona p1 = new Persona("Javier", "Villa", "29581261H", LocalDate.of(1993, 4, 28), "HOMBRE");
	Persona p2 = new Persona("Javier", "Villa", "29581261H", LocalDate.of(2003, 4, 28), "HOMBRE");


	
	assertTrue(p1.bonoJovenDisponible());
	assertTrue(p2.bonoJovenDisponible());
	
	
}	@Test
void bonoJovenNoTest() {
	
	Persona p1 = new Persona("Javier", "Villa", "29581261H", LocalDate.of(1992, 4, 28), "HOMBRE");
	Persona p2 = new Persona("Javier", "Villa", "29581261H", LocalDate.of(2004, 4, 28), "HOMBRE");

	

	assertFalse(p1.bonoJovenDisponible());
	assertFalse(p2.bonoJovenDisponible());

}
@Test
void devolverEdadTest() {
	
	Persona p1 = new Persona("Javier", "Villa", "29581261H", LocalDate.of(1992, 4, 28), "HOMBRE");
	Persona p2 = new Persona("Javier", "Villa", "29581261H", LocalDate.of(2021, 4, 28), "HOMBRE");
	Persona p3 = new Persona("Javier", "Villa", "29581261H", LocalDate.of(1960, 4, 28), "HOMBRE");
	Persona p4 = new Persona("Javier", "Villa", "29581261H", LocalDate.of(2022, 4, 28), "HOMBRE");


	assertEquals(p1.getEdad(), 30);
	assertEquals(p2.getEdad(), 1);
	assertEquals(p3.getEdad(), 62);
	assertEquals(p4.getEdad(), 0);

}@Test
void noDevolverEdadTest() {
	try {
		Persona p1 = new Persona("Javier", "Villa", "29581261H", LocalDate.of(2023, 4, 28), "HOMBRE");
		Persona p2 = new Persona("Javier", "Villa", "29581261H", null, "HOMBRE");

		assert(false);
	}catch (PersonaException e){
		assert(true);

	}
	

}
@ValueSource (ints = {2002,1950,1800})
@ParameterizedTest
void noDevolverEdadAFinalesTest(Integer anno) {
		Persona p1 = new Persona("Javier", "Villa", "29581261H", LocalDate.of(2003, 4, 28), "HOMBRE");
		assertEquals(p1.obtenerEdadPara(anno),-1);

	
	
}
@ValueSource (ints = {2003,2012,2018})
@ParameterizedTest
void DevolverEdadAFinalesTest(Integer anno) {
		Persona p1 = new Persona("Javier", "Villa", "29581261H", LocalDate.of(2003, 4, 28), "HOMBRE");
		assertTrue(p1.obtenerEdadPara(anno)!=-1);

	
	
}

//REFACTORIZACION
@Test
void datosRefactorizadosValidosTest() {
	
		Persona2 p1 = new Persona2();
		Persona2 p2 = new Persona2();
		Persona2 p3 = new Persona2();
p1.validarDatos("Javier", "Villarreal", "29581261H");
p2.validarDatos("Javier", "Villa", "29581261H", LocalDate.of(2003, 4, 28), "HOMBRE");
p3.validarDatos("Javier", "Villa", "29581261H", LocalDate.of(2003, 4, 28), "MUJER");

	assert(true);
	
}
@Test
void noDatosRefactorizadosValidosTest() {
	try {
		Persona2 p1 = new Persona2();
		
p1.validarDatos("Javier", "Villarreal", "295812619");
p1.validarDatos("Javier", "Villa", "29581H", LocalDate.of(2003, 4, 28), "HOMBRE");
p1.validarDatos("Javier", "Villa", "295812610", LocalDate.of(2003, 4, 28), "HOMBRE");
p1.validarDatos("", "", "295812610", LocalDate.of(2022, 4, 28), "MUJER");

	}catch (PersonaException e) {
	
}
}
	@Test
	void noDatosRefactorizadosVaciosTest() {
		try {
			Persona2 p1 = new Persona2();
			
	p1.validarDatos("", "", "");
	p1.validarDatos("", "", "", LocalDate.of(2003, 4, 28), "");


		}catch (PersonaException e) {
		
	}
	
}
	
	@Test
void bonoJovenSiTestRefactorizada() {
	
	
Persona2 p1 = new Persona2("Javier", "Villa", "29581261H", LocalDate.of(1993, 4, 28), "HOMBRE");
Persona2 p2 = new Persona2("Javier", "Villa", "29581261H", LocalDate.of(2003, 4, 28), "HOMBRE");



assertTrue(p1.bonoJovenDisponible());
assertTrue(p2.bonoJovenDisponible());


}	@Test
void bonoJovenNoTestRefactorizada() {

Persona2 p1 = new Persona2("Javier", "Villa", "29581261H", LocalDate.of(1992, 4, 28), "HOMBRE");
Persona2 p2 = new Persona2("Javier", "Villa", "29581261H", LocalDate.of(2004, 4, 28), "HOMBRE");



assertFalse(p1.bonoJovenDisponible());
assertFalse(p2.bonoJovenDisponible());

}
@Test
void devolverEdadTestRefactorizada() {

Persona2 p1 = new Persona2("Javier", "Villa", "29581261H", LocalDate.of(1992, 4, 28), "HOMBRE");
Persona2 p2 = new Persona2("Javier", "Villa", "29581261H", LocalDate.of(2021, 4, 28), "HOMBRE");
Persona2 p3 = new Persona2("Javier", "Villa", "29581261H", LocalDate.of(1960, 4, 28), "HOMBRE");
Persona2 p4 = new Persona2("Javier", "Villa", "29581261H", LocalDate.of(2022, 4, 28), "HOMBRE");


assertEquals(p1.getEdad(), 30);
assertEquals(p2.getEdad(), 1);
assertEquals(p3.getEdad(), 62);
assertEquals(p4.getEdad(), 0);

}@Test
void noDevolverEdadTestRefactorizada() {
try {
	Persona2 p1 = new Persona2("Javier", "Villa", "29581261H", LocalDate.of(2023, 4, 28), "HOMBRE");
	Persona2 p2 = new Persona2("Javier", "Villa", "29581261H", null, "HOMBRE");

	assert(false);
}catch (PersonaException e){
	assert(true);

}


}
@ValueSource (ints = {2002,1950,1800})
@ParameterizedTest
void noDevolverEdadAFinalesTestRefactorizado(Integer anno) {
	Persona2 p1 = new Persona2("Javier", "Villa", "29581261H", LocalDate.of(2003, 4, 28), "HOMBRE");
	assertEquals(p1.obtenerEdadPara(anno),-1);



}
@ValueSource (ints = {2003,2012,2018})
@ParameterizedTest
void DevolverEdadAFinalesTestRefactorizado(Integer anno) {
	Persona2 p1 = new Persona2("Javier", "Villa", "29581261H", LocalDate.of(2003, 4, 28), "HOMBRE");
	assertTrue(p1.obtenerEdadPara(anno)!=-1);



}

}

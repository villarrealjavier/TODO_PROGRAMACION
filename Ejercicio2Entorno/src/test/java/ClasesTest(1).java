package test.java;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ClasesTest {

	@ValueSource (ints = {5,7})
	@ParameterizedTest
	void testNoVacia(Integer num1) {
		Map<Integer,Integer> mapaVacio = new HashMap<Integer,Integer>();
		mapaVacio.put(num1, 1);
		assertTrue(!mapaVacio.isEmpty());
	}

	@org.junit.jupiter.api.Test
	void testIsEmpty() {
		Map<Integer,Integer> mapaVacio = new HashMap<Integer,Integer>();
		
		assertTrue(mapaVacio.isEmpty());
	}

	@org.junit.jupiter.api.Test
	void testNoObtiene() {
		Map<Integer,Integer> mapaVacio = new HashMap<Integer,Integer>();
		mapaVacio.put(7, 7);
		
		assertNotEquals(mapaVacio.get(9), 7);
		assertEquals(mapaVacio.get(0), null);
		assertEquals(mapaVacio.get(null), null);

	}
	@org.junit.jupiter.api.Test
	void testGet() {
		Map<Integer,Integer> mapaVacio = new HashMap<Integer,Integer>();
		mapaVacio.put(7, 7);
		mapaVacio.put(-7, 7);
		mapaVacio.put(0, 7);
		

		
		assertEquals(mapaVacio.get(7), 7);
		assertEquals(mapaVacio.get(-7), 7);
		assertEquals(mapaVacio.get(0), 7);

	}

	@org.junit.jupiter.api.Test
	void testPut() {
		Map<Integer,Integer> mapaVacio = new HashMap<Integer,Integer>();
		mapaVacio.put(3, 3);
		mapaVacio.put(-3, -3);
		mapaVacio.put(4, -3);
		mapaVacio.put(-4, 3);
		mapaVacio.put(0, 0);
		mapaVacio.put(null, null);




		assertEquals(mapaVacio.get(3), 3);
		assertEquals(mapaVacio.get(-3), -3);
		assertEquals(mapaVacio.get(-4), 3);
		assertEquals(mapaVacio.get(0), 0);
		assertEquals(mapaVacio.get(4), -3);
		assertEquals(mapaVacio.get(null), null);

		
	}

	
	@Test
	void testPutAll() {
		Map<Integer,Integer> mapaVacio = new HashMap<Integer,Integer>();
		mapaVacio.put(3, 3);
		mapaVacio.put(-3, -3);
		mapaVacio.put(4, -3);
		mapaVacio.put(-4, 3);
		mapaVacio.put(0, 0);
		Map<Integer,Integer> mapaannadir = new HashMap<Integer,Integer>();
		mapaannadir.put(12, 9);
		mapaannadir.put(88, 12);
		mapaVacio.putAll(mapaannadir);
		
		assertEquals(mapaVacio.size(), 7);
		
		
	}

	@org.junit.jupiter.api.Test
	void testClear() {
		Map<Integer,Integer> mapaVacio = new HashMap<Integer,Integer>();
		mapaVacio.put(3, 3);
		mapaVacio.put(-3, -3);
		mapaVacio.put(4, -3);
		mapaVacio.put(-4, 3);
		mapaVacio.put(0, 0);
		mapaVacio.clear();
		
		assertEquals(mapaVacio.size(), 0);
	}

	@ValueSource(strings = {"Tomate","Queso","L"})
	@ParameterizedTest
	void testContienePalabra(String palabra) {
		Map<String,Integer> mapaVacio = new HashMap<String,Integer>();
		mapaVacio.put(palabra, 1);
		assertTrue(mapaVacio.containsKey(palabra));
		
	}
	@ValueSource(strings = {"Tomate","Queso","L"})
	@ParameterizedTest
	void testNoContienePalabra(String palabra) {
		Map<String,Integer> mapaVacio = new HashMap<String,Integer>();
		mapaVacio.put("Ole", 1);
		assertTrue(!mapaVacio.containsKey(palabra));
		
	}

}

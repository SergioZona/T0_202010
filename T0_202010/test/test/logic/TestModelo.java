package test.logic;

import static org.junit.Assert.*;
import model.logic.Modelo;

import org.junit.Before;
import org.junit.Test;

public class TestModelo {
	
	private Modelo modelo;
	private static int CAPACIDAD=100;
	
	@Before
	public void setUp1() {
		modelo= new Modelo(CAPACIDAD);
	}

	public void setUp2() {
		for(int i =0; i< CAPACIDAD;i++){
			modelo.agregar(i);
		}
	}

	@Test
	public void testModelo() {
		assertTrue(modelo!=null);
		assertEquals(0, modelo.darTamano());  // Modelo con 0 elementos presentes.
	}

	@Test
	public void testDarTamano() {
		setUp1();
		//Caso del tamaño inicial y la capacidad
		assertEquals(0, modelo.darTamano());
		assertEquals(CAPACIDAD, modelo.darDatos().darCapacidad());
		
		//Caso de agregar un elemento
		modelo.agregar(1);
		assertEquals(1, modelo.darTamano());
		
		//Caso de eliminar un elemento
		modelo.eliminar(1);
		assertEquals(0, modelo.darTamano());
		// TODO
	}

	@Test
	public void testAgregar() {
		setUp1();
		//Comprobar agregar un elemento.
		modelo.agregar(1);
		assertEquals(1, modelo.darTamano());
		modelo.eliminar(1);
		
		//Comprobar que la capacidad del arreglo aumenta si el tamaño sobrepasa la capacidad.
		setUp2();
		modelo.agregar(101);
		assertEquals(200, modelo.darDatos().darCapacidad());
		// TODO Completar la prueba
	}

	@Test
	public void testBuscar() {
		setUp2();
		//Buscar al primer elemento.
		assertEquals(0, modelo.buscar(0));
		
		//Buscar un elemento intermedio.
		assertEquals(57,modelo.buscar(57));
		
		//Buscar el último elemento.
		assertEquals(99, modelo.buscar(99));
		
		//Buscar un elemento que no existe.
		assertEquals(null, modelo.buscar(135));
		// TODO Completar la prueba
	}

	@Test
	public void testEliminar() {
		setUp2();
		
		//Eliminar el último elemento. 
		modelo.eliminar(99);
		assertEquals(null, modelo.darDatos().darElemento(99));
		assertEquals(99, modelo.darTamano());
		
		//Eliminar un elemento intermedio.
		modelo.eliminar(11);
		assertEquals(12, modelo.darDatos().darElemento(11)); //Comprueba si se movió el arreglo un espacio a la izquierda.
		assertEquals(98, modelo.darTamano());
		
		//Eliminar al primer elemento.
		modelo.eliminar(0);
		assertEquals(1, modelo.darDatos().darElemento(0)); //Comprueba si se movió el arreglo un espacio a la izquierda.
		assertEquals(97, modelo.darTamano());
		
		// TODO Completar la prueba
	}
}

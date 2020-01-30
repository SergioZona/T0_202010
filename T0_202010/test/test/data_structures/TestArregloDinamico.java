package test.data_structures;

import model.data_structures.ArregloDinamico;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TestArregloDinamico {

	private ArregloDinamico arreglo;
	private static int TAMANO=100;

	@Before
	public void setUp1() {
		arreglo= new ArregloDinamico(TAMANO);
	}

	public void setUp2() {
		for(int i =0; i< TAMANO*2; i++){
			arreglo.agregar(i);
		}
	}

	@Test
	public void testArregloDinamico() {
		// TODO
		setUp2();
		assertEquals(200, arreglo.darCapacidad()); 
		arreglo.agregar(1);
		assertEquals(400, arreglo.darCapacidad()); 
	}

	@Test
	public void testDarElemento() {
		setUp2();
		//Solicitar el primer elemento.
		assertEquals(0, arreglo.darElemento(0));

		//Solicitar un elemento intermedio.
		assertEquals(57,arreglo.darElemento(57));

		//Solicitar el último elemento.
		assertEquals(199, arreglo.darElemento(199));

		//Solicitar un elemento que no existe.
		assertEquals(null,arreglo.darElemento(480));
		// TODO Completar la prueba
	}
}

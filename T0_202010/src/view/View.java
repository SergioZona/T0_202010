package view;

import model.logic.Modelo;

public class View 
{
	    /**
	     * Metodo constructor
	     */
	    public View()
	    {
	    	
	    }
	    
		public void printMenu()
		{
			System.out.println("1. Crear Arreglo Dinamico de Int's");
			System.out.println("2. Agregar Int");
			System.out.println("3. Buscar Int");
			System.out.println("4. Eliminar Int");
			System.out.println("5. Imprimir el Arreglo");
			System.out.println("6. Exit");
			System.out.println("Dar el numero de opcion a resolver, luego oprimir tecla Return: (e.g., 1):");
		}

		public void printMessage(String mensaje) {

			System.out.println(mensaje);
		}		
		
		public void printModelo(Modelo modelo)
		{
			// TODO implementar
			for(int i=0; i<modelo.darDatos().darTamano(); i++)
			{			
				System.out.println(modelo.darDatos().darElemento(i));				
			}
		}
}

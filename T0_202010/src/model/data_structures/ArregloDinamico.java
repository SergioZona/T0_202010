package model.data_structures;

/**
 * 2019-01-23
 * Estructura de Datos Arreglo Dinamico de Strings.
 * El arreglo al llenarse (llegar a su maxima capacidad) debe aumentar su capacidad.
 * @author Fernando De la Rosa
 *
 */
public class ArregloDinamico<T extends Comparable<T>> implements IArregloDinamico<T>
 {
	/**
	 * Capacidad maxima del arreglo
	 */
	private int tamanoMax;
	/**
	 * Numero de elementos presentes en el arreglo (de forma compacta desde la posicion 0)
	 */
	private int tamanoAct;
	/**
	 * Arreglo de elementos de tamaNo maximo
	 */
	private T elementos[ ];

	/**
	 * Construir un arreglo con la capacidad maxima inicial.
	 * @param max Capacidad maxima inicial
	 */
	public ArregloDinamico( int max )
	{
		elementos = (T[]) new Comparable[max];
		tamanoMax = max;
		tamanoAct = 0;
	}

	public void agregar( T dato )
	{
		if ( tamanoAct == tamanoMax )
		{  // caso de arreglo lleno (aumentar tamaNo)
			tamanoMax = 2 * tamanoMax;
			T [ ] copia = elementos;
			elementos = (T[]) new Comparable[tamanoMax];
			for ( int i = 0; i < tamanoAct; i++)
			{
				elementos[i] = copia[i];
			} 
			System.out.println("Arreglo lleno: " + tamanoAct + " - Arreglo duplicado: " + tamanoMax);
		}	
		elementos[tamanoAct] = dato;
		tamanoAct++;
	}

	public int darCapacidad() {
		return tamanoMax;
	}

	public int darTamano() {
		return tamanoAct;
	}

	public T darElemento(int i) {
		// TODO implementar
		if(elementos.length<i)
		{
			return null;
		}
		else
		{
			return elementos[i];
		}
	}

	public T buscar(T dato) {
		boolean encontrado=false;
		T buscado=null;
		try
		{
			for(int i=0; i<elementos.length && encontrado==false; i++)
			{
				if(elementos[i].compareTo(dato)==0)
				{
					encontrado=true;
					buscado=elementos[i];
				}
			}
		}
		catch (Exception e)
		{
			return null;
		}
		
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		return buscado;

	}

	public T eliminar(T dato) {
		boolean encontrado=false;
		T eliminado=null;
		if(buscar(dato)==null)
		{
			encontrado=true;
		}
		for(int i=0; i<elementos.length && encontrado==false; i++)
		{
			//El try se encuentra en caso de que el compareTo tire un error.
			try
			{
				if(elementos[i].compareTo(dato)==0)
				{
					encontrado=true;
					eliminado=elementos[i];
					//Caso para último elemento, se pone null predeterminado en caso de que no entre al for.
					elementos[i]=null;
					tamanoAct--;
					for(int j=i; j<elementos.length-1; j++)
					{
						elementos[j]=elementos[j+1];
					}				
				}
			}
			catch (Exception e)
			{
				return null;
			}
			
		}
		// TODO implementar
		// Recomendacion: Usar el criterio de comparacion natural (metodo compareTo()) definido en Strings.
		return eliminado;
	}

	@Override
	public int compareTo(T obj) {
		
		// TODO Auto-generated method stub
		return 0;
	}
}

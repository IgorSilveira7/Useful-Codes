package binary_search;

public class BinarySearch {
	
	public int buscaBinariaIterativa(int[] array, int x) {
		int meio;
		int inicio = 0;
		int fim = array.length - 1;
		
		while(inicio <= fim) {
			meio = (inicio + fim) / 2;
			if(array[meio] == x)
				return meio;
			else if(array[meio] < x)
				inicio = meio + 1;
			else if(array[meio] > x)
				fim = meio - 1;
		}
		return -1;
	}

	public int buscaBinariaRecursiva(int[] array, int ini, int fim, int x) {
		Integer retorno = 0;
		if(ini > fim)
			retorno = null;
		else {
			int meio = (ini + fim)/2;
			if(array[meio] == x)
				retorno = array[meio];
			else if(array[meio] < x)
				retorno = buscaBinariaRecursiva(array, meio+1, fim, x);
			else if(array[meio] > x)
				retorno = buscaBinariaRecursiva(array, ini, meio-1, x);
		}
		return retorno;
	}

}

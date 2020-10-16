package sorting.algorithms;

public class Codes {

	// BubbleSort

	public void bubbleSort(int[] array) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 1; j < array.length; j++) {
				if (array[j] < array[j - 1]) {
					swap(array, j, j - 1);
				}
			}
		}
	}
	
	// BubbleSort Recursivo
	
	public void bubbleRecursivo(int[] array, int n) {
		// CASO BASE.
		if (n == 0) {
			return;
		}
		for (int i = 0; i < n-1; i++) {
			if (array[i] > array[i+1]) {
				this.swap(array, i, i+1);
			}
		}
		bubbleRecursivo(array, n-1);
	}

	// SelectionSort

	public void selectionSort(int[] array) {
		int minIndex;

		for (int i = 0; i < array.length - 1; i++) {
			minIndex = i;
			for (int j = i + 1; j < array.length; j++) {
				if (array[j] < array[minIndex]) {
					minIndex = j;
				}
			}

			swap(array, i, minIndex);
		}
	}
	
	// SelectionSort Recursivo
	
	public void SelectionRecursivo(int[] array, int comeco) {
		if (comeco == array.length-1) {
			return;
		}
		int min = comeco;
		for (int i = comeco; i < array.length; i++) {
			if (array[i] < array[min]) {
				min = i;
			}
		}
		this.swap(array, comeco, min);
		this.SelectionRecursivo(array, ++comeco);
	}

	// InsertionSort

	public void insertionSort(int[] array, int leftIndex, int rightIndex) {
		int key;

		for (int i = 1; i <= rightIndex; i++) {
			key = array[i];
			int j = i - 1;
			while (j >= leftIndex && array[j] > key) {
				array[j + 1] = array[j];
				j--;
			}
			array[j + 1] = key;
		}
	}

	// BubbleSort Simultaneo

	public void bubbleSimultaneo(int[] array) {
		for (int k = 0; k < array.length / 2; k++) {

			int i = 1;
			int j = array.length - 1;

			while (i < array.length && j > 0) {
				if (array[i] < array[i - 1]) {
					swap(array, i, i - 1);
				}

				if (array[j] < array[j - 1]) {
					swap(array, j, j - 1);
				}
				i++;
				j--;
			}

		}

	}

	// QuickSort

	
	public void quickSort(int array[], int leftIndex, int rightIndex) {
		
		if(leftIndex < rightIndex) {
			int aux = particiona(array, leftIndex, rightIndex);
			
			quickSort(array, leftIndex, aux - 1);
			quickSort(array, aux + 1, rightIndex);
		
		}
		
	}

	
	private int particiona(int[] array, int leftIndex, int rightIndex) {
		int pivot = array[rightIndex];
		int pos = leftIndex - 1;
		
		for(int i = leftIndex; i < rightIndex; i++) {
			if(array[i] < pivot) {
				pos++;
				swap(array, i, pos);
			}
		}
		
		swap(array, rightIndex, pos + 1);

		return pos + 1;
	}

	// MergeSort

	public void mergeSort(int[] array, int leftIndex, int rightIndex) {
		if (leftIndex < rightIndex) {
			int middleIndex = (leftIndex + rightIndex) / 2;

			mergeSort(array, leftIndex, middleIndex);
			mergeSort(array, middleIndex + 1, rightIndex);

			merge(array, leftIndex, middleIndex, rightIndex);
		}
	}

	private void merge(int array[], int leftIndex, int middleIndex, int rightIndex) {

		int n1 = middleIndex - leftIndex + 1;
		int n2 = rightIndex - middleIndex;

		int[] leftArray = new int[n1];
		int[] rightArray = new int[n2];

		for (int i = 0; i < n1; i++) {
			leftArray[i] = array[leftIndex + i];
		}

		for (int j = 0; j < n2; j++) {
			rightArray[j] = array[middleIndex + 1 + j];
		}

		int i = 0;
		int j = 0;
		int k = leftIndex;

		while (i < n1 && j < n2) {
			if (leftArray[i] <= rightArray[j]) {
				array[k] = leftArray[i];
				i++;
			} else {
				array[k] = rightArray[j];
				j++;
			}
			k++;
		}

		while (i < n1) {
			array[k] = leftArray[i];
			i++;
			k++;
		}

		while (j < n2) {
			array[k] = rightArray[j];
			j++;
			k++;
		}
	}
	

	// CountingSort
	
	public void countingSort(int[] array, int leftIndex, int rightIndex) {
		
		if(leftIndex < rightIndex) {
			
			int max = encontraMax(array, leftIndex, rightIndex);
			int min = encontraMin(array, leftIndex, rightIndex);
			
			int offset = min;
			int auxLength = max - min + 1;
			int resultLength = rightIndex - leftIndex + 1;
			
			int[] result = new int[resultLength];
			int[] aux = new int[auxLength];
			
			for(int i = leftIndex; i <= rightIndex; i++ ) {
				aux[array[i] - offset]++;
			}
			
			for(int j = 1; j < aux.length; j++) {
				aux[j]+= aux[j - 1];
			}
			
			
			for(int k = rightIndex; k >= leftIndex; k--) {
				aux[array[k] - offset]--;
				result[aux[array[k] - offset]] = array[k];
			}
			
			int auxIndex = 0;
			
			for(int k = leftIndex; k <= rightIndex; k++) {
				array[k] = result[auxIndex];
				auxIndex++;
			}
		}
			
		
	}
	



	private int encontraMax(int[] array, int leftIndex, int maxIndex) {
		int max = 0;

		for (int i = leftIndex; i <= maxIndex; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		
		return max;
	}

		
	private int encontraMin(int[] array, int leftIndex, int maxIndex) {
		int min = array[leftIndex];
		
		for (int i = leftIndex; i <= maxIndex; i++) {
			if(array[i] < min) {
				min = array[i];
			}
		}
		
		return min;
	}
	
	
	
	// GnomeSort

	public void gnomeSort(int[] array, int leftIndex, int rightIndex) {
		int pos = leftIndex + 1;

		while (pos <= rightIndex) {
			if (array[pos] >= array[pos - 1]) {
				pos++;
			} else {
				swap(array, pos, pos - 1);

				if (pos > leftIndex + 1) {
					pos--;
				} else {
					pos++;
				}
			}
		}
	}

	// CombSort

	public void combSort(int[] array, int leftIndex, int rightIndex) {
		int gap = rightIndex - leftIndex + 1;
		boolean swapped = false;

		while (gap >= 1) {
			gap = (int) (gap / 1.25);

			if (gap < 1) {
				gap = 1;
			}

			swapped = false;
			int i = 0;

			while ((i + gap) <= rightIndex) {
				if (array[i] > array[i + gap]) {
					swap(array, i, i + gap);
					swapped = true;
				}
				i++;
			}

			if (gap == 1 && !swapped) {
				gap = 0;
			}
		}
	}

	// Trocar
	
	private void swap(int[] array, int index1, int index2) {
		int aux = array[index1];
		;
		array[index1] = array[index2];
		array[index2] = aux;
	}


	// Radix Sort
	protected static int d = 8;
	protected static int w = 32;
	public static int[] radixSort(int[] a) {
		int[] b = null;
		for (int p = 0; p < w/d; p++) {
			int c[] = new int[1<<d];
			b = new int[a.length];
			for (int i = 0; i < a.length; i++)
				c[(a[i] >> d*p)&((1<<d)-1)]++;
			for (int i = 1; i < 1<<d; i++)
				c[i] += c[i-1];
			for (int i = a.length-1; i >= 0; i--)
				b[--c[(a[i] >> d*p)&((1<<d)-1)]] = a[i];
			a = b;
		}
		return b;
	}


}

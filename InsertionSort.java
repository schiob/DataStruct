import java.util.Random;


public class InsertionSort {

	public static void main(String[] args) {
		int[] arr = new int[15];
		populate(arr);
		print(arr);
		insertionSort(arr);
		print(arr);
	}

	public static void insertionSort(int[] arr){
		for(int i = 1 ; i < arr.length ; i++){
			int j = i - 1, cont = 0;
			while(j >= 0 && arr[i] <= arr[j]){
				cont++;
				j--;
			}
			switchV(arr, i, cont);
		}
	}

	private static void switchV(int[] arr, int i, int cont) {
		int aux = arr[i];
		while(cont-- > 0){
			arr[i] = arr[--i];
		}
		arr[i] = aux;
	}
	
	private static void print(int[] arr){
		for(int i = 0 ; i < arr.length ; i++){
			System.out.printf("%d ", arr[i]);
		}
		System.out.println();
	}
	
	private static void populate(int[] arr) {
		Random r = new Random();
		for(int i = 0 ; i < arr.length ; i++){
			arr[i] = r.nextInt(101);
		}
	}

}

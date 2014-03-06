import java.util.Random;


public class QuickSort {

	public static void main(String[] args) {
		int[] arr = new int[15000];
		populate(arr);
		print(arr);
		quickSort(arr, 0, arr.length - 1);
		print(arr);
	}
	
	public static void quickSort(int[] arr, int left, int right){
		int i = left, j = right;
		int pivote = arr[(left + right) / 2];
		do{
			while(arr[i]<pivote)
				i++; 
			while(arr[j]>pivote)
				j--;
			if (i<=j){
				camb(arr, i, j);
				i++;
				j--;
			}
		} while(i<=j);
		
		if(left<j)
			quickSort(arr, left, j);
		if(right>i)
			quickSort(arr, i, right);
	}
	
	
	private static void camb(int[] arr, int i1, int i2){
		int aux = arr[i1];
		arr[i1] = arr[i2];
		arr[i2] = aux;
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
			arr[i] = r.nextInt(10100);
		}
	}
	
}

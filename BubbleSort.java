import java.util.Random;


public class BubbleSort {

	public static void main(String[] args) {
		int[] arr = new int[15];
		populate(arr);
		print(arr);
		bubbleSort(arr, arr.length);
		print(arr);
	}
	
	public static void bubbleSort(int[] arr, int l){
		if(l <= 1)
			return;
		for(int i = 0 ; i < l - 1 ; i++){
			compare(arr, i);
		}
		bubbleSort(arr, --l);
	}
	
	private static void compare(int[] arr, int i){
		if(arr[i] > arr[i+1]){
			int aux = arr[i+1];
			arr[i+1] = arr[i];
			arr[i] = aux;
		}
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

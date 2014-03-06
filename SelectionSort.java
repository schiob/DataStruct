import java.util.Random;


public class SelectionSort {

	public static void main(String[] args) {
		int[] arr = new int[15];
		populate(arr);
		print(arr);
		selectionSort(arr, 0);
		print(arr);
	}
	
	public static void selectionSort(int[] arr, int act){
		if(act == arr.length -1)
			return;
		int men = act;
		for(int i = act + 1 ; i < arr.length ; i++){
			if(arr[i] < arr[men])
				men = i;
		}
		switchV(arr, act, men);
		selectionSort(arr, ++act);
	}
	
	private static void switchV(int[] arr, int act, int men){
		int aux = arr[act];
		arr[act] = arr[men];
		arr[men] = aux;
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

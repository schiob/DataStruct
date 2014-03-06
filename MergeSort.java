import java.util.Arrays;
import java.util.Random;


public class MergeSort {

	public static void main(String[] args) {
		int[] arr = new int[12345];
		populate(arr);
		print(arr);
		split(arr);
		print(arr);
	}
	
	public static void split(int[] arr){
		if(arr.length != 1){
			int pivot = arr.length / 2;
			int[] lArr = Arrays.copyOfRange(arr, 0, pivot);
			int[] rArr = Arrays.copyOfRange(arr, pivot,  arr.length);
			split(lArr);
			split(rArr);
			merge(arr, lArr, rArr);
			
		}
	}
	
	private static void merge(int[] arr, int[] lArr, int[] rArr){
		int sum = lArr.length + rArr.length;
		int index = 0, leftI = 0, rightI = 0;
		
		while(index < sum){
			if(rightI == rArr.length){
				arr[index++] = lArr[leftI++];
				continue;
			}
			else if(leftI == lArr.length){
				arr[index++] = rArr[rightI++];
				continue;
			}
			else if(lArr[leftI] <= rArr[rightI]){
				arr[index++] = lArr[leftI++];
			}
			else if(lArr[leftI] >= rArr[rightI]){
				arr[index++] = rArr[rightI++];
			}
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
			arr[i] = r.nextInt(100000);
		}
	}

}

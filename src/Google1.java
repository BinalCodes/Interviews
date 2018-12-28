/*
 * Given a max heap as an array, return the top k elements. Do not modify heap or copy entire heap to a different data structure. Example:
15
/ \
13 12
/ \ /
10 8	9
	int[] arr = {15,13,12,10,8,9};
	List<Integer> peekTopK(int[] arr, int k)
	Expected output for k = 5 ==> [15,13,12,10,9]
 */
public class Google1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[]= {100,60,72,23,2,66,70};
		int k =3;
		getKthLargestFromArr(arr,k);
	}
	
	public static void getKthLargestFromArr(int[] arr, int k) {
		int result[] = new int[k];
		for(int i =0 ;i<arr.length; i++) {
			result[k] = arr[0];
			
		}
	}
	
	public int getLeftChildIndex(int root) {
		return (2*root )+1;
	}
	public int getRightChildIndex(int root) {
		return (2*root)+2;
	}
	public int getParent(int leftChildIndex) {
		return (leftChildIndex-1)/2;
	}
}

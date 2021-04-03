
public class Merge {

	//instance variables 
	private int [] arr = new int [10];
	private int index=0;
	private int size=0;
	private int foundCount, foundIndex;
	
	//constructor
	public Merge() {
		
	}
	
	//add numbers to an array
	public void addArray(int n) {
		if (size<10) {
			arr[index] = n;
			index++;
			size++;
		}else {
			System.out.println("Sorry, there are too many integers in the array.");
			System.out.println();
		}
		
		System.out.println("Here is what your array looks like right now.");
		for (int i=0; i<size; i++) {
			System.out.println(i + ": " + arr[i]);
		}
		System.out.println();
	}
	
	//search using recursive binary
	public void binSearch(int n) {
		
		//sort using merge
		this.sort(arr, 0, size-1);
		
		//print statement to show short
		System.out.println("Here is what your sorted array looks like: ");
		for (int i=0; i<size; i++) {
			System.out.println(i + ": " + arr[i]);
		}
		System.out.println();
		
		
		//search using recursive binary
		foundIndex=0;
		foundCount=0;
		this.binRecurSearch(n, 0, size-1, (size-1)/2);
		
		
		//print index that number was found at, or -1 if not found
		if (foundIndex!=-1) {
			System.out.println(arr[foundIndex] + " is at index " + foundIndex);
		}else {
			System.out.println("Sorry, that number is not in the array");
		}
		System.out.println();
	}
	
	
	//main function for merge sort
	private void sort(int a[], int left, int right) {
		if (left < right) {
			
			//find middle point
			int m = (left + right) / 2;
			
			//sort first and second halves 
			sort(arr, left, m);
			sort(arr, m+1, right);
			
			//merge sorted halves
			merge(arr, left, m, right);
		}
	}
	
	//does actual merge 
	private void merge(int a[],  int left, int m, int right) {
		
		//find sizes of two subarrays to be merged
		int n1 = m - left + 1;
		int n2 = right - m;
		
		//create temp arrays
		int l [] = new int [n1];
		int r [] = new int [n2];
		
		//copy data to temp arrays
		for (int i=0; i<n1; i++) {
			l[i] = arr[left + i];
		}
		for (int j=0; j<n2; j++) {
			r[j] = arr[m + 1 + j];
		}
		
		/*merge temp arrays*/
		//initial indexes of first and second subarray
		int i=0, j=0;
		
		//initial index of merged subarray array
		int k=left;
		
		
		while (i<n1 && j<n2) {
			
			if (l[i] <r[j]) {
				arr[k] = l[i];
				i++;
			}else {
				arr[k] = r[j];
				j++;
			}
			k++;
		
		}//end of while
		
		//copy remaining elements of l[] if any
		while (i<n1) {
			arr[k] = l[i];
			i++;
			k++;
		}
		
		//copy remaining elements of r[] if any
		while (j<n2) {
			arr[k] = r[j];
			j++;
			k++;
		}
		
	}
	
	//does recursive binary, returns index of int to be found
	private void binRecurSearch(int n, int start, int end, int midIndex) {
		
		//base case
		if (start==end) {
			if (arr[end]==n && foundCount<=0) {
				foundIndex=end;
				return;
			}else if (arr[end] !=n && foundCount<=0){
				foundIndex=-1;
				return;
			}else {
				if (foundCount!=0) {
					return;
				}else {
					foundIndex=-1;
					return;
				}
			}

		}else {
		
			if (n==arr[midIndex]) {
				start=end;
				foundCount++;
				foundIndex=midIndex;
				
				binRecurSearch(n, start, end, midIndex);
			
			}else if (n > arr[midIndex]) {
				start = midIndex + 1;
				midIndex = (((midIndex+1) + end) / 2); 
				
				binRecurSearch(n, start, end, midIndex);
			
			}else {
				end = midIndex-1;
				midIndex = (midIndex + start) / 2;
				
				binRecurSearch(n, start, end, midIndex);
			}
				
		}
		
	}
	
	
}//end of class

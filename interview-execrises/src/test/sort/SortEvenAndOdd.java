package test.sort;

public class SortEvenAndOdd extends SortBase{

	public static void main(String[] args) {
		int [] unsorted_array = generateUnsortedArray();
		System.out.println("UnSorted: ");
		displayArray(unsorted_array);
		sort (unsorted_array);
		System.out.println("\nSorted:");
		displayArray(unsorted_array);
	}

	public static void sort(int [] x) {
		for (int i = 0; i <x.length ; i++){
			if (x[i] % 2 != 0)
			{
				for (int j = i+1; j < x.length; j++)
				{
					if (x[j]%2 == 0)
					{
						int temp = x[i];
						x[i] = x [j];
						x[j] = temp;
					}
				}
			}
		}
	}
}

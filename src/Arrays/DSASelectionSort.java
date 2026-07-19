package Arrays;

public class DSASelectionSort {

    public static void main(String[]  args){

        // Step 1: Create an integer array
       /* int[] my_array={64, 34, 25, 5, 22, 11, 90, 12};
        int n=my_array.length; // Step 2: Store the size of the array

        for(int i=0; i<n-1; i++) // Step 3: Outer Loop
            // this loop decides the position where the next smallest element should be placed.
        {
            int min_index=i; // Step 4: Assume the current index contains the smallest value
            for(int j=i+1; j<n; j++)  // Step 5: Search for the actual smallest element from the remaining unsorted parts of the array.
            {
                if(my_array[j]<my_array[min_index])  // Step 6: If a smaller element is found, update the minimum index.
                {
                    min_index=j;
                }
            }
            int min_value=my_array[min_index]; // Step 7: Save the smallest value temporarily
            for(int k=min_index; k>i; k--)  // Step 8: Shift all elements one position to the right until the correct position becomes empty.
            {
                my_array[k]=my_array[k-1];
            }
            my_array[i]=min_value;  // Step 9: Insert the smallest value into its correct sorted position.
        }
        System.out.print("Sorted array: ");  // Step 10: Print the sorted array.
        for(int i=0; i<n; i++){
            System.out.print(my_array[i]+" ");
        }
        System.out.println();*/

        int[] my_array={64, 34, 25, 12, 22, 11, 90, 5};
        int n=my_array.length;

        for(int i=0; i<n; i++){
            int min_index=i;
            for(int j=i+1; j<n; j++)
            {
                if(my_array[j]<my_array[min_index])
                {
                    min_index=j;
                }
            }
            int temp=my_array[i];
            my_array[i]=my_array[min_index];
            my_array[min_index]=temp;
        }
        System.out.print("Sorted array: ");
        for(int i=0; i<n; i++){
            System.out.print(my_array[i]+" ");
        }
        System.out.println();
    }
}

/**
 * Created by shantanus on 12/15/2017.
 */
public class MergeSort {

    public static void printArr(int[] arr){
        System.out.println("In MergeSort PrintArr");
        for(int i=0; i < arr.length; ++i) {
            System.out.println("\t " + Integer.toString(arr[i]));
        }
    }

    public void mergeSort(int[] arr, int low, int high){
        if(low>=high)
            return;

        int mid = (low + high)/2 ;
        mergeSort(arr, low, mid);
        mergeSort(arr, mid+1, high);
        merge(arr, low,mid, high);

        return;
    }

    public void merge(int[] arr, int low, int mid,int high){
        if(low>=high)
            return;

        int[] aux = new int[high-low+1];
        int i = low;
        int j = mid+1;
        int k = 0;
        while(i<=mid && j<=high) {
            if (arr[i] <= arr[j]) {
                aux[k] = arr[i];
                i++;
            } else {
                aux[k] = arr[j];
                j++;
             }
            k++;
        }
        if(i> mid) {
            while(j<=high){
                aux[k]=arr[j];
                j++;k++;
            }
        }
        if(j> high){
            while(i<=mid) {
                aux[k] = arr[i];
                i++;++k;
            }
        }

        // finally copy aux to arr
        for(int x=0; x<aux.length;x++){
            arr[low+x]= aux[x];
        }
        return ;
    }
}

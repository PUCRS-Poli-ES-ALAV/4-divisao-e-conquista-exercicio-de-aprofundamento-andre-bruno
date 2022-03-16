public class main{
    public static void merge(int[] arr, int[] leftArray, int[] rightArray, int left, int right){
        int i = 0;
        int j = 0;
        int k = 0;
        
        while(i < left && j < right){
            if(leftArray[i] < rightArray[j]){
                arr[k++] = leftArray[i++];
                
            }
            else{
                arr[k++] = rightArray[j++];

            }
            while(i < left){
                arr[k++] = leftArray[i++];
            }
            while(j < right){
                arr[k++] = rightArray[j++];
            }
        }        
    }

    public static void mergeSort(int[] arr, int tam){
        if(tam < 2)
            return;

        int mid = tam/2;
        int[] left = new int[mid];
        int[] right = new int[tam-mid];

        for(int i = 0; i < mid; i++)
            left[i] = arr[i];

        for(int i = mid; i < tam; i++)
            right[i-mid] = arr[i];

        mergeSort(left, mid);
        mergeSort(right, tam-mid);

        merge(arr, left, right, mid, tam-mid);
    }
    
    
    public static void main(String[] args) {
    int[] arr = {13,66,15,24,35,26,77,48,10};    
    mergeSort(arr, arr.length);
    for(int i=0; i<arr.length; i++){
        System.out.print(arr[i] + " ");
    }
    }
}
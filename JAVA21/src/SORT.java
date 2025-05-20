import java.util.Arrays;

public class  SORT {
    public static void main(String[] args) {
        int[] arr = {6,1,2,5,7,9,10,11};
        quickSort(arr,0,arr.length-1);
        System.out.println(Arrays.toString(arr));

    }
    public static void BubbleSort(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            for(int j =0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void chooseSort(int[] arr){
        for(int i = 0;i<arr.length-1;i++){
            for(int j = i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }
    public static void insertSort(int[] arr){
        for(int i =1;i<arr.length;i++){
            int curr = arr[i];
            int prev = i-1;
            while(prev>=0&&arr[prev]>curr) {
                arr[prev+1] = arr[prev];
                prev--;
            }
                arr[prev+1] = curr;
            }

        }
    public static void quickSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int start = left;
        int end = right;
        int pivot = arr[left];
        while(start!=end){
            while(start<end&&arr[end]>=pivot){
                end--;
            }
            while(start<end&&arr[start]<=pivot){
                start++;
            }
            if(start<end){
                swap(arr,start,end);
            }
        }
        swap(arr,left,end);
        quickSort(arr,left,end-1);
        quickSort(arr,end+1,right);

    }
    public static void swap(int[] arr,int i,int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public static void timeSort(int[] arr,int left,int right){
        if(left>=right){
            return;
        }
        int mid = (left+right)>>1;
        timeSort(arr,left,mid);
        timeSort(arr,mid+1,right);

        merge(arr, left, right, mid);
    }

    private static void merge(int[] arr, int left, int right, int mid) {
        int lstart = left;
        int lend = mid;
        int rstart = mid +1;
        int rend = right;
        int index = 0;
        int[] temp = new int[right - left +1];
        while(lstart<=lend&&rstart<=rend){
            if(arr[lstart]< arr[rstart]){
                temp[index] = arr[lstart];
                lstart++;
            }
            else{
                temp[index] = arr[rstart];
                rstart++;
            }
            index++;
        }
        while(lstart<=lend){
            temp[index] = arr[lstart];
            lstart++;
            index++;
        }
        while(rstart<=rend){
            temp[index] = arr[rstart];
            rstart++;
            index++;
        }
        for(int i = 0;i<temp.length;i++){
            arr[left +i] = temp[i];
        }
    }


}

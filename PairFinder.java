public class PairFinder{
    public static void findPairSums(int k, int[] arr){
        for(int i = 0; i < arr.length; i++){
            for(int j = i + 1; j< arr.length; j++){
               if(arr[j] + arr [i]== k){
                   System.out.println(arr[j] + " + " + arr[i] + " = " + k);
               } 

            }
        }
    }
    public static void findPairSumsFaster(int k, int[] arr){
        if(arr == null){
            throw new IllegalArgumentException("Nope!");
        }
        int i = 0;
        int j = arr.length-1;
        sort.mergeSort(arr);
       while(i<j){
           if(arr[i]+arr[j]== k){
               String s = arr[i] + "+" +arr[j] + "="+ k;
               System.out.println(s);
               if(arr[i] == arr[i+1]){
                   i++;
               } else{
                   j--;
               }
           }else if(arr[i] + arr[j] > k){
               j--;
           }else{
               i++;
           }
       }
    }
    public static void main(String [] args){
        int [] arr =  {10, 4, 7, 7, 8, 5, 15};
        int [] arr2 =  {2, 4, 5, 1, 2, 4, 3};
        findPairSums(12, arr);
        findPairSumsFaster(12, arr);
        findPairSumsFaster(8,arr2);
    }
}

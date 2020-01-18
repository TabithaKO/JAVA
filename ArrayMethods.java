import java.util.Arrays;

public class ArrayMethods {
    // This is the constant variable given
    public static final String[] DAYS = { "Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday",
            "Saturday" };

    // This is the element swapping method
    public static void swapAdjacent(int[] values) {
        int length = values.length;
        for (int i = 1; i < length; i += 2) {
            int replace = values[i];
            values[i] = values[i - 1];
            values[i - 1] = replace;
        }
        System.out.println(Arrays.toString(values));
    };

    public static int[] copyReplace(int[] values, int oldVal, int newVal) {
        int length = values.length;
        // Searching for the old to replace with the new
        for (int i = 0; i < length; i++) {
            if (values[i] == oldVal) {
                values[i] = newVal;
            }
        }
        return values;

    }

    // This is the max sorted values method
    public static int maxSorted(int[] values) {
        int length = values.length;
        int seq = 0;
        int check = 0;

        for (int i = 1; i < length - 1; i++) {
            if (values[i] <= values[i + 1] && values[i] >= values[i - 1]) {
                seq += 1;
            } else if (seq > check) {
                check = seq;
                seq = 0;
            }
        }

        return check;
    };

    public static int getIndexOfDay(String day) {
        int index = 0;
        String lower = day.toLowerCase();
        for (int i = 0; i < DAYS.length; i++) {
            String compare = (DAYS[i]).toLowerCase();
            if (lower.equals(compare)) {
                index = i;
                break;
            }else{
                index = -1;
            }
        }
        return index;
    }
    public static int[] reverseInterchange( int[] arr1, int [] arr2 ){
       int length = 0;
        if(arr1.length > arr2.length){
           length = arr2.length;
       } else{
           length = arr1.length;
       };
       int x = 0;
       int [] arr3 = new int [length*2];
       for(int i =0; i<length*2; i+=2){
           arr3[i] = arr1[x];
           x+=1;
       }
       //setting a reverse array for arr2
      //I'll start by creatng an intermediate arr2 of the same length as length
      int [] inter = new int [length]; 
       for(int i =0; i <length; i++){
        inter[i] = arr2[i];
       }
      int stop = 0;
      if(length%2 == 0){
          stop = (length/2)-1;
      }else{
          stop = (length-1)/2;
      }
       int y = length-1;
       for (int i=0; i<=stop; i++){
           int replace = inter [i];
           inter[i] = inter[y];
           inter[y] = replace;
           y= y-1;
       }
      
       int z = 0;
       for(int i =1; i< length*2; i+=2){
           arr3[i] = inter[z];
           z += 1;
       }
       
       return arr3;
    }
    public static void main(String[] args) {
        int a1[] = { 1, 2, 3, 4, 5, 6 };
        int a2[] = { 2, 5, 4 ,2, 7, 4, 2};
        System.out.println( Arrays.toString( copyReplace(a2, 4,0) ) );

    }
}

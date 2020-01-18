import java.util.Arrays;

//import sun.security.util.ArrayUtil;

/*
 * Student First Name: Tabitha 
 * Student Last Name: Oanda
 * Student BU Number: U828277701
 * Purpose: 
 */

public class Set {

    private int SIZE = 20; // length of the array
    public int[] set; // array referece to the set
    private int next; // index to next available slot in array
   
   

    // We are creating the set constructor which gives us an empty array and sets
    // the pointer equal to 0
    public Set() {
        int size = SIZE;
        set = new int[size];
        next = 0;
    }

    public Set(int[] A) {
        this();
        // In this section we want to fit in the set array with the new numbers input
        // Check for duplicate numbers because sets don't have duplicates(.isValid)
        // If the elements input are larger than the set size you can make the set
        // bigger
        for (int i = 0; i < A.length; i++) {
            // The insert method will call the resize method
            insert(A[i]);
        }
    }

    public Set clone() {
        // I want to create a new set that looks exactly like the old one
        Set clone = new Set(set);
        return clone;

    }

    // This method re-allocates the array S to twice as big and copies all the
    // elements over.
    // It is called only by insert.

    private void resize() {
        int[] temp = new int[SIZE * 2];
        for (int i = 0; i < set.length; ++i) {
            temp[i] = set[i];
        }
        SIZE = SIZE * 2;
        set = temp;
    }

    public String toString() {
        // making a char array then concatenating into a string
        String s = "";
        for (int i = 0; i < this.next ; i++) {
            if (i != next  - 1) {
                s += this.set[i];
                s += ",";
            } else {
                s += this.set[i];
            }
        }
        return s;
    }

    public int size() {
        // this determines the size of the set
        // How to get this particular set?
        int count = next ;
        return count;
    }

    public boolean isEmpty() {
        boolean checker = false;
        if (next  == 0) {
            checker = true;
        }
        return checker;
    }

    public boolean member(int k) {
        // I will loop through the set array and check for the existence of a element
        boolean checker = false;
        for (int i = 0; i < set.length; i++) {
            if (set[i] == k) {
                // If the element is in the array we will return true
                checker = true;
            }
        }
        return checker; // just to get it to compile; replace false with something appropriate
    }

    public boolean subset(Set T) {
        // Checking if every element of the new set matches the current set
        // begin by cloning the set
        boolean checker = false;
        Set Subset = T.clone();
        for (int x = 0; x < T.size(); x++) {
            // Check if the elements of the new class are members of the old class
            if (member(Subset.set[x]) == true) {
                checker = true;
            } else {
                checker = false;
                break;
            }

        }

        return checker;
    }

    public boolean equal(Set T) {
        // first check if the new set is a subset of the old one
        boolean checker = false;
        if (subset(T) == false) {
            checker = false;
        } else if (T.next  != next ) {
            checker = false;
        } else {
            for (int i = 0; i < next ; i++) {
                if (T.set[i] == this.set[i]) {
                    checker = true;
                } else {
                    checker = false;
                    break;
                }
            }
        }
        return checker;
    }

    public void insert(int k) {
        // first call the member method to check if its a member
        if (member(k) == false) {
            // if it's not a member, check the size
            if (next == SIZE) {
                resize();
                set[next] = k;
                next++;
            } else {
                // if there's still space we can continue to populate the list

                set[next] = k;
                next++;
            }
        }
        // else it should not add the new element
        ;

    }

    // I need to write an instance method that finds the index of an element in an
    // array
    public int findIndex(int[] arr, int k) {
        int value = 0;
        for (int i = 0; i < arr.length; i++) {
            if (k == arr[i]) {
                value = i;
            }
        }
        return value;
    }

    public void delete(int k) {
        // find out if the unwanted int is in the array
        if (member(k)) {
            int val = findIndex(set, k);
            for (int i = val; i < set.length - 1; i++) {
                // shifting the elements to the left
                set[i] = set[i + 1];
            }
            next  -= 1;
        }
    }

    public Set union(Set T) {
        int combonext  = T.next  + next ;
        int [] arr = new int [combonext ];
        Set union = new Set(arr);
        int counter = 0;
        for (int i = 0; i < this.next ; i++) {
           if(union.member(this.set[i])== false){
             union.insert(this.set[i]);
             counter +=1;
           }
        }
        for (int i = 0; i < T.next ; i++) {
           if(union.member(T.set[i])== false){
             union.insert(T.set[i]);
             counter +=1;
           }
        }
        union.next  = counter;
        return union;
    }

    public Set intersection(Set T) {
        int count = 0;
        Set inter = new Set();
        for (int i = 0; i < this.next; i++) {
            if (this.member(T.set[i]) == true) {
                inter.insert(T.set[i]);
                count +=1;
            }
        }
        inter.next  = count;
        return inter;
    }

    public Set setdifference(Set T) {
        Set difference = new Set();
        // If the element of the main set is not in the imported set, then it goes into
        // the new differernce set
        int count = 0;
      
           for(int i =0; i<T.next; i++){
            
              if(T.member(this.set[i])== false){
                difference.insert(this.set[i]);
                count += 1;
              }
           
           }
           difference.next  = count;
           return difference;
        }
    
      
    public static void main(String[] args) {
        int[] check = { 1, 2, 3, 4, 5 };
        int[] check2 = { 2, 4, 6, 8, 10 };
        Set mySet = new Set(check);
        Set mySet2 = new Set(check2);
        System.out.println(mySet.toString());
        System.out.println(mySet2.toString());
        System.out.println(mySet2.union(mySet));
        System.out.println(mySet2.intersection(mySet));
        System.out.println(mySet2.setdifference(mySet));

    }

}
// Have a method that returns whether its a member and also returns the index.
// Therefore it wil be easier to delete stuff
//

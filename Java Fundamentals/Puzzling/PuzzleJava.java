import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class PuzzleJava{
    public static void main(String[] args) {
        // arraysum() ;
        // shufflearray();

    }


    public static void arraysum()  {
       int [] array={3,5,1,2,7,9,8,13,25,32};
       ArrayList<Integer> newArray = new ArrayList<Integer>();
       for (int i = 0; i < array.length; i++){
           System.out.println(array[i]);
           if (array[i]>10){
               newArray.add(array[i]);
           }
       }
       System.out.println(newArray);
    }
    
    public static void shufflearray()  {
        ArrayList<String> names = new ArrayList<String>();
        String[] array={"Nancy","Jinichi","Fujibayashi","Momochi","Ishikawa"};
        names.add("Nancy");
        names.add("Jinichi"); 
        names.add("Fujibayashi");
        names.add("Momochi");
        names.add("Ishikawa");
        Collections.shuffle(names);
        System.out.println(names);
        for ( int i = 0 ; i<array.length ; i++){
          if ( array[i].length()>5){
                         System.out.println(array[i]);
                     } 
                }
            }

Create an array that contains all 26 letters of the alphabet (this array must have 26 values). 
Shuffle the array and, after shuffling, display the last letter from the array. 
Have it also display the first letter of the array.
    If the first letter in the array is a vowel, have it display a message.

            
     
   

}
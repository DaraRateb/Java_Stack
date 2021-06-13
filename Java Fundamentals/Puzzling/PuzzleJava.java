import java.util.ArrayList;

public class PuzzleJava{
    public static void main(String[] args) {
        // arraysum() ;

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
    Create an array with the following values: Nancy, Jinichi, Fujibayashi, Momochi, Ishikawa. Shuffle the array and print the name of each person. Have the method also return an array with names that are longer than 5 characters.
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



}
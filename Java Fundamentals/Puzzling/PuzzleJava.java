import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Arrays;
import java.util.Random;


public class PuzzleJava{
    public static void main(String[] args) {
        // arraysum() ;
        // shufflearray();
        // lettersarray();
        // randomarray();
        // sortRandomArray();
        // randomString();
        randomStringwords();

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


public static void lettersarray()  {
   ArrayList<Character> letters = new ArrayList();
   ArrayList<Character> vowels = new ArrayList();

    for (char i='a' ; i<='z' ; i++){
        letters.add(i);

    }
        
        Collections.shuffle(letters);
        // System.out.println(letters);
        System.out.println(letters.get(letters.size()-1));
        System.out.println(letters.get(0));
        

        vowels.add('i');
        vowels.add('e');
        vowels.add('u');
        vowels.add('a');
        vowels.add('o');

        if (vowels.contains(letters.get(0))){
           System.out.println("first character is a vowel");
        }
}

public static void randomarray(){
    Random r = new Random();
    int [] array = {1,2,3,4,5,6,7,8,9,10};
    for(int i=0; i<array.length; i++){
        array[i] = r.nextInt(100-55) + 55;
        System.out.println(array[i]);
    } 
}
public static void sortRandomArray(){
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    Random r = new Random();
    for(int i=0; i<10 ; i++){
        numbers.add(r.nextInt(100-55) + 55);
    } 
   Collections.sort(numbers);
   System.out.println(numbers);
   System.out.println(String.format("The Minimum is %d",numbers.get(0)));
}
public static void randomString(){
    String [] array ={"a","b","c","t","t"};
    Random r = new Random();
    String y="";
    for (int i = 0; i < array.length; i++) {
        array[i]=String.valueOf((char)(r.nextInt(26) + 'a'));
        y=y+array[i];
    } 
   System.out.println(y);
}
public static void randomStringwords(){
    ArrayList<String> words = new ArrayList<String>();
    Random r = new Random();
    String y="";
    for (int i = 0; i <10; i++) {
        for (int j=0; j<5; j++){
        y+=String.valueOf((char)(r.nextInt(26) + 'a'));
        }
        words.add(y);
        y="";
    } 
   System.out.println(words);
}



}
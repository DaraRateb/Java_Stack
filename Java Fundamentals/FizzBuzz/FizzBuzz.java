public class FizzBuzz {
    public static String fizzBuzz(int number) {
        String str= number + "";

        if (number % 3 ==0 && number %5==0){
            str="FizzBuzz";
        }

        else if (number % 3 ==0){
            str="Fizz";
        }
        else if (number % 5 == 0){
            str="Buzz";
        }
        return str;
}


public static void main (String[] arg){
    
    String Game = fizzBuzz(3);
    System.out.println(Game);
}
}
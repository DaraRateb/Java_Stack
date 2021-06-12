import java.util.ArrayList;

public class Basics {

    public static void main(String[] args)  {
        // print();
        // printodd();
        // sum();
        // iterate();
        // findMax();
        // getAverage();
        // oddarray();
        // ArrayList list = new ArrayList();
        // list.add(1);
        // list.add(2);
        // list.add(3);
        // greaterthanY(list,4);
        // squarevalue();
        // eliminateNegative();
        // arrayAttributes();
        shift();

    }

        //1)Print 1-255
    public static void print()  {
        for (int i = 0; i < 256; i++){
            System.out.println(i);
        }
    }
    // 2)Print odd numbers between 1-255
        public static void printodd()  {
            for (int i = 0; i < 256; i++){
                if(i%2 != 0){
                    System.out.println(i);
                }
                
            }
        }


//3)Print Sum
        public static void sum(){
            int sum=0;
            for (int i = 0; i < 256; i++){
                sum=sum+i;
                System.out.println("New Number: " +i+ "Sum: "+ sum);
            }
        }
    

//4)Iterating through an array
        public static void iterate(){
            int[] array={1,3,5,7,9,13};
            for (int i = 0; i < array.length; i++) {
                int x = array[i];
                System.out.println(x + " ");

            }
        }

//5)Find Max
        public static void findMax() {
            int[] array={3,55,8,3};
            int max= array[0];
            for (int i = 0; i < array.length; i++){
                if(array[i]>max){
                    max=array[i];
                }
            }
            System.out.println(max);
        }
 
        
//6)Get Average
        public static void getAverage()  {
            int[] array={-1, 1, 2};
            double sum=0;
            double average=0;
            for (int i = 0; i < array.length; i++) {
                sum=sum+array[i];
            }
                average=sum/array.length;
                System.out.println(average);
        }


    // 7)Array with Odd Numbers
    public static void oddarray() {
        ArrayList<Integer> y = new ArrayList<Integer>();
        for (int i =1; i<256; i++){
            if (i%2 != 0){
                y.add(i);
            }
        }
        System.out.println(y);
    }

    // Greater Than Y
    public static void greaterthanY(ArrayList<Integer> array , int y ){
        
        int counter=0;
        for (int i=0; i< array.size(); i++){
            if (array.get(i)>y){
                counter=counter+1;
            }
        }
        System.out.println(counter);
    }

    // 9)Square the values
 public static void squarevalue() {
    int [] x={1,5,10,-2};
    // int [] y = new int [5];
    // for (int i = 0; i < y.length; i ++){
    //     y[i] = 0;
    // }
    for (int i =1; i<x.length; i++){
        x[i]=x[i]*x[i];
        System.out.println(x[i]);
        }
    
    }
    // 10)Eliminate Negative Numbers
public static void eliminateNegative(){
    int[] x= {1, 5, 10, -2};
    for (int i =0; i<x.length; i++){
        if (x[i]<0){
            x[i]=0;
        }
        System.out.println(x[i]);
}
}

// 11)Max, Min, and Average
public static void arrayAttributes(){
    int[] x= {1, 5, 10, -2};
    int[] y={0,0,0};
    int sum=0;
    int avg=0;
    int max=x[0];
    int min=x[0];
    for (int i =0; i<x.length; i++){
        sum=sum+x[i];
        if (x[i]>max){
            max=x[i];
        }
        if (x[i]<min){
            min=x[i];
        }
    }
        avg=sum/x.length;
        y[0]=max;
        y[1]=min;
        y[2]=avg;
        for (int j=0; j<y.length; j++){
            System.out.println(y[j]); 
        }
}

// 12)Shifting the Values in the Array
 public static void shift(){
    int[] x= {1, 5, 10, 7, -2};
    
    for (int i =0; i<x.length-1; i++){
        x[i]=x[i+1];
    }
    x[x.length-1]=0;
    for (int j=0; j<x.length; j++){
        System.out.println(x[j]);
    }



 }

}

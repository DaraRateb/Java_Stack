public class Dog extends Animal{
    String type="mammal"; 
    class Main{
    public Dog(){
        System.out.println("I am a dog");
        super("animal");
    }
    public void display(){
        System.out.Println("Here is  a dog class ")
    }
    public void printMessages(){
        this.display();
        Super.display();
    }
}
}
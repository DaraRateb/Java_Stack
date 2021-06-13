public class Samurai extends Human {
    public static int counter = 0 ; 
    public Samurai (){

    this.health = 200;
    this.counter=this.counter+1 ; 
    
    }
    public void deathBlow(Human human){
        human.health = 0 ;
        this.health = this.health/2;
}
    public void meditate(){
        this.health=this.health+this.health/2;
    }

// public static void howMany(){
//     System.out.println(this.counter);
// }
}
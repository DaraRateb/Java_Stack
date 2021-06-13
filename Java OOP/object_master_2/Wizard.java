public class Wizard extends Human {
    int health = 50;
    int intelligence =8;

    public void heal(Human human){
        human.health=this.intelligence+human.health;
    } 

    
    public void fireball(Human human){
        human.health = human.health-(human.intelligence * 3);
    }
}
public class Ninja extends Human {
    int stealth = 10;
    public steal(Human human){
        int ninjasteal = this.stealth;
        human.health=human.health- ninjasteal;

    }
    
    public runAway(){
        this.health=this.health- 10 ; 

    }
}
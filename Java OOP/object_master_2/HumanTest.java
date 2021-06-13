   public class HumanTest{
   public static void main (String [] args){
        Human Muhammad = new Human();
        Human Laila = new Human();
        Wizard Samar= new Wizard();
        Samurai Malik=new Samurai();
        // Samar.heal(Laila);
        Samar.fireball(Muhammad);
        Malik.deathBlow(Laila);
        System.out.println(Laila.health);
        System.out.println( Muhammad.health);
        System.out.println( Muhammad.health);
        System.out.println(Muhammad.intelligence);
        System.out.println(Malik.health);
        System.out.println(Samurai.counter);
    }
   }
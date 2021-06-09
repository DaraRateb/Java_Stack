import java.lang.Math;

public class Pythagorean {
    public double calculateHypotenuse(int legA, int legB) {
        double squarelegC=legA*legA + legB*legB;
        double legC= Math.sqrt(squarelegC);
        return legC;
    }
}
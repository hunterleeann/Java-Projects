
import java.lang.Math;
        import java.util.Scanner;

/**
 *
 * @author Hunter Snyder
 * Lab 2
 * Calculate the temperature in celsius based on the resistance value r
 */
public class ClipThermometer
{
    public static void main(String args[]){
        double T = 0;
        System.out.print("What is the resistance(R) value? "); //asks user for R value.
        Scanner userInput = new Scanner(System.in);
        double input = userInput.nextDouble();//accepts and stores value in "input" variable.
        System.out.println("The liquid temperature in Celsius is: " + String.format("%.2f",Resistance(3969, input, 1075, 85, T)) + " degrees.");
    }

    /**
     *
     * @param B
     * @param R
     * @param resistanceAtTemp resistance r
     * @param temp temperature
     * @param T
     * @return the total resistance
     */
    public static double Resistance(double B, double R, double resistanceAtTemp, double temp, double T){
        T = ((B*temp)/(temp*Math.log(R/resistanceAtTemp)+B))-273; //Does the math to calulate the final temp in C after receiving the user input.
        return T;
    }
}

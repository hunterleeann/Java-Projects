import java.util.*;

/**
 * Converts user input from decimal base to roman numerals
 * Lab 2
 * @author Hunter Snyder
 */

public class RomanNumerals {

    public static void main(String[] args){
        int input;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.print("Please enter the number you would like to convert to Roman numerals: ");
            input = sc.nextInt();
        } while(input < 1 | input > 3999);
        System.out.println("The roman numeral for " + input + " is " + converter(input));
    }

    /**
     *
     * @param number user input
     * @return the converted number into roman numeral
     */
    public static String converter(int number){
        int [] romanValues = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
        String[] romanLetters = {"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};

        StringBuilder romanNumber = new StringBuilder();

        for(int i = 0; i < romanValues.length; i++){
            while (number >= romanValues[i]){
                number -= romanValues[i];
                romanNumber.append(romanLetters[i]);
            }
        }
        return romanNumber.toString();
    }
}


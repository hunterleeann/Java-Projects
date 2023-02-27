import java.io.File;
import java.io.FileWriter;

//Comment in which test group you'd like to use! 
public class Tester
{
    public static void main(String[] args)
    {
        //first test
        String first = "99";
        String second = "9999";

        //second test
        // String first = "89";
        // String second = "9876";

        //third test
        // String first = "2147483647";
        // String second = "2147483647";

        //the 3 StackInterfaces here are required
        StackInterface<Integer> firstStack = new LinkedStack<Integer>();
        StackInterface<Integer> secondStack = new LinkedStack<Integer>();
        StackInterface<Integer> resultStack = new LinkedStack<Integer>();

        char[] firstNumber = first.toCharArray();
        char[] secondNumber = second.toCharArray();
        
        //push digits from numbers into stacks in appropriate order
        int num = 0;
        for (int i  = 0; i < firstNumber.length ;i++)
        {
            num = Character.getNumericValue(firstNumber[i]);
            firstStack.push(num);
        }
        for (int i  = 0; i < secondNumber.length ;i++)
        {
            num = Character.getNumericValue(secondNumber[i]);
            secondStack.push(num);
        }

        int carry = 0;
        int firstDigit = 0;
        int secondDigit = 0;
        int addition = 0;
        int resultDigit = 0;
        int digit = 0;

        //pop stacks, add digits and push result to result stack.  Careful with carry
        while(!firstStack.isEmpty() && !secondStack.isEmpty())
        {
            // getting the 1st stack digit
            firstDigit = firstStack.pop();

            // getting the 2nd stack digit
            secondDigit = secondStack.pop();

            // adding both digits + carry
            addition = firstDigit + secondDigit + carry;

            // getting the right most number
            resultDigit = addition % 10;

            // getting the "carry"
            carry = (addition - resultDigit) / 10;

            // push the digit into the result
            resultStack.push(resultDigit);
        }

        if(firstStack.isEmpty()){
            //take care of second stack
            while(!secondStack.isEmpty()){
                // getting the result stack digit
                digit = secondStack.pop();

                // adding digit + carry
                addition = digit + carry;

                // getting the right most number
                resultDigit = addition % 10;

                // getting the "carry"
                carry = (addition - resultDigit) / 10;

                // push the digit into the result
                resultStack.push(resultDigit);
            }
        }
        else{
            //first stack is empty
            while(!firstStack.isEmpty()){
                // getting the result stack digit
                digit = firstStack.pop();

                // adding digit + carry
                addition = digit + carry;

                // getting the right most number
                resultDigit = addition % 10;

                // getting the "carry"
                carry = (addition - resultDigit) / 10;

                // push the digit into the result
                resultStack.push(resultDigit);
            }
        }

        // If there's any carry left, push remainder carry into stack
        if (carry > 0)
        {
            resultStack.push(carry);
        }

        String results = "";
        //print the result from the result stack
        num = 0;
        while(!resultStack.isEmpty())
        {
            //pop results and digits are reversed
            num = (resultStack.pop());
            results += String.valueOf(num);
        }
        
        String resultString = first + " + " + second + " = "+ results;
    
        try {
            FileWriter output = new FileWriter("output.txt");
     
            output.write(resultString);
            System.out.println(resultString);
            //System.out.println("Data is written to the file.");
     
            // Closes the writer
            output.close();
          }
          catch (Exception e) {
            e.getStackTrace();
          }
        
    }
}

import java.util.*;

/**
 * @author Hunter Snyder
 * Lab 3
 * Nim Game
 */

public class Nim {

    /**
     * The main method is where the headquaters of the gam are at
     * @param args
     */
    public static void main(String[] args){
        Random rnd = new Random();
        boolean computerSmart; // true is smart and false is stupid
        boolean computerTurn; //true is computer's turn and false is human's turn
        int pickSize, input, max, min;
        int pow2Minus1[] = {63,31,15,7,3};
        double halfOfPile;
        Scanner sc = new Scanner(System.in);

        int pileSize = generatePileSize(rnd); //get random pile size between 1 and 100
        System.out.println("Initial Pile Size: "+ pileSize);

        int whoPlaysFirst = generateZeroOrOne(rnd); // 0 is human and 1 is computer
        if ( whoPlaysFirst == 0){
            computerTurn = false;
            System.out.println("You play first!");
        }
        else {
            computerTurn = true;
            System.out.println("Computer plays first!");
        }

        int computerSmartorStupid = generateZeroOrOne(rnd);; // 0 is stupid and 1 is smart
        if (computerSmartorStupid == 0){ computerSmart = false;
            System.out.println("easy mode");
        } else { computerSmart = true;
            System.out.println("hard mode");
        }

        while (pileSize > 1) {

            if (computerTurn == true){
                //computer's turn
                System.out.println("Computer's turn!");

                if(computerSmart == true){
                    // power of two minus one = 3,7,15,31,63
                    boolean inList = Arrays.asList(pow2Minus1).contains(pileSize);
                    if (inList == true) {
                        System.out.println("pick size is one of 3,7,15,31,63 - computer will choose a random number");
                        pickSize = computerPlaysStupid(rnd, pileSize);
                    }else{
                        //Computer takes off enough marbles to make the size of a pile a power of 2 minus one.
                        //int pickOptions[] = new int [5];
                        ArrayList<Integer> pickOptions = new ArrayList<Integer>();

                        for(int i=0; i < pow2Minus1.length; i++){
                            pickSize = pileSize - pow2Minus1[i];
                            if(pickSize >= 1 && pickSize <= pileSize/2){
                                pickOptions.add(pickSize);
                            }
                        }//end for

                        if(pickOptions.size() > 1){
                            //if there are more than one viable options, choose the biggest number
                            pickSize = Collections.max(pickOptions);
                        } else if (pickOptions.size() == 1){
                            //if there's one option, get that only option
                            pickSize = pickOptions.get(0);
                        }
                        else {
                            //if there are no options, play stupid
                            pickSize = computerPlaysStupid(rnd, pileSize);
                        }
                    }//end else

                }//end computer smart
                else{ //computer is stupid
                    //computer takes a random number between 1 and n/2
                    pickSize = computerPlaysStupid(rnd, pileSize);
                    //moved computer plays stupid code to a method
                }

                pileSize -= pickSize;
                System.out.println("Computer chose "+ pickSize + " there's " + pileSize + " remaining in the pile.");
                computerTurn = false;
                isGameOver(pileSize,computerTurn);

            }
            else {
                //human's turn
                System.out.print("Pick a number between one and " + pileSize/2+": ");
                input = sc.nextInt();

                pileSize -= input;
                System.out.println("You chose "+ input + " there's " + pileSize + " remaining in the pile.");
                computerTurn = true;
                isGameOver(pileSize,computerTurn);

            }


        }//end while





    }//end main

    /**
     * generates the pile size
     * @param rnd random object
     * @return random number
     */
    public static int generatePileSize(Random rnd) {
        int randomNumber;
        randomNumber = rnd.nextInt(90)+10;
        return randomNumber;
    }

    /**
     *  Checks if game is over by checking whether the pile size is 1 or not
     * @param pileSize number that will be checked to see if game is over
     * @param computerTurn who will potentially lose?
     */
    public static void isGameOver(int pileSize, boolean computerTurn){
        if (pileSize == 1 && computerTurn){
            //computer lost
            System.out.println("Computer lost!");
            System.exit(0);
        }
        else if (pileSize == 1 && !computerTurn){
            //human lost
            System.out.println("You lost!");
            System.exit(0);
        }
        else if (pileSize > 1) {
            System.out.println("-------------------------");
            System.out.println("Pile Size: " + pileSize);
        }
    }

    /**
     * Simple method that generates 0 or 1 randomly
     * @param rnd random object
     *
     * @return the random number
     */
    public static int generateZeroOrOne(Random rnd){
        int randomNumber =  rnd.nextInt(999) + 1;
        if (randomNumber > 499){ //random number is 500-1000
            return 1;
        }
        else { //random number is 1-499
            return 0;
        }
    }

    /**
     * reusable method for when then computer plays stupid
     * @param rnd random object
     * @param pileSize the size of the pile
     * @return the number that will eventually be substracted from the pile size
     */
    public static int computerPlaysStupid(Random rnd, int pileSize){
        double halfOfPile = Math.ceil(((double) pileSize)/2);
        int max = (int)halfOfPile;
        int min = 1;
        int pickSize;
        if (pileSize == 2 || pileSize == 3){
            pickSize = 1;
        }
        else{
            pickSize = rnd.nextInt(max - min + 1) + min;
        }
        return pickSize;
    }





}

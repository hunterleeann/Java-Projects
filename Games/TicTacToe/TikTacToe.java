import java.util.Scanner;

/**
 * @author Hunter Snyder
 * Tic-Tac-Toe
 */
public class TikTacToeJava{

    static int playerOneScore = 0;
    static int playerTwoScore = 0;
    static Scanner userInput = new Scanner(System.in);

    public static void main(String [] args){

        char [][] designBoard = {{'_','|','_','|','_'},{'_', '|', '_','|','_'},{' ','|',' ','|',' '}};
        buildBoard(designBoard);
        boolean gameOver = false;
        boolean playAgain = true;

        while(playAgain) {
            while (!gameOver) {
                //System.out.println("Welcome to Tic Tac Toe!!");
                playerOneMove(designBoard);
                gameOver = isGameOver(designBoard);
                if (gameOver) {
                    break;
                }

                playerTwoMove(designBoard);
                gameOver = isGameOver(designBoard);
                if (gameOver) {
                    break;
                }
            }
            System.out.println("Player one score: " + playerOneScore);
            System.out.println("Player two Score: "+ playerTwoScore);
            System.out.println("Would you like to play again? Y/N");
            userInput.nextLine();
            String result = userInput.nextLine();

            switch (result){
                case "Y":
                case "y":
                    playAgain = true;
                    System.out.println("Let's go!");
                    resetBoard(designBoard);
                    gameOver = false;
                    buildBoard(designBoard);
                    break;

                case "N":
                case "n":
                    playAgain = false;
                    System.out.println("Thanks for playing!");
                    break;
                default:
                    break;
            }

        }
    }


    /**
     * builds the tic tac toe game board
     * @param gameBoard
     */
    public static void buildBoard(char [][] gameBoard){

        for(char[] row : gameBoard){
            for( char c : row){
                System.out.print(c);
            }
            System.out.println();
        }
    }


    /**
     * updates the tic tac toe board
     * @param position of the player
     * @param player x or o
     * @param gameBoard where the changes will be displayed
     */
    public static void updateBoard( int position, int player, char [][] gameBoard){

        char symbol;

        if(player==1){
            symbol = 'X';
        }else{
            symbol = 'O';
        }

        switch (position){

            case 1:
                gameBoard[0][0] = symbol;
                buildBoard(gameBoard);
                break;
            case 2:
                gameBoard[0][2] = symbol;
                buildBoard(gameBoard);
                break;
            case 3:
                gameBoard[0][4] = symbol;
                buildBoard(gameBoard);
                break;
            case 4:
                gameBoard[1][0] = symbol;
                buildBoard(gameBoard);
                break;
            case 5:
                gameBoard[1][2] = symbol;
                buildBoard(gameBoard);
                break;
            case 6:
                gameBoard[1][4] = symbol;
                buildBoard(gameBoard);
                break;
            case 7:
                gameBoard[2][0] = symbol;
                buildBoard(gameBoard);
                break;
            case 8:
                gameBoard[2][2] = symbol;
                buildBoard(gameBoard);
                break;
            case 9:
                gameBoard[2][4] = symbol;
                buildBoard(gameBoard);
                break;
            default:
                break;

        }

    }


    /**
     * player one moves
     * @param gameBoard
     */
    public static void playerOneMove(char[][] gameBoard){

        System.out.println("Player one's turn. Pick a location: (1-9)");


        int move = userInput.nextInt();

        boolean result = validMove(move,gameBoard);

        while(!result){
            System.out.println("Sorry! Invalid Move. Try again");
            move = userInput.nextInt();
            result = validMove(move,gameBoard);
        }

        System.out.println("Player one moved at position " + move);
        updateBoard(move,1,gameBoard);


    }


    /**
     * checks whether the move is valid
     * @param move
     * @param gameBoard
     * @return true if valid else false
     */
    public static boolean validMove(int move, char[][] gameBoard){

        switch (move){
            case 1:
                if(gameBoard[0][0] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 2:
                if(gameBoard[0][2] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 3:
                if(gameBoard[0][4] == '_'){
                    return true;
                } else{
                    return false;
                }

            case 4:
                if(gameBoard[1][0] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 5:
                if(gameBoard[1][2] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 6:
                if(gameBoard[1][4] == '_'){
                    return true;
                } else{
                    return false;
                }
            case 7:
                if(gameBoard[2][0] == ' '){
                    return true;
                } else{
                    return false;
                }
            case 8:
                if(gameBoard[2][2] == ' '){
                    return true;
                } else{
                    return false;
                }
            case 9:
                if(gameBoard[2][4] == ' '){
                    return true;
                } else{
                    return false;
                }

            default:
                return false;
        }

    }

    public static void playerTwoMove(char [][] gameBoard){

        System.out.println("Player two's turn. Pick a location: (1-9)");


        int move = userInput.nextInt();

        boolean result = validMove(move,gameBoard);

        while(!result){
            System.out.println("Sorry! Invalid Move. Try again");
            move = userInput.nextInt();
            result = validMove(move,gameBoard);
        }

        System.out.println("Player two moved at position " + move);
        updateBoard(move,2,gameBoard);
    }


    /**
     * Checks the board to see whether someone won/lost
     * @param gameboard
     * @return true if game over else false
     */
    public static boolean isGameOver(char [][] gameboard){

        //Horizontal Win
        if(gameboard[0][0] == 'X'&& gameboard[0][2] == 'X' && gameboard [0][4] == 'X' ){
            System.out.println("Player two wins");
            playerOneScore++;
            return true;
        }
        if(gameboard[0][0] == 'O'&& gameboard[0][2] == 'O' && gameboard [0][4] == 'O' ){
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }
        if(gameboard[1][0] == 'X'&& gameboard[1][2] == 'X' && gameboard [1][4] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameboard[1][0] == 'O'&& gameboard[1][2] == 'O' && gameboard [1][4] == 'O' ){
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }
        if(gameboard[2][0] == 'X'&& gameboard[2][2] == 'X' && gameboard [2][4] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameboard[2][0] == 'O'&& gameboard[2][2] == 'O' && gameboard [2][4] == 'O' ) {
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }

        if(gameboard[0][0] == 'X'&& gameboard[1][0] == 'X' && gameboard [2][0] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameboard[0][0] == 'O'&& gameboard[1][0] == 'O' && gameboard [2][0] == 'O' ){
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }

        if(gameboard[0][2] == 'X'&& gameboard[1][2] == 'X' && gameboard [2][2] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameboard[0][2] == 'O'&& gameboard[1][2] == 'O' && gameboard [2][2] == 'O' ){
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }

        if(gameboard[0][4] == 'X'&& gameboard[1][4] == 'X' && gameboard [2][4] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameboard[0][4] == 'O'&& gameboard[1][4] == 'O' && gameboard [2][4] == 'O' ){
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }

        //Diagonal Wins
        if(gameboard[0][0] == 'X'&& gameboard[1][2] == 'X' && gameboard [2][4] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameboard[0][0] == 'O'&& gameboard[1][2] == 'O' && gameboard [2][4] == 'O' ){
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }

        if(gameboard[2][0] == 'X'&& gameboard[1][2] == 'X' && gameboard [0][4] == 'X' ){
            System.out.println("Player one wins");
            playerOneScore++;
            return true;
        }
        if(gameboard[2][0] == 'O'&& gameboard[1][2] == 'O' && gameboard [0][4] == 'O' ){
            System.out.println("Player two wins");
            playerTwoScore++;
            return true;
        }

        if(gameboard[0][0] != '_' && gameboard[0][2] != '_' && gameboard[0][4] != '_' && gameboard[1][0] !='_'&&
                gameboard[1][2] != '_' && gameboard[1][4] != '_' && gameboard[2][0] != ' ' && gameboard[2][2] != ' ' && gameboard[2][4] != ' '){
            System.out.println("Its a tie");
            return true;
        }




        return false;}

    /**
     * resets the board to play again
     * @param gameBoard
     */
    public static void resetBoard(char [][] gameBoard){
        gameBoard[0][0] = '_';
        gameBoard[0][2] = '_';
        gameBoard[0][4] = '_';
        gameBoard[1][0] = '_';
        gameBoard[1][2] = '_';
        gameBoard[1][4] = '_';
        gameBoard[2][0] = ' ';
        gameBoard[2][2] = ' ';
        gameBoard[2][4] = ' ';

    }





























}

package MiniProjectSeries;

import java.util.Scanner;

public class TicTacToe {

    public static void horizontalLines(){
        for (int i = 1; i <=13; i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public static void displayBoard(char[][] board){
        horizontalLines();
        for (int i = 0; i <3 ; i++) {
            System.out.print("| ");
            for (int j = 0; j <3; j++) {
                System.out.print(board[i][j]+" | ");
            }
            System.out.println();
            horizontalLines();
        }
    }


    public static int checkRowWised(char[][] board){
        for (int i = 0; i < 3; i++) {
            if(board[i][0]==board[i][1] && board[i][1]==board[i][2]){
                return i;
            }
        }
        return -1;
    }

    public static int checkColWised(char[][] board){
        for (int i = 0; i < 3; i++) {
            if(board[0][i]==board[1][i] && board[1][i]==board[2][i]){
                return i;
            }
        }
        return -1;
    }

    public static boolean checkDiagonal(char[][] board){
        if(board[0][0]==board[1][1] && board[1][1]==board[2][2])return true;
        if(board[0][2]==board[1][1] && board[1][1]==board[2][0])return true;
        return false;
    }

    public static boolean checkAllValidations(char[][] board,String player1,String player2){
        int whichRow=checkRowWised(board);
        if(whichRow!=-1){
            if(board[whichRow][0]=='X'){
                System.out.println(player1+" has Won the Game");
            }
            else{
                System.out.println(player2+" has Won the Game");
            }
            return true;
        }
        int whichCol=checkColWised(board);
        if(whichCol!=-1){
            if(board[0][whichCol]=='X'){
                System.out.println(player1+" has Won the Game");
            }
            else{
                System.out.println(player2+" has Won the Game");
            }
            return true;
        }
        if(checkDiagonal(board)){
            if(board[1][1]=='X'){
                System.out.println(player1+" has Won the Game");
            }
            else{
                System.out.println(player2+" has Won the Game");
            }
            return true;
        }

        return false;
    }

    public static boolean isDraw(char[][] board){
        for (int i = 0; i <3 ; i++) {
            for (int j = 0; j < 3; j++) {
                if(board[i][j]>='1' && board[i][j]<='9'){
                    return false;
                }
            }
        }
        return true;
    }
    public static void letsPlayTicTacToe(char[][] board){
        Scanner in=new Scanner(System.in);
        System.out.println("Enter Player1 Name: ");
        String player1=in.next();
        System.out.println("Enter Player2 Name: ");
        String player2=in.next();

        boolean isGameOn=true;
        boolean isPlayer1Turn=true;

        while (isGameOn){
            if(!checkAllValidations(board,player1,player2)){
                System.out.flush();
                boolean doesUserSelectPorperBlock=false;
                while(!doesUserSelectPorperBlock){
                    if(isDraw(board)){
                        isGameOn=false;
                    }
                    if(isPlayer1Turn){
                        System.out.println(player1+" which Block you are choosing? ");
                    }
                    else{
                        System.out.println(player2+" which Block you are choosing? ");
                    }
                    int pick=in.nextInt();
                    pick-=1;
                    int row=pick/3;
                    int col=pick%3;
                    if(board[row][col]>='1' && board[row][col]<='9'){
                        board[row][col]=isPlayer1Turn?'X':'O';
                        isPlayer1Turn=!isPlayer1Turn;
                        doesUserSelectPorperBlock=true;
                    }
                    displayBoard(board);
                }

            }
            else{
                break;
            }
        }


    }

    public static void main(String[] args) {
        char[][] board=new char[3][3];

        char number='1';
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j]=number++;
            }
        }
        displayBoard(board);
        letsPlayTicTacToe(board);
    }
}

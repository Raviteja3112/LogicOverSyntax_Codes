import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Game2048 {

    static long score=0;

    public static void horizontalLine(){
        System.out.println("-----------------");
    }

    public  static void displayBoard(int[][] board){
        for (int i = 0; i < 4; i++) {
            horizontalLine();
            for (int j = 0; j < 4; j++) {
                if(board[i][j]==0){
                    System.out.print("| "+" "+" ");
                }
                else{
                    System.out.print("| "+board[i][j]+" ");
                }
            }
            System.out.print("|");
            System.out.println();
        }
        horizontalLine();
        System.out.println("\n Score: "+score);

    }

    public static void initalSetup(int[][] board){
        int row=(int)(Math.random()* board.length);
        int col=(int)(Math.random()* board.length);
        board[row][col]=2;

        row=(int)(Math.random()* board.length);
        col=(int)(Math.random()* board.length);
        board[row][col]=2;
    }

    public static List<Integer> computation(List<Integer> list){
        List<Integer> result=new ArrayList<>();

        int i=0;
        while(i<list.size()-1){
            int a=list.get(i);
            int b=list.get(i+1);
            if(a==b){
                result.add(a+b);
                score+=a+b;
                i+=2;
            }
            else{
                result.add(a);
                i++;
            }
        }
        if(i<list.size()){
            result.add(list.get(list.size()-1));
        }
        return result;
    }

    public static List<Integer> movementLeftSide(int[][] board,int row){
        List<Integer> list=new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            if(board[row][i]!=0){
                list.add(board[row][i]);
            }
        }
        return computation(list);
    }

    public static List<Integer> movementRightSide(int[][] board, int row) {
        List<Integer> list = new ArrayList<>();
        for (int i = board.length - 1; i >= 0; i--) {
            if (board[row][i] != 0) {
                list.add(board[row][i]);
            }
        }
        return computation(list);
    }

    public static List<Integer> movementUpSide(int[][] board, int col) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < board.length; i++) {
            if (board[i][col] != 0) {
                list.add(board[i][col]);
            }
        }

        return computation(list);
    }


    public static List<Integer> movementDownSide(int[][] board, int col) {
        List<Integer> list = new ArrayList<>();

        for (int i = board.length - 1; i >= 0; i--) {
            if (board[i][col] != 0) {
                list.add(board[i][col]);
            }
        }

        return computation(list);
    }

    public static boolean didPlayerWon(int[][] board){
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if(board[i][j]!=2048){
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean didPlayerLost(int[][] board){

        boolean didRowMergePossibility=false;
        boolean didColMergePossibility=false;

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <4 ; j++) {
                if(board[i][j]==0){
                    return false;
                }
                if(j!=3 && board[i][j]==board[i][j+1]){
                    return false;
                }
                if(i!=3 && board[i][j]==board[i+1][j]){
                    return false;
                }
            }
        }
        return true;
    }


    public static void randomPlace2(int[][] board){
        int row=-1,col=-1;
        do{
            row=(int)(Math.random()*4);
            col=(int)(Math.random()*4);
        }while (board[row][col]!=0);
        board[row][col]=2;
    }
    
    
    public static void playGame2048(){
        final int SIZE=4;
        int[][] board=new int[SIZE][SIZE];
        displayBoard(board);

        initalSetup(board);
        displayBoard(board);


        while(true){
            Scanner in=new Scanner(System.in);
            System.out.println("Chose a-w-s-d:\n");
            char movement=in.next().charAt(0);

            if(movement=='w'){
                //Move Up
                for (int j = 0; j < 4; j++) {
                    List<Integer> list = movementUpSide(board, j);
                    int idx = 0;
                    for (int i = 0; i < list.size(); i++) {
                        board[idx++][j] = list.get(i);
                    }
                    while (idx < 4) {
                        board[idx++][j] = 0;
                    }
                }

            }
            else if(movement=='s'){
                //Move Down
                for (int j = 0; j < 4; j++) {
                    List<Integer> list = movementDownSide(board, j);
                    int idx = 3;
                    for (int i = 0; i < list.size(); i++) {
                        board[idx--][j] = list.get(i);
                    }
                    while (idx >= 0) {
                        board[idx--][j] = 0;
                    }
                }
            }
            else if(movement=='d'){
                //Move Right
                for (int i = 0; i < 4; i++) {
                    List<Integer> list = movementRightSide(board, i);
                    int idx = 3;
                    for (int j = 0; j < list.size(); j++) {
                        board[i][idx--] = list.get(j);
                    }
                    while (idx >= 0) {
                        board[i][idx--] = 0;
                    }
                }
            }
            else{
                //Move Left
                for (int i = 0; i < 4; i++) {
                    List<Integer> list=movementLeftSide(board,i);
                    for (int j = 0; j < list.size(); j++) {
                        board[i][j]=list.get(j);
                    }
                    for (int j = list.size(); j <4; j++) {
                        board[i][j]=0;
                    }
                }
            }
            randomPlace2(board);
            displayBoard(board);

            if(didPlayerWon(board)){
                System.out.println("Ayyayyaya Super ayyyy!!!!");
                return;
            }
            if(didPlayerLost(board)){
                System.out.println("Assalu taggedhele!!!");
                return;
            }
        }

    }

    public static void main(String[] args) {
       playGame2048();
    }
}

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //GENERATE BOARD//
        char[][] board = new char[3][3];
        for (int a = 0; a < 3; a++) {
            for (int b = 0; b < 3; b++) {
                board[a][b] = ' ';
            }
        }
        System.out.println(printedBoard(board));
        int player = 0;
        while(true){
            playerMove(board,player);
            checkBoard(board);
            /*if (checkBoard(board) == "X Wins"){
                System.out.println("X Wins");
                break;
            } else if(checkBoard(board) == "O Wins"){
                System.out.println("O Wins");
                break;
            } else if(checkBoard(board) == "Draw"){
                System.out.println("Draw");
                break;
            }*/
            System.out.println(printedBoard(board));
            player += 1;
        }
    }

    public static void playerMove(char[][] board, int player) {
        Scanner input = new Scanner(System.in);
        int validMove = 0;
        while (validMove == 0) {
            System.out.print("Enter the coordinates: ");
            try {
                int x = input.nextInt() - 1;
                int y = input.nextInt() - 1;
                if (x > 2 || y > 2) {
                    System.out.println("Coordinates should be from 1 to 3!");
                } else if (board[x][y] != ' ') {
                    System.out.println("This cell is occupied! Choose another one!");
                } else {
                    if(player % 2 == 0){
                        board[x][y] = 'X';
                    } else{
                        board[x][y] = 'O';
                    }
                    validMove = 1;
                }
            } catch (Exception NumberFormatException) {
                System.out.println("You should enter numbers!");
                input.nextLine();
            }
        }
    }

    public static String printedBoard (char[][] board) {
        String printedBoard = "---------\n| " + board[0][0] + " " + board[0][1] + " " + board[0][2] +
                " |\n| " + board[1][0] + " " + board[1][1] + " " + board[1][2] +
                " |\n| " + board[2][0] + " " + board[2][1] + " " + board[2][2] + " |\n---------";
        return printedBoard;
    }

    public static void checkBoard (char[][] board) {
        boolean xWins = false;
        boolean oWins = false;
        int boardCount = 0;
        for (int i = 0; i < board.length; i++) {
            if (board[i][0] + board[i][1] + board[i][2] == 264 || board[0][i] + board[1][i] + board[2][i] == 264) {
                xWins = true;
            }

            if (board[i][0] + board[i][1] + board[i][2] == 237 || board[0][i] + board[1][i] + board[2][i] == 237) {
                oWins = true;
            }

        }

        for (int c = 0; c < 3; c++) {
            for (int d = 0; d < 3; d++) {
                if (board[c][d] != ' '){
                    boardCount++;
                }
            }
        }

        if (board[0][0] + board[1][1] + board[2][2] == 264 || board[0][2] + board[1][1] + board[2][0] == 264) {
            xWins = true;
        }

        if (board[0][0] + board[1][1] + board[2][2] == 237 || board[0][2] + board[1][1] + board[2][0] == 237) {
            oWins = true;
        }

        if (xWins) {
            System.out.println(printedBoard(board));
            System.out.println("X wins");
            System.exit(0);
        } else if (oWins) {
            System.out.println(printedBoard(board));
            System.out.println("O wins");
            System.exit(0);
        } else if (boardCount == 9){
            System.out.println(printedBoard(board));
            System.out.println("Draw");
            System.exit(0);
        }
    }
}
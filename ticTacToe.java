import java.util.Scanner;

public class ticTacToe {
    
    static char[][] board = new char[3][3];

    public static void  fillboard(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                board[i][j]=' ';

            }
        }
    }

    public static void printboard(){
        System.out.println("------------------");
        for(int i=0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++){
                System.out.print(board[i][j]+" |");
            }
            System.out.println("\n-----------------");
        }
    }

    public static boolean isvalid(int r,int c){
        if (r>=0 && r<3 && c>=0 && c<3 && board[r][c]==' ') {
            return true;
        }
        return false;
    }

    public static boolean won(char x){
        for(int i=0;i<3;i++){
            if(board[i][0]== x && board[i][1]==x && board[i][2]==x ){
                return true;
            }
            if(board[0][i]== x && board[1][i]==x && board[2][i]==x ){
                return true;
            }
            if(board[0][0]== x && board[1][1]==x && board[2][2]==x ){
                return true;
            }
            if(board[0][2]== x && board[1][1]==x && board[2][0]==x ){
                return true;
            }
        }
        return false;
    }

    public static boolean full(){
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if (board[i][j]==' ') {
                    return false;
                }
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        fillboard();
        char curr ='X';
        while (true) {
            printboard();
            System.out.print("player "+curr+" row/column(0-2): ");
            int r = sc.nextInt();
            int c= sc.nextInt();

            if (!isvalid(r,c)) {
                System.out.println("try again");
                continue;

            }
            board[r][c]=curr;
            if (won(curr)) {
                printboard();
                System.out.println("Player "+curr+" wins");
                break;

            }

            if (full()) {
                printboard();
                System.out.println("DRAW");
                break;
            }
            curr =(curr=='X')?'O':'X';
        }
        sc.close();

        
    }
}

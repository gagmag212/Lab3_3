import javax.xml.transform.sax.SAXSource;
import java.util.Scanner;

public class Game {
    private static OX ox;
    private static Scanner kb = new Scanner(System.in);
    private static int col,row;
    public static void main (String[] args){
        ox = new OX();
        while (true) {
            printTable();
            intput();
            if(ox.checkWin(col,row)){
                printTable();
                score();
                ox.reset();
                continue;
            }
            if(ox.isDraw()){
                printTable();
                score();
                ox.reset();
                continue;
            }
            ox.switchPlayer();
        }

    }

    private static void score() {
        System.out.println("X Win: "+ox.getScoreX());
        System.out.println("O Win: "+ox.getScoreO());
        System.out.println("Draw: "+ox.getScoreDraw());
    }

    private static void printTable() {
        System.out.print(ox.getTableString());
    }

    public static void intput(){
        boolean canPut = true;
        do {
            System.out.print(ox.getCurrentPlayer() + " (col): ");
            col = kb.nextInt();
            System.out.print(ox.getCurrentPlayer() + " (Row): ");
            row = kb.nextInt();
            canPut = ox.put(col, row);
            if (!canPut) {
                System.out.println("Plese input number between 0-2");
            }
        }while (!canPut);

    }
}

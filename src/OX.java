import java.lang.annotation.Target;

public class OX {
    public String[][] table = {
            {" ","0","1","2"},
            {"0","-","-","-"},
            {"1","-","-","-"},
            {"2","-","-","-"}
    };
    private  String player;
    private  int countX;
    private  int countO;
    private  int countDraw;
    private  int turncount;
    public OX() {
        player = "X";
        countX = 0;
        countO = 0;
        countDraw = 0;
        turncount = 0;
    }
    public String getTableString(){
        String result="";
        for(int row = 0;row<table.length;row++){
            for(int col = 0;col<table[row].length;col++){
                 result += table[row][col];
            }
            result += "\n";
        }
        return result;
    }

    public String getCurrentPlayer() {
        return  player;
    }

    public int getCountX() {
        return countX;
    }

    public int getCountO() {
        return countO;
    }

    public int getCountDraw() {
        return countDraw;
    }

    public boolean put(int col, int row) {
        try {
            if (!table[row + 1][col + 1].equals("-")) {
                return false;
            }
            table[row + 1][col + 1] = getCurrentPlayer();
        }catch (ArrayIndexOutOfBoundsException e){
            return false;
        }
        turncount++;
        if(checkWin(col,row)) {
            if (player.equals("X")) {
                countX++;
            }else if(player.equals("O")){
                countO++;
            }
        }
        if(isDraw()){
            countDraw++;
        }
        return true;

    }

    public void switchPlayer() {
        if(player == "X") {
            player = "O";
        }else{
            player = "X";
        }
    }


    public String get(int col , int row) {
        if(col > 2 || col < 0 || row > 2|| row < 0){
            return null;
        }
        return  table[row+1][col+1];
    }

    public boolean checkWin(int col, int row) {
        //checkWinCol
        boolean colWin = true;
        for (int i = 0; i < 3; i++ ){
           if (!table[i+1][col+1].equals(player)){
               colWin = false;
           }
        }if(colWin){
           return true;
        }

        //checkWinRow
        boolean rowWin = true;
        for (int i = 0; i < 3; i++ ){
            if (!table[row+1][i+1].equals(player)){
                rowWin = false;
            }
        }if(rowWin){
            return true;
        }

        //checkWinES
        boolean esWin = true;
        for (int i = 0; i < 3; i++ ){
            if (!table[i+1][i+1].equals(player)){
                esWin = false;
            }
        }if(esWin){
            return true;
        }

        //checkWinSS
        boolean ssWin = true;
        for (int i = 0; i < 3; i++ ){
            if (!table[i+1][3-i].equals(player)){
                ssWin = false;
            }
        }if(ssWin){
            return true;
        }
        return false;
    }

    public void reset() {
        for (int i = 0; i < 3; i++){
            for(int j =0; j < 3; j++){
                table[i+1][j+1] = "-";
            }
        }
        player = "X";
        turncount = 0;
    }

    public int getTurnCount() {
        return turncount;
    }

    public boolean isDraw() {
        if(turncount < 9){
            return false;
        }
        return true;
    }


    public int getScoreX() {
        return countX;
    }

    public int getScoreO() {
        return countO;
    }

    public int getScoreDraw() {
        return countDraw;
    }
}

public class Boards {

    int[][] chosenBoard;
    int difficulty;

    public int[][] easyBoard = {
            {0,0,0,2,6,0,7,0,1},
            {6,8,0,0,7,0,0,9,0},
            {1,9,0,0,0,4,5,0,0},
            {8,2,0,1,0,0,0,4,0},
            {0,0,4,6,0,2,9,0,0},
            {0,5,0,0,0,3,0,2,8},
            {0,0,9,3,0,0,0,7,4},
            {0,4,0,0,5,0,0,3,6},
            {7,0,3,0,1,8,0,0,0}
    };

    public int[][] interBoard = {
            {0,2,0,6,0,8,0,0,0},
            {5,8,0,0,0,9,7,0,0},
            {0,0,0,0,4,0,0,0,0},
            {3,7,0,0,0,0,5,0,0},
            {6,0,0,0,0,0,0,0,4},
            {0,0,8,0,0,0,0,1,3},
            {0,0,0,0,2,0,0,0,0},
            {0,0,9,8,0,0,0,3,6},
            {0,0,0,3,0,6,0,9,0}
    };

    public int[][] hardBoard = {
            {0,0,0,6,0,0,4,0,0},
            {7,0,0,0,0,3,6,0,0},
            {0,0,0,0,9,1,0,8,0},
            {0,0,0,0,0,0,0,0,0},
            {0,5,0,1,8,0,0,0,3},
            {0,0,0,3,0,6,0,4,5},
            {0,4,0,2,0,0,0,6,0},
            {9,0,3,0,0,0,0,0,0},
            {0,2,0,0,0,0,1,0,0}
    };

    public Boards (int playerDiff) {
        difficulty = playerDiff;
    }

    public int[][] boardPicker () {

        switch (difficulty) {
            case 1:
                System.out.println("Tabuleiro escolhido: fácil.");
                chosenBoard = easyBoard;
                break;
            case 2:
                System.out.println("Tabuleiro escolhido: Intermediário.");
                chosenBoard = interBoard;
                break;
            case 3:
                System.out.println("Tabuleiro escolhido: Difícil.");
                chosenBoard = hardBoard;
                break;
            default:
                System.out.println("Tabuleiro escolhido: padrão (fácil).");
                chosenBoard = easyBoard;
        }

        return chosenBoard;
    }



}

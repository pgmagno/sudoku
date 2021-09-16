
import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {

    static int[][] objMatrix12 = {
            {3, 3, 4, 6, 7, 8, 9, 1, 2},
            {6, 7, 2, 1, 9, 5, 3, 4, 8},
            {1, 9, 8, 3, 4, 2, 5, 6, 7},
            {8, 5, 9, 7, 6, 1, 4, 2, 3},
            {4, 2, 6, 8, 5, 3, 7, 9, 1},
            {7, 1, 3, 9, 2, 4, 8, 5, 6},
            {9, 6, 1, 5, 3, 7, 2, 8, 4},
            {2, 8, 7, 4, 1, 9, 6, 3, 5},
            {3, 4, 5, 2, 8, 6, 1, 7, 9}
    };

    public static void main(String[] args) {


        Scanner sc1 = new Scanner(System.in);
        Scanner playerOption = new Scanner(System.in);
        String playerContinue = "Y";
        String rowColNum;

        System.out.println("Começando o Jogo");

        PrintBoard formattedBoard = new PrintBoard(objMatrix12);
        formattedBoard.printFormattedBoard();

        while (playerContinue.equals("Y")) {


            System.out.print("Digite uma sequência de Linha-Coluna-Número: ");
            try {
                rowColNum = sc1.nextLine();
                String[] rowColNumArray = rowColNum.split("-");
                int row = Integer.parseInt(rowColNumArray[0]);
                int col = Integer.parseInt(rowColNumArray[1]);
                int num = Integer.parseInt(rowColNumArray[2]);
                objMatrix12[row - 1][col - 1] = num;
                CheckGame newGame = new CheckGame(objMatrix12);
                PrintBoard modifiedFormattedBoard = new PrintBoard(objMatrix12);
                modifiedFormattedBoard.printFormattedBoard();
                if (newGame.checkGame()){
                    break;
                }
            }
            catch (Exception e) {
                System.out.println("Digite uma sequência correta, não esqueça os traços. Exemplo: 1-2-3");
            }


            //playerOption.nextLine();
            System.out.println("Quer continuar?");
            playerContinue = playerOption.nextLine();
            if (playerContinue.equals("N")) {
                System.out.println("Thank you for playing.");
                break;
            }
        }



    }
}
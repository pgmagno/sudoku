
import java.util.Locale;
import java.util.Scanner;

public class Sudoku {

    static int[][] objMatrix;


    public static void main(String[] args) {


        Scanner sc1 = new Scanner(System.in);
        Scanner playerOption = new Scanner(System.in);
        String playerContinue = "Y";
        String rowColNum;

        String[] convertedAnswer = {"N", "NO", "NAO"};

        int playerChoice;

        System.out.println("Bem-Vindo ao SudoCU");
        System.out.println("Escolha um nível de dificuldade (1: fácil, 2: intermediário e 3: difícil)");

        playerChoice = playerOption.nextInt();

        Boards board = new Boards(playerChoice);
        objMatrix = board.boardPicker();


        System.out.println("Começando o Jogo");

        PrintBoard formattedBoard = new PrintBoard(objMatrix);
        formattedBoard.printFormattedBoard();

        gameLoop:
        while (!playerContinue.equals("N")) {

            CheckGame newGame = new CheckGame(objMatrix);

            System.out.print("Digite uma sequência de Linha-Coluna-Número: ");
            int numOfExceptions = 1;
            while (numOfExceptions > 0) {
                try {
                    numOfExceptions = 0;
                    rowColNum = sc1.nextLine();
                    playerContinue = rowColNum;
                    if (playerContinue.equals("N")) {
                        System.out.println("Obrigado por Jogar");
                        break gameLoop;
                    }
                    if (playerContinue.equals("Problems")){
                        newGame.problemLog();
                    }
                    String[] rowColNumArray = rowColNum.split("-");
                    int row = Integer.parseInt(rowColNumArray[0]);
                    int col = Integer.parseInt(rowColNumArray[1]);
                    int num = Integer.parseInt(rowColNumArray[2]);

                    if (row < 1 || row > 9 || col < 1 || col > 9 || num < 1 || num > 9) {
                        throw new Exception("Número Inválido");
                    }

                    objMatrix[row - 1][col - 1] = num;

                    PrintBoard modifiedFormattedBoard = new PrintBoard(objMatrix);
                    modifiedFormattedBoard.printFormattedBoard();
                } catch (Exception e) {
                    numOfExceptions++;
                    System.out.println("Digite uma sequência correta, não esqueça os traços. Exemplo: 1-2-3");
                }
            }
            if (newGame.checkGame()) {
                break;
            }
            playerOption.nextLine(); //fazer o swallow do End of Line character
            System.out.print("Quer continuar? (S/N) ");
            playerContinue = playerOption.nextLine().toUpperCase();

            for (String t : convertedAnswer) {
                if (playerContinue.equals(t)) {
                    System.out.println("Obrigado por jogar.");
                    break;
                }
            }

        }
    }
}
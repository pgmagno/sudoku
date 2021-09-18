
import java.util.Locale;
import java.util.Scanner;

public class Sudoku {

    static int[][] objMatrix;


    public static void main(String[] args) {


        Scanner sc1 = new Scanner(System.in);
        Scanner playerOption = new Scanner(System.in);
        String playerContinue = "Y";
        String rowColNum;

        String[] convertedExitAnswer = {"N", "NO", "NAO", "NÃO"};
        String[] convertedProblemAnswer = {"PROBLEMS", "PROBLEMAS"};


        int playerDiff = 0;

        System.out.println("################# SUDOKU #################");
        System.out.println("Instruções: Escolha um nível de dificuldade e digite uma sequência de Linha-Coluna-Número.");
        System.out.println("Exemplo: 1-2-3, em que 1 é o número da linha, 2 o da coluna e 3 o número a ser inserido");
        System.out.println("A qualquer momento digite 'Problemas', para checar o tabuleiro, ou 'N' para sair");
        System.out.println("Assim que o tabuleiro estiver solucionado, o jogo se encerrará!");
        System.out.println("Boa Sorte!");
        System.out.println();
        System.out.println("---------------------- Novo Jogo ----------------------");
        System.out.println();
        System.out.println("Escolha um nível de dificuldade (1: fácil, 2: intermediário e 3: difícil)");





            try {
                playerDiff = playerOption.nextInt();
            } catch (Exception e) {
                System.out.print("Entrada Inválida. ");
            }


        Boards board = new Boards(playerDiff);
        objMatrix = board.boardPicker();

        System.out.println("Começando o Jogo");

        PrintBoard formattedBoard = new PrintBoard(objMatrix);
        formattedBoard.printFormattedBoard();

        gameLoop:
        while (true) {

            CheckGame newGame = new CheckGame(objMatrix);
            newGame.checkGame();

            System.out.print("Digite uma sequência de Linha-Coluna-Número: ");
            int numOfExceptions = 1;
            while (numOfExceptions > 0) {
                try {
                    numOfExceptions = 0;
                    rowColNum = sc1.nextLine();
                    playerContinue = rowColNum;

                    for (String t : convertedExitAnswer) {
                        if (playerContinue.toUpperCase().equals(t)) {
                            System.out.println("Obrigado por jogar.");
                            break gameLoop;
                        }
                    }
                    for (String t : convertedProblemAnswer) {
                        if (playerContinue.toUpperCase().equals(t)) {
                            newGame.problemLog();
                        }
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
                    if (newGame.checkGame()) {
                        break gameLoop;
                    }
                } catch (Exception e) {
                    numOfExceptions++;
                    System.out.println("Digite uma sequência correta, não esqueça os traços. Exemplo: 1-2-3");
                }
            }
        }
    }
}
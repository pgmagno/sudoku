public class PrintBoard {

    int[][] formattedBoard;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_UNDERSCORE = "\u001B[0;21m";

    //System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);

    public PrintBoard (int[][] rawMatrix) {
        formattedBoard = rawMatrix;
    }

    public void printFormattedBoard () {

        String color = ANSI_BLACK;

        for (int i = 0; i < 9; i++) {
            System.out.print(ANSI_UNDERSCORE + color + "|" + ANSI_RESET);
            for (int j = 0; j < 9; j++) {
                if (j == 2 || j == 5 || j == 8) {
                    System.out.print(ANSI_UNDERSCORE + formattedBoard[i][j] + color + "|" + ANSI_RESET);
                } else {
                    System.out.print(ANSI_UNDERSCORE + formattedBoard[i][j] + ANSI_GREEN +  "|" + ANSI_RESET);
                }
            }
            System.out.println();
            if(i == 2 || i == 5) {
                System.out.println(" -----------------");
            }

        }

    }

}

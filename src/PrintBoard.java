public class PrintBoard {

    int[][] formattedBoard;

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    public static final String ANSI_UNDERSCORE = "\u001B[0;4m";
    public static final String ANSI_UNDERSCORE_BOLD = "\u001B[36;21m";

    //System.out.println(ANSI_RED + "This text is red!" + ANSI_RESET);

    public PrintBoard (int[][] rawMatrix) {
        formattedBoard = rawMatrix;
    }

    public void printFormattedBoard () {

        String color = ANSI_BLACK;

        System.out.println(ANSI_BLUE + "_____________________" + ANSI_RESET);

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {
                if (j == 2 || j == 5) {
                    System.out.print(formattedBoard[i][j] + ANSI_RED + " | " + ANSI_RESET);
                } else {
                    System.out.print(formattedBoard[i][j] + " ");
                }
            }
            System.out.println();
            if(i == 2 || i == 5) {
                System.out.println(ANSI_RED + "------|-------|------" + ANSI_RESET);
            }

        }
        System.out.println(ANSI_BLUE + "---------------------" + ANSI_RESET);


    }

}

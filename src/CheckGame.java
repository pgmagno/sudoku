public class CheckGame {


    int[][] matrixToCheck;
    String[] problems = new String[27];
    public CheckGame(int[][] objMatrix) {
        matrixToCheck = objMatrix;
    }
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_RESET = "\u001B[0m";

    public boolean checkGame() {

        int ok = 0;

        boolean resultOfGame;

        int p = 0;
        int[] listFromQuadrant = new int[9];


        //pegar um quadrante (Top Left)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                listFromQuadrant[p] = matrixToCheck[i][j];
                p++;
            }
        }

        DuplicateCheck testCheckTL = new DuplicateCheck(listFromQuadrant);
        if (testCheckTL.dupCheck()) {
            ok++;
        } else {
            problems[0] = "Quadrante Top Left";
        }

        p = 0;
        //pegar um quadrante (Top Center)
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                listFromQuadrant[p] = matrixToCheck[i][j];
                p++;
            }
        }
        DuplicateCheck testCheckTopCenter = new DuplicateCheck(listFromQuadrant);
        if (testCheckTopCenter.dupCheck()) {
            ok++;
        } else {
            problems[1] = "Quadrante Top Center";
        }

        p = 0;
        //pegar um quadrante (Top Right)
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                listFromQuadrant[p] = matrixToCheck[i][j];
                p++;
            }
        }
        DuplicateCheck testCheckTopRight = new DuplicateCheck(listFromQuadrant);
        if (testCheckTopRight.dupCheck()) {
            ok++;
        } else {
            problems[2] = "Quadrante Top Right";
        }

        p = 0;
        //pegar um quadrante (center left)
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                listFromQuadrant[p] = matrixToCheck[i][j];
                p++;
            }
        }
        DuplicateCheck testCheckCentLeft = new DuplicateCheck(listFromQuadrant);
        if (testCheckCentLeft.dupCheck()) {
            ok++;
        } else {
            problems[3] = "Quadrante Center Left";
        }

        p = 0;
        //pegar um quadrante (Center)
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                listFromQuadrant[p] = matrixToCheck[i][j];
                p++;
            }
        }
        DuplicateCheck testCheckCenter = new DuplicateCheck(listFromQuadrant);
        if (testCheckCenter.dupCheck()) {
            ok++;
        } else {
            problems[4] = "Quadrante Center";
        }

        p = 0;
        //pegar um quadrante (center right)
        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                listFromQuadrant[p] = matrixToCheck[i][j];
                p++;
            }
        }
        DuplicateCheck testCheckCentRight = new DuplicateCheck(listFromQuadrant);
        if (testCheckCentRight.dupCheck()) {
            ok++;
        } else {
            problems[5] = "Quadrante Center Right";
        }

        p = 0;
        //pegar um quadrante (bottom left)
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                listFromQuadrant[p] = matrixToCheck[i][j];
                p++;
            }
        }
        DuplicateCheck testCheckBotLeft = new DuplicateCheck(listFromQuadrant);
        if (testCheckBotLeft.dupCheck()) {
            ok++;
        } else {
            problems[6] = "Quadrante Bottom Left";
        }

        p = 0;
        //pegar um quadrante (bottom center)
        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                listFromQuadrant[p] = matrixToCheck[i][j];
                p++;
            }
        }
        DuplicateCheck testCheckBotCenter = new DuplicateCheck(listFromQuadrant);
        if (testCheckBotCenter.dupCheck()) {
            ok++;
        } else {
            problems[7] = "Quadrante Bottom Center";
        }

        p = 0;
        //pegar um quadrante (bottom right)
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                listFromQuadrant[p] = matrixToCheck[i][j];
                p++;
            }
        }
        DuplicateCheck testCheckBotRight = new DuplicateCheck(listFromQuadrant);
        if (testCheckBotRight.dupCheck()) {
            ok++;
        } else {
            problems[8] = "Quadrante Bottom Right";
        }

        ////////////////////// Checando Colunas /////////////////////////////////////////

        int[] colunaInteira = new int[9];
        // coluna inteira
        for (int j = 0; j < 9; j++) {
            for (int i = 0; i < 9; i++) {
                colunaInteira[i] = matrixToCheck[i][j];
            }
            DuplicateCheck testColunaInteira = new DuplicateCheck(colunaInteira);
            if (testColunaInteira.dupCheck()) {
                ok++;
            } else {
                problems[8 + j] = "Coluna " + (j + 1);
            }
        }

    //////////////////////// checando Linhas ////////////////////////////////////////

        int[] linhaInteira = new int[9];

        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                linhaInteira[j] = matrixToCheck[i][j];
        }
        DuplicateCheck testLinhaInteira = new DuplicateCheck(linhaInteira);

            if (testLinhaInteira.dupCheck()) {
                ok++;
            } else {
                problems[17 + i] = "Linha " + (i + 1);
            }
        }

////////////////////// verificando resultados e retornando //////////////////////////

        if (ok == 27) {
            System.out.println("Fim de Jogo. Parabéns!");
            resultOfGame = true;
        } else {
            resultOfGame = false;
        }
        return resultOfGame;
    }

    public void problemLog () {
        System.out.println("Problemas: ");
        for (String t : problems) {
            if (t != null) {
                System.out.println(ANSI_RED + "* " + t + ANSI_RESET);
            }
        }
        System.out.println();
    }


}
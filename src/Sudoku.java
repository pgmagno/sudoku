
import java.util.Arrays;
import java.util.Scanner;

public class Sudoku {


    static int[][] quadrantTL = {
            {1,   2,   3,   4,   5,   6,   7,   8,   9},
            {1,   2,   3,   4,   5,   6,   7,   8,   9},
            {1,   2,   3,   4,   5,   6,   7,   8,   9},
            {11,  22,  33,  44,  55,  66,  77,  88,  99},
            {11,  22,  33,  41,  51,  61,  77,  88,  99},
            {11,  22,  33,  42,  52,  62,  77,  88,  99},
            {111, 222, 333, 444, 555, 666, 777, 888, 999},
            {111, 222, 333, 444, 555, 666, 777, 888, 999},
            {111, 222, 333, 444, 555, 666, 777, 888, 999}
    };

    public static void main(String[] args) {

        // pegar valores das colunas
        for (int i = 3; i < 6; i++) {
          //  System.out.print(quadrantTL[i][0] + " ");
        }
        // coluna inteira
        for (int i = 0; i < 9; i++) {
        //    System.out.print(quadrantTL[i][0] + " ");
        }

        // pegar valores das linhas
        for (int i = 6; i < 9; i++) {
          //  System.out.print(quadrantTL[i][0] + " ");
        }
        //pegar o valor da linha inteira
        for (int i = 0; i < 9; i++) {
       //       System.out.print(quadrantTL[0][i] + " ");
        }

        //pegar um quadrante (nesse caso o do centro)
        for (int i = 3; i < 6; i++) {
            for(int j = 3; j < 6; j++) {
           //    System.out.println(quadrantTL[i][j]);
            }
        }


      //  Scanner sc1 = new Scanner(System.in);
      //  int num1 = sc1.nextInt();
      //  System.out.println(num1);
        int[] testArray = {1,2,3,4,5,6,7,9,9};
        DuplicateCheck testCheck = new DuplicateCheck(testArray);
        System.out.println(testCheck.dupCheck());
    }
}
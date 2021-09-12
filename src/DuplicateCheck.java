import java.util.Arrays;

public class DuplicateCheck {
    // Checa a presença de valores duplicados

    int[] intArray;

    public DuplicateCheck (int[] objIntArray) {
        intArray = objIntArray;
    }

    // Methods
    public boolean dupCheck () {

        int intChecker;
        int p;
        boolean result = false;

        for(int k : intArray) {
            intChecker = k;
            p = 0;
            for(int m : intArray) {
                if (intChecker == m) {
                    p++;
                }
            }
            if (p > 1) {
                result = false;
            } else {
                result = true;
            }
       }
    return result;
    }

}

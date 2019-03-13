package HomeWork5;

/**
 Java. Algorithms and data structures. Home work 5.

@author Sergey Bondarenko
@version dated Mar 13, 2019
 */

public class MainHW5 {
    public static void main(String[] args) {

        // Task 1. exponentiation
        System.out.println(exponentiation(4, -2));//0.0625
        System.out.println(exponentiation(3, 4));//81
        System.out.println(exponentiation(3, 0));//1
        System.out.println(exponentiation(5, -3));//0,008
        System.out.println(exponentiation(0, 25));//0
        System.out.println(exponentiation(0, 0));//error
    }

    private static double exponentiation(double digit, int rank) {
        if (digit == 0) {
            if (rank != 0)
                return 0;
            else
                throw new IllegalArgumentException("Invalid rank " + rank + " for value = 0");
        }
        if (rank < 0) {
            return 1 / (digit * exponentiation(digit, -rank - 1));
        }
        else if (rank > 0) {
            return digit * exponentiation(digit, rank - 1);
        }
        else {
            return 1;
        }
    }

}

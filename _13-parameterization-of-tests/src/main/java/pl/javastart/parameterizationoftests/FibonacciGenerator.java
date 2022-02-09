package pl.javastart.parameterizationoftests;

public class FibonacciGenerator {
    public static void main(String[] args) {

//        System.out.println(isFibonacciNumber(5));
//        System.out.println(checkIfFibonacciNumberNoRecursion(7));
        System.out.println(checkIfFibonacciNumber(2));
        System.out.println(fibonacci(2));
    }

    boolean isFibonacciNumber(int number) {
        return isPerfectSquare(5 * number * number + 4) ||
                isPerfectSquare (5 * number * number - 4);
    }

    boolean isPerfectSquare(int number) {
        int squareRoot = (int) Math.sqrt(number);
        return (squareRoot * squareRoot == number);
    }

    static int fibonacci(int n){
        double prev = 0, next = 1, result = 0;
        for (int i = 0; i < n; i++) {
            result = prev + next;
            prev = next;
            next = result;
        }
        return (int) result;
    }

    int checkIfFibonacciNumberNoRecursion(int number) {
        double previous = 0;
        double next = 1;
        double result = 0;
        for (int i = 0; i < number; i++) {
            result = previous + next;
            previous = next;
            next = result;
        }
        return (int) result;
    }

//Rekurencyjny sposób implementacji ciągu Fibonacciego, nie zalecany, ale nie pomijający wszystkich cyfr
    static int checkIfFibonacciNumber(int number) {
        if (number == 0) {
            return 0;
        } else if (number == 1) {
            return 1;
        } else if (number >= 2) {
            return checkIfFibonacciNumber(number - 1) + checkIfFibonacciNumber(number - 2);
        }
        return number;
    }

}

package MathOperations;

public class Divide {

    public int divide(int a, int b) {
        if (b == 0) {
            System.out.println(a  +" Cannot divide by zero.");
            return 0;
        }
        return a / b;
    }

}

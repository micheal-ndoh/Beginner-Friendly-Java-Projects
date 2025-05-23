// package MathOperations;

// import main.java.com.MathOperations.*;

// import org.junit.jupiter.api.Test;
// import java.math.BigInteger;
// import static org.junit.jupiter.api.Assertions.*;

// public class CalculatorTest {

//     @Test
//     public void testAddition() {
//         Addition addition = new Addition();
//         assertEquals(new BigInteger("15"), addition.add(new BigInteger("10"), new BigInteger("5")));
//     }

//     @Test
//     public void testSubtraction() {
//         Subtraction subtraction = new Subtraction();
//         assertEquals(new BigInteger("5"), subtraction.subtract(new BigInteger("10"), new BigInteger("5")));
//     }

//     @Test
//     public void testMultiplication() {
//         Multiply multiply = new Multiply();
//         assertEquals(new BigInteger("50"), multiply.multiply(new BigInteger("10"), new BigInteger("5")));
//     }

//     @Test
//     public void testDivision() {
//         Divide divide = new Divide();
//         assertEquals(new BigInteger("2"), divide.divide(new BigInteger("10"), new BigInteger("5")));
//     }

//     @Test
//     public void testFactorial() {
//         Factorial factorial = new Factorial();
//         assertEquals(new BigInteger("120"), factorial.fact(5));
//     }

//     @Test
//     public void testFactorialOfZero() {
//         Factorial factorial = new Factorial();
//         assertEquals(BigInteger.ONE, factorial.fact(0));
//     }

//     @Test
//     public void testFactorialNegativeNumber() {
//         Factorial factorial = new Factorial();
//         assertThrows(IllegalArgumentException.class, () -> factorial.fact(-1));
//     }

//     @Test
//     public void testDivideByZero() {
//         Divide divide = new Divide();
//         assertThrows(ArithmeticException.class, () -> divide.divide(new BigInteger("10"), BigInteger.ZERO));
//     }
// }

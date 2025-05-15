



public class Time {
    public static void main(String[] args) {
        Util.printTwice("Hello");
        Util.printTwice(10);
    }
    public class Util {
    public static <T> void printTwice(T value) {
            System.out.println(value);
            System.out.println(value);
        }
    }
    //Arrays
} 
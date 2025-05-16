public class genericClass {

    public static <T, U> void Pair(T[] arr, U[] arr2) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("First Array: " +arr[i]);
        }
        for (int i = 0; i < arr2.length; i++) {
            System.out.println("Second Array: " + arr2[i]);
        }
    }
}
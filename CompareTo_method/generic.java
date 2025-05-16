

public class generic {
    
    public static void main(String[] args) {

    //    displayArray(new Integer[]{1,2,3});
    //    displayArray(new String[]{"a","b","c"});
    //    displayArray(new Character[]{'A','A','A'});

    //    MyGenericClass<Integer, Integer> myInt = new MyGenericClass(10, 20);
    // MyGenericClass<Double, Double> myDouble = new MyGenericClass(10.0, 20.0);
    // MyGenericClass<Character, Character> myChar = new MyGenericClass('A', 'S');
    // MyGenericClass<String, String> myString = new MyGenericClass("Hello", "World");

    // System.out.println(myInt.getValue());
    // System.out.println(myDouble.getValue());
    // System.out.println(myChar.getValue());
    // System.out.println(myString.getValue());

    
    Integer[] intArr = {1,2,3};
    String[] StrArr = {"a","b","c"};
    Character[] CharArr = {'A','B','C'};
    genericClass.Pair(intArr, StrArr);
    genericClass.Pair(intArr, CharArr);

    
    }
   
}
    // public static <T> void displayArray(T[] arr) {
    //     for (int i = 0; i < arr.length; i++) {
    //         System.out.println(arr[i]);
    //     }
    // }

   
   


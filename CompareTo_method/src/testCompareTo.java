public class testCompareTo {
    public static void main(String[] args) {
        testCompare("apple", "");
        testCompare("apple", "apple");
        testCompare("banana", "apple");
        testCompare("abc", "abcd");
        testCompare("abcd", "abc");
    }

    public static void testCompare(String s1, String s2) {
        int builtin = s1.compareTo(s2);
        int myCustom = CompareTo.compareStrings(s1, s2);

        String result = builtin == myCustom ? " \nMATCH " : " NO MATCH ";
        System.out.println(builtin + " " + myCustom + result);
    }
}

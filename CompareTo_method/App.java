import java.util.Collection;
import java.util.Iterator;
public class App {
    
    public static void main(String[] args) {
        Collection<String> collection1 = new java.util.HashSet<>();
        Collection<String> collection2 = new java.util.HashSet<>();
        collection1.add("A");
        collection1.add("B");
        collection1.add("C");
        System.out.println(collection1);

        collection1.add("D");
        collection1.add("E");
        collection1.add("F");
        collection1.add("G");
        System.out.println(collection1);
        collection2.add("H");
        collection2.add("I");
        System.out.println(collection2);

        removeNames(collection1, collection2);
        System.out.println(collection1);
        System.out.println(collection2);}

    private static void removeNames(Collection<String> collection1, Collection<String> collection2) {
        //get Iterator.
        Iterator<String> iterator = collection1.iterator();
        //Loop while collection has items
        while(iterator.hasNext()){
        if (collection2.contains(iterator.next()))
        iterator.remove(); //remove the current Name or Item
        }
        }
}
package HashTables;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetPractice {

    public static void main(String[] args){

        //====================================================================
        //Creating HashSet
        //====================================================================

        HashSet<String> fruits=new HashSet<>();

        //====================================================================
        //Adding Elements
        //====================================================================
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Mango");
        fruits.add("Orange");
        fruits.add("Grapes");

        System.out.println("Original HashSet: ");
        System.out.println(fruits);

        //===================================================================
        //Duplicate Element
        //===================================================================
        System.out.println("\nAdding Duplicate : Apple");
        boolean duplicate=fruits.add("Apple");

        System.out.println("Added Successfully ? "+ duplicate);
        System.out.println(fruits);

        //===================================================================
        //Size
        //===================================================================
        System.out.println("\nTotal Elements: "+fruits.size());

        //===================================================================
        //Contains
        //===================================================================
        System.out.println("\nContains Mango?");
        System.out.println(fruits.contains("Mango"));

        //===================================================================
        //Remove Element
        //===================================================================
        System.out.println("\nRemoving Orange...");
        fruits.remove("Orange");

        System.out.println(fruits);

        //==================================================================
        //For-each Loop
        //==================================================================
        System.out.println("\nUsing For-each Loop");

        for(String fruit : fruits){
            System.out.println(fruit);
        }

        //=================================================================
        //Iterator
        //=================================================================
        System.out.println("\nUsing Iterator");

        Iterator<String> iterator=fruits.iterator();

        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //=================================================================
        //Convert to Array
        //=================================================================
        System.out.println("\nConvert HashSet to Array");

        String[] array=fruits.toArray(new String[0]);

        for(String item : array){
            System.out.println(item);
        }

        //================================================================
        //Another HashSet
        //================================================================
        HashSet<String> tropical=new HashSet<>();

        tropical.add("Mango");
        tropical.add("Papaya");
        tropical.add("Banana");
        tropical.add("Pineapple");

        System.out.println("\nSecond HashSet: ");
        System.out.println(tropical);

        //===============================================================
        //Union
        //===============================================================
        HashSet<String> union=new HashSet<> (fruits);

        union.addAll(tropical);

        System.out.println("\nUnion: ");
        System.out.println(union);

        //==============================================================
        //Intersection
        //==============================================================
        HashSet<String> intersection =new HashSet<> (fruits);

        intersection.retainAll(tropical);

        System.out.println("\nIntersection: ");
        System.out.println(intersection);

        //=============================================================
        //Difference
        //=============================================================
        HashSet<String> difference =new HashSet<> (fruits);

        difference.removeAll(tropical);

        System.out.println("\nDifference: ");
        System.out.println(difference);

        //=============================================================
        //isEmpty()
        //=============================================================
        System.out.println("\nIs HashSet Empty?");
        System.out.println(fruits.isEmpty());

        //=============================================================
        //Clear HashSet
        //=============================================================
        fruits.clear();

        System.out.println("\nAfter Clear: ");
        System.out.println(fruits);

        System.out.println("Is Empty: "+fruits.isEmpty());
    }
}

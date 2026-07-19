package HashTables;

import java.util.HashMap;
import java.util.Map;

public class HashMapPractice {

    public static void main(String[] args){

        //Creating a HashMap
        HashMap<Integer, String> students=new HashMap<>();

        //Adding elements
        students.put(101,"Aman");
        students.put(102,"Priya");
        students.put(103,"Rahul");
        students.put(104,"Neha");
        students.put(105,"Riya");

        System.out.println("Initial HashMap: ");
        System.out.println(students);

        //Accessing a value
        System.out.println("\nStudent with ID 103: ");
        System.out.println(students.get(103));

        //Updating a value
        students.put(103,"Rohan");
        System.out.println("\nAfter Updating ID 103: ");
        System.out.println(students);

        //Checking key
        System.out.println("\nContains Key 104?");
        System.out.println(students.containsKey(104));

        //Checking value
        System.out.println("\nContains Value 'Neha'?");
        System.out.println(students.containsValue("Neha"));

        //Removing an element
        students.remove(102);

        System.out.println("\nAfter Removing ID 102: ");
        System.out.println(students);

        //Size
        System.out.println("\nSize of HashMap: ");
        System.out.println(students.size());

        //Traversing using keySet()
        System.out.println("\nTraversing using keySet(): ");

        for(Integer key : students.keySet()){
            System.out.println(key+"->"+students.get(key));
        }

        //Traversing using entrySet()
        System.out.println("\nTraversing using entrySet(): ");

        for(Map.Entry<Integer, String> entry : students.entrySet()){
            System.out.println("Key = "+entry.getKey()+",Value = "+entry.getValue());
        }

        //Traversing values
        System.out.println("\nOnly Values: ");

        for(String value : students.values()){
            System.out.println(value);
        }

        //Checking if empty
        System.out.println("\nIs HashMap Empty?");
        System.out.println(students.isEmpty());

        //Clearing HashMap
        students.clear();

        System.out.println("\nAfter Clearing HashMap: ");
        System.out.println(students);

        System.out.println("\nIs HashMap Empty Now?");
        System.out.println(students.isEmpty());
    }
}

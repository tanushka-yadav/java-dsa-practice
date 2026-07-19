package HashTables;

import java.util.HashMap;
import java.util.Map;
public class HashTablePractice {

    public static void main(String[] args){

        //Creating a Hash Table
        HashMap<Integer,String> students=new HashMap<>();

        //Insert (Put)
        students.put(101,"Tanushka");
        students.put(102,"Rahul");
        students.put(103,"Anjali");
        students.put(104,"Rohan");

        System.out.println("Original Hash Table: ");
        System.out.println(students);

        //Access Value
        System.out.println("\nStudent with ID 102: ");
        System.out.println(students.get(102));

        //Update Value
        students.put(103,"Priya");

        System.out.println("\nAfter Updating ID 103: ");
        System.out.println(students);

        //Check Key
        System.out.println("\nContains Key 104? ");
        System.out.println(students.containsKey(104));

        //Check Value
        System.out.println("\nContains Value 'Rahul'? ");
        System.out.println(students.containsValue("Rahul"));

        //Remove Entry
        students.remove(102);

        System.out.println("\nAfter Removing ID 102: ");
        System.out.println(students);

        //Size
        System.out.println("\nTotal Students: ");
        System.out.println(students.size());

        //Traverse Hash Table
        System.out.println("\nTraversing Hash Table: ");

        for(Map.Entry<Integer, String> entry : students.entrySet()){
            System.out.println("ID = "+ entry.getKey()+ ", Name = "+entry.getValue());
        }

        //Keys Only
        System.out.println("\nKeys: ");
        for(Integer key : students.keySet()){
            System.out.println(key);
        }

        //Values Only
        System.out.println("\nValues: ");
        for(String value : students.values()){
            System.out.println(value);
        }

        //Empty Check
        System.out.println("\nIs Hash Table Empty? ");
        System.out.println(students.isEmpty());

        //Clear Hash Table
        students.clear();

        System.out.println("\nAfter Clearing: ");
        System.out.println(students);
    }
}

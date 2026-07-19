package LinkedLists;

public class LinkedListMemoryInfo {

    public static void main(String[] args){

        int myVal=13;

        //Value of integer
        System.out.println("Value of Integer 'myVal': "+myVal);

        //Size of int in Java
        System.out.println("Size of integer 'myVal': "+(Integer.SIZE/8)+" bytes");

        //Java does not allow direct access to memory addresses
        Integer obj=myVal;
        System.out.println("Reference (Hash Code) of 'myVal': "+ Integer.toHexString(System.identityHashCode(obj)));

        //Reference size cannot be obtained directly
        System.out.println("Size of reference: JVM dependent (typically 4 or 8 bytes)");
    }
}

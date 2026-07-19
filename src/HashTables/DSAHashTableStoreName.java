package HashTables;

public class DSAHashTableStoreName {
    public static void main(String[] args){
        String value="Bob";
        System.out.println(" ' "+value+" ' has has code: "+hasFunction(value));
    }

    public static int hasFunction(String value){
        int sum=0;
        for(int i=0; i<value.length(); i++){
            sum+=value.charAt(i);
        }
        return sum%10;
    }
}

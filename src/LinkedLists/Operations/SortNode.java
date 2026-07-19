package LinkedLists.Operations;

/*class SortNodeData{
    int data;
    SortNodeData next;

    SortNodeData(int data){
        this.data=data;
        this.next=null;
    }
}

class LinkedList{
    SortNodeData head;

    //Insert node at the end
    void insert(int data){
        SortNodeData newNode=new SortNodeData(data);

        if(head==null)
        {
            head=newNode;
            return;
        }

        SortNodeData temp=head;
        while(temp.next!=null){
            temp=temp.next;
        }

        temp.next=newNode;
    }

    //Sort the linked list
    void sortList(){
        if(head==null || head.next==null){
            return;
        }

        SortNodeData current=head;

        while(current!=null){
            SortNodeData index=current.next;

            while(index!=null){
                if(current.data>index.data){
                    int temp=current.data;
                    current.data=index.data;
                    index.data=temp;
                }
                index=index.next;
            }
            current=current.next;
        }
    }

    //Display the linked list
    void display(){
        SortNodeData temp=head;

        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }

        System.out.println("null");
    }
}*/

//descending
class ListElement{
    int data;
    ListElement next;

    ListElement(int data){
        this.data=data;
        this.next=null;
    }
}

class SortLinkedList{

    ListElement head;

    //Insert node at the end
    void insert (int data){

        ListElement newElement=new ListElement(data);
        if(head==null){
            head=newElement;
            return;
        }

        ListElement temp=head;

        while(temp.next!=null){
            temp=temp.next;
        }
        temp.next=newElement;
    }

    //Sort in Descending Order
    void sortDescending(){

        if(head==null || head.next==null){
            return;
        }

        ListElement current=head;

        while(current != null){
            ListElement index=current.next;

            while(index != null){
                if(current.data<index.data){

                    int temp=current.data;
                    current.data=index.data;
                    index.data=temp;
                }

                index=index.next;
            }

            current=current.next;
        }
    }

    //Display Linked List
    void display(){
        ListElement temp=head;

        while(temp!=null){
            System.out.print(temp.data+" -> ");
            temp=temp.next;
        }

        System.out.println("null");
    }
}

public class SortNode {
    public static void main(String[] args){

        /*LinkedList list=new LinkedList();

        list.insert(40);
        list.insert(10);
        list.insert(30);
        list.insert(20);
        list.insert(50);

        System.out.println("Original Linked List: ");
        list.display();

        list.sortList();

        System.out.println("Sorted Linked List: ");
        list.display();*/

        SortLinkedList list=new SortLinkedList();

        list.insert(15);
        list.insert(40);
        list.insert(10);
        list.insert(35);
        list.insert(20);

        System.out.println("Original Linked List: ");
        list.display();

        list.sortDescending();

        System.out.println("\nSorted Linked List (Descending): ");
        list.display();
    }

}

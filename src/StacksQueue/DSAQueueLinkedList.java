package StacksQueue;

public class DSAQueueLinkedList {
    public static void main(String[] args)
    {
        QueueLinkedList myQueue=new QueueLinkedList();

        myQueue.enqueue('A');
        myQueue.enqueue('B');
        myQueue.enqueue('C');
        System.out.print("Queue: ");
        myQueue.printQueue();

        System.out.println("Dequeue: "+myQueue.dequeue());
        System.out.println("Peek: "+myQueue.peek());
        System.out.println("isEmpty: "+myQueue.isEmpty());
        System.out.println("Size: "+myQueue.size());
    }
}

class NodeLinkedList{
    char data;
    NodeLinkedList next;

    public NodeLinkedList(char data){
        this.data=data;
        this.next=null;
    }
}

class QueueLinkedList{
    NodeLinkedList front;
    NodeLinkedList rear;
    int length;

    public QueueLinkedList(){
        this.front=null;
        this.rear=null;
        this.length=0;
    }

    public void enqueue(char element){
        NodeLinkedList newNode=new NodeLinkedList(element);
        if(this.rear==null)
        {
            this.front=this.rear=newNode;
            length++;
            return;
        }
        this.rear.next=newNode;
        this.rear=newNode;
        length++;
    }

    public char dequeue(){
        if(isEmpty()){
            System.out.println("Queue is Empty");
            return ' ';
        }
        NodeLinkedList temp=this.front;
        this.front=temp.next;
        if(this.front==null){
            this.rear=null;
        }
        length--;
        return temp.data;
    }

    public char peek(){
        if(isEmpty()){
            System.out.println("Queue is empty");
            return ' ';
        }
        return this.front.data;
    }

    public boolean isEmpty(){
        return length==0;
    }

    public int size(){
        return length;
    }

    public void printQueue(){
        NodeLinkedList temp=this.front;
        while(temp!=null){
            System.out.print(temp.data+ " ");
            temp=temp.next;
        }
        System.out.println();
    }
}

package LinkedLists;

import javax.swing.*;
import java.awt.*;

public class LinkedListTheoryGUI extends JFrame{

    JTextArea area;

    public LinkedListTheoryGUI(){

        setTitle("DSA Linked List Theory");
        setSize(900,700);
        setLocationRelativeTo(null);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        area=new JTextArea();
        area.setEditable(false);
        area.setFont(new Font("Monospaced", Font.PLAIN, 16));

        area.setText(
                "====================================================================================================\n"+
                        "             DATA STRUCTURES AND ALGORITHMS\n" +
                        "                 LINKED LIST THEORY\n" +
                        "=============================================================================================\n\n"+

                        "1. WHAT IS A LINKED LIST?\n"+
                        "---------------------------------------------------------------------------------------------\n" +
                        "A Linked List is a linear data structure where nodes are\n"+
                        "connected together using links (references).\n\n"+

                        "Each node contains:\n"+
                        "-> Data\n"+
                        "-> Reference (Pointer) to the next node\n\n"+

                        "The nodes are connected like this:\n\n"+

                        "[Data|Next] -------> [Data|Next] -------> [Data|Next] -------> NULL\n\n"+

                        "NULL indicates the end of the Linked List.\n\n"+

                        "---------------------------------------------------------------------------------------------\n"+
                        "2. STRUCTURE OF A NODE\n"+
                        "---------------------------------------------------------------------------------------------\n"+

                        "Every node contains two parts:\n\n"+

                        "  +---------------+\n"+
                        "  |     DATA      |\n"+
                        "  +---------------+\n"+
                        "  |     NEXT      |\n"+
                        "  +---------------+\n\n"+


                        "DATA : Stores the value.\n"+
                        "NEXT : Stores the address/reference of the next node.\n\n"+

                        "---------------------------------------------------------------------------------------------\n"+
                        "3. HOW LINKED LIST WORKS\n"+
                        "---------------------------------------------------------------------------------------------\n"+
                        "Suppose we store numbers:\n\n"+

                        "10 --> 20 --> 30 --> 40 --> NULL\n\n"+

                        "Node Representation:\n\n"+

                        "[10|*] -------> [20|*] ------- [30|*] -------> [40|NULL]\n\n"+

                        "Each node knows where the next node is located in memory.\n\n"+

                        "---------------------------------------------------------------------------------------------\n"+
                        "4. WHY LINKED LIST?\n"+
                        "---------------------------------------------------------------------------------------------\n"+
                        "Unlike arrays, Linked List nodes are NOT Stored\n" + "contiguously in memory.\n\n"+

                        "They can be stored anywhere there is free memory.\n\n"+

                        "Advantages:\n"+
                        "-> Dynamic Size\n"+
                        "-> Easy insertion\n"+
                        "-> Easy deletion\n"+
                        "-> No shifting of elements\n\n"+

                        "---------------------------------------------------------------------------------------------\n"+
                        "5. LINKED LIST VS ARRAY\n"+
                        "---------------------------------------------------------------------------------------------\n"+
                        "Feature                                                  Arrays          Linked List\n"+
                        "---------------------------------------------------------------------------------------------\n"+
                        "Existing Data Structure                                   Yes                No\n"+
                        "Fixed Size                                                Yes                No\n"+
                        "Stored Continuously                                       Yes                No\n"+
                        "Extra Memory Required                                     Yes                No\n"+
                        "Random Access                                             Yes                No\n"+
                        "Insertion Fast                                            Yes                No\n"+
                        "Deletion Fast                                             Yes                No\n"+

                        "Explanation:\n\n"+

                        "ARRAY\n"+
                        "-----\n"+
                        "-> Fixed size.\n"+
                        "-> Elements are stored continuously.\n"+
                        "-> Direct access using index.\n"+
                        "-> Insertion and deletion require shifting.\n\n"+

                        "LINKED LIST\n"+
                        "-----------\n"+
                        "-> Dynamic size.\n"+
                        "-> Nodes are stored anywhere in memory.\n"+
                        "-> Each node stores a link to next node.\n"+
                        "-> Easy insertion and deletion.\n"+
                        "-> Random access is not possible.\n\n"+

                        "---------------------------------------------------------------------------------------------\n"+
                        "6. MEMORY REPRESENTATION\n"+
                        "---------------------------------------------------------------------------------------------\n"+
                        "Array Memory:\n\n"+

                        "100  104 108 112\n"+
                        "+---+---+---+---+\n"+
                        "|10 |20 |30 |40 |\n"+
                        "+---+---+---+---+\n\n"+

                        "Linked List Memory:\n\n"+

                        "Address  Data  Next\n"+
                        "500       10   900\n"+
                        "900       20   300\n"+
                        "300       30   700\n"+
                        "700       40   NULL\n\n"+

                        "Nodes are scattered in memory.\n\n"+

                        "---------------------------------------------------------------------------------------------\n"+
                        "7. ADVANTAGES OF LINKED LIST\n"+
                        "---------------------------------------------------------------------------------------------\n"+
                        "1. Dynamic size.\n"+
                        "2. Efficient insertion.\n"+
                        "3. Efficient deletion.\n"+
                        "4. Memory allocated only when required.\n"+
                        "5. No memory wastage due to fixed size.\n\n"+

                        "---------------------------------------------------------------------------------------------\n"+
                        "8. DISADVANTAGES OF LINKED LIST\n"+
                        "---------------------------------------------------------------------------------------------\n"+
                        "1. Extra memory required for pointer.\n"+
                        "2. Random access not possible.\n"+
                        "3. Traversal is slower than arrays.\n"+
                        "4. More complex implementation.\n\n"+

                        "---------------------------------------------------------------------------------------------\n"+
                        "9. REAL LIFE EXAMPLES\n"+
                        "---------------------------------------------------------------------------------------------\n"+
                        "-> Music Playlist\n"+
                        "-> Browser History\n"+
                        "-> Undo and Redo\n"+
                        "-> Image Viewer\n"+
                        "-> Train Compartments\n"+
                        "-> Navigation System\n\n"+

                        "---------------------------------------------------------------------------------------------\n"+

                        "10. CONCLUSION\n"+
                        "---------------------------------------------------------------------------------------------\n"+
                        "A Linked List is a dynamic linear data structure made of\n"+
                        "nodes. Every node contains data and the reference of the\n"+
                        "next node. It provides efficient insertion and deletion,\n"+
                        "while arrays provide faster random access.\n\n"+

                        "=============================================================================================\n"+
                        "                                   END OF LINKED LIST THEORY\n"+
                        "=============================================================================================\n"
        );

        JScrollPane scrollPane=new JScrollPane(area);

        add(scrollPane);

        setVisible(true);


    }

    public static void main(String[] args){

        SwingUtilities.invokeLater(() -> new LinkedListTheoryGUI());
    }
}

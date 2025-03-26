/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package test;

import com.umg.data.structures.DoublyLinkedList;
import com.umg.data.structures.LinkedList;
import com.umg.data.structures.Queue;
import com.umg.data.structures.Stack;
import com.umg.nodes.Node;
import com.umg.nodes.NodeD;

/**
 *
 * @author mrph0
 */
public class Test {
    public static void main(String[] args) {
        //testLinkedList();
        testDoublyLinkedList();
        //testStack();
        //testQueue();
    }
    
    public static void testLinkedList() {
        LinkedList list = new LinkedList();
        list.append(new Node(10));
        list.append(new Node(45));
        list.insert(2, 78);
        list.removeByIndex(1);
        
        list.printList();
        
    }
    
    public static void testDoublyLinkedList(){
        DoublyLinkedList doublyList = new DoublyLinkedList();
        doublyList.append(new NodeD(10));
        doublyList.append(new NodeD(20));
        doublyList.append(new NodeD(40));
        doublyList.append(new NodeD(50));
        doublyList.append(new NodeD(60));
        doublyList.removeByValue(40);
        
        doublyList.printList();
    }
    
    public static void testStack(){
        Stack stack = new Stack();
        stack.push(new Node(1));
        stack.push(new Node(2));
        stack.push(new Node(3));
        stack.printStack();
        
    }
    
    public static void testQueue(){
        Queue queue = new Queue();
        queue.enqueue(new Node(1));
        queue.enqueue(new Node(2));
        queue.enqueue(new Node(3));
        queue.printQueue();
    }
}

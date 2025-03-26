package com.umg.data.structures;

import com.umg.nodes.Node;

/**
 *
 * @author mrph0
 */
public class Stack {
    //LIFO -> Last In, First Out
    private Node top;
    private int height;
    
    public void printStack(){
        Node temp = top;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getHeight() {
        return height;
    }
    
    public boolean isEmpty() {
        return top == null;
    }
    
    public void push(Node newNode) {
        if(isEmpty()){
            top = newNode;
        } else {
            newNode.next = top;
            top = newNode;
        }
        height++;
    }
    
    public Node pop(Node newNode) {
        if(isEmpty()){
            return null;
        } 
        
        Node temp = top;
        top = top.next;
        temp.next = null;
        height--;
        return temp;
    }
    
    public void peek(){
        if (isEmpty()) {
            return;
        }
        System.out.println("Peek: "+ top.value);
    }
}

package com.umg.data.structures;

import com.umg.nodes.Node;

/**
 *
 * @author mrph0
 */
public class LinkedList {

    private Node head;
    private int length;

    public void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

    public int getLength() {
        return length;
    }

    public boolean isEmpty() {
        return length == 0;
    }

    public void append(Node newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
        length++;
    }

    public void prepend(Node newNode) {
        if (isEmpty()) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
        length++;
    }

    public Node search(int value) {
        if (isEmpty()) {
            return null;
        }
        Node temp = head;
        while (temp != null) {
            if (temp.value == value) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }

    public Node get(int index) {
        if (index < 0 || index >= length || isEmpty()) {
            return null;
        }

        Node temp = head;
        for (int i = 0; i < index; i++) {
            temp = temp.next;
        }

        return temp;
    }

    public boolean update(int index, int newValue) {
        Node temp = get(index);
        if (temp == null) {
            return false;
        }
        temp.value = newValue;
        return true;
    }

    public boolean removeFirst() {
        if (isEmpty()) {
            return false;
        }

        Node temp = head;
        head = head.next;
        temp.next = null;
        length--;
        return true;
    }

    public boolean removeByValue(int value) {
        if (isEmpty()) {
            return false;
        }

        if (head.value == value) {
            return removeFirst();
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.value == value) {
                Node deleted = temp.next;
                temp.next = temp.next.next;
                deleted.next = null;
                length--;
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    public Node insert(int index, int data) {
        Node newNode = new Node(data);

        if (isEmpty()) {
            return null;
        }

        Node temp = head;
        int count = 0;

        while (temp != null && count < index - 1) {
            temp = temp.next;
            count++;
        }

        if (temp == null) {
            return null;
        }
        newNode.next = temp.next;
        temp.next = newNode;
        return null;
    }

    public boolean removeByIndex(int index) {
        if (isEmpty()) {
            return false;
        }
        
        if (index == 0) {
            head = head.next;
            return removeFirst();
        }
        
        Node temp = head;
        Node prev = null;
        int currentIndex = 0;
        
        while (temp != null && currentIndex < index) {
            prev = temp;
            temp = temp.next;
            currentIndex++;
        }
        
        if (temp != null) {
            prev.next = temp.next;
        }
        return false;
    }
}

package com.umg.data.structures;

import com.umg.nodes.NodeD;

/**
 *
 * @author mrph0
 */
public class DoublyLinkedList {

    private NodeD head;
    private NodeD tail;
    private int length;

    public void printList() {
        NodeD temp = head;
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

    public void append(NodeD newNode) {
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        length++;
    }

    public void prepend(NodeD newNode) {
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        length++;
    }

    public void emptyList() {
        head = null;
        tail = null;
    }

    public boolean removeFirst() {
        if (isEmpty()) {
            return false;
        }

        if (length == 1) {
            emptyList();
            return true;
        }

        NodeD temp = head;
        head = head.next;
        head.prev = null;
        temp.next = null;
        length--;
        return true;
    }

    public boolean removeLast() {
        if (isEmpty()) {
            return false;
        }

        if (length == 1) {
            emptyList();
            return true;
        }

        NodeD temp = tail;
        tail = tail.prev;
        tail.next = null;
        temp.prev = null;
        length--;
        return true;
    }

    public NodeD get(int index) {
        if (index < 0 || index >= length || isEmpty()) {
            return null;
        }

        if (index < length / 2) {
            NodeD temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        } else {
            NodeD temp = tail;
            for (int i = length - 1; i > index; i--) {
                temp = temp.prev;
            }
            return temp;
        }
    }

    public boolean update(int index, int newValue) {
        NodeD temp = get(index);
        if (temp == null) {
            return false;
        }
        temp.value = newValue;
        return true;
    }

    public boolean removeByIndex(int index) {

        if (index < 0 || index >= length || isEmpty()) {
            return false;
        }

        if (index == 0) {
            return removeFirst();
        }

        if (index == length - 1) {
            return removeLast();
        }

        NodeD temp = get(index);

        temp.prev.next = temp.next; //before
        temp.next.prev = temp.prev; //after
        temp.next = null;
        temp.prev = null;
        length--;
        return true;
    }

    public boolean removeByValue(int value) {
        NodeD temp = head;

        while (temp != null) {
            if (temp.value == value) {
                if (temp.prev != null) {
                    temp.prev.next = temp.next;
                } else {
                    head = temp.next;
                }
                
                if (temp.next != null) {
                    temp.next.prev = temp.prev;
                } else {
                    tail = temp.prev;
                }
                
                return true;
            }
            temp = temp.next;
        }
        
        return false;
    }
}

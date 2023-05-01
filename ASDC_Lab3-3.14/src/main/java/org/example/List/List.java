package org.example.List;

import org.example.Student;


public class List implements LinkedList{
    private Node head;
    private int size;
    @Override
    public void addToTail(Student student) {
        Node newNode = new Node(student);
        if(head == null){
            head = newNode;
        }else{
            Node current = head;
            while (current.next != null){
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    @Override
    public void addToHead(Student student) {
        Node newNode = new Node(student);
        newNode = head;
        head = newNode;
        size++;
    }

    @Override
    public void add(Student student, int index) {
        if(index<0 || index > size){
            return;
        }
        Node current = head;
        Node previous =current;
        int i = 0;
        while(i < index){
            previous = current;
            current = current.next;
            i++;
        }
        Node node = new Node(student);
        previous.next = node;
        node.next = current;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >size){
            return false;
        }
        Node current = head;
        Node previous =current;
        int i = 0;
        while(i < index){
            previous = current;
            current = current.next;
            i++;
        }
        previous.next = current.next;
        size --;
        return true;
    }

    @Override
    public boolean remove(Student student) {
        if(head == null){
            return false;
        }
        Node current = head;
        Node previous = current;
        while(current != null){
            if(current.value.getIdnp() == student.getIdnp()){
                previous.next = current.next;
                size--;
                return true;
            }
            previous = current;
            current = current.next;
        }
        return false;
    }

    @Override
    public void print() {
        if(head == null){
            return;
        }
        Node current = head;
        while (current != null){
            System.out.println(current.value);
            current = current.next;
        }
    }

    @Override
    public boolean contains(Student student) {
        if (head == null){
            return false;
        }
        Node current = head;
        while (current != null){
            if(current.value.equals(student)){
                return true;
            }
            current = current.next;
        }
        return false;
    }

    public int getSize() {
        return size;
    }
}

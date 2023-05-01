package org.example.List;

import org.example.Student;

public interface LinkedList {
    void addToTail(Student student);
    void addToHead(Student student);
    void add(Student student,int index);
    boolean isEmpty();
    boolean remove(int index);
    boolean remove(Student student);
    void print();
    boolean contains(Student student);
}

package org.example.List;

import org.example.Student;

public class Node {
    Student value;
    Node next;

    public Node(Student value) {
        this.value = value;
        next = null;
    }
}

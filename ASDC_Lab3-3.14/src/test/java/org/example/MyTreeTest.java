package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

class MyTreeTest {
    MyTree tree;
    @BeforeEach
    public void init(){
        tree = new MyTree();
        File file = new File("src/MOCK_DATA.csv");
        ArrayList<Student> list = Student.readingFromFile(file);
        for(Student student : list){
            tree.add(student);
        }
    }

    @Test
    public void addingOfNewNodeIncreaseSize(){
        int before = tree.getSize();
        Student student = new Student("Filbert,Cragoe,Informatics,1995,2023,51");
        tree.add(student);
        int after = tree.getSize();
        assertEquals(before + 1,after);
    }
    @Test
    public void removingUnExistingNodeShouldReturnFalse(){
        Student student = new Student("Filbert,Cragoe,Informatics,1995,2023,51");
        boolean removed = tree.remove(student);
        assertEquals(removed,false);
    }
    @Test
    public void searchingMethodReturnsTrueIfElementIsPresentInTree(){
        Student student = new Student("Filbert,Cragoe,Informatics,1995,2023,51");
        tree.add(student);
        boolean isPresent = tree.exists(student);
        assertEquals(isPresent,true);
    }
}
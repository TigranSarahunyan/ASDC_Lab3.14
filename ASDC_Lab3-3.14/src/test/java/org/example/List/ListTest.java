package org.example.List;

import org.example.Student;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class ListTest {
    List list;
    @BeforeEach
    public void init(){
        list = new List();
        File file = new File("src/MOCK_DATA.csv");
        ArrayList<Student> list1 = Student.readingFromFile(file);
        for(Student student : list1){
            list.addToTail(student);
        }
    }

    @Test
    public void addingElementToListToTailIncreaseSize(){
        Student student1 = new Student();
        int before = list.getSize();
        list.addToTail(student1);
        assertEquals(before + 1, list.getSize());
    }

    @Test
    public void addingElementToListToHeadIncreaseSize(){
        Student student1 = new Student();
        int before = list.getSize();
        list.addToHead(student1);
        assertEquals(before + 1, list.getSize());
    }
    @Test
    public void addingElementToListTByIndexIncreaseSize(){
        Student student1 = new Student();
        int before = list.getSize();
        list.add(student1,1);
        assertEquals(before + 1, list.getSize());
    }
    @Test
    public void ifElementExistContainReturnsTrue(){
        Student student1 = new Student();
        list.addToTail(student1);
        boolean exists = list.contains(student1);
        assertEquals(exists,true);
    }
    @Test
    public void removingElementByValueOfNodeDecreasesSize(){
        Student student1 = new Student();
        list.addToTail(student1);
        int before = list.getSize();
        list.remove(student1);
        assertEquals(before - 1, list.getSize());
    }
    @Test
    public void removingElementByIndexOfNodeDecreasesSize(){
        int before = list.getSize();
        list.remove(1);
        assertEquals(before - 1, list.getSize());
    }
}
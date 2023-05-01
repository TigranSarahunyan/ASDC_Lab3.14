package org.example;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;

public class Student {
    private String firstName;
    private String lastName;
    private String faculty;
    private int yearOfBirthday;
    private int yearOfApplying;
    private int idnp;

    ///Базовый конструктор
    public Student() {
    }

    public Student(String firstName, String lastName, String faculty, int yearOfBirthday, int yearOfApplying, int idnp) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.faculty = faculty;
        this.yearOfBirthday = yearOfBirthday;
        this.yearOfApplying = yearOfApplying;
        this.idnp = idnp;
    }

    ///Конструктор копирования
    public Student(Student student){
        this.firstName = student.firstName;
        this.lastName = student.lastName;
        this.faculty = student.faculty;
        this.yearOfBirthday = student.yearOfBirthday;
        this.yearOfApplying = student.yearOfApplying;
        this.idnp = student.idnp;
    }



    ///Метод сравнения
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return yearOfBirthday == student.yearOfBirthday && yearOfApplying == student.yearOfApplying && idnp == student.idnp && Objects.equals(firstName, student.firstName) && Objects.equals(lastName, student.lastName) && Objects.equals(faculty, student.faculty);
    }

    ///Метод копирования
    public Student copy(Student student){
        return new Student(student);
    }

    ///Метод чтения из файла
    public static ArrayList<Student> readingFromFile(File file){
        ArrayList<Student> list = new ArrayList<>();
        try(BufferedReader reader = new BufferedReader(new FileReader(file))){
            String string;
            while ((string = reader.readLine() )!= null){
                list.add(new Student(string)) ;
            }

        }catch (IOException e){
            e.printStackTrace();
        }
        return list;
    }

    ///Конструктор объекта со строки
    Student(String string){
        String[] array = string.split(",");
        firstName = array[0];
        lastName = array[1];
        faculty = array[2];
        yearOfBirthday = Integer.parseInt(array[3]);
        yearOfApplying = Integer.parseInt(array[4]);
        idnp = Integer.parseInt(array[5]);
    }

    ///Метод записи в файл
    public static void writingToFile(File file, ArrayList<Student> list){
        try(FileWriter writer = new FileWriter(file)){
            for(Student student:list){
                String str = student.firstName + "," + student.lastName + "," +
                        student.faculty + "," + student.yearOfBirthday + "," +
                        student.yearOfApplying + "," + student.idnp;
                writer.write(str+"\n");
            }
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    @Override
    public String toString() {
        return "Student{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", faculty='" + faculty + '\'' +
                ", yearOfBirthday=" + yearOfBirthday +
                ", yearOfApplying=" + yearOfApplying +
                ", idnp=" + idnp +
                '}';
    }

    public int getIdnp() {
        return idnp;
    }
}

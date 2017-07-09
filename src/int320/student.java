/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int320;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 *
 * @author mosza16
 */
public class student {
    int id;
    String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public student(int id, String name) {
        this.id = id;
        this.name = name;
    }
    public static void main(String[] args) {
        List<student> s = new ArrayList<>();
      
        s.add(new student(002, "mos2"));
        s.add(new student(001, "mos1"));
        s.add(new student(003, "mos3"));
        //Collections.sort(s, new sortByStudentId());
        
        s.sort(new sortByStudentName());
        System.out.println(s);
    }

    @Override
    public String toString() {
        return "student{" + "id=" + id + ", name=" + name + '}';
    }
    
}

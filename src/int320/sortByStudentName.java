/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package int320;

import java.util.Comparator;

/**
 *
 * @author mosza16
 */
public class sortByStudentName implements Comparator<student>{

    @Override
    public int compare(student o1, student o2) {
        return o1.name.compareTo(o2.name);
    }
    
}

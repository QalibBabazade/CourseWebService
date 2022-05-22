/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.com.webservice.dao;

import az.com.webservice.model.Student;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public interface StudentDao {

    List<Student> getStudentList() throws Exception;

    void addStudent(Student student) throws Exception;

    void updateStudent(Student student) throws Exception;

    void deleteStudent(Long studentId) throws Exception;

    List<Student> searchStudent(String keyword) throws Exception;

    Student getStudentById(Long studentId) throws Exception;
}

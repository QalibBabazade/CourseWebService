/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.com.webservice.dao;

import az.com.webservice.model.Teacher;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public interface TeacherDao {

    List<Teacher> getTeacherList() throws Exception;

    void addTeacher(Teacher teacher) throws Exception;

    void updateTeacher(Teacher teacher) throws Exception;

    void deleteTeacher(Long teacherId) throws Exception;

    List<Teacher> searchTeacher(String keyword) throws Exception;

    Teacher getTeacherById(Long teacherId) throws Exception;

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.com.webservice.service;

import az.com.webservice.request.RequeStudent;
import az.com.webservice.responce.RespStatus;
import az.com.webservice.responce.RespStatusList;
import az.com.webservice.responce.RespStudent;
import az.com.webservice.responce.RespStudentList;

/**
 *
 * @author qalib.babazade
 */
public interface StudentService {

    RespStudentList getStudentList();

    RespStatusList addStudent(RequeStudent requeStudent);

    RespStudent getStudentById(Long studentId);

    RespStatusList updateStudent(RequeStudent requeStudent);

    RespStatusList deleteStudent(Long studentId);

}

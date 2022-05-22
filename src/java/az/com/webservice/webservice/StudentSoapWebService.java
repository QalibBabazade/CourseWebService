/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.com.webservice.webservice;

import az.com.webservice.dao.StudentDao;
import az.com.webservice.dao.impl.StudentDaoImpl;
import az.com.webservice.request.RequeStudent;
import az.com.webservice.responce.RespStatusList;
import az.com.webservice.responce.RespStudent;
import az.com.webservice.responce.RespStudentList;
import az.com.webservice.service.StudentService;
import az.com.webservice.service.impl.StudentServiceImpl;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author qalib.babazade
 */
@WebService(serviceName = "StudentSoapWebService")
public class StudentSoapWebService {

    StudentDao studentDao = new StudentDaoImpl();
    StudentService studentService = new StudentServiceImpl(studentDao);

    @WebMethod(operationName = "getStudentList")
    public RespStudentList getStudentList() {
        return studentService.getStudentList();
    }

    @WebMethod(operationName = "getStudentById")
    public RespStudent getStudentById(@WebParam(name = "studentId") Long studentId) {
        return studentService.getStudentById(studentId);
    }

    @WebMethod(operationName = "addStudent")
    public RespStatusList addStudent(RequeStudent requeStudent) {
        return studentService.addStudent(requeStudent);
    }

    @WebMethod(operationName = "updateStudent")
    public RespStatusList updateStudent(RequeStudent requeStudent) {
        return studentService.updateStudent(requeStudent);
    }

    @WebMethod(operationName = "deleteStudent")
    public RespStatusList deleteStudent(@WebParam(name = "studentId") Long studentId) {
        return studentService.deleteStudent(studentId);
    }

}

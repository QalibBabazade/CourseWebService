/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.com.webservice.webservice;

import az.com.webservice.dao.TeacherDao;
import az.com.webservice.dao.impl.TeacherDaoImpl;
import az.com.webservice.request.RequeTeacher;
import az.com.webservice.responce.RespStatusList;
import az.com.webservice.responce.RespTeacher;
import az.com.webservice.responce.RespTeacherList;
import az.com.webservice.service.TeacherService;
import az.com.webservice.service.impl.TeacherServiceimpl;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author qalib.babazade
 */
@WebService(serviceName = "TeacherSoapWebService")
public class TeacherSoapWebService {

    TeacherDao teacherDao = new TeacherDaoImpl();
    TeacherService teacherService = new TeacherServiceimpl(teacherDao);

    @WebMethod(operationName = "getTeacherList")
    public RespTeacherList getTeacherList() {
        return teacherService.getTeacherList();
    }

    @WebMethod(operationName = "getTeacherById")
    public RespTeacher getTeacherById(@WebParam(name = "teacherId") Long teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    @WebMethod(operationName = "addTeacher")
    public RespStatusList addTeacher(RequeTeacher requeTeacher) {
        return teacherService.addTeacher(requeTeacher);
    }

    @WebMethod(operationName = "updateTeacher")
    public RespStatusList updateTeacher(RequeTeacher requeTeacher) {
        return teacherService.updateTeacher(requeTeacher);
    }

    @WebMethod(operationName = "deleteTeacher")
    public RespStatusList deleteTeacher(@WebParam(name = "teacherId") Long teacherId) {
        return teacherService.deleteTeacher(teacherId);
    }
}

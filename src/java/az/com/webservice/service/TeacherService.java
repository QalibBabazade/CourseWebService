/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.com.webservice.service;

import az.com.webservice.request.RequeTeacher;
import az.com.webservice.responce.RespStatusList;
import az.com.webservice.responce.RespTeacher;
import az.com.webservice.responce.RespTeacherList;

/**
 *
 * @author qalib.babazade
 */
public interface TeacherService {

    RespTeacherList getTeacherList();

    RespTeacher getTeacherById(Long teacherId);

    RespStatusList addTeacher(RequeTeacher requeTeacher);

    RespStatusList updateTeacher(RequeTeacher requeTeacher);

    RespStatusList deleteTeacher(Long teacherId);
}

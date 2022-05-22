/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.com.webservice.service.impl;

import az.com.webservice.dao.TeacherDao;
import az.com.webservice.exception.ExceptionConstants;
import az.com.webservice.exception.WebServiceException;
import az.com.webservice.model.Teacher;
import az.com.webservice.request.RequeTeacher;
import az.com.webservice.responce.RespStatus;
import az.com.webservice.responce.RespStatusList;
import az.com.webservice.responce.RespTeacher;
import az.com.webservice.responce.RespTeacherList;
import az.com.webservice.service.TeacherService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 *
 * @author qalib.babazade
 */
public class TeacherServiceimpl implements TeacherService {
    
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    private TeacherDao teacherDao;

    public TeacherServiceimpl(TeacherDao teacherDao) {
       this.teacherDao = teacherDao;
    }

    @Override
    public RespTeacherList getTeacherList() {
        RespTeacherList responce = new RespTeacherList();
        List<RespTeacher> respTeacherList = new ArrayList<>();
        try {
            
            List<Teacher> teacherList = teacherDao.getTeacherList();
            if(teacherList.isEmpty()){
                throw new WebServiceException(ExceptionConstants.TEACHER_NOT_FOUND,"Teacher not found");
            }
            for(Teacher teacher : teacherList){
               RespTeacher respTeacher = new RespTeacher();
               respTeacher.setTeacherId(teacher.getId());
               respTeacher.setName(teacher.getName());
               respTeacher.setSurname(teacher.getSurname());
               if(teacher.getDob() != null){
                  respTeacher.setDob(df.format(teacher.getDob())); 
               }
               respTeacher.setAddress(teacher.getAddress());
               respTeacher.setPhone(teacher.getPhone());
               respTeacher.setWorkExperience(teacher.getWorkExperience());
               respTeacherList.add(respTeacher);
               
            }
            responce.setRespTeacher(respTeacherList);
            responce.setStatus(RespStatus.getSuccessMessage());
  
        }catch(WebServiceException ex){
            ex.printStackTrace();
            responce.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
        }
         catch (Exception ex) {
            ex.printStackTrace();
            throw  new WebServiceException(ExceptionConstants.INTERNAL_EXCEPTION,"Internal Exception");
        }
         return responce;
    }

    @Override
    public RespTeacher getTeacherById(Long teacherId) {
        RespTeacher responce = new RespTeacher();
        try{
            if(teacherId == null){
                throw new WebServiceException(ExceptionConstants.INVALID_REQUEST_DATA,"Invalid request data");
            }
         Teacher teacher = teacherDao.getTeacherById(teacherId);
         if(teacher == null){
             throw new WebServiceException(ExceptionConstants.TEACHER_NOT_FOUND,"Teacher Not Found!");
         }
               responce.setTeacherId(teacher.getId());
               responce.setName(teacher.getName());
               responce.setSurname(teacher.getSurname());
               if(teacher.getDob() != null){
                  responce.setDob(df.format(teacher.getDob())); 
               }
               
               responce.setAddress(teacher.getAddress());
               responce.setPhone(teacher.getPhone());
               responce.setWorkExperience(teacher.getWorkExperience());
               responce.setStatus(RespStatus.getSuccessMessage());
            
        }catch(WebServiceException ex){
            ex.printStackTrace();
            responce.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
        }
         catch (Exception ex) {
            ex.printStackTrace();
            throw  new WebServiceException(ExceptionConstants.INTERNAL_EXCEPTION,"Internal Exception");
        }
        return responce;
    }

    @Override
    public RespStatusList addTeacher(RequeTeacher requeTeacher) {
        RespStatusList responce = new RespStatusList();
        try{
            String name = requeTeacher.getName();
            String surname = requeTeacher.getSurname();
            Date dob = requeTeacher.getDob();
            String address = requeTeacher.getAddress();
            String phone = requeTeacher.getPhone();
            Integer workExperience = requeTeacher.getWorkExperience();
            if(name == null || surname == null){
                throw new WebServiceException(ExceptionConstants.INVALID_REQUEST_DATA,"Invalid request data");
            }
            Teacher teacher = new Teacher();
            teacher.setName(name);
            teacher.setSurname(surname);
            teacher.setDob(dob);
            teacher.setAddress(address);
            teacher.setPhone(phone);
            teacher.setWorkExperience(workExperience);
            teacherDao.addTeacher(teacher);
            responce.setStatus(RespStatus.getSuccessMessage());
            
        }catch(WebServiceException ex){
            ex.printStackTrace();
            responce.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
        }
         catch (Exception ex) {
            ex.printStackTrace();
            throw  new WebServiceException(ExceptionConstants.INTERNAL_EXCEPTION,"Internal Exception");
        }
        return responce;
    }

    @Override
    public RespStatusList updateTeacher(RequeTeacher requeTeacher) {
          RespStatusList responce = new RespStatusList();
        try{
            Long teacherId = requeTeacher.getTeacherId();
            String name = requeTeacher.getName();
            String surname = requeTeacher.getSurname();
            Date dob = requeTeacher.getDob();
            String address = requeTeacher.getAddress();
            String phone = requeTeacher.getPhone();
            Integer workExperience = requeTeacher.getWorkExperience();
            if(teacherId == null || name == null || surname == null){
                throw new WebServiceException(ExceptionConstants.INVALID_REQUEST_DATA,"Invalid request data");
            }
            Teacher teacher = teacherDao.getTeacherById(teacherId);
            if(teacher == null){
                throw new WebServiceException(ExceptionConstants.TEACHER_NOT_FOUND,"Teacher not found");
            }
            teacher.setName(name);
            teacher.setSurname(surname);
            teacher.setDob(dob);
            teacher.setAddress(address);
            teacher.setPhone(phone);
            teacher.setWorkExperience(workExperience);
            teacherDao.updateTeacher(teacher);
            responce.setStatus(RespStatus.getSuccessMessage());
            
        }catch(WebServiceException ex){
            ex.printStackTrace();
            responce.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
        }
         catch (Exception ex) {
            ex.printStackTrace();
            throw  new WebServiceException(ExceptionConstants.INTERNAL_EXCEPTION,"Internal Exception");
        }
        return responce;
    }

    @Override
    public RespStatusList deleteTeacher(Long teacherId) {
        RespStatusList responce = new RespStatusList();
        try{  
            if(teacherId == null){
                throw new WebServiceException(ExceptionConstants.INVALID_REQUEST_DATA,"Invalid request data");
            }
            Teacher teacher = teacherDao.getTeacherById(teacherId);
            if(teacher == null){
                throw new WebServiceException(ExceptionConstants.TEACHER_NOT_FOUND,"Teacher not found");
            }
            teacherDao.deleteTeacher(teacherId);
            responce.setStatus(RespStatus.getSuccessMessage());
            
        }catch(WebServiceException ex){
            ex.printStackTrace();
            responce.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
        }
         catch (Exception ex) {
            ex.printStackTrace();
            throw  new WebServiceException(ExceptionConstants.INTERNAL_EXCEPTION,"Internal Exception");
        }
        return responce;

    }

}

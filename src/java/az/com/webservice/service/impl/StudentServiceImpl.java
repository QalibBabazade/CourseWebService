/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.com.webservice.service.impl;

import az.com.webservice.dao.StudentDao;
import az.com.webservice.exception.ExceptionConstants;
import az.com.webservice.exception.WebServiceException;
import az.com.webservice.model.Student;
import az.com.webservice.request.RequeStudent;
import az.com.webservice.responce.RespStatus;
import az.com.webservice.responce.RespStatusList;
import az.com.webservice.responce.RespStudent;
import az.com.webservice.responce.RespStudentList;
import az.com.webservice.service.StudentService;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public class StudentServiceImpl implements StudentService {

    DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    
    private StudentDao studentDao;
    
    public StudentServiceImpl(StudentDao studentDao) {
        this.studentDao = studentDao;
    }
    
    @Override
    
    public RespStudentList getStudentList() {
        RespStudentList responce = new RespStudentList();
        List<RespStudent> respStudentList = new ArrayList<>();
        try {
            List<Student> studentList = studentDao.getStudentList();
            if (studentList.isEmpty()) {
                throw new WebServiceException(ExceptionConstants.STUDENT_NOT_FOUND, "Student not found");
            }
            
            for (Student student : studentList) {
                RespStudent respStudent = new RespStudent();
                respStudent.setStudentId(student.getId());
                respStudent.setName(student.getName());
                respStudent.setSurname(student.getSurname());
                if (student.getDob() != null) {
                    respStudent.setDob(df.format(student.getDob()));                    
                }
                respStudent.setAddress(student.getAddress());
                respStudent.setPhone(student.getPhone());
                respStudentList.add(respStudent);
                
            }
            responce.setRespStudent(respStudentList);
            responce.setRespStatus(RespStatus.getSuccessMessage());
            
        } catch (WebServiceException ex) {
            ex.printStackTrace();
            responce.setRespStatus(new RespStatus(ex.getCode(), ex.getMessage()));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            responce.setRespStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
        }
        return responce;
    }
    
    @Override
    public RespStudent getStudentById(Long studentId) {
        RespStudent responce = new RespStudent();
        try {
            if (studentId == null) {
                throw new WebServiceException(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data");
            }
            Student student = studentDao.getStudentById(studentId);
            if (student == null) {
                throw new WebServiceException(ExceptionConstants.STUDENT_NOT_FOUND, "Student not Found");
            }
            responce.setStudentId(student.getId());
            responce.setName(student.getName());
            responce.setSurname(student.getSurname());
            if (student.getDob() != null) {
                responce.setDob(df.format(student.getDob()));                
            }
            responce.setAddress(student.getAddress());
            responce.setPhone(student.getPhone());
            responce.setStatus(RespStatus.getSuccessMessage());
            
        } catch (WebServiceException ex) {
            ex.printStackTrace();
            responce.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            responce.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
        }
        return responce;
    }
    
    @Override
    public RespStatusList addStudent(RequeStudent requeStudent) {
        RespStatusList responce = new RespStatusList();
        try {
            String name = requeStudent.getName();
            String surname = requeStudent.getSurname();
            Date dob = requeStudent.getDob();
            String address = requeStudent.getAddress();
            String phone = requeStudent.getPhone();
            if (name == null || surname == null) {
                throw new WebServiceException(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data");
            }
            Student student = new Student();
            student.setName(name);
            student.setSurname(surname);
            student.setDob(dob);
            student.setAddress(address);
            student.setPhone(phone);
            studentDao.addStudent(student);
            responce.setStatus(RespStatus.getSuccessMessage());
            
        } catch (WebServiceException ex) {
            ex.printStackTrace();
            responce.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            responce.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
        }
        return responce;
    }
    
    @Override
    public RespStatusList updateStudent(RequeStudent requeStudent) {
        RespStatusList responce = new RespStatusList();
        try {
            Long studentId = requeStudent.getStudentId();
            String name = requeStudent.getName();
            String surname = requeStudent.getSurname();
            Date dob = requeStudent.getDob();
            String address = requeStudent.getAddress();
            String phone = requeStudent.getPhone();
            if (studentId == null || name == null || surname == null) {
                throw new WebServiceException(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data");
            }
            Student student = studentDao.getStudentById(studentId);
            if (student == null) {
                throw new WebServiceException(ExceptionConstants.STUDENT_NOT_FOUND, "Student not found");
            }
            student.setName(name);
            student.setSurname(surname);
            student.setDob(dob);
            student.setAddress(address);
            student.setPhone(phone);
            studentDao.updateStudent(student);
            responce.setStatus(RespStatus.getSuccessMessage());            
            
        } catch (WebServiceException ex) {
            ex.printStackTrace();
            responce.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            responce.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
        }
        return responce;
        
    }
    
    @Override
    public RespStatusList deleteStudent(Long studentId) {
        RespStatusList responce = new RespStatusList();
        try {
            if (studentId == null) {
                throw new WebServiceException(ExceptionConstants.INVALID_REQUEST_DATA, "Invalid request data");
            }
            Student student = studentDao.getStudentById(studentId);
            if (student == null) {
                throw new WebServiceException(ExceptionConstants.STUDENT_NOT_FOUND, "Student not found");
            }
            
            studentDao.deleteStudent(studentId);
            responce.setStatus(RespStatus.getSuccessMessage());            
            
        } catch (WebServiceException ex) {
            ex.printStackTrace();
            responce.setStatus(new RespStatus(ex.getCode(), ex.getMessage()));
            
        } catch (Exception ex) {
            ex.printStackTrace();
            responce.setStatus(new RespStatus(ExceptionConstants.INTERNAL_EXCEPTION, "Internal Exception"));
        }
        return responce;
    }
    
}

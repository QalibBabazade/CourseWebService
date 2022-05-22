/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.com.webservice.dao.impl;

import az.com.webservice.dao.DbHelper;
import az.com.webservice.dao.StudentDao;
import az.com.webservice.model.Student;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> getStudentList() throws Exception {
        List<Student> studentList = new ArrayList<>();
        String sql = "SELECT ID,NAME,SURNAME,DOB,ADDRESS,PHONE FROM coursedb.student\n"
                + "WHERE ACTIVE = 1";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Student student = new Student();
                student.setId(rs.getLong("id"));
                student.setName(rs.getString("name"));
                student.setSurname(rs.getString("surname"));
                student.setDob(rs.getDate("dob"));
                student.setAddress(rs.getString("address"));
                student.setPhone(rs.getString("phone"));
                studentList.add(student);

            }

        }
        return studentList;
    }

    @Override
    public void addStudent(Student student) throws Exception {
        String sql = "INSERT INTO STUDENT(NAME,SURNAME,DOB,ADDRESS,PHONE)\n"
                + "VALUES(?,?,?,?,?)";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            if (student.getDob() != null) {
                ps.setDate(3, new java.sql.Date(student.getDob().getTime()));
            } else {
                ps.setDate(3, null);
            }
            ps.setString(4, student.getAddress());
            ps.setString(5, student.getPhone());
            ps.execute();
        }
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        String sql = "UPDATE STUDENT SET NAME = ?, SURNAME = ?,DOB = ?, ADDRESS = ?,PHONE = ?\n"
                + "WHERE ID = ?";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, student.getName());
            ps.setString(2, student.getSurname());
            if (student.getDob() != null) {
                ps.setDate(3, new java.sql.Date(student.getDob().getTime()));
            } else {
                ps.setDate(3, null);
            }
            ps.setString(4, student.getAddress());
            ps.setString(5, student.getPhone());
            ps.setLong(6, student.getId());
            ps.execute();
        }
    }

    @Override
    public void deleteStudent(Long studentId) throws Exception {
        String sql = "UPDATE STUDENT SET ACTIVE = 0\n"
                + "WHERE ID = ?";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, studentId);
            ps.execute();
        }
    }

    @Override
    public List<Student> searchStudent(String keyword) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Student getStudentById(Long studentId) throws Exception {
        Student student = new Student();
        String sql = "SELECT ID,NAME,SURNAME,DOB,ADDRESS,PHONE FROM coursedb.student\n"
                + "WHERE ACTIVE = 1 AND ID = ?";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, studentId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                student.setId(rs.getLong("ID"));
                student.setName(rs.getString("NAME"));
                student.setSurname(rs.getString("SURNAME"));
                student.setDob(rs.getDate("DOB"));
                student.setAddress(rs.getString("ADDRESS"));
                student.setPhone(rs.getString("PHONE"));
            } else {
                student = null;
            }
        }
        return student;
    }

}

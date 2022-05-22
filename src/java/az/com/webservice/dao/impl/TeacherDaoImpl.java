/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.com.webservice.dao.impl;

import az.com.webservice.dao.DbHelper;
import az.com.webservice.dao.TeacherDao;
import az.com.webservice.model.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author qalib.babazade
 */
public class TeacherDaoImpl implements TeacherDao {

    @Override
    public List<Teacher> getTeacherList() throws Exception {
        List<Teacher> teacherList = new ArrayList<>();
        String sql = "SELECT ID,NAME,SURNAME,DOB,ADDRESS,PHONE,WORK_EXPERIENCE FROM coursedb.teacher\n"
                + "WHERE ACTIVE = 1";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Teacher teacher = new Teacher();
                teacher.setId(rs.getLong("ID"));
                teacher.setName(rs.getString("NAME"));
                teacher.setSurname(rs.getString("SURNAME"));
                teacher.setDob(rs.getDate("DOB"));
                teacher.setAddress(rs.getString("ADDRESS"));
                teacher.setPhone(rs.getString("PHONE"));
                teacher.setWorkExperience(rs.getInt("WORK_EXPERIENCE"));
                teacherList.add(teacher);
            }

        }
        return teacherList;
    }

    @Override
    public void addTeacher(Teacher teacher) throws Exception {
        String sql = "INSERT INTO TEACHER(NAME,SURNAME,DOB,ADDRESS,PHONE,WORK_EXPERIENCE)\n"
                + "VALUES(?,?,?,?,?,?)";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getSurname());
            if (teacher.getDob() != null) {
                ps.setDate(3, new java.sql.Date(teacher.getDob().getTime()));
            } else {
                ps.setDate(3, null);
            }
            ps.setString(4, teacher.getAddress());
            ps.setString(5, teacher.getPhone());
            ps.setInt(6, teacher.getWorkExperience());
            ps.execute();
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) throws Exception {
        String sql = "UPDATE TEACHER SET NAME = ?, SURNAME = ?,DOB = ?, ADDRESS = ?,PHONE = ?,WORK_EXPERIENCE = ?\n"
                + "WHERE ID = ?";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setString(1, teacher.getName());
            ps.setString(2, teacher.getSurname());
            if (teacher.getDob() != null) {
                ps.setDate(3, new java.sql.Date(teacher.getDob().getTime()));
            } else {
                ps.setDate(3, null);
            }
            ps.setString(4, teacher.getAddress());
            ps.setString(5, teacher.getPhone());
            ps.setInt(6, teacher.getWorkExperience());
            ps.setLong(7, teacher.getId());
            ps.execute();
        }
    }

    @Override
    public void deleteTeacher(Long teacherId) throws Exception {

        String sql = "UPDATE TEACHER SET ACTIVE = 0\n"
                + "WHERE ID = ?";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {

            ps.setLong(1, teacherId);
            ps.execute();
        }
    }

    @Override
    public List<Teacher> searchTeacher(String keyword) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Teacher getTeacherById(Long teacherId) throws Exception {
        Teacher teacher = new Teacher();
        String sql = "SELECT ID,NAME,SURNAME,DOB,ADDRESS,PHONE,WORK_EXPERIENCE FROM coursedb.teacher\n"
                + "WHERE ACTIVE = 1 AND ID = ?";
        try (Connection c = DbHelper.getConnection(); PreparedStatement ps = c.prepareStatement(sql)) {
            ps.setLong(1, teacherId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                teacher.setId(rs.getLong("ID"));
                teacher.setName(rs.getString("NAME"));
                teacher.setSurname(rs.getString("SURNAME"));
                teacher.setDob(rs.getDate("DOB"));
                teacher.setAddress(rs.getString("ADDRESS"));
                teacher.setPhone(rs.getString("PHONE"));
                teacher.setWorkExperience(rs.getInt("WORK_EXPERIENCE"));

            } else {
                teacher = null;
            }
        }
        return teacher;
    }

}

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
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author qalib.babazade
 */
@Path("/TeacherWebService")
public class TeacherWebService {

    TeacherDao teacherDao = new TeacherDaoImpl();
    TeacherService teacherService = new TeacherServiceimpl(teacherDao);

    @GET
    @Path("/getTeacherList")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespTeacherList getTeacherList() {
        return teacherService.getTeacherList();
    }

    @GET
    @Path("/getTeacherById")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespTeacher getTeacherById(@QueryParam("teacherId") Long teacherId) {
        return teacherService.getTeacherById(teacherId);
    }

    @POST
    @Path("/addTeacher")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespStatusList addTeacher(RequeTeacher requeTeacher) {
        return teacherService.addTeacher(requeTeacher);
    }

    @PUT
    @Path("/updateTeacher")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespStatusList updateStudent(RequeTeacher requeTeacher) {
        return teacherService.updateTeacher(requeTeacher);
    }

    @PUT
    @Path("/deleteTeacher/{teacherId}")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public RespStatusList deleteTeacher(@PathParam("teacherId") Long teacherId) {

        return teacherService.deleteTeacher(teacherId);
    }
}

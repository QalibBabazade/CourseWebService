

package az.com.webservice.webservice;


import az.com.webservice.dao.StudentDao;
import az.com.webservice.dao.impl.StudentDaoImpl;
import az.com.webservice.request.RequeStudent;
import az.com.webservice.responce.RespStatusList;
import az.com.webservice.responce.RespStudent;
import az.com.webservice.responce.RespStudentList;
import az.com.webservice.service.StudentService;
import az.com.webservice.service.impl.StudentServiceImpl;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author Qalib
 */


@Path("/StudentWebService")
public class StudentWebService {
    
    StudentDao studentDao = new StudentDaoImpl();
    StudentService studentService = new StudentServiceImpl(studentDao);

    @GET
    @Path("/getStudentList")
    @Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML} )
    public RespStudentList getStudentList() {
       
        return studentService.getStudentList();
    }
    
    @GET
    @Path("/getStudentById")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public RespStudent getStudentById(@QueryParam("studentId") Long studentId){
        return studentService.getStudentById(studentId);
    }
    
    @POST
    @Path("/addStudent")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public RespStatusList addStudent(RequeStudent requeStudent){
       return studentService.addStudent(requeStudent);
    }
    
    @PUT
    @Path("/updateStudent")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public RespStatusList updateStudent(RequeStudent requeStudent){
       return studentService.updateStudent(requeStudent);
    }
    
    @PUT
    @Path("/deleteStudent/{studentId}")
    @Produces({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    @Consumes({MediaType.APPLICATION_JSON,MediaType.APPLICATION_XML})
    public RespStatusList deleteStudent(@PathParam("studentId") Long studentId){
        
        return studentService.deleteStudent(studentId);
    }
}

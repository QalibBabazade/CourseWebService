package az.com.webservice.webservice;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.core.Application;

@javax.ws.rs.ApplicationPath("api")
public class ApiConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(StudentWebService.class);
        set.add(TeacherWebService.class);
        return set;
    }

}

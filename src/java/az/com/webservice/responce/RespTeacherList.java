/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.com.webservice.responce;

import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author qalib.babazade
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RespTeacherList {

    private List<RespTeacher> respTeacher;
    private RespStatus Status;

    public List<RespTeacher> getRespTeacher() {
        return respTeacher;
    }

    public void setRespTeacher(List<RespTeacher> respTeacher) {
        this.respTeacher = respTeacher;
    }

    public RespStatus getStatus() {
        return Status;
    }

    public void setStatus(RespStatus Status) {
        this.Status = Status;
    }

}

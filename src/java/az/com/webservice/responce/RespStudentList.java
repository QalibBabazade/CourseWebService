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
public class RespStudentList {

    private List<RespStudent> respStudent;
    private RespStatus respStatus;

    public List<RespStudent> getRespStudent() {
        return respStudent;
    }

    public void setRespStudent(List<RespStudent> respStudent) {
        this.respStudent = respStudent;
    }

    public RespStatus getRespStatus() {
        return respStatus;
    }

    public void setRespStatus(RespStatus respStatus) {
        this.respStatus = respStatus;
    }

}

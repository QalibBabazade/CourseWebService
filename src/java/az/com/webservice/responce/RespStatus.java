/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.com.webservice.responce;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author qalib.babazade
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class RespStatus {

    private Integer code;
    private String message;
    private static final Integer success_code = 1;
    private static final String success_message = "SUCCESS!";

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public RespStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public RespStatus() {
    }

    public static RespStatus getSuccessMessage() {
        return new RespStatus(success_code, success_message);
    }

}

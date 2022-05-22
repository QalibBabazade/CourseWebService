/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package az.com.webservice.exception;

/**
 *
 * @author qalib.babazade
 */
public class WebServiceException extends RuntimeException {

    private Integer code;

    public WebServiceException() {

    }

    public WebServiceException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public Integer getCode() {

        return code;
    }

}

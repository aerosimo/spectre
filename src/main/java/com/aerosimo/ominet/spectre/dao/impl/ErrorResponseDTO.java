/******************************************************************************
 * This piece of work is to enhance spectre project functionality.            *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      ErrorResponseDTO.java                                           *
 * Created:   19/09/2025, 19:18                                               *
 * Modified:  19/09/2025, 19:18                                               *
 *                                                                            *
 * Copyright (c)  2025.  Aerosimo Ltd                                         *
 *                                                                            *
 * Permission is hereby granted, free of charge, to any person obtaining a    *
 * copy of this software and associated documentation files (the "Software"), *
 * to deal in the Software without restriction, including without limitation  *
 * the rights to use, copy, modify, merge, publish, distribute, sublicense,   *
 * and/or sell copies of the Software, and to permit persons to whom the      *
 * Software is furnished to do so, subject to the following conditions:       *
 *                                                                            *
 * The above copyright notice and this permission notice shall be included    *
 * in all copies or substantial portions of the Software.                     *
 *                                                                            *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,            *
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES            *
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND                   *
 * NONINFINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT                 *
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,               *
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING               *
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE                 *
 * OR OTHER DEALINGS IN THE SOFTWARE.                                         *
 *                                                                            *
 ******************************************************************************/

package com.aerosimo.ominet.spectre.dao.impl;

import jakarta.xml.bind.annotation.*;

@XmlRootElement(name = "ErrorResponseDTO")
@XmlType(propOrder = {"errorID","errorRef", "errorTime", "errorCode", "errorMessage", "errorService"})
@XmlAccessorType(XmlAccessType.FIELD)
public class ErrorResponseDTO {

    @XmlElement
    private Integer errorID;
    @XmlElement
    private String errorRef;
    @XmlElement
    private String errorTime;
    @XmlElement
    private String errorCode;
    @XmlElement
    private String errorMessage;
    @XmlElement
    private String errorService;

    public ErrorResponseDTO() {
    }

    public ErrorResponseDTO(Integer errorID, String errorRef, String errorTime, String errorCode, String errorMessage, String errorService) {
        this.errorID = errorID;
        this.errorRef = errorRef;
        this.errorTime = errorTime;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.errorService = errorService;
    }

    public Integer getErrorID() {
        return errorID;
    }

    public void setErrorID(Integer errorID) {
        this.errorID = errorID;
    }

    public String getErrorRef() {
        return errorRef;
    }

    public void setErrorRef(String errorRef) {
        this.errorRef = errorRef;
    }

    public String getErrorTime() {
        return errorTime;
    }

    public void setErrorTime(String errorTime) {
        this.errorTime = errorTime;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorService() {
        return errorService;
    }

    public void setErrorService(String errorService) {
        this.errorService = errorService;
    }

    @Override
    public String toString() {
        return "ErrorResponseDTO{" +
                "errorID=" + errorID +
                ", errorRef='" + errorRef + '\'' +
                ", errorTime='" + errorTime + '\'' +
                ", errorCode='" + errorCode + '\'' +
                ", errorMessage='" + errorMessage + '\'' +
                ", errorService='" + errorService + '\'' +
                '}';
    }
}
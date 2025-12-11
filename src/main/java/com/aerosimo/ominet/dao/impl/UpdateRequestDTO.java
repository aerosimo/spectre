/******************************************************************************
 * This piece of work is to enhance spectre project functionality.            *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      UpdateRequestDTO.java                                           *
 * Created:   26/11/2025, 09:55                                               *
 * Modified:  26/11/2025, 09:55                                               *
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

package com.aerosimo.ominet.dao.impl;

public class UpdateRequestDTO {

    private String faultReference;
    private String faultStatus;
    private String faultState;

    public UpdateRequestDTO() {
    }

    public UpdateRequestDTO(String faultReference, String faultStatus, String faultState) {
        this.faultReference = faultReference;
        this.faultStatus = faultStatus;
        this.faultState = faultState;
    }

    public String getFaultReference() {
        return faultReference;
    }

    public void setFaultReference(String faultReference) {
        this.faultReference = faultReference;
    }

    public String getFaultStatus() {
        return faultStatus;
    }

    public void setFaultStatus(String faultStatus) {
        this.faultStatus = faultStatus;
    }

    public String getFaultState() {
        return faultState;
    }

    public void setFaultState(String faultState) {
        this.faultState = faultState;
    }

    @Override
    public String toString() {
        return "UpdateRequestDTO{" +
                "faultReference='" + faultReference + '\'' +
                ", faultStatus='" + faultStatus + '\'' +
                ", faultState='" + faultState + '\'' +
                '}';
    }
}
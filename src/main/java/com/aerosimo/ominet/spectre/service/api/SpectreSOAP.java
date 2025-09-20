/******************************************************************************
 * This piece of work is to enhance spectre project functionality.            *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      SpectreSOAP.java                                                *
 * Created:   19/09/2025, 19:22                                               *
 * Modified:  19/09/2025, 19:22                                               *
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

package com.aerosimo.ominet.spectre.service.api;

import com.aerosimo.ominet.spectre.dao.impl.ErrorResponseDTO;
import com.aerosimo.ominet.spectre.dao.mapper.ErrorVaultDAO;
import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.ws.BindingType;
import jakarta.xml.ws.soap.SOAPBinding;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@WebService(name = "spectre", serviceName = "spectre",
        portName = "spectreport", targetNamespace = "https://aerosimo.com/api/ws/spectre")
@BindingType(SOAPBinding.SOAP12HTTP_BINDING)
public class SpectreSOAP {

    private static final Logger log;

    static {
        log = LogManager.getLogger(SpectreSOAP.class.getName());
    }
    static String Response;

    @WebMethod(operationName = "recordError")
    @WebResult(name = "recordError", partName = "recordErrorResponse")
    public String recordError(@XmlElement(required = true) @WebParam(name = "faultcode", partName = "recordErrorRequest") String faultcode,
                              @XmlElement(required = true) @WebParam(name = "faultmessage", partName = "recordErrorRequest") String faultmessage,
                              @XmlElement(required = true) @WebParam(name = "faultservicename", partName = "recordErrorRequest") String faultservicename){

        if (faultcode.isEmpty()) {
            Response = "Schema Validation failed because Fault Code is a required field";
            log.error(Response);
        } else if (faultmessage.isEmpty()) {
            Response = "Schema Validation failed because Fault Message is a required field";
            log.error(Response);
        } else if (faultservicename.isEmpty()) {
            Response = "Schema Validation failed because Service Name is a required field";
            log.error(Response);
        }
        Response = ErrorVaultDAO.storeError(faultcode, faultmessage, faultservicename);
        log.info("Successfully store new error into error vault with reference {}",Response);
        return Response;
    }

    @WebMethod(operationName = "getTopErrors")
    @WebResult(name = "getTopErrors", partName = "getTopErrorsResponse")
    public List<ErrorResponseDTO> getTopErrors(@XmlElement(required = true)@WebParam(name = "records", partName = "getTopErrorsRequest") int records) {
        log.info("Successfully return top errors from error vault with records {}",records);
        return ErrorVaultDAO.getTopErrors(records);
    }
}
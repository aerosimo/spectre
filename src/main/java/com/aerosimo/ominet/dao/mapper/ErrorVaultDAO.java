/******************************************************************************
 * This piece of work is to enhance spectre project functionality.            *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      ErrorVaultDAO.java                                              *
 * Created:   12/10/2025, 15:23                                               *
 * Modified:  26/11/2025, 08:35                                               *
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

package com.aerosimo.ominet.dao.mapper;

import com.aerosimo.ominet.dao.impl.APIResponseDTO;
import com.aerosimo.ominet.mail.ErrorMail;
import com.aerosimo.ominet.core.config.Connect;
import com.aerosimo.ominet.dao.impl.ErrorResponseDTO;
import oracle.jdbc.OracleTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ErrorVaultDAO {

    private static final Logger log = LogManager.getLogger(ErrorVaultDAO.class.getName());

    public static APIResponseDTO storeError(String faultCode, String faultMessage, String faultService) {
        log.info("Preparing to store new error into error vault");
        String sql = "{call errorVault_pkg.storeError(?,?,?,?)}";
        try (Connection con = Connect.dbase();
             CallableStatement stmt = con.prepareCall(sql)) {
            stmt.setString(1, faultCode);
            stmt.setString(2, faultMessage);
            stmt.setString(3, faultService);
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.execute();
            String response = stmt.getString(4);
            if (response.startsWith("ERROR CODE:")){
                log.info("Unsuccessful in storing new error into error vault with the following - {}", response);
                return new APIResponseDTO("unsuccessful", response.toLowerCase());
            } else {
                String result = ErrorMail.mail(response, faultCode, faultMessage);
                log.debug("Response from sending error email - {}", result);
                log.info("Successfully store new error into error vault - {}", response);
                return new APIResponseDTO("success", response.toLowerCase());
            }
        } catch (SQLException err) {
            log.error("Database adaptor error (storeError) occurred with the following - {}", ErrorVaultDAO.class.getName(), err);
            return new APIResponseDTO("error","internal server error");
        }
    }

    public static List<ErrorResponseDTO> getTopErrors(int records){
        log.info("Preparing to fetch new top errors from error vault");
        List<ErrorResponseDTO> errorList = new ArrayList<>();
        String sql = "{call errorVault_pkg.getErrors(?,?)}";
        try (Connection con = Connect.dbase();
             CallableStatement stmt = con.prepareCall(sql)) {
            stmt.setInt(1, records);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            try (ResultSet rs = (ResultSet) stmt.getObject(2)) {
                while (rs != null && rs.next()) {
                    ErrorResponseDTO fault = new ErrorResponseDTO();
                    fault.setErrorID(Integer.valueOf(rs.getString("errorId")));
                    fault.setErrorRef(rs.getString("errorReference"));
                    fault.setErrorTime(rs.getString("errorTime"));
                    fault.setErrorCode(rs.getString("errorCode"));
                    fault.setErrorMessage(rs.getString("errorMessage"));
                    fault.setErrorService(rs.getString("errorService"));
                    fault.setErrorStatus(rs.getString("errorStatus"));
                    fault.setErrorSate(rs.getString("errorSate"));
                    errorList.add(fault);
                }
            }
        } catch (SQLException err) {
            log.error("Database adaptor error (getTopErrors) occurred with the following - {}", ErrorVaultDAO.class.getName(), err);
        }
        return errorList;
    }

    public static APIResponseDTO updateError(String faultReference, String faultStatus, String faultState) {
        log.info("Preparing to update error status into error vault");
        String sql = "{call errorVault_pkg.updateError(?,?,?,?)}";
        try (Connection con = Connect.dbase();
             CallableStatement stmt = con.prepareCall(sql)) {
            stmt.setString(1, faultReference);
            stmt.setString(2, faultStatus);
            stmt.setString(3, faultStatus);
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.execute();
            String response = stmt.getString(4);
            if (response.startsWith("ERROR CODE:")){
                log.info("Unsuccessful in updating error status into error vault with the following- {}", response);
                return new APIResponseDTO("unsuccessful", response.toLowerCase());
            } else {
                log.info("Successfully update error status into error vault with the following - {}", response);
                return new APIResponseDTO("success", response.toLowerCase());
            }
        } catch (SQLException err) {
            log.error("Database adaptor error (updateError) occurred with the following - {}", ErrorVaultDAO.class.getName(), err);
            return new APIResponseDTO("error","internal server error");
        }
    }
}
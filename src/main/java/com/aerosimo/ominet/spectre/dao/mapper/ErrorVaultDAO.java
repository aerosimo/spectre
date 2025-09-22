/******************************************************************************
 * This piece of work is to enhance spectre project functionality.            *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      ErrorVaultDAO.java                                              *
 * Created:   19/09/2025, 19:20                                               *
 * Modified:  19/09/2025, 19:20                                               *
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

package com.aerosimo.ominet.spectre.dao.mapper;

import com.aerosimo.ominet.spectre.com.mail.ErrorMail;
import com.aerosimo.ominet.spectre.core.config.Connect;
import com.aerosimo.ominet.spectre.dao.impl.ErrorResponseDTO;
import oracle.jdbc.OracleTypes;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ErrorVaultDAO {

    private static final Logger log;

    static {
        log = LogManager.getLogger(ErrorVaultDAO.class.getName());
    }

    public static String storeError(String faultCode, String faultMessage, String faultService) {
        log.info("Preparing to store new error into error vault");
        String response;
        Connection con = null;
        CallableStatement stmt = null;
        String sql = "{call error_vault_pkg.store_error(?,?,?,?)}";
        try {
            con = Connect.dbase();
            stmt = con.prepareCall(sql);
            stmt.setString(1, faultCode);
            stmt.setString(2, faultMessage);
            stmt.setString(3, faultService);
            stmt.registerOutParameter(4, Types.VARCHAR);
            stmt.execute();
            response = stmt.getString(4);
            ErrorMail.mail(response, faultCode, faultMessage);
            log.info("Successfully store new error into error vault");
        } catch (SQLException err) {
            response = "ErrorVaultDAO (storeError) attempt failed";
            log.error("Database adaptor error (storeError) occurred with the following - {}", ErrorVaultDAO.class.getName(), err);
        } finally {
            // Close the statement and connection
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            log.info("DB Connection for (storeError) Closed....");
        }
        return response;
    }

    public static List<ErrorResponseDTO> getTopErrors(int records){
        log.info("Preparing to fetch new top errors from error vault");
        List<ErrorResponseDTO> errorList = new ArrayList<>();
        String sql = "{call error_vault_pkg.get_errors(?,?)}";
        Connection con = null;
        CallableStatement stmt = null;
        try {
            con = Connect.dbase();
            stmt = con.prepareCall(sql);
            stmt.setInt(1, records);
            stmt.registerOutParameter(2, OracleTypes.CURSOR);
            stmt.execute();
            ResultSet rs = (ResultSet) stmt.getObject(2);
            while (rs.next()) errorList.add(new ErrorResponseDTO(rs.getInt(1),
                    rs.getString(2),
                    rs.getString(3),
                    rs.getString(4),
                    rs.getString(5),
                    rs.getString(6)));
        } catch (SQLException err) {
            log.error("Database adaptor error (getTopErrors) occurred with the following - {}", ErrorVaultDAO.class.getName(), err);
        } finally {
            // Close the statement and connection
            try {
                stmt.close();
                con.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
            log.info("DB Connection for (getTopErrors) Closed....");
        }
        return errorList;
    }
}
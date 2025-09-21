/******************************************************************************
 * This piece of work is to enhance spectre project functionality.            *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      Connect.java                                                    *
 * Created:   19/09/2025, 16:35                                               *
 * Modified:  19/09/2025, 16:35                                               *
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

package com.aerosimo.ominet.spectre.core.config;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class Connect {

    private static final Logger log = LogManager.getLogger(Connect.class.getName());

    static DataSource ds;

    static {
        try {
            log.info("Looking up JNDI DataSource for Oracle DB");
            InitialContext ctx = new InitialContext();
            ds = (DataSource) ctx.lookup("java:comp/env/jdbc/hats"); // <-- check JNDI name
            log.info("DataSource lookup successful");
        } catch (NamingException e) {
            log.error("JNDI lookup for Oracle DB failed", e);
            throw new ExceptionInInitializerError(e);
        }
    }

    /**
     * Always fetch a fresh connection from the pool.
     * Caller must close the connection (use try-with-resources).
     */
    public static Connection dbase() throws SQLException {
        log.debug("Fetching a new connection from Oracle DataSource");
        return ds.getConnection();
    }
}
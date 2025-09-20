/******************************************************************************
 * This piece of work is to enhance spectre project functionality.            *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      SpectreREST.java                                                *
 * Created:   20/09/2025, 15:06                                               *
 * Modified:  20/09/2025, 15:06                                               *
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

import com.aerosimo.ominet.spectre.dao.impl.ErrorRequestDTO;
import com.aerosimo.ominet.spectre.dao.impl.ErrorResponseDTO;
import com.aerosimo.ominet.spectre.dao.mapper.ErrorVaultDAO;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Path("/errors")   // <--- resource directly under /api/errors
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SpectreREST {

    private static final Logger log;

    static {
        log = LogManager.getLogger(SpectreREST.class.getName());
    }
    /**
     * Store a new error in the Error Vault.
     * POST http://host:port/context/api/errors
     */
    @POST
    public Response storeError(ErrorRequestDTO request) {
        if (request == null ||
                request.getFaultCode() == null ||
                request.getFaultMessage() == null ||
                request.getFaultService() == null) {
            log.error("Bad request - {}", SpectreREST.class.getName(), Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"Missing required fields\"}")
                    .build());
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity("{\"error\":\"Missing required fields\"}")
                    .build();
        }

        String ref = ErrorVaultDAO.storeError(
                request.getFaultCode(),
                request.getFaultMessage(),
                request.getFaultService()
        );
        log.info("Successfully store new error into error vault with reference {}",
                Response.ok("{\"errorRef\":\"" + ref + "\"}").build());
        return Response.ok("{\"errorRef\":\"" + ref + "\"}").build();
    }

    /**
     * Get top N errors from the Error Vault.
     * GET http://host:port/context/api/errors?records=5
     */
    @GET
    public Response getTopErrors(@QueryParam("records") @DefaultValue("10") int records) {
        List<ErrorResponseDTO> errors;
        errors = ErrorVaultDAO.getTopErrors(records);
        log.info("Successfully return top errors from error vault with records {}",records);
        return Response.ok(errors).build();
    }
}
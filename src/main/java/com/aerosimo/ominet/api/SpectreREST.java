/******************************************************************************
 * This piece of work is to enhance spectre project functionality.            *
 *                                                                            *
 * Author:    eomisore                                                        *
 * File:      SpectreREST.java                                                *
 * Created:   17/10/2025, 20:51                                               *
 * Modified:  26/11/2025, 08:36                                               *
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

package com.aerosimo.ominet.api;

import com.aerosimo.ominet.dao.impl.APIResponseDTO;
import com.aerosimo.ominet.dao.impl.ErrorRequestDTO;
import com.aerosimo.ominet.dao.impl.ErrorResponseDTO;
import com.aerosimo.ominet.dao.impl.UpdateRequestDTO;
import com.aerosimo.ominet.dao.mapper.ErrorVaultDAO;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

@Path("/errors")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class SpectreREST {

    private static final Logger log = LogManager.getLogger(SpectreREST.class.getName());

    @POST
    @Path("/stow")
    public Response storeError(ErrorRequestDTO req) {
        if (req == null ||
                req.getFaultCode() == null ||
                req.getFaultMessage() == null ||
                req.getFaultService() == null) {
            log.error("Missing required parameters in ErrorRequestDTO");
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new APIResponseDTO("unsuccessful", "missing required fields"))
                    .build();
        }

        APIResponseDTO ref = ErrorVaultDAO.storeError(
                req.getFaultCode(),
                req.getFaultMessage(),
                req.getFaultService()
        );
        return Response.ok(new APIResponseDTO(ref.getStatus(), ref.getMessage())).build();
    }

    @GET
    @Path("/retrieve")
    public Response getTopErrors(@QueryParam("records") @DefaultValue("10") int records) {
        List<ErrorResponseDTO> errors;
        errors = ErrorVaultDAO.getTopErrors(records);
        log.info("Successfully return top errors from error vault with records {}",records);
        return Response.ok(errors).build();
    }

    @POST
    @Path("/overhaul")
    public Response updateError(UpdateRequestDTO req) {
        if (req == null ||
                req.getFaultReference() == null ||
                req.getFaultStatus() == null) {
            log.error("Missing required parameters in UpdateRequestDTO");
            return Response.status(Response.Status.BAD_REQUEST)
                    .entity(new APIResponseDTO("unsuccessful", "missing required fields"))
                    .build();
        }

        APIResponseDTO ref = ErrorVaultDAO.updateError(
                req.getFaultReference(),
                req.getFaultStatus(),
                req.getFaultState()
        );
        return Response.ok(new APIResponseDTO(ref.getStatus(), ref.getMessage())).build();
    }
}
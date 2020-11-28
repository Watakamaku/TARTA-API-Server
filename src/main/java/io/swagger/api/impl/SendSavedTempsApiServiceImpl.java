package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;

import io.swagger.model.TomaTemperatura;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-11-28T11:29:04.589Z[GMT]")public class SendSavedTempsApiServiceImpl extends SendSavedTempsApiService {
    @Override
    public Response sendSavedTempsPost(List<TomaTemperatura> body, SecurityContext securityContext) throws NotFoundException {

        int totalRows = body.size();
        int rowsAdded = 0;
        String user = "";

        for (int i = 0; i < body.size(); i++) {
            server.getInstance().setUserTemp(body.get(i).getIdUser().toString(), body.get(i));
            user = body.get(i).getIdUser().toString();
            rowsAdded++;
        }
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Added a total of : " + rowsAdded + " out of " + totalRows + " to the user " + user)).build();
    }
}

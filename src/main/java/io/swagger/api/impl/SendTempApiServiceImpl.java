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
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-11-28T11:29:04.589Z[GMT]")public class SendTempApiServiceImpl extends SendTempApiService {
    @Override
    public Response sendTempPost(TomaTemperatura body, SecurityContext securityContext) throws NotFoundException {
        System.out.println("SendTemp.java - User : " + body.getIdUser() + " temp: " + body.getTemperatura() + " pulso: " + body.getPulso() + " timestamp " + body.getTimestamp());
        server.getInstance().setUserTemp(body.getIdUser(), body);
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "Added the temp with timestamp " + body.getTimestamp() + " to the user " + body.getIdUser().toString())).build();
    }
}

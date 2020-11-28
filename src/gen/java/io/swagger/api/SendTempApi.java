package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.SendTempApiService;
import io.swagger.api.factories.SendTempApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import io.swagger.model.TomaTemperatura;

import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import javax.servlet.ServletConfig;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.ws.rs.*;
import javax.validation.constraints.*;


@Path("/sendTemp")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-11-28T11:29:04.589Z[GMT]")public class SendTempApi  {
   private final SendTempApiService delegate;

   public SendTempApi(@Context ServletConfig servletContext) {
      SendTempApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("SendTempApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (SendTempApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = SendTempApiServiceFactory.getSendTempApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    
    @Operation(summary = "Enviar una toma de temperatura", description = "Envía una toma de temperatura de un usuario al servidor", tags={ "Servidor" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Temperatura enviada"),
        
        @ApiResponse(responseCode = "400", description = "Error al mandar la temperatura") })
    public Response sendTempPost(@Parameter(in = ParameterIn.DEFAULT, description = "Parámetros a enviar" ) TomaTemperatura body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendTempPost(body,securityContext);
    }
}

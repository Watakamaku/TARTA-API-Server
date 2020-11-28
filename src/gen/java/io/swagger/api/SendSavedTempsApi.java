package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.SendSavedTempsApiService;
import io.swagger.api.factories.SendSavedTempsApiServiceFactory;

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


@Path("/sendSavedTemps")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-11-28T11:29:04.589Z[GMT]")public class SendSavedTempsApi  {
   private final SendSavedTempsApiService delegate;

   public SendSavedTempsApi(@Context ServletConfig servletContext) {
      SendSavedTempsApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("SendSavedTempsApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (SendSavedTempsApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = SendSavedTempsApiServiceFactory.getSendSavedTempsApi();
      }

      this.delegate = delegate;
   }

    @POST
    
    @Consumes({ "application/json" })
    
    @Operation(summary = "Envia las temperaturas almacenadas en la pulsera", description = "Envía todas las temperaturas tomadas", tags={ "Servidor" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Lista de temperaturas enviadas"),
        
        @ApiResponse(responseCode = "400", description = "Error al mandar las temperaturas") })
    public Response sendSavedTempsPost(@Parameter(in = ParameterIn.DEFAULT, description = "Parámetros a enviar" ) List<TomaTemperatura> body

,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.sendSavedTempsPost(body,securityContext);
    }
}

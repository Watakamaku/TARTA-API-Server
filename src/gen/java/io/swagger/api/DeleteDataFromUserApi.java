package io.swagger.api;

import io.swagger.model.*;
import io.swagger.api.DeleteDataFromUserApiService;
import io.swagger.api.factories.DeleteDataFromUserApiServiceFactory;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;


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


@Path("/deleteDataFromUser")


@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-11-28T11:29:04.589Z[GMT]")public class DeleteDataFromUserApi  {
   private final DeleteDataFromUserApiService delegate;

   public DeleteDataFromUserApi(@Context ServletConfig servletContext) {
      DeleteDataFromUserApiService delegate = null;

      if (servletContext != null) {
         String implClass = servletContext.getInitParameter("DeleteDataFromUserApi.implementation");
         if (implClass != null && !"".equals(implClass.trim())) {
            try {
               delegate = (DeleteDataFromUserApiService) Class.forName(implClass).newInstance();
            } catch (Exception e) {
               throw new RuntimeException(e);
            }
         } 
      }

      if (delegate == null) {
         delegate = DeleteDataFromUserApiServiceFactory.getDeleteDataFromUserApi();
      }

      this.delegate = delegate;
   }

    @DELETE
    @Path("/{userId}")
    
    
    @Operation(summary = "Borra todos los registros de temperatura de un usuario asociado a una pulsera", description = "Borra todos los registros de temperatura de un usuario asociado a una pulsera", tags={ "Servidor" })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Usuario eliminado"),
        
        @ApiResponse(responseCode = "400", description = "Error, usuario no encontrado") })
    public Response deleteDataFromUserUserIdDelete(@Parameter(in = ParameterIn.PATH, description = "Usuario del que se pretende eliminar el contenido",required=true) @PathParam("userId") String userId
,@Context SecurityContext securityContext)
    throws NotFoundException {
        return delegate.deleteDataFromUserUserIdDelete(userId,securityContext);
    }
}

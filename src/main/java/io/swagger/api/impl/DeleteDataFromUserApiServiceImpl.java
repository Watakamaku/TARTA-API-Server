package io.swagger.api.impl;

import io.swagger.api.*;
import io.swagger.model.*;


import java.util.Map;
import java.util.List;
import io.swagger.api.NotFoundException;

import java.io.InputStream;

import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;
import javax.validation.constraints.*;
@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-11-28T11:29:04.589Z[GMT]")public class DeleteDataFromUserApiServiceImpl extends DeleteDataFromUserApiService {
    @Override
    public Response deleteDataFromUserUserIdDelete(String userId, SecurityContext securityContext) throws NotFoundException {
        int result = server.getInstance().deleteUser(userId);
        String resp="";
        if(result == 0){
            resp = "not deleted succesfully";
        }else if(result == 1){
            resp = "deleted succesfully";
        }else{
            resp = "something went wrong";
        }
        return Response.ok().entity(new ApiResponseMessage(ApiResponseMessage.OK, "The user " + userId + " was " + resp)).build();
    }
}

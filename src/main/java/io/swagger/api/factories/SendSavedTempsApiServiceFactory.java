package io.swagger.api.factories;

import io.swagger.api.SendSavedTempsApiService;
import io.swagger.api.impl.SendSavedTempsApiServiceImpl;

@javax.annotation.Generated(value = "io.swagger.codegen.v3.generators.java.JavaJerseyServerCodegen", date = "2020-11-28T11:29:04.589Z[GMT]")public class SendSavedTempsApiServiceFactory {
    private final static SendSavedTempsApiService service = new SendSavedTempsApiServiceImpl();

    public static SendSavedTempsApiService getSendSavedTempsApi() {
        return service;
    }
}

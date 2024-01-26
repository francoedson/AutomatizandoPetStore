package com.nttdata.petstore;

import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

public class CreateOrderSteps {

    private static String URL_BASE="https://petstore.swagger.io/v2";

    @Step("Crear orden {0} en PetStore")
    public void createOrden(String id,String petId, String quantity){
        SerenityRest.given()
                .contentType("application/json")
                .body("{\n" +
                        "  \"id\": \""+id+"\",\n" +
                        "  \"petId\": \""+petId+"\",\n" +
                        "  \"quantity\": \""+quantity+"\",\n" +
                        "  \"shipDate\": \"2024-01-26T21:27:14.974Z\",\n" +
                        "  \"status\": \"placed\",\n" +
                        "  \"complete\": true\n" +
                        "}")
                .post(URL_BASE+"/store/order");
    }

}

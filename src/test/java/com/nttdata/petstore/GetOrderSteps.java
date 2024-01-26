package com.nttdata.petstore;

import net.serenitybdd.rest.SerenityRest;

public class GetOrderSteps {
    private static String URL_BASE = "https://petstore.swagger.io/v2";
    public void consultar(int id) {
        SerenityRest.given()
                .log().all()
                .get(URL_BASE+"/store/order/"+id);
    }
}

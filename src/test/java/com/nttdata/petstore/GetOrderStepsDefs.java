package com.nttdata.petstore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class GetOrderStepsDefs {

    @Steps
    GetOrderSteps getOrder;

    @When("consulto la orden con id {string}")
    public void consultoLaOrdenConId(String id) {
        getOrder.consultar(Integer.parseInt(id));
    }

    @And("el id de la orden es {string}")
    public void elIdDeLaOrdenEs(String id) {
        int petIdInt = Integer.parseInt(id);
        restAssuredThat(response -> response.body("id", equalTo(petIdInt)));
        System.out.println("ID de la Orden: " + SerenityRest.lastResponse().body().path("id").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }
}

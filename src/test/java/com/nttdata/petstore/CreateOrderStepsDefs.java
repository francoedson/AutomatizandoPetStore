package com.nttdata.petstore;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Steps;

import static net.serenitybdd.rest.SerenityRest.restAssuredThat;
import static org.hamcrest.CoreMatchers.equalTo;

public class CreateOrderStepsDefs {

    @Steps
    CreateOrderSteps createOrder;

    @When("creo una orden con  id {string}, id de la mascota {string} y la cantidad es {string}")
    public void crearOrden(String id,String petId,String quantity){
        createOrder.createOrden(id,petId,quantity);
    }

    @Then("el código de respuesta es {string}")
    public void elCódigoDeRespuestaEs(String statusCode) {
        int statusCodeInt = Integer.parseInt(statusCode);
        restAssuredThat(response -> response.statusCode(statusCodeInt));
    }

    @And("el id de la mascota es {string}")
    public void elIdDeLaMascotaEs(String petId) {
        int petIdInt = Integer.parseInt(petId);
        restAssuredThat(response -> response.body("petId", equalTo(petIdInt)));
        System.out.println("ID de la Mascota: " + SerenityRest.lastResponse().body().path("petId").toString());
        System.out.println(SerenityRest.lastResponse().print());
    }
}

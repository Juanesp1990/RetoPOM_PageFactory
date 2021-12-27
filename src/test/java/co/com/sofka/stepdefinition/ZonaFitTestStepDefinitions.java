package co.com.sofka.stepdefinition;

import co.com.sofka.model.ZonaFitModel;
import co.com.sofka.page.ZonaFitPage;
import co.com.sofka.setup.WebUI;
import co.com.sofka.util.City;
import co.com.sofka.util.State;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ZonaFitTestStepDefinitions extends WebUI {
    private ZonaFitModel cliente;
    private ZonaFitPage zonaFitPage;

    @Given("El cliente se encuentra en el dominio de compras de la página de zonafit")
    public void elClienteSeEncuentraEnElDominioDeComprasDeLaPáginaDeZonafit () {
        try {
            generalSetUp();
            generateClient();

        } catch (Exception e) {
            quiteDriver();
        }

    }

    @When("el cliente selecciona los productos que desea comprar")
    public void elClienteSeleccionaLosProductosQueDeseaComprar ()  {
        try {
            zonaFitPage = new ZonaFitPage(cliente, super.driver);
            zonaFitPage.fillMandatoryFields();
        }catch (Exception exception){

        }finally {
            //quiteDriver();
        }

    }

    @When("el cliente llena el formulario de la compra y confirma su acción")
    public void elClienteLlenaElFormularioDeLaCompraYConfirmaSuAcción () {

    }

    @Then("la página deberá mostrar un mensaje indicando su pedido")
    public void laPáginaDeberáMostrarUnMensajeIndicandoSuPedido () {

    }

    private void generateClient () {
        cliente = new ZonaFitModel();
        cliente.setDocumentNumber("1128436729");
        cliente.setEmail("andres.perez@gmail.com");
        cliente.setName("Andres Mauricio");
        cliente.setLastName("Perez");
        cliente.setState(State.HUILA);
        cliente.setCity(City.BRUSELAS_HUI);
        cliente.setAddress("Circular 4 n° 18-28");
        cliente.setComplementaryAddress("INT 402");
        cliente.setCellPhone("3214869753");
        cliente.setNote(" El horario de entrega preferiblemente en la mañana");

    }
}

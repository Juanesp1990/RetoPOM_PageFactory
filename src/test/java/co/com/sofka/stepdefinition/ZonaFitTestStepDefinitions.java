package co.com.sofka.stepdefinition;

import co.com.sofka.model.ZonaFitModel;
import co.com.sofka.page.ZonaFitPage;
import co.com.sofka.setup.WebUI;
import co.com.sofka.util.City;
import co.com.sofka.util.State;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;

public class ZonaFitTestStepDefinitions extends WebUI {

    private static final Logger LOGGER = Logger.getLogger(ZonaFitTestStepDefinitions.class);
    private static final String MESSAGE_OK = "PROCESO EXITOSO";
    private static final String MESSAGE_ERROR_OPEN = "Error Iniciando la página zonafit ";
    private static final String MESSAGE_ERROR_SELECT_PRODUCT = "Error en la selección de los productos";
    private static final String MESSAGE_ERROR_FIELDS = "Error llenando los campos";
    private static final String MESSAGE_ERROR_COMPARATION = "Error comparando la información";

    private ZonaFitModel cliente;
    private ZonaFitPage zonaFitPage;

    private ZonaFitModel clienteProduct;
    private ZonaFitPage zonaFitPageProduct;

    @Given("El cliente se encuentra en el portal de compras de la página de zonafit")
    public void elClienteSeEncuentraEnElPortalDeComprasDeLaPaginaDeZonafit () {
        try {
            generalSetUp();
            generateClient();

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            quiteDriver();
            Assertions.fail(MESSAGE_ERROR_OPEN);
        }

    }

    @When("el cliente ingresa a la opción de ofertas, selecciona los productos que desea comprar")
    public void elClienteIngresaALaOpcionDeOfertasSeleccionaLosProductosQueDeseaComprar () {
        try {
            zonaFitPage = new ZonaFitPage(cliente, super.driver);
            zonaFitPage.selectOffers();
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            quiteDriver();
            Assertions.fail(MESSAGE_ERROR_SELECT_PRODUCT);

        }

    }

    @When("el cliente llena el formulario de detalles del pago y confirma su acción")
    public void elClienteLlenaElFormularioDeDetallesDelPagoYConfirmaSuAccion () {
        try {
            zonaFitPage.fillMandatoryFields();
            zonaFitPage.selectPayment(true);
        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            quiteDriver();
            Assertions.fail(MESSAGE_ERROR_FIELDS);
        }
    }

    @Then("la página deberá mostrar un mensaje indicando pedido recibido")
    public void laPaginaDeberaMostrarUnMensajeIndicandoPedidoRecibido () {
        try {
            Assertions.assertEquals("Gracias. Tu pedido ha sido recibido.", zonaFitPage.isPresentMessage(), "");
            LOGGER.info(MESSAGE_OK);

        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
            Assertions.fail(MESSAGE_ERROR_COMPARATION);
        } finally {
            quiteDriver();
        }

    }

    /*condiciones segundo escenario*/

    @Given("El cliente se encuentra en el home de zonafit")
    public void elClienteSeEncuentraEnElHomeDeZonafit () {
        try {
            generalSetUp();
            generateClientTwo();

        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            quiteDriver();
            Assertions.fail(MESSAGE_ERROR_OPEN);
        }

    }

    @When("el cliente ingresa a la opción de más productos y selecciona que desea comprar")
    public void elClienteIngresaALaOpcionDeMasProductosQueDeseaComprar () {
        try {
            zonaFitPageProduct = new ZonaFitPage(clienteProduct, super.driver);
            zonaFitPageProduct.selectProduct();
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            quiteDriver();
            Assertions.fail(MESSAGE_ERROR_SELECT_PRODUCT);
        }

    }

    @When("el cliente llena el formulario de detalles del pago, selecciona Bancolombia y confirma su acción")
    public void elClienteLlenaElFormularioDeDetallesDelPagoSeleccionaBancolombiaYConfirmaSuAccion () {
        try {
            zonaFitPageProduct.fillMandatoryFields();
            zonaFitPageProduct.selectPayment(false);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            quiteDriver();
            Assertions.fail(MESSAGE_ERROR_FIELDS);
        }


    }

    @Then("la página deberá mostrar un código qr para realizar el pago")
    public void laPaginaDeberaMostrarUnCodigoQrParaRealizarElPago () {
        try {
            Assertions.assertTrue(zonaFitPageProduct.isPresentImg(), "");
            LOGGER.info(MESSAGE_OK);
        } catch (Exception e) {
            LOGGER.warn(e.getMessage());
            Assertions.fail(MESSAGE_ERROR_COMPARATION);
        } finally {
            quiteDriver();
        }

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

    private void generateClientTwo () {
        clienteProduct = new ZonaFitModel();
        clienteProduct.setDocumentNumber("1152426179");
        clienteProduct.setEmail("marce.agui@gmail.com");
        clienteProduct.setName("Marcela");
        clienteProduct.setLastName("Aguilar");
        clienteProduct.setState(State.ANTIOQUIA);
        clienteProduct.setCity(City.SABANETA_ANT);
        clienteProduct.setAddress("Calle 28 a n° 28-33");
        clienteProduct.setComplementaryAddress("apto 303");
        clienteProduct.setCellPhone("3214869753");
        clienteProduct.setNote(" La dirección es interna a la unidad, queda a dos cuadras del parque");
    }
}

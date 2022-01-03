package co.com.sofka.page;

import co.com.sofka.model.ZonaFitModel;
import co.com.sofka.page.common.CommonActionOnpages;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static io.cucumber.messages.internal.com.google.common.base.StandardSystemProperty.USER_DIR;

public class ZonaFitPage extends CommonActionOnpages {

    private final ZonaFitModel zonaFitModel;
    private static final Logger LOGGER = Logger.getLogger(ZonaFitPage.class);

    /*locators*/

    @CacheLookup
    @FindBy(xpath = "//a[@class='dashicons-tag mega-menu-link']")
    private WebElement ofertas;

    @CacheLookup
    @FindBy(xpath = "//a[@class='dashicons-plus-alt2 mega-menu-link']")
    private WebElement masProductos;

    @CacheLookup
    @FindBy(xpath = "//a[@class='dashicons-plus-alt2 mega-menu-link']")
    private WebElement ordenarPor;

    @CacheLookup
    @FindBy(xpath = "//option[@value='price']")
    private WebElement precioMenorMayor;

    @CacheLookup
    @FindBy(css = "input[data-brand='800']")
    private WebElement marcaZonaFit;

    @CacheLookup
    @FindBy(css = "input[data-brand='136']")
    private WebElement marcaUniversal;

    @CacheLookup
    @FindBy(css = "div[class='wc-proceed-to-checkout']")
    private WebElement buttonEndBuy;

    @CacheLookup
    @FindBy(id = "billing_myfield12")
    private WebElement numberDocument;

    @CacheLookup
    @FindBy(id = "billing_email")
    private WebElement email;

    @CacheLookup
    @FindBy(id = "billing_first_name")
    private WebElement name;

    @CacheLookup
    @FindBy(id = "billing_last_name")
    private WebElement lastName;

    @CacheLookup
    @FindBy(id = "select2-billing_state-container")
    private WebElement state;
    @FindBy(css = "input[class='select2-search__field']")
    private WebElement stateField;

    @CacheLookup
    @FindBy(id = "select2-billing_city-container")
    private WebElement city;
    @CacheLookup
    @FindBy(css = "input[class='select2-search__field']")
    private WebElement cityField;

    @CacheLookup
    @FindBy(id = "billing_address_1")
    private WebElement address;

    @CacheLookup
    @FindBy(id = "billing_address_2")
    private WebElement complementaryAddress;

    @CacheLookup
    @FindBy(id = "billing_phone")
    private WebElement cellphone;

    @CacheLookup
    @FindBy(id = "order_comments")
    private WebElement note;

    @CacheLookup
    @FindBy(id = "payment_method_bank_transfer_1")
    private WebElement paymentMethodBaloto;

    @CacheLookup
    @FindBy(id = "terms")
    private WebElement terms;

    @CacheLookup
    @FindBy(id = "place_order")
    private WebElement buttonOrden;

    @CacheLookup
    @FindBy(xpath = "//*[@id=\"main\"]/div[2]/div/div/div[2]/div/p/strong")
    private WebElement mensajePedidoRecibido;

    @CacheLookup
    @FindBy(xpath = "//img[@data-src='https://zonafit.co/qr.jpg']")
    private WebElement codigoQr;

    /*rute*/

    private static final String PAGE_BASE_PATCH = USER_DIR.value() + "\\src\\main\\resources\\page.zonafit\\";
    private static final String SELECT_PICTURE_ADD_CAR = PAGE_BASE_PATCH + "addCar.PNG";
    private static final String SELECT_PICTURE_SEE_CAR = PAGE_BASE_PATCH + "seeCar.PNG";
    private static final String SELECT_END_BUY = PAGE_BASE_PATCH + "endBuy.PNG";

    //constructor
    public ZonaFitPage (ZonaFitModel zonaFitModel, WebDriver webDriver) {
        super(webDriver);
        this.zonaFitModel = zonaFitModel;
        PageFactory.initElements(webDriver, this);

    }

    //functions
    public void selectOffers () {
        click(ofertas);
        click(ofertas);
        click(marcaZonaFit);
        selectTwoProduct();
    }

    public void selectProduct () {
        click(masProductos);
        click(masProductos);
        click(ordenarPor);
        click(precioMenorMayor);
        scrollDown();
        scrollDown();
        click(marcaUniversal);
        selectTwoProduct();
    }

    public void fillMandatoryFields () {
        try {
            click(buttonEndBuy);
            scrollDown();
            scrollUp();
            waitGeneral(numberDocument);
            clearText(numberDocument);
            typeInto(numberDocument, zonaFitModel.getDocumentNumber());
            clearText(email);
            typeInto(email, zonaFitModel.getEmail());
            clearText(name);
            typeInto(name, zonaFitModel.getName());
            clearText(lastName);
            typeInto(lastName, zonaFitModel.getLastName());

            scrollDown();
            click(state);
            clearText(stateField);
            typeInto(stateField, zonaFitModel.getState().getValue());
            pressEnter(stateField);

            click(city);
            clearText(cityField);
            typeInto(cityField, zonaFitModel.getCity().getValue());
            pressEnter(cityField);

            clearText(address);
            typeInto(address, zonaFitModel.getAddress());
            clearText(complementaryAddress);
            typeInto(complementaryAddress, zonaFitModel.getComplementaryAddress());
            clearText(cellphone);
            typeInto(cellphone, zonaFitModel.getCellPhone());
            clearText(note);
            typeInto(note, zonaFitModel.getNote());


        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
        }

    }

    public void selectPayment (boolean option) {
        scrollTo(paymentMethodBaloto);
        waitGeneral(terms);
        try {
            click(terms);
        } catch (Exception e) {
            LOGGER.info(e.getMessage());
            waitGeneral(terms);
            click(terms);
        }

        if (option == true) {
            waitGeneral(paymentMethodBaloto);
            try {
                click(paymentMethodBaloto);
            } catch (Exception e) {
                LOGGER.info(e.getMessage());
                waitGeneral(paymentMethodBaloto);
                click(paymentMethodBaloto);
            }
            scrollUp();
        }

        waitGeneral(paymentMethodBaloto);
        try {
            click(SELECT_END_BUY);
        } catch (Exception exceptione) {
            LOGGER.info(exceptione.getMessage());
            waitGeneral(paymentMethodBaloto);
            scrollUp();
            scrollDown();
            click(SELECT_END_BUY);
        }

        LOGGER.info("MELO CARAMELO");

    }

    public String isPresentMessage () {
        waitGeneral(mensajePedidoRecibido);
        return getText(mensajePedidoRecibido).trim();
    }

    public boolean isPresentImg () {
        try {
            waitGeneral(codigoQr);
            return getStatusElement(codigoQr);
        } catch (Exception exception) {
            return false;
        }
    }

    private void selectTwoProduct () {
        scrollDown();
        scrollDown();
        click(SELECT_PICTURE_ADD_CAR);

        click(SELECT_PICTURE_ADD_CAR);
        click(SELECT_PICTURE_SEE_CAR);
    }


}

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
    @FindBy(css = "input[data-brand='800']")
    private WebElement marca;

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

    /*rute*/

    private static final String PAGE_BASE_PATCH = USER_DIR.value() + "\\src\\main\\resources\\page.zonafit\\";
    private static final String SELECT_PICTURE_ADD_CAR = PAGE_BASE_PATCH + "addCar.PNG";
    private static final String SELECT_PICTURE_SEE_CAR = PAGE_BASE_PATCH + "seeCar.PNG";
    private static final String TERMS_CONDITIONS = PAGE_BASE_PATCH + "read.PNG";
    private static final String SELECT_END_BUY = PAGE_BASE_PATCH + "endBuy.PNG";

    //constructor
    public ZonaFitPage (ZonaFitModel zonaFitModel, WebDriver webDriver) {
        super(webDriver);
        this.zonaFitModel = zonaFitModel;
        PageFactory.initElements(webDriver, this);

    }


    //functions
    public void fillMandatoryFields () {
        try {
            click(ofertas);
            click(ofertas);

            click(marca);

            scrollDown();
            click(SELECT_PICTURE_ADD_CAR);
            scrollDown();
            click(SELECT_PICTURE_ADD_CAR);
            click(SELECT_PICTURE_SEE_CAR);

            click(buttonEndBuy);

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

            scrollTo(paymentMethodBaloto);

            waitGeneral(terms);
            waitClick(terms);
            //click(TERMS_CONDITIONS);

            waitClick(paymentMethodBaloto);

            scrollUp();
            waitGeneral(paymentMethodBaloto);
            //click(SELECT_END_BUY);

            LOGGER.info("MELO CARAMELO");

        } catch (Exception exception) {
            LOGGER.warn(exception.getMessage());
        }

    }

}

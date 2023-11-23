package steps;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.Formatter;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static org.hamcrest.MatcherAssert.assertThat;

public class LoansSteps {
    /* локаторы */
    private final String INPUT_FIELDS = "//input[contains(@class, ' form_float__input') and @name='application[%s]']";
    private SelenideElement submitButton = $(byXpath("//input[@type='submit']"));
    private final String ERRORS_IN_FIELD = "//span[@id='application_%s-error' and @class='form_float__error']";
    private final String PLUS_BUTTONS_IN_SLIDER = "//span[@role='slider%sPlus']";
    private final String ERROR_UNDER_SLIDER = "//div[@class = '%s_limitation small orange active']";

    /* получение элементов */
    @SafeVarargs
    public final SelenideElement getSelenideElement(String locator, Object... value) {
        return $(byXpath(new Formatter().format(locator, value).toString()));
    }

    /* проверка на наличие */
    public Boolean elementShouldHaveText(SelenideElement locator, String str) {
        return locator.is(text(str));
    }

    /* клик на элемент */
    public void clickOnElement(SelenideElement locator) {
        locator.scrollTo();
        locator.shouldBe(enabled).click();
    }

    /* работа со значениями */
    public void inputField(SelenideElement locator, String str) {
        locator.hover().shouldBe(enabled).setValue(str);
    }

    /* методы огурца :) */
    @Given("I open page {string}")
    public void iOpenWebSite(String arg0) {
        Selenide.open(arg0);
    }

    @When("I set value {string} in field {string}")
    public void iSetValueInField(String arg0, String arg1) {
        /* first_name, middle_initial, last_name, mobile_phone*/
        inputField(getSelenideElement(INPUT_FIELDS, arg1), arg0);
    }

    @When("I click on submit button")
    public void iClickOnButton() {
        clickOnElement(submitButton);
    }

    @Then("I see error {string} in field {string}")
    public void iSeeError(String arg0, String arg1) {
        assertThat("Error " + arg0 + " is not exist", elementShouldHaveText(getSelenideElement(ERRORS_IN_FIELD, arg1), arg0));
    }

    @When("I click {string} time on plus button in slider {string}")
    public void iScrollingSlider(String arg0, String arg1) {
        for (int i = 1; i <= Integer.parseInt(arg0); i++) {
            clickOnElement(getSelenideElement(PLUS_BUTTONS_IN_SLIDER, arg1));
        }
    }

    @Then("I see error {string} under {string} slider")
    public void iSeeErrorUnderSlider(String arg0, String arg1) {
        assertThat("Error " + arg0 + " is not exist", elementShouldHaveText(getSelenideElement(ERROR_UNDER_SLIDER, arg1), arg0));
    }
}
package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoansPage;

import java.io.IOException;

public class LoansSteps extends LoansPage {
    /* методы огурца :) */
    @Given("I open page {string}")
    public void iOpenWebSite(String arg0) throws IOException {
        app.init();
        app.base().openUrl(arg0);
    }

    @When("I set value {string} in field {string}")
    public void iSetValueInField(String arg0, String arg1) {
        setInputInField(arg1, arg0);
    }

    @When("I click on submit button")
    public void iClickOnSubmitButton() {
        clickOnSubmitButton();
    }

    @Then("I see error {string} in field {string}")
    public void iSeeError(String arg0, String arg1) {
        isErrorInFieldExist(arg1, arg0);
    }

    @When("I click {string} time on plus button in slider {string}")
    public void iScrollingSlider(String arg0, String arg1) {
        clickOnSliderButton(arg0, arg1);
    }

    @Then("I see error {string} under {string} slider")
    public void iSeeErrorUnderSlider(String arg0, String arg1) {
        isErrorUnderSliderExist(arg0, arg1);
    }
}
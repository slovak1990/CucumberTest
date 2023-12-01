package pages;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import ru.yandex.qatools.htmlelements.annotations.Name;
import tests.BaseTest;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class LoansPage extends BaseTest {
    /* локаторы */
    @Name("Инпуты ввода")
    private final String INPUT_FIELDS = "//input[contains(@class, ' form_float__input') and @name='application[%s]']";

    @Name("Кнопка подверждения")
    private SelenideElement submitButton = $(byXpath("//input[@type='submit']"));

    @Name("Текст ошибок в инпутах")
    private final String ERRORS_IN_FIELD = "//span[@id='application_%s-error' and @class='form_float__error']";

    @Name("Кнопка '+' в слайдере")
    private final String PLUS_BUTTONS_IN_SLIDER = "//span[@role='slider%sPlus']";

    @Name("Текст ошибки под слайдером")
    private final String ERROR_UNDER_SLIDER = "//div[@class = '%s_limitation small orange active']";


    /* Работа со значениями */
    @Step("Ввод значения {value} в поле {field}")
    public void setInputInField(String field, String value) {
        /* first_name, middle_initial, last_name, mobile_phone*/
        app.base().inputField(app.base().getSelenideElement(INPUT_FIELDS, field), value);
    }

    /* Клики на элементы */
    @Step("Нажать на кнопку подтверждения")
    public void clickOnSubmitButton() {
        app.base().clickOnElement(submitButton);
    }

    @Step("Кликнуть на кнопку {button} в слайдере в кол-ве {times} раз")
    public void clickOnSliderButton(String times, String button) {
        for (int i = 1; i <= Integer.parseInt(times); i++) {
            app.base().clickOnElement(app.base().getSelenideElement(PLUS_BUTTONS_IN_SLIDER, button));
        }
    }

    /* Проверки */
    @Step("Проверить наличие ошибки {error} в поле {field}")
    public boolean isErrorInFieldExist(String field, String error) {
        return app.base().elementShouldHaveText(app.base().getSelenideElement(ERRORS_IN_FIELD, field), error);
    }

    @Step("Проверить наличие ошибки {error} под слайдером {slider}")
    public boolean isErrorUnderSliderExist(String error, String slider) {
        return app.base().elementShouldHaveText(app.base().getSelenideElement(ERROR_UNDER_SLIDER, slider), error);
    }
}
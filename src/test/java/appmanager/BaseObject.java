package appmanager;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import java.util.Formatter;

import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class BaseObject {
    public MyAppManager app;

    public BaseObject(MyAppManager app) {
        this.app = app;
    }

    /* */
    @Step("Открыть сайт страницы")
    public void openUrl(String url) {
        open(url);
    }

    /* получение элементов */
    @SafeVarargs
    @Step("Получить элемент")
    public final SelenideElement getSelenideElement(String locator, Object... value) {
        return $(byXpath(new Formatter().format(locator, value).toString()));
    }

    /* проверка на наличие */
    @Step("Проверить наличие текста у элемента")
    public Boolean elementShouldHaveText(SelenideElement locator, String str) {
        return locator.is(text(str));
    }

    /* клик на элемент */
    @Step("Нажать на элемент")
    public void clickOnElement(SelenideElement locator) {
        locator.scrollTo();
        locator.shouldBe(enabled).click();
    }

    /* работа со значениями */
    @Step("Ввод текстового значения в поле")
    public void inputField(SelenideElement locator, String str) {
        locator.hover().shouldBe(enabled).setValue(str);
    }
}
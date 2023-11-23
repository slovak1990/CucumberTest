package hooks;

import com.codeborne.selenide.Selenide;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;

public class AfterStepsHook {
    // Действия совершаемые после каждого шага
    @AfterStep
    public void takeScreenShotAfterStep(Scenario scenario) {
        Selenide.screenshot(System.currentTimeMillis() + "steps");
    }
}
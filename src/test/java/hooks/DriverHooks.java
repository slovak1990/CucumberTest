package hooks;

import com.codeborne.selenide.Configuration;
import org.junit.Before;

public class DriverHooks {
    /**
     * Настройка таймаута для взаимодействия с элементами перед запуском тестов
     */
    @Before
    public void setUpDriverBeforeScenario(){
        Configuration.timeout = 60000;
    }
}
package tests;

import appmanager.MyAppManager;
import com.codeborne.selenide.Browsers;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.IOException;

public class BaseTest {
    protected static final MyAppManager app
            = new MyAppManager(System.getProperty("browser", Browsers.CHROME));

    @BeforeEach
    public void setUp() throws IOException {
        app.init();
    }

    @AfterEach
    public void tearDown() {
        app.stop();
    }
}
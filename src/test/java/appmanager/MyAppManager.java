package appmanager;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.WebDriverRunner;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.*;

public class MyAppManager {
    private BaseObject baseObject;
    private final String browser;
    private final Properties properties;

    public MyAppManager(String browser) {
        this.browser = browser;
        properties = new Properties();
    }

    public void init() throws IOException {
        String target = System.getProperty("target", "local");
        properties.load(new FileReader(String.format("src/test/resources/%s.properties", target)));
        Configuration.browser = browser;
        Configuration.timeout = 20000;
        Configuration.browserSize = properties.getProperty("browser.size");

        baseObject = new BaseObject(this);

    }

    public void stop() {
        if (WebDriverRunner.hasWebDriverStarted()) {
            localStorage().clear();
            clearBrowserCookies();
            closeWebDriver();
        }
    }

    public BaseObject base() {
            if (baseObject == null) {
                throw new RuntimeException("baseObject is not initialized. Call init() first.");
            }
            return baseObject;
    }
}
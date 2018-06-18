package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class FireFox implements IBrowser {

    @Override
    public WebDriver create() {
        String PATH_PROJECT=new File(".").getAbsolutePath().replace(".","");
        System.setProperty("webdriver.gecko.driver", PATH_PROJECT+"src\\test\\java\\drivers\\geckodriver.exe");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);

        FirefoxOptions options = new FirefoxOptions();
        options.addArguments("--enable-memory-info");
        options.addArguments("--no-sandbox");

        WebDriver driver = new FirefoxDriver(options);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        return driver;
    }
}
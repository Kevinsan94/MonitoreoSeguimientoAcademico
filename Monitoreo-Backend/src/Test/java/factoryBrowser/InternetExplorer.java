package factoryBrowser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public class InternetExplorer implements IBrowser {

    @Override
    public WebDriver create() {
        String PATH_PROJECT=new File(".").getAbsolutePath().replace(".","");
        System.setProperty("java.net.preferIPv4Stack", "true");
        System.setProperty("webdriver.ie.driver", PATH_PROJECT+"src\\test\\java\\drivers\\IEDriverServer.exe");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("credentials_enable_service", false);
        WebDriver driver = new InternetExplorerDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        return driver;
    }
}
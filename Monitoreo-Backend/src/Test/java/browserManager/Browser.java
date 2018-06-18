package browserManager;

import factoryBrowser.FactoryBrowser;
import org.openqa.selenium.WebDriver;

import java.io.IOException;

/**
 *
 */
public class Browser {

    private static Browser ourInstance = null;
    public WebDriver driver;

    /**
     * @return
     */
    public static Browser getCurrentSession() {
        if (ourInstance == null)
            ourInstance = new Browser();

        return ourInstance;
    }

    private Browser() {
        driver = FactoryBrowser.make(FactoryBrowser.CHROME).create();
    }

    public void closeBrowser() {
        driver.quit();
        ourInstance = null;
        try {
            Runtime.getRuntime().exec("TASKKILL /F /IM chrome.exe");
            Runtime.getRuntime().exec("taskkill /F /IM chromedriver.exe");
            Runtime.getRuntime().exec("taskkill /F /IM firefoxdriver.exe");
            Runtime.getRuntime().exec("taskkill /F /IM iedriver.exe");

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
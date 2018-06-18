package pages;

import control.Button;
import org.openqa.selenium.By;

public class Home {

    public Button updateStudentButton;
    public Button logoutButton;

    public Home() {
        updateStudentButton = new Button(By.id("update"));
        logoutButton = new Button(By.id("logout"));
    }
}

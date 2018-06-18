package pages;

import control.Button;
import control.TextBox;
import org.openqa.selenium.By;

public class Login {

    public TextBox codeTextBox;
    public TextBox passTextBox;
    public Button loginButton;

    public Login(){
        loginButton = new Button(By.id("subButton"));
        codeTextBox = new TextBox(By.id("user"));
        passTextBox = new TextBox(By.id("pass"));
    }
}

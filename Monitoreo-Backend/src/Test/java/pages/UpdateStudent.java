package pages;

import control.Button;
import control.Text;
import control.TextBox;
import org.openqa.selenium.By;

public class UpdateStudent {
    public TextBox codeTextBox;
    public TextBox nameTextBox;
    public TextBox lastNameTextBox;
    public TextBox numberTextBox;
    public TextBox emailTextBox;
    public TextBox passTextBox;
    public Button updateStudentButton;
    public Text verificationText;

    public UpdateStudent(){

        codeTextBox = new TextBox(By.id("codigo"));
        nameTextBox = new TextBox(By.id("nombre"));
        lastNameTextBox = new TextBox(By.id("apellido"));
        numberTextBox = new TextBox(By.id("fono"));
        emailTextBox = new TextBox(By.id("mail"));
        passTextBox = new TextBox(By.id("pass"));

        updateStudentButton = new Button(By.id("subUpdate"));

        verificationText = new Text(By.id("message"));
    }

}

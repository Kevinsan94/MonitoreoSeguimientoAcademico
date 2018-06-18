package pages;

import control.Button;
import control.Text;
import control.TextBox;
import org.openqa.selenium.By;

public class NotesInsert {

    public TextBox codeTextBox;
    public TextBox subjectTextBox;
    public TextBox firstTextBox;
    public TextBox secondTextBox;
    public TextBox thirdTextBox;
    public Button insertNotesButton;
    public Text verificationText;

    public NotesInsert(){
        codeTextBox = new TextBox(By.id("code"));
        subjectTextBox = new TextBox(By.id("subject"));
        firstTextBox = new TextBox(By.id("p1"));
        secondTextBox = new TextBox(By.id("p2"));
        thirdTextBox = new TextBox(By.id("p3"));

        insertNotesButton = new Button(By.id("subInsert"));

        verificationText = new Text(By.id("message"));
    }
}

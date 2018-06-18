package pages;

import control.Button;
import org.openqa.selenium.By;

public class Teacher {
    public Button insertNotesButton;

    public Teacher(){
        insertNotesButton = new Button(By.id("setGrades"));
    }
}

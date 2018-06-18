package control;

import org.openqa.selenium.By;

public class Text extends Control{
    public Text(By customLocator){
        this.locator=customLocator;
    }
}

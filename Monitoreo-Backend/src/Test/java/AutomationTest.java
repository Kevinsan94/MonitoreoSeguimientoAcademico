import browserManager.Browser;
import ch.qos.logback.core.net.SyslogOutputStream;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import pages.*;

public class AutomationTest {

    private static Login loginPage;
    private static Home homePage;
    private static Teacher teacherPage;
    private static UpdateStudent updateStudentPage;
    private static NotesInsert notesInsertPage;

    @BeforeClass
    public static void openBrowser(){
        loginPage = new Login();
        homePage = new Home();
        teacherPage = new Teacher();
        updateStudentPage = new UpdateStudent();
        notesInsertPage = new NotesInsert();
    }

    @Test
    public void verifyLogin () throws InterruptedException{

        Browser.getCurrentSession().driver.get("http://localhost:4200/login");
        loginPage.codeTextBox.set("admin");
        Thread.sleep(2000);
        loginPage.passTextBox.set("Prueba1234*");
        Thread.sleep(2000);
        loginPage.loginButton.click();
        Thread.sleep(2000);

        Assert.assertTrue("Error no se pudo entrar al sistema",
                homePage.logoutButton.isDisplayed());

        Assert.assertEquals("Error, no se pudo logear",
                "LOGOUT",
                homePage.logoutButton.getTextValue());

        Thread.sleep(2000);
    }

    @Test
    public void verifyUpdateStudent () throws InterruptedException{

        Browser.getCurrentSession().driver.get("http://localhost:4200/login");
        loginPage.codeTextBox.set("admin");
        Thread.sleep(2000);
        loginPage.passTextBox.set("Prueba1234*");
        Thread.sleep(2000);
        loginPage.loginButton.click();
        Thread.sleep(2000);
        homePage.updateStudentButton.click();
        Thread.sleep(2000);
        updateStudentPage.codeTextBox.set("28715");
        Thread.sleep(2000);
        updateStudentPage.nameTextBox.set("Kevin");
        Thread.sleep(2000);
        updateStudentPage.lastNameTextBox.set("Viscafe");
        Thread.sleep(2000);
        updateStudentPage.numberTextBox.set("71224896");
        Thread.sleep(2000);
        updateStudentPage.emailTextBox.set("kevinviscafe@hotmail.com");
        Thread.sleep(2000);
        updateStudentPage.passTextBox.set("Prueba1234*");
        Thread.sleep(2000);

        updateStudentPage.updateStudentButton.click();
        Thread.sleep(2000);

        Assert.assertEquals("Error",
                "Correctly updated",
                updateStudentPage.verificationText.getTextValue());

        Thread.sleep(2000);
    }

    @Test
    public void verifyInsertNotes () throws InterruptedException {
        Browser.getCurrentSession().driver.get("http://localhost:4200/login");
        loginPage.codeTextBox.set("2871");
        Thread.sleep(2000);
        loginPage.passTextBox.set("Alexis1234*");
        Thread.sleep(2000);
        loginPage.loginButton.click();
        Thread.sleep(2000);

        teacherPage.insertNotesButton.click();
        Thread.sleep(2000);

        notesInsertPage.codeTextBox.set("28715");
        Thread.sleep(2000);
        notesInsertPage.subjectTextBox.set("Test1");
        Thread.sleep(2000);
        notesInsertPage.firstTextBox.set("80");
        Thread.sleep(2000);
        notesInsertPage.secondTextBox.set("34");
        Thread.sleep(2000);
        notesInsertPage.thirdTextBox.set("96");
        Thread.sleep(2000);
        notesInsertPage.insertNotesButton.click();
        Thread.sleep(2000);

        Assert.assertEquals("Error",
                "Correctly inserted",
                notesInsertPage.verificationText.getTextValue());

    }

    @AfterClass
    public  static void closeBrowser(){
        Browser.getCurrentSession().closeBrowser();
    }

}

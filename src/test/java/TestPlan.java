import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestPlan {
    private static final WebDriver driver = new ChromeDriver();

    @BeforeSuite
    public static void main(String[] args) {
        // ChromeDriver location set up in Utils class
            System.setProperty("webdriver.chrome.driver", Utils.CHROME_DRIVER_LOCATION);
    }

    @Test(testName = "Check if firstname exists")
    public static void firstNameExists(){
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        Assert.assertTrue(webForm.FirstnameExist());
    }
    @Test(testName = "Check if middlename exists")
    public static void middleNameExists(){
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        Assert.assertTrue(webForm.MiddlenameExist());
    }
    @Test(testName = "Check if last name exists")
    public static void lastNameExists(){
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        Assert.assertTrue(webForm.LastnameExist());
    }
    @Test(testName = "Check if math exists")
    public static void mathExists(){
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        Assert.assertTrue(webForm.mathExist());
    }
    @Test(testName = "Check if Registration form Exists after redirect")
    public static void submitForm(){
        driver.get(Utils.BASE_URL);
        WebForm webForm = new WebForm(driver);
        webForm.enterNames();
        webForm.pressSubmitButton();
        Assert.assertTrue(webForm.verifyRegistrationPage());
    }
    @AfterSuite
    public static void cleanUp(){
        driver.manage().deleteAllCookies();
        driver.close();
    }
}

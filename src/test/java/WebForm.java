import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class WebForm extends PageObject{

    private final String FIRST_NAME = "First Name";
    private final String LAST_NAME = "Last Name";
    private final String MIDDLE_NAME = "Middle Name";
    private final String EMAIL = "test@gmail.com";
    @FindBy(id = "first_4")
    private WebElement first_name;

    @FindBy(id = "last_4")
    private WebElement last_name;

    @FindBy(id = "middle_4")
    private WebElement middle_name;

    @FindBy(id = "input_6")
    private WebElement email;

    @FindBy(id="input_46")
    private WebElement ddl_subject;

    @FindBy(xpath = "//*[@id=\'input_20\']")
    private WebElement submit_button;

    @FindBy(xpath = "//*[@id=\'header_1\']")
    private WebElement registrationHeader;

    public WebForm(WebDriver driver) {
        super(driver);
    }

    public void enterFirstName(){
        this.first_name.sendKeys(FIRST_NAME);
    }

    public void enterLastName(){
        this.last_name.sendKeys(LAST_NAME);
    }
    public void enterNames()
    {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.tagName("object")));
        enterFirstName();
        enterMiddleName();
        enterLastName();
        enterEmail();
        driver.switchTo().parentFrame();
    }
    public void enterMiddleName(){
        this.middle_name.sendKeys(MIDDLE_NAME);
    }
    public void enterEmail(){
        this.email.sendKeys(EMAIL);
    }

    public void pressSubmitButton(){
        driver.switchTo().frame(driver.findElement(By.tagName("object")));
        this.submit_button.click();
        driver.switchTo().parentFrame();
        try {
            Thread.sleep(7000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public boolean FirstnameExist() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.tagName("object")));
        boolean result= this.first_name.isDisplayed();
        driver.switchTo().parentFrame();
        return result;

    }
    public boolean MiddlenameExist() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.tagName("object")));
        boolean result= this.middle_name.isDisplayed();
        driver.switchTo().parentFrame();
        return result;

    }
    public boolean LastnameExist() {
        driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.tagName("object")));
        boolean result= this.last_name.isDisplayed();
        driver.switchTo().parentFrame();
        return result;
    }
    public boolean emailExist() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.tagName("object")));
        boolean result= this.email.isDisplayed();
        driver.switchTo().parentFrame();
        return result;
    }
    public boolean mathExist() {
        driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
        driver.switchTo().frame(driver.findElement(By.tagName("object")));
        boolean result= false;

        WebElement myDropDown=driver.findElement(By.id("input_46"));
        String dropdownText=myDropDown.getText();
        if(dropdownText.indexOf("Math 101") !=-1)
        {
            result=true;
        }
        driver.switchTo().parentFrame();
        return result;

    }
    public boolean verifyRegistrationPage() {
        driver.switchTo().frame(driver.findElement(By.tagName("object")));
        boolean result=this.registrationHeader.getText().equalsIgnoreCase("Student Registration Form");
        driver.switchTo().parentFrame();
        return result;
    }
}

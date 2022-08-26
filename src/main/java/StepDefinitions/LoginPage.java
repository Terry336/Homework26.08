package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;

public class LoginPage {

//    @FindBy(id= "user-name")
//    private WebElement username;
//    @FindBy(id = "password")
//    private WebElement password;
//    @FindBy(id= "login-button")
//    private WebElement loginBtn;


    WebDriver driver;

    private By Username = By.id("user-name");
    private By Password = By.id("password");
    private By LoginButton = By.id("login-button");
    public LoginPage(WebDriver driver) {
        this.driver = driver;}

        public void EnterUserNameAndPass(String username, String password){
        driver.findElement(Username).sendKeys(username);
        driver.findElement(Password).sendKeys(password);
    }
    public void ClickLoginButton(){
        System.out.println("Button click called");
        driver.findElement(LoginButton).click();
    }

}

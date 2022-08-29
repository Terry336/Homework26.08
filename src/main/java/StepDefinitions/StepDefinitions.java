package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class StepDefinitions {

    public WebDriver driver;
    LoginPage login;
    public WebDriverWait wait;

    @Before
    public void BeforeEachTest() {
        String projectPath = System.getProperty("user.dir");
        System.setProperty("webdriver.chrome.driver", projectPath + "/src/main/resources/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        login = new LoginPage(driver);
    }




    @Given("user navigates to login page")
    public void user_navigates_to_login_page() {
        login = new LoginPage(driver);
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @When("^user enters (.*) and (.*)$")
    public void user_enters_username_and_password(String username, String password) {
        login.EnterUserNameAndPass(username, password);
//        login.EnterUserNameAndPass(username, password);
//        driver.findElement(By.id("user-name")).sendKeys(username);
//        driver.findElement(By.id("password")).sendKeys(password);
    }



    @When("clicks log in")
    public void clicks_log_in() {
        login.ClickLoginButton();
//      driver.findElement(By.id("login-button")).click();
    }

    @When("selects an item and add it to cart")
    public void selects_an_item_and_add_it_to_cart() {
        driver.findElement(By.id("add-to-cart-sauce-labs-bolt-t-shirt")).click();
    }

    @Then("user goes to the cart and verifies that the item is added")
    public void user_goes_to_the_cart_and_verifies_that_the_item_is_added() {
        driver.findElement(By.className("shopping_cart_link")).click();
        WebElement itemAdded= driver.findElement(By.xpath("//div[@class='inventory_item_name']"));
        Assert.assertEquals("Sauce Labs Bolt T-Shirt", itemAdded.getText());
    }

    @After
    public void AfterEachTest() {
        driver.quit();
    }
}

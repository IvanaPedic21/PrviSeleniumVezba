import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Testtest {
    @Test

    public void loginTest(){

        WebDriver driver = new ChromeDriver();
//        driver.get("https://www.google.com/");
        driver.get("https://www.saucedemo.com/");
        WebElement userNameField = driver.findElement(By.name("user-name"));
        userNameField.click();
        userNameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("inventory") : "Error Wrong URL. Expected to be on inventory page, but I'm on " + currentUrl;

        WebElement titleOfPage = driver.findElement(By.className("title"));
        String currentTitleText = titleOfPage.getText();
        assert currentTitleText.equals("PRODUCTS"): "Wrong title, Expected 'PRODUCTS'. Actual: " + currentTitleText;

        driver.quit();

    }

@Test
    public void invalidUsernameValidPasword (){

    WebDriver driver = new ChromeDriver();
    driver.get("https://www.saucedemo.com/");

    System.out.println ("[TEST] Entering invalid username");
    WebElement userNameField = driver.findElement(By.name("user-name"));
    userNameField.sendKeys("invalid_user");

    System.out.println("[TEST] Entering valid password");
    WebElement passwordField = driver.findElement(By.id("password"));
    passwordField.sendKeys("secret_sauce");

    System.out.println("[TEST] Clicking Login button");
    WebElement loginButton = driver.findElement(By.id("login-button"));
    loginButton.click();

    System.out.println("[TEST] Clicking Login button");
    String cuurentURL = driver.getCurrentUrl();
    assert cuurentURL.equals("https://www.saucedemo.com/") :"Error Wrong URL. Expected to be on Login page, but I'm on " + cuurentURL;

    WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test = 'error']"));
    assert errorMessage.isDisplayed(): "Error message is not displayed";
    String errorMessageText = errorMessage.getText();
    assert errorMessageText.equals("Epic sadface: Username and password do not match any user in this service"): "Wrong error." +
            "Expected: Epic sadface: Username and pasword do not match any user in this service. Actual:"+errorMessageText;


    driver.quit();
    }

@Test

    public void invalidUsernameInvalidPassword(){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        stampaj("[TEST] Entering invalid username");
        WebElement usernameField = driver.findElement(By.name("user-name"));
        usernameField.click();
        usernameField.sendKeys("locked_out_user");

        stampaj("[TEST] Entering invalid passwoord ");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("nije");

        stampaj("[TEST] Clicking login button");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        stampaj("[TEST] Checking error message, is it displayed ");
        WebElement errorMessage = driver.findElement(By.xpath("//h3[@@data-test = 'error'"));
        assert errorMessage.isDisplayed(): "Error message is not displayed";

         stampaj ( "[TEST] Checking error message, is it wright message" );
         String errorMessageText = errorMessage.getText();
         assert errorMessageText.equals("Epic sadface: Username and password do not match any user in this service" ):"Wrong error." +
                 "Expected: Epic sadface: Username and password do not match any user in this service.Actual:"+errorMessageText;

        driver.quit();

}

    public static void stampaj(String s) {
        System.out.println("s");
    }



}




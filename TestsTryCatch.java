import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class TestsTryCatch {

    @Test
    public void invalidUsernameValidPasword (){

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        sleep();

        System.out.println ("[TEST] Entering invalid username");
        WebElement userNameField = driver.findElement(By.name("user-name"));
        userNameField.sendKeys("invalid_user");

        sleep();

        System.out.println("[TEST] Entering valid password");
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        sleep();

        System.out.println("[TEST] Clicking Login button");
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        sleep();

        System.out.println("[TEST] Clicking Login button");
        String cuurentURL = driver.getCurrentUrl();
        assert cuurentURL.equals("https://www.saucedemo.com/") :"Error Wrong URL. Expected to be on Login page, but I'm on " + cuurentURL;

        sleep();

        WebElement errorMessage = driver.findElement(By.xpath("//h3[@data-test = 'error']"));
        assert errorMessage.isDisplayed(): "Error message is not displayed";
        String errorMessageText = errorMessage.getText();
        assert errorMessageText.equals("Epic sadface: Username and password do not match any user in this service"): "Wrong error." +
                "Expected: Epic sadface: Username and password do not match any user in this service. Actual:"+errorMessageText;


        driver.quit();
    }

    private void sleep() {
        try {
            Thread.sleep(1000);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }

    }

}

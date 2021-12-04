import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

public class ResetTest {



    @Test

    public void testResetApp() {
        WebDriver driver = login();
        WebElement bikeLightAddToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        bikeLightAddToCartButton.click();
        sleep();
        WebElement shoppingCarIcontBadge = driver.findElement(By.className("shopping_cart_badge"));
        sleep();
        String numberInShoppingCartIconBadge = shoppingCarIcontBadge.getText();
        assert numberInShoppingCartIconBadge.equals("1") : "Error. Expected 1.Actual:" + numberInShoppingCartIconBadge;
        sleep();
        WebElement burgerMenu = driver.findElement(By.id("react-burger-menu-btn"));
        burgerMenu.click();
        sleep();
        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("react-burger-cross-btn")));
        sleep();
        WebElement resetButton = driver.findElement(By.id("reset_sidebar_link"));
        resetButton.click();
        sleep();
        driver.quit();
    }
    private void sleep() {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public WebDriver login(){
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        WebElement userNameField = driver.findElement(By.name("user-name"));
        userNameField.click();
        userNameField.sendKeys("standard_user");
        sleep();
        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");
        sleep();
        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();
        sleep();
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("inventory") : "Error Wrong URL. Expected to be on inventory page, but I'm on " + currentUrl;
        return driver;

    }

}




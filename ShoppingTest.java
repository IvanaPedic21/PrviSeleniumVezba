import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class ShoppingTest {

    @Test

    public void testAddItemToCartAndBuyIt() {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");

        WebElement usernameField = driver.findElement(By.name("user-name"));
        usernameField.click();
        usernameField.sendKeys("standard_user");

        WebElement passwordField = driver.findElement(By.id("password"));
        passwordField.sendKeys("secret_sauce");

        WebElement loginButtonField = driver.findElement(By.id("login-button"));
        loginButtonField.click();

        String currentURL = driver.getCurrentUrl();
        assert currentURL.contains("inventory") : "Error. Wrong URL. Expected to be on inventory page, but I'm on" + currentURL;

        WebElement bikeLightAddToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-bike-light"));
        bikeLightAddToCartButton.click();

        WebElement bikeLightRemoveItem = driver.findElement(By.id("remove-sauce-labs-bike-light"));
        assert bikeLightRemoveItem.isDisplayed() : "Remove button is not displayed";

        WebElement shoppingCarIcontBadge = driver.findElement(By.className("shopping_cart_badge"));
        String numberInShoppingCartIconBadge = shoppingCarIcontBadge.getText();
        assert numberInShoppingCartIconBadge.equals("1") : "Error. Expected 1.Actual:" + numberInShoppingCartIconBadge;

        WebElement shoppingCartIcon = driver.findElement(By.className("shopping_cart_link"));
        shoppingCartIcon.click();

        String currentUrl = driver.getCurrentUrl();
        assert currentUrl.contains("cart") : "Error. Wrong URL. Expected to be on cart page, but I'm on" + currentURL;

        WebElement itemInCart = driver.findElement(By.className("inventory_item_name"));
        String itemInCartTitle = itemInCart.getText();
        assert itemInCartTitle.contains("Bike Light") : "Error";

        WebElement checkoutButton = driver.findElement(By.xpath("//button [text() = 'Checkout']"));
        checkoutButton.click();

        WebElement firstName = driver.findElement(By.id("first-name"));
        firstName.sendKeys("Ivana");
        WebElement lastName = driver.findElement(By.id("last-name"));
        lastName.sendKeys("Pedic");
        WebElement zipPostalCode = driver.findElement(By.id("postal-code"));
        zipPostalCode.sendKeys("26101");

        WebElement continueButton = driver.findElement(By.xpath("//input[contains(@class, 'submit-button')]"));
        continueButton.click();


        WebElement finishButton = driver.findElement(By.id("finish"));
        finishButton.click();

        driver.quit();

    }
}



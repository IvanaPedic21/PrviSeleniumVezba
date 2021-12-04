import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.List;

public class SortItems {

    @Test


    public void testSortItemsByPriceAsc(){
        WebDriver driver = login();
        List<WebElement> unsortedList = driver.findElements(By.className("inventory_item"));
        for (WebElement e : unsortedList) {
            String itemName = e.findElement(By.className("inventory_item_name")).getText();
            String price = e.findElement(By.className("inventory_item_price")).getText();
            System.out.println("Cena za:" + itemName + "je" + price);
        }
//        Select dropDownMenu = new Select(driver.findElement(By.className("product_sort_container")));
//        dropDownMenu.selectByVisibleText("Price (low to high)");

        WebElement dropDownMenu = driver.findElement(By.className("product_sort_container"));
        dropDownMenu.click();

        WebElement sortByHighToLow = dropDownMenu.findElement(By.xpath("//option[text() = 'Price (low to high)']"));
        sortByHighToLow.click();

        List<WebElement> sortedList = driver.findElements(By.className("inventory_item"));
        for (WebElement e : sortedList) {
            String itemName = e.findElement(By.className("inventory_item_name")).getText();
            String price = e.findElement(By.className("inventory_item_price")).getText();
            System.out.println("Cena za:" + itemName + "je" + price);
        }
        String firstItemUnsorted = unsortedList.get(0).findElement(By.className("inventory_item_price")).getText().replace("$" ,"");
        double firstItemUnsortedValue = Double.valueOf(firstItemUnsorted);

        String firstItemSorted = sortedList.get(0).findElement(By.className("inventory_item_price")).getText().replace("$" , "");
        double firstItemSortedValue = Double.valueOf(firstItemSorted);

        assert firstItemUnsortedValue >= firstItemSortedValue : "Error. Items are not sorted";
        driver.quit();

    }

    public WebDriver login(){
        WebDriver driver = new ChromeDriver();
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
        return driver;

    }

}



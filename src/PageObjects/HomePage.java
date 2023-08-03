package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage {
    private WebDriver driver;

    public HomePage(WebDriver driver) {
        this.driver = driver;
    }

    public void navigateToCompanyCareers() {
        driver.findElement(By.linkText("Company")).click();
        driver.findElement(By.linkText("Careers")).click();
    }
}

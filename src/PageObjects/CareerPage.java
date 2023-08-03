package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CareerPage {
    private WebDriver driver;

    public CareerPage(WebDriver driver) {
        this.driver = driver;
    }

    public void checkCareerPageSections() {
        assert driver.findElement(By.id("locations")).isDisplayed();
        assert driver.findElement(By.id("teams")).isDisplayed();
        assert driver.findElement(By.id("life")).isDisplayed();
    }

    public void navigateToQAJobs() {
        driver.get("https://useinsider.com/careers/quality-assurance/");
        driver.findElement(By.linkText("See all QA jobs")).click();
    }
}

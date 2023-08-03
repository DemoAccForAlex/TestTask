package PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.List;

public class JobsPage {
    private WebDriver driver;

    public JobsPage(WebDriver driver) {
        this.driver = driver;
    }

    public void filterJobs() {
        driver.findElement(By.id("location-filter")).sendKeys("Istanbul, Turkey");
        driver.findElement(By.id("department-filter")).sendKeys("Quality Assurance");
    }

    public void checkJobs() {
        List<WebElement> jobs = driver.findElements(By.className("job-listing"));
        for (WebElement job : jobs) {
            assert job.findElement(By.className("position")).getText().contains("Quality Assurance");
            assert job.findElement(By.className("department")).getText().contains("Quality Assurance");
            assert job.findElement(By.className("location")).getText().contains("Istanbul, Turkey");
        }
    }

    public void viewRole() {
        driver.findElement(By.linkText("View Role")).click();
    }
}

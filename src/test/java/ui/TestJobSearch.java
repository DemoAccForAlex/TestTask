package test.java.ui;

import PageObjects.CareerPage;
import PageObjects.HomePage;
import PageObjects.JobsPage;
import jdk.javadoc.internal.doclets.toolkit.util.DocFile;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;

public class TestJobSearch {
    private static DocFile FileUtils;

    public static void main(String[] args) {
        testCase("chrome");
        testCase("firefox");
    }

    public static void testCase(String browser) {
        WebDriver driver;

        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "/Users/oleksandr.serhieiev/Downloads/chromedriver_mac64/chromedriver");
            driver = new ChromeDriver();
//        } else {
//            System.setProperty("webdriver.gecko.driver", "/Users/oleksandr.serhieiev/Downloads/geckoFolder/geckodriver");
//            driver = new FirefoxDriver();
//        }

            try {
                driver.get("https://useinsider.com/");
                assert driver.getTitle().contains("Insider");

                // Navigate to the Careers page
                HomePage homePage = new HomePage(driver);
                homePage.navigateToCompanyCareers();

                // Check Career page and navigate to QA jobs
                CareerPage careerPage = new CareerPage(driver);
                careerPage.checkCareerPageSections();
                careerPage.navigateToQAJobs();

                // Filter jobs and check job details
                JobsPage jobsPage = new JobsPage(driver);
                jobsPage.filterJobs();
                jobsPage.checkJobs();
                jobsPage.viewRole();

                // Check redirection to Lever Application form page
                assert driver.getCurrentUrl().contains("lever.co");
            } catch (AssertionError e) {
                // Take a screenshot if the test fails
                File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                File destFile = new File("test_failure.png");

                e.printStackTrace();
            } finally {
                driver.quit();
            }
        }
    }
}

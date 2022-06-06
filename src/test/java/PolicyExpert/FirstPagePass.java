package PolicyExpert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;




public class FirstPagePass extends ClientDetails {
        private final String URL = "https://insurance.policyexpert.co.uk/home/section/about-you";
        WebDriver driver;


    @BeforeTest

    public void setup() throws InterruptedException {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().fullscreen();
        driver.get(URL);
        Thread.sleep(500);

    }


    @Test
    public void firstUiTest() throws InterruptedException {

        //choose title
        WebElement chooseTitle = driver.findElement(By.xpath("//*[text()='Mr']"));
        chooseTitle.click();


        //insert name and surname
        driver.findElement(By.id("first_name")).sendKeys(name);
        driver.findElement(By.id("last_name")).sendKeys(surname);


        //insert Day of Birth
        driver.findElement(By.id("policyholder_date_of_birth.day")).sendKeys(day); //day
        driver.findElement(By.id("policyholder_date_of_birth.month")).sendKeys(month); //month
        driver.findElement(By.id("policyholder_date_of_birth.year")).sendKeys(year); //year


        // choose marital status
        WebElement materialStatus = driver.findElement(By.xpath("//*[text()='Married']"));
        materialStatus.click();


        //occupation, choose "Art Director" from the option list
        driver.findElement(By.cssSelector("[name='occupation']")).sendKeys("dire");
        Thread.sleep(1500);
        WebElement firstOccupation = driver.findElement(By.id("downshift-0-item-1"));
        firstOccupation.click();


        // choose option "No" for additional occupation
        WebElement buttonNo = driver.findElement(By.cssSelector("[aria-label='No']"));
        buttonNo.click();


        // insert phone number and email
        driver.findElement(By.id("primary_phone_number")).sendKeys(phone);
        driver.findElement(By.id("customer_email")).sendKeys(email);


        //"next" button click
        driver.findElement(By.cssSelector("[data-di-id='di-id-8186e128-e8850100']")).click();

    }


    @AfterTest
    public void endTest() throws InterruptedException {

        Thread.sleep(3500);
        driver.quit();

    }


}

package stepdefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;
import java.util.Map;


public class MyStepdefs {

    WebDriverWait wait;
     WebDriver driver;

    @Given("I am on the right page")
    public void iAmOnTheRightPage() {

        driver = new ChromeDriver();

        //driver = new SafariDriver();

        driver.get("https://membership.basketballengland.co.uk/NewSupporterAccount");
    }

    @When("I put all the login info {string}, {string}, {string}, {string}, {string}, {string}")
    public void iPutAllTheLoginInfo(String dateOfBirth, String forename, String surname, String email, String password, String confirmpassword) throws InterruptedException {

        //List<Map<String, String>> data = table.asMaps(String.class, String.class);

        //WebElement date = driver.findElement(By.name("14/02/2002"));
        WebElement date = driver.findElement(By.name("DateOfBirth"));
        //date.sendKeys(data.get(0).get("DateOfBirth"));
        date.sendKeys(dateOfBirth);
        Thread.sleep(1000);

        //WebElement firstName = driver.findElement(By.name("Nahom"));
        WebElement firstName = driver.findElement(By.name("Forename"));
        //firstName.sendKeys(data.get(0).get("FirstName"));
        firstName.sendKeys(forename);
        Thread.sleep(1000);

        //WebElement lastName = driver.findElement(By.name("Tesfay"));
        WebElement lastName = driver.findElement(By.name("Surname"));
        //lastName.sendKeys(data.get(0).get("LastName"));
        lastName.sendKeys(surname);
        Thread.sleep(1000);

        //WebElement mail = driver.findElement(By.name("Nahomt50@mailnesia.com"));
        WebElement mail = driver.findElement(By.name("EmailAddress"));
        //email.sendKeys(data.get(0).get("Email"));
        mail.sendKeys(email);
        Thread.sleep(1000);

        //WebElement emailConfirmation = driver.findElement(By.name("Nahomt50@mailnesia.com"));
        WebElement emailConfirmation = driver.findElement(By.name("ConfirmEmailAddress"));
        //emailConfirmation.sendKeys(data.get(0).get("ConfirmEmail"));
        emailConfirmation.sendKeys(email);
        Thread.sleep(1000);

        //WebElement password = driver.findElement(By.name("1234.Tesfay"));
        WebElement passwordElement = driver.findElement(By.name("Password"));
        //password.sendKeys(data.get(0).get("Password"));
        passwordElement.sendKeys(password);
        Thread.sleep(1000);

        //WebElement passwordConfirmation = driver.findElement(By.name("1234.Tesfay"));
        WebElement passwordConfirmation = driver.findElement(By.name("ConfirmPassword"));
        //passwordConfirmation.sendKeys(data.get(0).get("ConfirmPassword"));
        passwordConfirmation.sendKeys(confirmpassword);
        Thread.sleep(1000);

    }

    @And("Click the right boxes")
    public void clickTheRightBoxes() throws InterruptedException {

        //Check this out
        WebElement termsAndConditions = driver.findElement(By.cssSelector("label[for='sign_up_25']"));
        termsAndConditions.click();
        Thread.sleep(500);

        WebElement ageConsent = driver.findElement(By.cssSelector("label[for='sign_up_26']"));
        ageConsent.click();
        Thread.sleep(500);

        WebElement consent = driver.findElement(By.cssSelector("label[for='fanmembersignup_agreetocodeofethicsandconduct']"));
        consent.click();
        Thread.sleep(500);

        WebElement join = driver.findElement(By.name("join"));
        join.click();
        Thread.sleep(500);
    }

    @Then("I will get to the confirmation page")
    public void iWillGetToTheConfirmationPage() {

         wait = new WebDriverWait(driver, Duration.ofSeconds(5));

       wait.until(ExpectedConditions.urlContains("SignUpConfirmation"));

        boolean urlContainsConfirmation = wait.until(ExpectedConditions.urlContains("SignUpConfirmation"));
        Assert.assertTrue("The URL does not contain 'SignUpConfirmation'", urlContainsConfirmation);

    }

    @Then("I will get error message")
    public void iWillGetErrorMessage() {

        wait = new WebDriverWait(driver, Duration.ofSeconds(5));

        WebElement joinButton = driver.findElement(By.name("join"));

        Assert.assertTrue("Error, the submitted information is wrong", joinButton.isEnabled());

        List<WebElement> errorMessages = driver.findElements(By.cssSelector(".field-validation-error"));

        boolean atLeastOneErrorVisible = errorMessages.stream().anyMatch(WebElement::isDisplayed);

        Assert.assertTrue("Expected at least one error message to be visible, but none were.", atLeastOneErrorVisible);
        
        }

    }

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MakeAppointmentPage {
    private WebDriver driver;
    private By makeAppointment_message = By.xpath("//*[@id=\"appointment\"]/div/div/div/h2");
    private By BookAppointment = By.id("btn-book-appointment");

    private By Facility = By.name("facility");
    private By reAdmission = By.tagName("input[type='checkbox']");
    private By healthcareProgram1 = By.tagName("//input[@id='radio_program_medicare']");
    private By healthcareProgram2 = By.tagName("//input[@id='radio_program_medicaid']");
    private By healthcareProgram3 = By.tagName("//input[@id='radio_program_none']");
    private By datePicker = By.xpath("//*[@id='txt_visit_date']");
    private By commentsArea = By.tagName("//textarea[@class='form-control']");
    private By bookAppointmentBtn = By.id("btn-book-appointment");
    private By ConfirmationMessage = By.tagName("//a[text()='Go to Homepage']");

    public MakeAppointmentPage(WebDriver driver) {
        this.driver = driver;
    }

    public String getFlashMessage(){

    return driver.findElement(makeAppointment_message).getText();
    }


    public String _getConfirmationMessage() {

        return driver.findElement(ConfirmationMessage).getText();
    }

    public void setFacility(String facility) {
        driver.findElement(Facility).sendKeys(facility);
    }


    public void setReAdmission(String checkbox) {
        driver.findElement(reAdmission).sendKeys(checkbox);
    }

    public void setProgram1(String healthcareProgram) {
        driver.findElement(healthcareProgram1).click();
    }

    public void setProgram2(String healthcareProgram) {
        driver.findElement(healthcareProgram2).click();
    }

    public void setProgram3(String healthcareProgram) {
        driver.findElement(healthcareProgram3).click();
    }

    public void setVisitDate(String datePicker) {
        driver.findElement(By.id(datePicker)).click();
    }


    public void setComments(String comments) {
        driver.findElement(commentsArea).sendKeys(comments);
    }

    public BookAppointmentPage clickAppointmentBtn() {
        driver.findElement(BookAppointment).click();
        return new BookAppointmentPage(driver);
    }
}



















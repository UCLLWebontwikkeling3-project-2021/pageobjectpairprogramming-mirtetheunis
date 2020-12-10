import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

//Thao De Clercq - Mirte Theunis

public class LogInPage extends Page{

    @FindBy(id="userId")  // verander
    private WebElement useridField;

    @FindBy(id="password")
    private WebElement passwordField;

    @FindBy(id="logIn")
    private WebElement logInButton;


    public LogInPage(WebDriver driver) {
        super(driver);
        this.driver.get(getPath()+"?command=LogIn");
    }

    public void setUserid(String userid) {
        useridField.clear();
        useridField.sendKeys(userid);
    }

    public void setPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public LogInPage submit() {
        logInButton.click();
        return PageFactory.initElements(driver, LogInPage.class);
    }


    public boolean hasErrorMessage (String message) {
        WebElement errorMsg = driver.findElement(By.cssSelector("div.alert-danger ul li"));
        return (message.equals(errorMsg.getText()));
    }

    public boolean hasWelcomeMessage (String message) {
        WebElement welcomeMsg = driver.findElement(By.cssSelector("h2"));
        return message.equals(welcomeMsg.getText());
    }


}

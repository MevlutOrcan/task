package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Driver;
import utils.ReusableMethods;

public class TestPage extends ReusableMethods {
    public TestPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(css = "#inputEmail")
    public WebElement email;

     @FindBy(id = "inputPassword")
    public WebElement password;



}

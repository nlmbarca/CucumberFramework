package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

public class AdminPage extends CommonMethods {

    @FindBy(id="menu_admin_Job")
    public WebElement jobDD;

    @FindBy(id = "menu_admin_viewJobTitleList")
    public WebElement jobTitles;

    public AdminPage(){
        PageFactory.initElements(driver,this);
    }
}

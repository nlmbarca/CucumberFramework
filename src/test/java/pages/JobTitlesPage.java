package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import steps.JobTitleSteps;
import utils.CommonMethods;

import java.util.List;

public class JobTitlesPage extends CommonMethods {

    @FindBy(xpath = "//table[@id='resultTable']")
    public List<WebElement> jobTitleTable;

    public JobTitlesPage(){
        PageFactory.initElements(driver,this);
    }
}

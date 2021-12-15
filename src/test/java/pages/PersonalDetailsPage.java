package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.CommonMethods;

import java.util.List;

public class PersonalDetailsPage extends CommonMethods {
    @FindBy(xpath = "//div[@id='profile-pic']/h1")
    public WebElement profileMadeName;

    @FindBy(xpath = "//div[@class='inner']/form/fieldset/ol")
    public List<WebElement> personalDetailsInfo;

    @FindBy(xpath = "//input[@id='personal_txtLicenNo']")
    public WebElement driversLicenseNumber;

    @FindBy(xpath = "//input[@id='personal_txtLicExpDate']")
    public WebElement licenseExpDate;

    @FindBy(xpath = "//input[@id='personal_txtNICNo']")
    public WebElement SsnNumber;

    @FindBy(xpath = "//input[@id='personal_txtSINNo']")
    public WebElement SinNumber;

    @FindBy(xpath = "//input[@id='personal_optGender_1']")
    public WebElement maleRadioButton;

    @FindBy(xpath = "//select[@id='personal_cmbMarital']")
    public WebElement martialStatusSelectOption;

    @FindBy(xpath = "//select[@id='personal_cmbNation']")
    public WebElement nationalitySelectOption;

    @FindBy(xpath = "//input[@id='personal_DOB']")
    public WebElement dateOfBirth;

    @FindBy(xpath = "//input[@id='personal_txtEmpNickName']")
    public WebElement nickNameField;

    @FindBy(xpath = "//input[@value='Edit']")
    public WebElement editPersonalDetailsInfo;

    @FindBy(id="personal_chkSmokeFlag")
    public WebElement smokerField;

    @FindBy(xpath = "//input[@id='personal_txtMilitarySer']")
    public WebElement militaryField;

    public PersonalDetailsPage() {
        PageFactory.initElements(driver, this);
    }
}

package com.filta.qa.home_page_franchisee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import com.filta.qa.helper.UserPage_Interface;
import com.filta.qa.util.Global;
import com.filta.qa.util.Login;
import com.filta.qa.util.Logout;
import com.filta.qa.util.ReadExcelData;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class UserPage implements UserPage_Interface
{
	private WebDriver driver;
	private Global globalObj;
	private Properties prop;
	private Login login;
	private String userName;
	private String firstName;
	private String lastName;
	private String filtaUserType;
	private String status;
	private String userType;
	private boolean sendRemainder;
	private String employeeStatus;
	private String title;
	private String department;
	private String[] iMType;
	private String defaultIMType;
	private String addressStreet;
	private String addressState;
	private String addressCountry;
	private String standardRate;
	private String description;
	private boolean displayEmployeeRecord;
	private String workPhone;
	private String mobile;
	private String otherPhone;
	private String fax;
	private String iMName;
	private String addressCity;
	private String addressPostalZipCodel;
	private String weeklyStandardHours;
	private String[] weeklyStandardHoursMin;
	private String defaultWeeklyStandardHoursMin;
	private String overTimeRate;
	private String emailAddress1;
	private boolean primaryRadio1;
	private boolean primaryReplyTo;
	private String[] emailClient;
	private String defaultEmailClient;
	private ReadExcelData userData;
	private ReadExcelData passwordData;
	private ReadExcelData themeData;
	private ReadExcelData advancedData;
	private ReadExcelData layoutData;
	private ReadExcelData localSettingData;
	private ReadExcelData calendarOptionData;
	private ReadExcelData accessData;
	private List<WebElement> list;
	private List<String> list2;
	private List<String> list3;

	private String alert1;
	private String alert2;
	private String number = null;
	private int countZero;
	private int countDollar;
	private int countComma;
	private int countDecimal;
	private int countNumber;

	private String exportDelimiter;
	private String importExportCharSet;
	private boolean showFullNameValue;
	private boolean notifyOnAssignmentvalue;
	private String dateFormat;
	private String timeFormat;
	private String timeZone;
	private String currency;
	private int currencySignificantDigit;
	private String thousandsSeparator;
	private String decimalSymbol;
	private String name;
	private String publishAtMyLocationValue;
	private String searchLocation;
	private String iCalValue;
	private String firstDayOfWeek;
	private boolean remainEmailTextbox;
	private boolean remainderPopupTextbox;
	private boolean mailMergetextBox;
	private String popupEditPage;
	private String emailEditPage;
	private Logout logout;
	private List<WebElement> allLinks;
	private List<WebElement> finalList;
	private List<WebElement> elementList;

	@FindBy(how = How.XPATH, using = ".//a[@class='container-close']")
	private WebElement containerClose;

	@FindBy(how = How.XPATH, using = ".//a[@id='user_link_link']")
	private WebElement topText1;

	@FindBy(how = How.XPATH, using = ".//div[@class='moduleTitle']//h2")
	private WebElement getUserName;

	@FindBy(how = How.XPATH, using = ".//input[@id='SAVE_HEADER']")
	private WebElement saveButtonHeader;

	@FindBy(how = How.XPATH, using = ".//input[@id='CANCEL_HEADER']")
	private WebElement cancelButtonHeader;

	@FindBy(how = How.XPATH, using = ".//input[@id='reset_user_preferences_header']")
	private WebElement resetUserPreferencesButtonHeader;

	@FindBy(how = How.XPATH, using = ".//input[@id='reset_homepage_header']")
	private WebElement resetHomePageButtonHeader;

	@FindBy(how = How.XPATH, using = ".//input[@id='SAVE_FOOTER']")
	private WebElement saveButtonFooter;

	@FindBy(how = How.XPATH, using = ".//input[@id='CANCEL_FOOTER']")
	private WebElement cancelButtonFooter;

	@FindBy(how = How.XPATH, using = ".//input[@id='reset_user_preferences_footer']")
	private WebElement resetUserPreferencesButtonFooter;

	@FindBy(how = How.XPATH, using = ".//input[@id='reset_homepage_footer']")
	private WebElement resetHomePageButtonFooter;

	@FindBy(how = How.XPATH, using = ".//input[@id='edit_button']")
	private WebElement editButton;

	@FindBy(how = How.XPATH, using = ".//a[@id='tab1']//em")
	private WebElement tab1OnEditPage;

	@FindBy(how = How.XPATH, using = ".//input[@id='user_name']")
	private WebElement editUname;

	@FindBy(how = How.XPATH, using = ".//input[@id='first_name']")
	private WebElement editFirstName;

	@FindBy(how = How.XPATH, using = ".//input[@id='last_name']")
	private WebElement editLastName;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][3]//td[@class='edit-table-row1'][4]")
	private WebElement editFiltaUserType;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][2]//td[@class='edit-table-row1'][2]")
	private WebElement editStatus;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][3]//td[@class='edit-table-row1'][2]")
	private WebElement editUserType;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][5]//td[@class='edit-table-row1'][2]")
	private WebElement editSendRemainder;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][1]//td[@class='edit-table-row1'][2]")
	private WebElement editEmployeeStatus;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][2]//td[@class='edit-table-row1'][2]")
	private WebElement editTitle;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][3]//td[@class='edit-table-row1'][2]")
	private WebElement editDepartment;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][7]//td[@class='edit-table-row1'][2]//input")
	private WebElement editAddressStreet;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][8]//td[@class='edit-table-row1'][2]//input")
	private WebElement editAddressState;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][9]//td[@class='edit-table-row1'][2]//input")
	private WebElement editAddressCountry;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][10]//td[@class='edit-table-row1'][2]//input")
	private WebElement editStandardRate;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][11]//td[@class='edit-table-row1'][2]//textarea")
	private WebElement editDescription;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][1]//td[@class='edit-table-row1'][4]")
	private WebElement editDisplayEmployeeRecord;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][2]//td[@class='edit-table-row1'][4]//input")
	private WebElement editWorkPhone;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][3]//td[@class='edit-table-row1'][4]//input")
	private WebElement editMobile;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][4]//td[@class='edit-table-row1'][4]//input")
	private WebElement editOtherPhone;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][5]//td[@class='edit-table-row1'][4]//input")
	private WebElement editFax;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][6]//td[@class='edit-table-row1'][4]//input")
	private WebElement editIMName;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][7]//td[@class='edit-table-row1'][4]//input")
	private WebElement editAddressCity;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][8]//td[@class='edit-table-row1'][4]//input")
	private WebElement editAddressPostalZipCode;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][9]//td[@class='edit-table-row1'][4]//input")
	private WebElement editWeeklyStandardHours;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][10]//td[@class='edit-table-row1'][4]//input")
	private WebElement editOverTimeRate;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//table[@class='emailaddresses_span']//tr[@id='Users0emailAddressRow0']//input[@id='Users0emailAddress0']")
	private WebElement editEmailAddress1;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//table[@class='emailaddresses_span']//input[@type='radio' and @id='Users0emailAddressPrimaryFlag0']")
	private WebElement editPrimaryRadio;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//table[@class='emailaddresses_span']//input[@type='radio' and @id='Users0emailAddressReplyToFlag0']")
	private WebElement editPrimaryReplyToRadio;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][9]//td[@class='edit-table-row1'][4]//select")
	private WebElement editDefaultMin;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//select[@id='email_link_type']")
	private WebElement editDefaultEmailClient;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//tr[1]//td[2]//span")
	private WebElement userProfileFullname;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//tr[1]//td[4]//span")
	private WebElement userProfileUsername;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//tr[2]//td[2]")
	private WebElement userProfileStatus;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//tr[2]//td[4]//span")
	private WebElement userProfileUserType;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//tr[3]//td[2]")
	private WebElement userProfileFiltaUserType;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//tr[4]//td[2]")
	private WebElement userProfileStoreAccess;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//tr[5]//td[2]//input")
	private WebElement userProfileSendRemainder;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[1]//td[2]//span")
	private WebElement userProfileEmployeeStatus;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[1]//td[4]")
	private WebElement userProfileDisplayEmployeeRecord;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[2]//td[2]//span")
	private WebElement userProfileTitle;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[2]//td[4]")
	private WebElement userProfileWorkPhone;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[3]//td[2]")
	private WebElement userProfileDepartment;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[3]//td[4]")
	private WebElement userProfileMobile;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[4]//td[2]//span")
	private WebElement userProfileReportsTo;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[4]//td[4]")
	private WebElement userProfileOtherPhone;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[5]//td[4]")
	private WebElement userProfileFax;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[6]//td[2]")
	private WebElement userProfileIMType;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][6]//td[@class='edit-table-row1'][2]//select")
	private WebElement editDefaultIMType;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[6]//td[4]//span")
	private WebElement userProfileIMName;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[7]//td[2]//span")
	private WebElement userProfileAddressStreet;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[7]//td[4]//span")
	private WebElement userProfileAddressCity;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[8]//td[2]//span")
	private WebElement userProfileAddressState;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[9]//td[2]//span")
	private WebElement userProfileAddressCounty;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[9]//td[4]//span")
	private WebElement userProfileWeeklyStandardHours;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[8]//td[4]//span")
	private WebElement userProfileAddressPostalZipCode;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[10]//td[2]//span")
	private WebElement userProfileStandardRate;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[10]//td[4]//span")
	private WebElement userProfileOverTimeRate;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//tr[11]//td[2]//span")
	private WebElement userProfileDescription;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//tbody//tr[2]//a")
	private WebElement userProfilePrimaryEmail;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//tbody//tr[3]//td[2]")
	private WebElement userProfileSugarClient;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_USER_INFORMATION']//h4")
	private WebElement userProfileUserLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='LBL_EMPLOYEE_INFORMATION']//h4")
	private WebElement userProfileEmployeeLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='email_options']//h4")
	private WebElement userProfileEmailLabel;

	@FindBy(how = How.XPATH, using = ".//ul[@id='groupTabs']//a")
	private WebElement userProfileAllLabel;

	@FindBy(how = How.XPATH, using = ".//a[@id='tab2']//em")
	private WebElement tab2OnEditPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='generate_password']//h4")
	private WebElement passwordPagePasswordLabel;

	@FindBy(how = How.CSS, using = "#generate_password_old_password > table > tbody > tr > td:nth-child(1)")
	private WebElement passwordPageCurrentPasswordLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='generate_password']//table[2]//tbody//tr[1]//td[1]")
	private WebElement passwordPageNewPasswordLabel;

	@FindBy(how = How.CSS, using = "#generate_password > table > tbody > tr > td > table:nth-child(3) > tbody > tr:nth-child(2) > td:nth-child(1)")
	private WebElement passwordPageConfirmPassword;

	@FindBy(how = How.CSS, using = "#generate_password > table > tbody > tr > td > table:nth-child(3) > tbody > tr:nth-child(3) > td")
	private WebElement passwordPageNote;

	@FindBy(how = How.XPATH, using = ".//input[@id='old_password']")
	private WebElement currentpasswordInput;

	@FindBy(how = How.XPATH, using = ".//input[@id='new_password']")
	private WebElement newPasswordInput;

	@FindBy(how = How.XPATH, using = ".//input[@id='confirm_pwd']")
	private WebElement confirmPasswordInput;

	@FindBy(how = How.XPATH, using = ".//div[@id='comfirm_pwd_match']")
	private WebElement passwordValidation;

	@FindBy(how = How.XPATH, using = ".//div[@id='sugarMsgWindow']//div[@id='sugarMsgWindow_h']")
	private WebElement passwordUpdatedLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='sugarMsgWindow']//div[@class='bd']")
	private WebElement passwordUpdatedLabel2;

	@FindBy(how = How.XPATH, using = ".//span[@id='error_pwd']")
	private WebElement passwordErrorMessage;

	@FindBy(how = How.XPATH, using = ".//div[@id='sugarMsgWindow']//a[@class='container-close']")
	private WebElement sugarDashletClose;

	@FindBy(how = How.XPATH, using = ".//a[@id='tab3']")
	private WebElement tab3OnEditPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='themepicker']//h4")
	private WebElement themeLabel;

	@FindBy(how = How.XPATH, using = ".//select[@name='user_theme']")
	private WebElement defaultTheme;

	@FindBy(how = How.XPATH, using = ".//a[@id='tab4']")
	private WebElement tab4OnEditPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//h4")
	private WebElement userSettingLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[2]//td[1]")
	private WebElement exportDelimiterLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[2]//td[2]//input")
	private WebElement exportDelimiterlabelTextbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[2]//td[3]")
	private WebElement notifyOnAssignment;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[2]//td[4]//input")
	private WebElement notifyOnAssignmentCheckBox;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[1]")
	private WebElement importExportLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[2]//select")
	private WebElement defaultSelectedImportExport;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[3]")
	private WebElement remainderLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[4]//div[1]//div[1]")
	private WebElement popup;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[4]//div[1]//input[2]")
	private WebElement defaultPopupCheckbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[4]//div[2]//input[2]")
	private WebElement defaultEmailCheckBox;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[4]//div[2]/div[1]")
	private WebElement email;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[4]//td[1]")
	private WebElement showFullName;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[4]//td[2]//input")
	private WebElement defaultShowFullameCheckbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[4]//td[4]//input")
	private WebElement defaultMailMergeCheckBox;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//tbody[1]//tr//th//h4")
	private WebElement layoutOptionn;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//tbody[1]//tr[@id='use_group_tabs_row']//span")
	private WebElement moduleMenuLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//tbody[1]//tr[@id='use_group_tabs_row']//input[2]")
	private WebElement moduleMenuLabelCheckbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//table//tbody//tr[3]//h4")
	private WebElement selectModule;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//table//tbody//tr[3]//tr[1]//td[2][@id='chooser_display_tabs_text']//nobr")
	private WebElement displayModule;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//table//tbody//tr[3]//tr[1]//td[4][@id='chooser_hide_tabs']//nobr")
	private WebElement hideModule;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//table//tbody//tr[4]//td//span")
	private WebElement subPanelTab;

	@FindBy(how = How.XPATH, using = ".//div[@id='layout']//table//tbody//tr[4]//td[2]//input")
	private WebElement subPanelCheckbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[1]//h4//slot")
	private WebElement localSetting;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[2]//td[1]//slot")
	private WebElement dataFormatLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[2]//td[3]//slot")
	private WebElement currencyLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[3]//td[1]//slot")
	private WebElement timeFormatLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[3]//td[3]//slot")
	private WebElement currencySignificantDigitsLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[2]//td[2]//select")
	private WebElement defaultDateFormat;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[2]//td[4]//select")
	private WebElement defaultCurrency;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[3]//td[2]//select")
	private WebElement defaultTimeFormat;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[3]//td[4]//select")
	private WebElement defaultCurrencySignificantDigits;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[4]//td[1]//slot")
	private WebElement timeZoneLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[4]//td[3]//slot")
	private WebElement exampleLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[4]//td[4]//slot//input")
	private WebElement exampleTextbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[5]//td[3]//slot")
	private WebElement separatorLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[5]//td[4]//slot//input")
	private WebElement sepratorTextbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[6]//td[1]")
	private WebElement nameDisplayFormatLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[6]//td[3]//slot")
	private WebElement decimalSymbolLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[6]//td[4]//slot//input")
	private WebElement decimalSymbolTextbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//h4")
	private WebElement calendarOptionLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[2]//td[1]//slot")
	private WebElement publishKeyLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[2]//td[2]//slot//input")
	private WebElement publishKeyTextbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[3]//td[1]//slot")
	private WebElement publishAtMyLocation;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[3]//td[2]//slot")
	private WebElement publishAtMyLocationText;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[4]//td[1]//slot")
	private WebElement searchLocationLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[4]//td[2]//slot")
	private WebElement searchLocationText;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[5]//td[1]//slot")
	private WebElement iCalintegrationURLLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[5]//td[2]//slot")
	private WebElement iCalintegrationText;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[6]//td[1]//slot")
	private WebElement firstDayOfWeekLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[6]//td[2]//slot//select")
	private WebElement defaultFirstdayOfWeek;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[4]//td[2]//select")
	private WebElement defaultTimeZone;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tbody//tr[6]//td[2]//select")
	private WebElement defaultName;

	@FindBy(how = How.XPATH, using = ".//div[@id='user_detailview_tabs']//ul[1]//li[2]")
	private WebElement advancedTab;

	@FindBy(how = How.XPATH, using = ".//div[@id='user_detailview_tabs']//ul[1]//li[2]//em")
	private WebElement advancedTabLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//h4//slot")
	private WebElement userSettingUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[2]//td[1]//slot")
	private WebElement notifyOnAssignmentUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[2]//td[2]//slot")
	private WebElement notifyOnAssignmentValueUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[2]//td[3]//slot")
	private WebElement notifyOnAssignmentTextUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[1]//slot")
	private WebElement remainderUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[2]//slot//div[1]//input")
	private WebElement popupCheckBoxUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[2]//slot//div[2]//input")
	private WebElement emailCheckBoxUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[2]//slot//div[1]")
	private WebElement popupUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[2]//slot//div[2]")
	private WebElement emailUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[3]//td[3]//slot")
	private WebElement remainderText;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[4]//td[1]//slot")
	private WebElement mailMergeuserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[4]//td[2]//slot//input")
	private WebElement mailMergeUserPageCheckBox;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[4]//td[3]//slot")
	private WebElement mailMergeTextUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[5]//td[1]//slot")
	private WebElement uRLUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[5]//td[2]//slot")
	private WebElement uRLUserPage2;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[5]//td[3]//slot")
	private WebElement uRLUserPage3;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[6]//td[1]//slot")
	private WebElement exportDelimiterUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[6]//td[2]//slot")
	private WebElement exportDelimiterTextboxUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[6]//td[3]//slot")
	private WebElement exportDelimiterText;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[7]//td[1]//slot")
	private WebElement importExportUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[7]//td[2]//slot")
	private WebElement importExportText;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[7]//td[3]//slot")
	private WebElement importExportTextUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[8]//td[1]//slot")
	private WebElement showFullNamesTextUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[8]//td[2]//slot//input")
	private WebElement showFullNameTextBox;

	@FindBy(how = How.XPATH, using = ".//div[@id='settings']//tr[8]//td[3]//slot")
	private WebElement showFullNameUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//h4//slot")
	private WebElement localeUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[2]//td[1]//slot")
	private WebElement dataFormatUserPageLabel;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[2]//td[2]//slot")
	private WebElement dataFormatText;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[2]//td[3]//slot")
	private WebElement dataFormatTextUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[3]//td[1]//slot")
	private WebElement timeFormatUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[3]//td[2]//slot")
	private WebElement timeFormatValueUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[3]//td[3]//slot")
	private WebElement timeFormatText;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[4]//td[1]//slot")
	private WebElement timeZoneUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[4]//td[2]//slot")
	private WebElement timeZoneValueUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[5]//td[1]//slot")
	private WebElement currencyUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[5]//td[2]//slot")
	private WebElement currencyValueUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[5]//td[3]//slot")
	private WebElement currencyText;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[6]//td[1]//slot")
	private WebElement currencyDigitUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[6]//td[2]//slot")
	private WebElement currencyDigitValueUserpage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[6]//td[3]//slot")
	private WebElement currencyDigitTextUserpage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[7]//td[1]//slot")
	private WebElement thousandsUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[7]//td[2]//slot")
	private WebElement thousandsValueUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[7]//td[3]//slot")
	private WebElement thousandsTextValueUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[8]//td[1]//slot")
	private WebElement decimalUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[8]//td[2]//slot")
	private WebElement decilamlValueUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[8]//td[3]")
	private WebElement deciamlTextUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[1]//slot")
	private WebElement nameDisplayUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[2]//slot//i[1]")
	private WebElement nameDisplayValueOneUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[2]//slot//i[2]")
	private WebElement nameDisplayValueSecondUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[2]//slot//i[3]")
	private WebElement nameDisplayValueThirdUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[2]//slot//i[4]")
	private WebElement nameDisplayValueForthUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[2]//slot//i[5]")
	private WebElement nameDisplayValueFifthUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[2]//slot//i[6]")
	private WebElement nameDisplayValueSixthUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='locale']//tr[9]//td[3]")
	private WebElement nameDisplayTextUserPage;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//h4//slot")
	private WebElement calendarOption;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[2]//td[1]//slot")
	private WebElement publishKey;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[2]//td[2]//slot")
	private WebElement publishKeyText;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[3]//td[1]//slot")
	private WebElement publishatmylocation;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[3]//td[2]//slot")
	private WebElement publishatmylocationtext;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[4]//td[1]//slot")
	private WebElement searchLocationn;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[4]//td[2]//slot")
	private WebElement searchLocationTextt;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[5]//td[1]//slot")
	private WebElement iCal;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[5]//td[2]//slot")
	private WebElement iCalText;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[6]//td[1]//slot")
	private WebElement firstDayOfWeekk;

	@FindBy(how = How.XPATH, using = ".//div[@id='calendar_options']//tr[6]//td[2]//slot")
	private WebElement firstDayOfWeekText;

	@FindBy(how = How.XPATH, using = ".//div[@id='edit_tabs']//h4//slot")
	private WebElement layoutOption;

	@FindBy(how = How.XPATH, using = ".//div[@id='edit_tabs']//tr[2]//td[1]//slot")
	private WebElement moduleMenuFilter;

	@FindBy(how = How.XPATH, using = ".//div[@id='edit_tabs']//tr[2]//td[2]//slot")
	private WebElement moduleMenuFilterCheckbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='edit_tabs']//tr[2]//td[3]//slot")
	private WebElement moduleMenuFiltertext;

	@FindBy(how = How.XPATH, using = ".//div[@id='edit_tabs']//tr[3]//td[1]//slot")
	private WebElement subPanelTabb;

	@FindBy(how = How.XPATH, using = ".//div[@id='edit_tabs']//tr[3]//td[2]//slot")
	private WebElement subPanelTabCheckbox;

	@FindBy(how = How.XPATH, using = ".//div[@id='edit_tabs']//tr[3]//td[3]//slot")
	private WebElement subPanelTabText;

	@FindBy(how = How.XPATH, using = ".//li[@id='All_sp_tab']//a")
	private WebElement all;

	@FindBy(how = How.XPATH, using = ".//div[@id='user_detailview_tabs']//ul[@class='yui-nav']//li[3]//a")
	private WebElement access;

	@FindBy(how = How.XPATH, using = ".//div[@class='table-responsive-edit']//table//tbody//tr[2]//td[2]")
	private WebElement enabledColor;

	@FindBy(how = How.XPATH, using = ".//div[@class='table-responsive-edit']//table//tbody//tr[2]//td[3]")
	private WebElement noneColor;

	@FindBy(how = How.XPATH, using = ".//div[@class='table-responsive-edit']//table//tbody//tr[3]//td[3]")
	private WebElement allColor;

	@FindBy(how = How.XPATH, using = ".//div[@class='table-responsive-edit']//table//tbody//tr[6]//td[3]")
	private WebElement ownerColor;

	@FindBy(how = How.XPATH, using = ".//div[@id='subpanel_title_aclroles']//table//tbody//h3/span[1]")
	private WebElement roles;

	@FindBy(how = How.XPATH, using = ".//div[@class='detail-table-overflow']//table//tr[2]//th[1]//a")
	private WebElement rolesName;

	@FindBy(how = How.XPATH, using = ".//div[@class='detail-table-overflow']//table//tr[2]//th[2]//span")
	private WebElement rolesDescription;

	@FindBy(how = How.XPATH, using = ".//div[@class='detail-table-overflow']//table//tr[3]//td[1]//span")
	private WebElement rolesFranchisee;

	@FindBy(how = How.XPATH, using = ".//div[@class='detail-table-overflow']//table//tr[3]//td[2]//span")
	private WebElement rolesNotDelete;

	@FindBy(how = How.XPATH, using = ".//ul[@id='groupTabs']//li//a")
	private WebElement rolesALL;

	public UserPage(WebDriver driver)
	{
		globalObj = new Global();
		prop = globalObj.readProperties();
		this.driver = driver;
		login = new Login(driver);
		logout = new Logout(driver);
		PageFactory.initElements(driver, this);
		userData = new ReadExcelData(prop.getProperty("Path1"), "UserProfile");
		passwordData = new ReadExcelData(prop.getProperty("Path1"), "Password");
		themeData = new ReadExcelData(prop.getProperty("Path1"), "Theme");
		advancedData = new ReadExcelData(prop.getProperty("Path1"), "Advanced");
		layoutData = new ReadExcelData(prop.getProperty("Path1"), "Layout");
		localSettingData = new ReadExcelData(prop.getProperty("Path1"), "Locale Settings");
		calendarOptionData = new ReadExcelData(prop.getProperty("Path1"), "Calrendar");
		accessData = new ReadExcelData(prop.getProperty("Path1"), "Access");
	}


	public void login()
	{
		login.credentials();
	}


	public void urlCheck()
	{
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(containerClose));
		containerClose.click();
		topText1.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(getUserName));
		Assert.assertEquals(driver.getCurrentUrl(), prop.getProperty("UserPageURL"));
//		Sa.assertAll();
	}


	public void buttonCheck()
	{
		Assert.assertEquals(saveButtonHeader.getAttribute("value"), prop.getProperty("UserPageSaveButtonNameHeader"));
		Assert.assertEquals(cancelButtonHeader.getAttribute("value"),
				prop.getProperty("UserPageCancelButtonNameHeader"));
		Assert.assertEquals(resetUserPreferencesButtonHeader.getAttribute("value"),
				prop.getProperty("UserPageResetUserPreferencesButtonHeader"));
		Assert.assertEquals(resetHomePageButtonHeader.getAttribute("value"),
				prop.getProperty("UserPageResetHomepageButtonHeader"));
		Assert.assertEquals(saveButtonFooter.getAttribute("value"), prop.getProperty("UserPageSaveButtonNameFooter"));
		Assert.assertEquals(cancelButtonFooter.getAttribute("value"),
				prop.getProperty("UserPageCancelButtonNameFooter"));
		Assert.assertEquals(resetUserPreferencesButtonFooter.getAttribute("value"),
				prop.getProperty("UserPageResetUserPreferencesButtonFooter"));
		Assert.assertEquals(resetHomePageButtonFooter.getAttribute("value"),
				prop.getProperty("UserPageResetHomepageButtonFooter"));
		cancelButtonHeader.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(editButton));
		Assert.assertEquals(editButton.getAttribute("value"), prop.getProperty("UserPageEditButton"));
		Assert.assertEquals(resetUserPreferencesButtonHeader.getAttribute("value"),
				prop.getProperty("UserPageResetUserPreferencesButtonHeader"));
		Assert.assertEquals(resetHomePageButtonHeader.getAttribute("value"),
				prop.getProperty("UserPageResetHomepageButtonHeader"));
//		sa.assertAll();
	}


	public void buttonBackGroundWithoutMouseOverview()
	{
		Assert.assertEquals(editButton.getCssValue("background"),
				prop.getProperty("UserPageEditButtonBackGroundColorBlue"));
		Assert.assertEquals(resetUserPreferencesButtonHeader.getCssValue("background"),
				prop.getProperty("UserPageResetUserPreferencesButtonBackGroundColorBlue"));
		Assert.assertEquals(resetHomePageButtonHeader.getCssValue("background"),
				prop.getProperty("UserPageResetHomePageButtonBackGroundColorBlue"));
		// Text Color Assertion
		Assert.assertEquals(editButton.getCssValue("color"), prop.getProperty("UserPageEditButtonTextWhite"));
		Assert.assertEquals(resetUserPreferencesButtonHeader.getCssValue("color"),
				prop.getProperty("UserPageResetUserPreferencesButtonTextWhite"));
		Assert.assertEquals(resetHomePageButtonHeader.getCssValue("color"),
				prop.getProperty("UserPageResetHomePageButtonTextWhite"));
		editButton.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(getUserName));
		Assert.assertEquals(saveButtonHeader.getCssValue("background"),
				prop.getProperty("UserPageSaveButtonHeaderBackGroundColorBlue"));
		Assert.assertEquals(cancelButtonHeader.getCssValue("background"),
				prop.getProperty("UserPageCancelButtonHeaderBackGroundColorBlue"));
		Assert.assertEquals(resetUserPreferencesButtonHeader.getCssValue("background"),
				prop.getProperty("UserPageResetUserPreferencesButtonHeaderBackGroundColorBlue"));
		Assert.assertEquals(resetHomePageButtonHeader.getCssValue("background"),
				prop.getProperty("UserPageResetHomePageButtonHeaderBackGroundColorBlue"));
		Assert.assertEquals(saveButtonFooter.getCssValue("background"),
				prop.getProperty("UserPageSaveButtonFooterBackGroundColorBlue"));
		Assert.assertEquals(cancelButtonFooter.getCssValue("background"),
				prop.getProperty("UserPageCancelButtonFooterBackGroundColorBlue"));
		Assert.assertEquals(resetUserPreferencesButtonFooter.getCssValue("background"),
				prop.getProperty("UserPageResetUserPreferencesButtonFooterBackGroundColorBlue"));
		Assert.assertEquals(resetHomePageButtonFooter.getCssValue("background"),
				prop.getProperty("UserPageResetHomePageButtonFooterBackGroundColorBlue"));
		// Text Color Assertion
		Assert.assertEquals(saveButtonHeader.getCssValue("color"),
				prop.getProperty("UserPageSaveButtonHeaderTextWhite"));
		Assert.assertEquals(cancelButtonHeader.getCssValue("color"),
				prop.getProperty("UserPageCancelButtonHeaderTextWhite"));
		Assert.assertEquals(resetUserPreferencesButtonHeader.getCssValue("color"),
				prop.getProperty("UserPageResetUserPreferencesButtonHeaderTextWhite"));
		Assert.assertEquals(resetHomePageButtonHeader.getCssValue("color"),
				prop.getProperty("UserPageResetHomePageButtonHeaderTextWhite"));
		Assert.assertEquals(saveButtonFooter.getCssValue("color"),
				prop.getProperty("UserPageSaveButtonFooterTextWhite"));
		Assert.assertEquals(cancelButtonFooter.getCssValue("color"),
				prop.getProperty("UserPageCancelButtonFooterTextWhite"));
		Assert.assertEquals(resetUserPreferencesButtonFooter.getCssValue("color"),
				prop.getProperty("UserPageResetUserPreferencesButtonFooterTextWhite"));
		Assert.assertEquals(resetHomePageButtonFooter.getCssValue("color"),
				prop.getProperty("UserPageResetHomePageButtonFooterTextWhite"));
//		Sa.assertAll();
	}


	public void buttonBackGroundWithMouseOverview()
	{
		globalObj.action(driver).moveToElement(saveButtonHeader).build().perform();
		Assert.assertEquals(saveButtonHeader.getCssValue("border-color"),
				prop.getProperty("UserPageSaveButtonHeaderBackGroundColorGreen"));
		globalObj.action(driver).moveToElement(cancelButtonHeader).build().perform();
		Assert.assertEquals(cancelButtonHeader.getCssValue("border-color"),
				prop.getProperty("UserPageCancelButtonHeaderBackGroundColorGreen"));
		globalObj.action(driver).moveToElement(resetUserPreferencesButtonHeader).build().perform();
		Assert.assertEquals(resetUserPreferencesButtonHeader.getCssValue("border-color"),
				prop.getProperty("UserPageResetUserPreferencesButtonHeaderBackGroundColorGreen"));
		globalObj.action(driver).moveToElement(resetHomePageButtonHeader).build().perform();
		Assert.assertEquals(resetHomePageButtonHeader.getCssValue("border-color"),
				prop.getProperty("UserPageResetHomePageButtonHeaderBackGroundColorGreen"));
		globalObj.action(driver).moveToElement(saveButtonFooter).build().perform();
		Assert.assertEquals(saveButtonFooter.getCssValue("border-color"),
				prop.getProperty("UserPageSaveButtonFooterBackGroundColorGreen"));
		globalObj.action(driver).moveToElement(cancelButtonFooter).build().perform();
		Assert.assertEquals(cancelButtonFooter.getCssValue("border-color"),
				prop.getProperty("UserPageCancelButtonFooterBackGroundColorGreen"));
		globalObj.action(driver).moveToElement(resetUserPreferencesButtonFooter).build().perform();
		Assert.assertEquals(resetUserPreferencesButtonFooter.getCssValue("border-color"),
				prop.getProperty("UserPageResetUserPreferencesButtonFooterBackGroundColorGreen"));
		globalObj.action(driver).moveToElement(resetHomePageButtonFooter).build().perform();
		Assert.assertEquals(resetHomePageButtonFooter.getCssValue("border-color"),
				prop.getProperty("UserPageResetHomePageButtonFooterBackGroundColorGreen"));
		cancelButtonFooter.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(editButton));
		globalObj.action(driver).moveToElement(editButton).build().perform();
		Assert.assertEquals(editButton.getCssValue("border-color"),
				prop.getProperty("UserPageEditButtonBackGroundColorGreen"));
		globalObj.action(driver).moveToElement(resetUserPreferencesButtonHeader).build().perform();
		Assert.assertEquals(resetUserPreferencesButtonHeader.getCssValue("border-color"),
				prop.getProperty("UserPageResetUserPreferencesButtonBackGroundColorGreen"));
		globalObj.action(driver).moveToElement(resetHomePageButtonHeader).build().perform();
		Assert.assertEquals(resetHomePageButtonHeader.getCssValue("border-color"),
				prop.getProperty("UserPageResetHomePageButtonBackGroundColorGreen"));
//		Sa.assertAll();
	}


	public void buttonToolTipCheck()
	{
		Assert.assertEquals(editButton.getAttribute("title"), prop.getProperty("UserPageEditButtonToolTip"));
		Assert.assertEquals(resetUserPreferencesButtonHeader.getAttribute("title"),
				prop.getProperty("UserPageResetUserPreferencesButtonToolTip"));
		Assert.assertEquals(resetHomePageButtonHeader.getAttribute("title"),
				prop.getProperty("UserPageResetHomePageButtonToolTip"));
		editButton.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(getUserName));
		Assert.assertEquals(saveButtonHeader.getAttribute("title"),
				prop.getProperty("UserPageSaveButtonHeaderToolTip"));
		Assert.assertEquals(cancelButtonHeader.getAttribute("title"),
				prop.getProperty("UserPageCancelButtonHeaderToolTip"));
		Assert.assertEquals(resetUserPreferencesButtonHeader.getAttribute("title"),
				prop.getProperty("UserPageResetUserPreferencesButtonHeaderToolTip"));
		Assert.assertEquals(resetHomePageButtonHeader.getAttribute("title"),
				prop.getProperty("UserPageResetHomePageButtonHeaderToolTip"));
		Assert.assertEquals(saveButtonFooter.getAttribute("title"),
				prop.getProperty("UserPageSaveButtonFooterToolTip"));
		Assert.assertEquals(cancelButtonFooter.getAttribute("title"),
				prop.getProperty("UserPageCancelButtonFooterToolTip"));
		Assert.assertEquals(resetUserPreferencesButtonFooter.getAttribute("title"),
				prop.getProperty("UserPageResetUserPreferencesButtonFooterToolTip"));
		Assert.assertEquals(resetHomePageButtonFooter.getAttribute("title"),
				prop.getProperty("UserPageResetHomePageButtonFooterToolTip"));
//		Sa.assertAll();
	}


	public void tabnamesCheck()
	{
		list = driver.findElements(By.xpath(".//ul[@class='yui-nav']//li//a//em"));
		for (int i = 0; i < list.size(); i++)
		{
			if (i == 2)
			{
				break;
			}
//			System.out.println(list.get(i).getText());
		}
		for (int i = 0; i < list.size(); i++)
		{
			if (i == 2)
			{
				break;
			}
			else
			{
//				System.out.println(list.get(i).getText());
//				System.out.println(Prop.getProperty("TabOnEditPage" + i));
				Assert.assertEquals(list.get(i).getText(), prop.getProperty("TabOnEditPage" + i));
			}
		}
		// Count of tabs Assertion
		cancelButtonHeader.click();
		globalObj.wait(driver).until(ExpectedConditions
				.visibilityOfAllElementsLocatedBy(By.xpath(".//ul[@class='yui-nav']//li[1]//em")));
		list = driver.findElements(By.xpath(".//ul[@class='yui-nav']//li//em"));
		for (int i = 0; i < list.size(); i++)
		{
			if (i == 1)
			{
				break;
			}
			else
			{
				Assert.assertEquals(list.get(i).getText(), prop.getProperty("TabOnUserPage" + i));

			}
		}
	}


	public void getDataFromEditPageUserProfile()
	{
		editButton.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(getUserName));
		// To Check Label on User Profile Page
		Assert.assertEquals(userProfileUserLabel.getText(), prop.getProperty("UserProfileLabel1"));
		Assert.assertEquals(userProfileUserLabel.getCssValue("color"), prop.getProperty("UserProfileLabelColor"));
		Assert.assertEquals(userProfileEmployeeLabel.getText(), prop.getProperty("UserProfileLabel2"));
		Assert.assertEquals(userProfileEmployeeLabel.getCssValue("color"),
				prop.getProperty("UserProfileLabelColor"));
		Assert.assertEquals(userProfileEmailLabel.getText(), prop.getProperty("UserProfileLabel3"));
		Assert.assertEquals(userProfileEmailLabel.getCssValue("color"), prop.getProperty("UserProfileLabelColor"));
		// To Get Data From Edit User Page
		userName = editUname.getAttribute("value");
		firstName = editFirstName.getAttribute("value");
		lastName = editLastName.getAttribute("value");
		filtaUserType = editFiltaUserType.getText();
		status = editStatus.getText();
		userType = editUserType.getText();
		sendRemainder = editSendRemainder.isSelected();
		employeeStatus = editEmployeeStatus.getText();
		title = editTitle.getText();
		department = editDepartment.getText();
		list = driver.findElements(By.xpath(
				".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][6]//td[@class='edit-table-row1'][2]//select//option"));
		iMType = new String[list.size()];
		for (int i = 0; i < list.size(); i++)
		{
			iMType[i] = list.get(i).getText();
		}
		defaultIMType = globalObj.select(editDefaultIMType).getFirstSelectedOption().getText();
		addressStreet = editAddressStreet.getAttribute("value");
		addressState = editAddressState.getAttribute("value");
		addressCountry = editAddressCountry.getAttribute("value");
		standardRate = editStandardRate.getAttribute("value");
		description = editDescription.getAttribute("value");
		displayEmployeeRecord = editDisplayEmployeeRecord.isSelected();
		workPhone = editWorkPhone.getAttribute("value");
		mobile = editMobile.getAttribute("value");
		otherPhone = editOtherPhone.getAttribute("value");
		fax = editFax.getAttribute("value");
		iMName = editIMName.getAttribute("value");
		addressCity = editAddressCity.getAttribute("value");
		addressPostalZipCodel = editAddressPostalZipCode.getAttribute("value");
		weeklyStandardHours = editWeeklyStandardHours.getAttribute("value");
		list = driver.findElements(By.xpath(
				".//div[@id='LBL_EMPLOYEE_INFORMATION']//table[@class='yui3-skin-sam edit view dcQuickEdit edit508'][1]//tr[@class='edit-table1'][9]//td[@class='edit-table-row1'][4]//select//option"));
		weeklyStandardHoursMin = new String[list.size()];
		for (int i = 0; i < list.size(); i++)
		{
			weeklyStandardHoursMin[i] = list.get(i).getText();
		}
		defaultWeeklyStandardHoursMin = globalObj.select(editDefaultMin).getFirstSelectedOption().getText();
		overTimeRate = editOverTimeRate.getAttribute("value");
		emailAddress1 = editEmailAddress1.getAttribute("value");
		primaryRadio1 = editPrimaryRadio.isSelected();
		primaryReplyTo = editPrimaryReplyToRadio.isSelected();
		list = driver.findElements(By.xpath(".//div[@id='email_options']//select[@id='email_link_type']//option"));
		emailClient = new String[list.size()];
		for (int i = 0; i < list.size(); i++)
		{
			emailClient[i] = list.get(i).getText();
		}
		defaultEmailClient = globalObj.select(editDefaultEmailClient).getFirstSelectedOption().getText();
		System.out.println("Email is: " + defaultEmailClient);
		// To Verify Edit Page Data From "UserPage.xlsx" sheet
		Assert.assertEquals(firstName + " " + lastName, userData.getCellData(1, 0));
		Assert.assertEquals(userName, userData.getCellData(1, 1));
		Assert.assertEquals(status, userData.getCellData(1, 2));
		Assert.assertEquals(userType.substring(0, 12), userData.getCellData(1, 3));
		Assert.assertEquals(filtaUserType, userData.getCellData(1, 4));
		Assert.assertEquals(sendRemainder, false);
		Assert.assertEquals(employeeStatus, userData.getCellData(1, 5));
		Assert.assertEquals(displayEmployeeRecord, false);
		Assert.assertEquals(title, userData.getCellData(1, 6));
		Assert.assertEquals(workPhone, userData.getCellData(1, 7));
		Assert.assertEquals(mobile, userData.getCellData(1, 8));
		Assert.assertEquals(userData.getCellData(1, 9), prop.getProperty("Reports_To"));
		Assert.assertEquals(otherPhone, userData.getCellData(1, 10));
		Assert.assertEquals(fax, userData.getCellData(1, 11));
		Assert.assertEquals(defaultIMType, userData.getCellData(1, 12));
		Assert.assertEquals(iMName, userData.getCellData(1, 13));
		Assert.assertEquals(addressStreet, userData.getCellData(1, 14));
		Assert.assertEquals(addressCity, userData.getCellData(1, 15));
		Assert.assertEquals(addressState, userData.getCellData(1, 16));
		Assert.assertEquals(addressPostalZipCodel, userData.getCellData(1, 17));
		Assert.assertEquals(addressCountry, userData.getCellData(1, 18));
		Assert.assertEquals(standardRate, String.valueOf(userData.getCellDataInt(1, 19)));
		Assert.assertEquals(overTimeRate, String.valueOf(userData.getCellDataInt(1, 20)));
		Assert.assertEquals(description, userData.getCellData(1, 21));
		Assert.assertEquals(emailAddress1, userData.getCellData(1, 22));
		Assert.assertTrue(primaryRadio1);
		Assert.assertEquals(primaryReplyTo, false);

	}


	public void verifyDataOfUserProfile()
	{
		cancelButtonHeader.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(editButton));
		// To Check Label on User Profile Page
		Assert.assertEquals(userProfileUserLabel.getText(), prop.getProperty("UserProfileLabel1"));
		Assert.assertEquals(userProfileUserLabel.getCssValue("color"), prop.getProperty("UserProfileLabelColor"));
		Assert.assertEquals(userProfileEmployeeLabel.getText(), prop.getProperty("UserProfileLabel2"));
		Assert.assertEquals(userProfileEmployeeLabel.getCssValue("color"),
				prop.getProperty("UserProfileLabelColor"));
		Assert.assertEquals(userProfileEmailLabel.getText(), prop.getProperty("UserProfileLabel3"));
		Assert.assertEquals(userProfileEmailLabel.getCssValue("color"), prop.getProperty("UserProfileLabelColor"));
		Assert.assertEquals(userProfileAllLabel.getText(), prop.getProperty("UserProfileLabel4"));
		Assert.assertEquals(userProfileAllLabel.getCssValue("color"), prop.getProperty("UserProfileLabelColor"));
		// Verify Data On User profile Page
		Assert.assertEquals(userProfileFullname.getText(), firstName + " " + lastName);
		Assert.assertEquals(userProfileUsername.getText(), userName);
		Assert.assertEquals(userProfileStatus.getText(), status);
		Assert.assertTrue(userProfileUserType.getText().startsWith(userType.substring(0, 12)));
		Assert.assertEquals(userProfileFiltaUserType.getText(), filtaUserType);
		Assert.assertEquals(userProfileStoreAccess.isSelected(),
				Boolean.parseBoolean(prop.getProperty("StoreAccess")));
		Assert.assertTrue(userProfileSendRemainder.isSelected());
		Assert.assertEquals(userProfileEmployeeStatus.getText(), employeeStatus);
		Assert.assertEquals(userProfileDisplayEmployeeRecord.isSelected(),
				Boolean.parseBoolean("DisplayEmployeeRecords"));
		Assert.assertEquals(userProfileTitle.getText(), title);
		Assert.assertEquals(userProfileWorkPhone.getText().replace("  ", ""), workPhone);
		Assert.assertEquals(userProfileDepartment.getText(), department);
		Assert.assertEquals(userProfileMobile.getText().replace("  ", ""), mobile);
		Assert.assertEquals(userProfileReportsTo.getText().replace(" ", ""), prop.getProperty("Reports_To"));
		Assert.assertEquals(userProfileOtherPhone.getText().replace("  ", ""), otherPhone);
		Assert.assertEquals(userProfileFax.getText().replace("  ", ""), fax);
		Assert.assertEquals(userProfileIMType.getText(), defaultIMType);
		Assert.assertEquals(userProfileIMName.getText(), iMName);
		Assert.assertEquals(userProfileAddressStreet.getText(), addressStreet);
		Assert.assertEquals(userProfileAddressCity.getText(), addressCity);
		Assert.assertEquals(userProfileAddressState.getText(), addressState);
		Assert.assertEquals(userProfileAddressCounty.getText(), addressCountry);
		Assert.assertEquals(userProfileWeeklyStandardHours.getText(),
				weeklyStandardHours + " : " + defaultWeeklyStandardHoursMin);
		Assert.assertEquals(userProfileAddressPostalZipCode.getText(), addressPostalZipCodel);
		Assert.assertEquals(userProfileStandardRate.getText(), standardRate);
		Assert.assertEquals(userProfileOverTimeRate.getText(), overTimeRate);
		Assert.assertEquals(userProfileDescription.getText(), description);
		Assert.assertEquals(userProfilePrimaryEmail.getText(), emailAddress1);
	}


	public void checkPasswordPage()
	{
		editButton.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(getUserName));
		// Click On Password Tab
		tab2OnEditPage.click();
		Assert.assertEquals(tab2OnEditPage.getCssValue("color"), prop.getProperty("EditPagePasswordColor"));
		// Verify Password Data With The Help Of "UserPage.xlsx" sheet
		Assert.assertEquals(passwordPagePasswordLabel.getText(), passwordData.getCellData(0, 4));
		Assert.assertEquals(passwordPagePasswordLabel.getCssValue("color"), passwordData.getCellData(1, 4));
		Assert.assertEquals(passwordPageCurrentPasswordLabel.getText(), passwordData.getCellData(0, 0));
		Assert.assertEquals(passwordPageNewPasswordLabel.getText(), passwordData.getCellData(0, 1));
		Assert.assertEquals(passwordPageConfirmPassword.getText(), passwordData.getCellData(0, 2));
		Assert.assertEquals(passwordPageNote.getText(),
				passwordData.getCellData(0, 3) + " " + passwordData.getCellData(1, 3));
		// verify Alert and Validation Message On Alert
		currentpasswordInput.sendKeys(passwordData.getCellData(0, 1));
		saveButtonHeader.click();
		// Handling Alert1
		alert1 = globalObj.alert(driver);
		Assert.assertEquals(alert1, passwordData.getCellData(1, 5));
		newPasswordInput.sendKeys(passwordData.getCellData(0, 2));
		saveButtonHeader.click();
		// Handling Alert2
		alert2 = globalObj.alert(driver);
		Assert.assertEquals(alert2, passwordData.getCellData(1, 6));
		saveButtonHeader.click();
		globalObj.alertAccept(driver);
		// Check Validation Message At Confirmation Message
		confirmPasswordInput.sendKeys("KC");
		globalObj.wait(driver).until(
				ExpectedConditions.textToBePresentInElement(passwordValidation, "The passwords do not match."));
		Assert.assertEquals(passwordValidation.getText(), passwordData.getCellData(2, 2));
		// Clear Text For NewPasswordInput And ConfirmPasswordInput And Pass Valid
		// Password
		newPasswordInput.clear();
		newPasswordInput.sendKeys(passwordData.getCellData(1, 1));
		confirmPasswordInput.clear();
		confirmPasswordInput.sendKeys(passwordData.getCellData(1, 2));
		saveButtonHeader.click();
		tab2OnEditPage.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(passwordErrorMessage));
		Assert.assertEquals(passwordErrorMessage.getText(),
				passwordData.getCellData(1, 9) + " " + userName + passwordData.getCellData(1, 10));
		// Check Sugar Dashlet Message
		currentpasswordInput.sendKeys(passwordData.getCellData(1, 0));
		newPasswordInput.sendKeys(passwordData.getCellData(1, 1));
		confirmPasswordInput.sendKeys(passwordData.getCellData(1, 2));
		saveButtonHeader.click();
		globalObj.wait(driver)
				.until(ExpectedConditions.textToBePresentInElement(passwordUpdatedLabel, "Password Updated"));
		Assert.assertEquals(passwordUpdatedLabel.getText(), passwordData.getCellData(1, 7));
		Assert.assertEquals(passwordUpdatedLabel2.getText(), passwordData.getCellData(1, 8));
//		Sa.assertAll();
		sugarDashletClose.click();
	}


	public void checkThemesPage()
	{
		editButton.click();
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(getUserName));
		tab3OnEditPage.click();
		Assert.assertEquals(tab3OnEditPage.getCssValue("color"), prop.getProperty("EditPageThemeColor"));
		Assert.assertEquals(themeLabel.getText(), prop.getProperty("ThemeLabel"));
		// Check List Of Themes And Count Of Themes
		list = driver.findElements(By.xpath(".//select[@name='user_theme']//option"));
		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(list.get(i).getText(), themeData.getCellData(1, i));
		}
		Assert.assertEquals(list.size(), (int) (themeData.getCellDataInt(1, 2)));
		Assert.assertEquals(globalObj.select(defaultTheme).getFirstSelectedOption().getText(),
				themeData.getCellData(1, 1));
//		Sa.assertAll();
	}


	public void checkDataFromEditPageAdvanced()
	{
		tab4OnEditPage.click();
		Assert.assertEquals(tab4OnEditPage.getCssValue("color"), prop.getProperty("EditPageThemeColor"));
		Assert.assertEquals(tab4OnEditPage.getText(), prop.getProperty("AdvancedLabel"));
		Assert.assertEquals(userSettingLabel.getText(), prop.getProperty("Advanced1"));
		Assert.assertEquals(userSettingLabel.getCssValue("color"), prop.getProperty("EdiPageAdvancedColor"));
		Assert.assertEquals(exportDelimiterLabel.getText().startsWith(advancedData.getCellData(0, 0)), true);
		exportDelimiter = exportDelimiterlabelTextbox.getAttribute("value");
		Assert.assertEquals(exportDelimiter, advancedData.getCellData(2, 0));
		Assert.assertEquals(notifyOnAssignment.getText().startsWith(advancedData.getCellData(0, 3)), true);
		notifyOnAssignmentvalue = notifyOnAssignmentCheckBox.isSelected();
		Assert.assertTrue(notifyOnAssignmentvalue);
		Assert.assertTrue(importExportLabel.getText().startsWith(advancedData.getCellData(0, 1)));
		importExportCharSet = globalObj.select(defaultSelectedImportExport).getFirstSelectedOption().getText();
		Assert.assertEquals(importExportCharSet, advancedData.getCellData(2, 1));
		list = driver.findElements(By.xpath(".//div[@id='settings']//tr[3]//td[2]//select//option"));
		for (int i = 0; i < list.size(); i++)
		{
			// System.out.println(list.get(i).getText());
			Assert.assertEquals(list.get(i).getText(), advancedData.getCellData(i, 6));
		}
		Assert.assertEquals(list.size(), Integer.parseInt(prop.getProperty("CharachterSetCount")));
		Assert.assertEquals(remainderLabel.getText().startsWith(advancedData.getCellData(0, 4)), true);
		popupEditPage = popup.getText();
		Assert.assertEquals(popupEditPage, advancedData.getCellData(1, 4));
		remainEmailTextbox = defaultEmailCheckBox.isSelected();
		remainderPopupTextbox = defaultPopupCheckbox.isSelected();
		Assert.assertEquals(remainderPopupTextbox, false);
		Assert.assertEquals(remainEmailTextbox, false);
		emailEditPage = email.getText();
		Assert.assertEquals(emailEditPage, advancedData.getCellData(2, 4));
		Assert.assertEquals(showFullName.getText().startsWith(advancedData.getCellData(0, 2)), true);
		showFullNameValue = defaultShowFullameCheckbox.isSelected();
		Assert.assertTrue(showFullNameValue);
		mailMergetextBox = defaultMailMergeCheckBox.isSelected();
		Assert.assertEquals(mailMergetextBox, false);
		Assert.assertEquals(layoutOption.getText(), layoutData.getCellData(0, 0));
		Assert.assertEquals(layoutOption.getText(), layoutData.getCellData(0, 0));
		Assert.assertEquals(layoutOption.getCssValue("color"), prop.getProperty("EdiPageAdvancedColor"));
		Assert.assertEquals(moduleMenuLabel.getText(), layoutData.getCellData(0, 1));
		Assert.assertTrue(moduleMenuLabelCheckbox.isSelected());
		Assert.assertEquals(selectModule.getText(), layoutData.getCellData(0, 6));
		Assert.assertEquals(displayModule.getText(), layoutData.getCellData(0, 3));
		Assert.assertEquals(hideModule.getText(), layoutData.getCellData(0, 4));
		list = driver
				.findElements(By.xpath(".//div[@id='layout']//table//tbody//tr[3]//tr[2]//td[2]//select//option"));
		list3 = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getText().length() != 0)
			{
				// System.out.println(List.get(i).getText());
				list3.add(list.get(i).getText());
			}
		}
//		for (int i = 0; i < List.size(); i++) {
//			System.out.println(List.get(i));
//		}
		list2 = new ArrayList<String>();
		list2.add("Home");
		list2.add("Customers");
		list2.add("Contacts");
		list2.add("Leads");
		list2.add("Calendar");
		list2.add("Documents");
		list2.add("Emails");
		list2.add("Calls");
		list2.add("Tech App");
		list2.add("Accounts");
		list2.add("Site-Evaluations");
		list2.add("Tasks");
		list2.add("Notes");
		list2.add("FIM Accounts");
		list2.add("Targets");
		list2.add("Collections");
		list2.add("Collectors");
		list2.add("Franchisee");
		list2.add("Jacobsen");
		list2.add("FiltaBio Reported Volumes");
		list2.add("Routes");
		list2.add("Invoices");
		list2.add("Reports");
		list2.add("Timesheets");
		list2.add("Worksheets");
		list2.add("Oil Transfers");
		list2.add("Routes");
		list2.add("Coolers");
		list2.add("Vans");
		list2.add("Tanks");
		list2.add("Invoice Settings");
		list2.add("Jobs");
		list2.add("Fryers");
		list2.add("Schedule Infos");
		list2.add("Postal/Zip Code");
		list2.add("Territory");
		list2.add("FiltaFry Invoices");
		list2.add("Machines");
		list2.add("FiltaCool Panels");
		list2.add("Archive Reports");
		list2.add("NCA Outgoing Payments");
		list2.add("Discount & Rebate");
		list2.add("QB Invoices");
		list2.add("Allocate Unapplied Payments");
		list2.add("Invoices");
		list2.add("NCA Payments");
		list2.add("Franchisee Credit-Debit");
		list2.add("Franchisee Payments");
		list2.add("QB Invoice Line Items");
		list2.add("NCA Group");
		list2.add("Rebate Payments");
		list2.add("NCA Chain");
		list2.add("Unapplied Payments");
		list2.add("WO Storage Location");
		list2.add("Advertisement Spends");
		list2.add("Knowledge Base");
		list2.add("Buyers");
		Assert.assertTrue((list3.containsAll(list2)));
		Assert.assertEquals(subPanelTab.getText(), layoutData.getCellData(0, 5));
		Assert.assertEquals(subPanelCheckbox.isSelected(), true);
		Assert.assertEquals(localSetting.getText(), localSettingData.getCellData(0, 0));
		Assert.assertEquals(dataFormatLabel.getText(), localSettingData.getCellData(0, 1));
		list = driver.findElements(By.xpath(".//div[@id='locale']//tbody//tr[2]//td[2]//select//option"));
		dateFormat = globalObj.select(defaultDateFormat).getFirstSelectedOption().getText();
		Assert.assertEquals("\"" + dateFormat + "\"", localSettingData.getCellData(5, 1));
		for (int i = 0; i < list.size(); i++)
		{
//			System.out.println(List.get(i).getText());
			Assert.assertEquals("\"" + list.get(i).getText() + "\"", localSettingData.getCellData(i + 1, 1));
		}
		Assert.assertEquals(currencyLabel.getText(), localSettingData.getCellData(0, 2));
		list = driver.findElements(By.xpath(".//div[@id='locale']//tbody//tr[2]//td[4]//select//option"));
		currency = globalObj.select(defaultCurrency).getFirstSelectedOption().getText();
		Assert.assertEquals(currency, localSettingData.getCellData(1, 2));
		for (int i = 0; i < list.size(); i++)
		{
//			System.out.println(list6.get(i).getText());
			Assert.assertEquals(list.get(i).getText(), localSettingData.getCellData(i + 1, 2));

		}
		Assert.assertEquals(timeFormatLabel.getText(), localSettingData.getCellData(0, 3));
		list = driver.findElements(By.xpath(".//div[@id='locale']//tbody//tr[3]//td[2]//select//option"));

		list2 = new ArrayList<String>();
		for (int i = 0; i < list.size(); i++)
		{
			if (list.get(i).getText().length() != 0)
			{
//				System.out.println(List.get(i).getText());
				list2.add(list.get(i).getText());
			}

		}
		list2 = new ArrayList<String>();
		list2.add("23:00");
		list2.add("11:00pm");
		list2.add("11:00PM");
		list2.add("11:00 pm");
		list2.add("11:00 PM");
		list2.add("23.00");
		list2.add("11.00pm");
		list2.add("11.00PM");
		list2.add("11.00 pm");
		list2.add("11.00 PM");
		timeFormat = globalObj.select(defaultTimeFormat).getFirstSelectedOption().getText();
		Assert.assertEquals(timeFormat, list2.get(0));
		Assert.assertTrue(list2.containsAll(list2));
		Assert.assertEquals(currencySignificantDigitsLabel.getText(), localSettingData.getCellData(0, 4));

		list = driver.findElements(By.xpath(".//div[@id='locale']//tbody//tr[3]//td[4]//select//option"));
		for (int i = 0; i < list.size(); i++)
		{
			Assert.assertEquals(Integer.parseInt(list.get(i).getText()),
					(int) localSettingData.getCellDataInt(i + 1, 4));
		}
		currencySignificantDigit = Integer
				.parseInt(globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText());
		Assert.assertEquals(currencySignificantDigitsLabel, (int) localSettingData.getCellDataInt(3, 4));

		Assert.assertEquals(timeZoneLabel.getText(), localSettingData.getCellData(0, 5));
//		List = driver
//				.findElements(By.xpath(".//div[@id='locale']//tbody//tr[4]//td[2]//select//option"));
		timeZone = globalObj.select(defaultTimeZone).getFirstSelectedOption().getText();
		Assert.assertEquals(timeZone, localSettingData.getCellData(327 + 1, 5));
//		for (int i = 0; i < List.size(); i++)
//		{
//		System.out.println(List.get(i).getText());
//			Assert.assertEquals(List.get(i).getText(), LocalSettingData.getCellData(i + 1, 5));
//		}
		Assert.assertEquals(exampleLabel.getText(), localSettingData.getCellData(0, 6));
		Assert.assertEquals(exampleTextbox.isEnabled(), false);
		if (Integer.parseInt(
				globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText()) == 2)
		{
//			System.out.println(ExampleTextbox.getAttribute("value"));
			number = exampleTextbox.getAttribute("value");
			countZero = 0;
			countDollar = 0;
			countComma = 0;
			countDecimal = 0;
			countNumber = 0;
			for (int i = 0; i < number.length(); i++)
			{
				if (number.charAt(i) == '0')
				{
					countZero++;
				}
				if (number.charAt(i) == '$')
				{
					countDollar++;
				}
				if (number.charAt(i) == ',')
				{
					countComma++;
				}
				if (number.charAt(i) == '.')
				{
					countDecimal++;
				}
				if (number.charAt(i) == '1' || number.charAt(i) == '2' || number.charAt(i) == '3'
						|| number.charAt(i) == '4' || number.charAt(i) == '5' || number.charAt(i) == '6'
						|| number.charAt(i) == '7' || number.charAt(i) == '8' || number.charAt(i) == '9')
				{
					countNumber++;
				}
			}
			Assert.assertEquals(countZero, Integer.parseInt(
					globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText()));
			Assert.assertEquals(countDollar, (int) localSettingData.getCellDataInt(1, 7));
			Assert.assertEquals(countComma, (int) localSettingData.getCellDataInt(1, 8));
			Assert.assertEquals(countDecimal, (int) localSettingData.getCellDataInt(2, 9));
			Assert.assertEquals(countNumber, (int) localSettingData.getCellDataInt(1, 10));
		}
		globalObj.select(defaultCurrencySignificantDigits).selectByVisibleText("0");
		if (Integer.parseInt(
				globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText()) == 0)
		{
			number = exampleTextbox.getAttribute("value");
			countZero = 0;
			countDollar = 0;
			countComma = 0;
			countDecimal = 0;
			countNumber = 0;
			for (int i = 0; i < number.length(); i++)
			{
				if (number.charAt(i) == '0')
				{
					countZero++;
				}
				if (number.charAt(i) == '$')
				{
					countDollar++;
				}
				if (number.charAt(i) == ',')
				{
					countComma++;
				}
				if (number.charAt(i) == '.')
				{
					countDecimal++;
				}
				if (number.charAt(i) == '1' || number.charAt(i) == '2' || number.charAt(i) == '3'
						|| number.charAt(i) == '4' || number.charAt(i) == '5' || number.charAt(i) == '6'
						|| number.charAt(i) == '7' || number.charAt(i) == '8' || number.charAt(i) == '9')
				{
					countNumber++;
				}
			}
			Assert.assertEquals(countZero, Integer.parseInt(
					globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText()));
			Assert.assertEquals(countDollar, (int) localSettingData.getCellDataInt(1, 7));
			Assert.assertEquals(countComma, (int) localSettingData.getCellDataInt(1, 8));
			Assert.assertEquals(countDecimal, (int) localSettingData.getCellDataInt(1, 9));
			Assert.assertEquals(countNumber, (int) localSettingData.getCellDataInt(1, 10));

		}
		globalObj.select(defaultCurrencySignificantDigits).selectByVisibleText("1");
		if (Integer.parseInt(
				globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText()) == 1)
		{
			number = exampleTextbox.getAttribute("value");
			countZero = 0;
			countDollar = 0;
			countComma = 0;
			countDecimal = 0;
			countNumber = 0;
			for (int i = 0; i < number.length(); i++)
			{
				if (number.charAt(i) == '0')
				{
					countZero++;
				}
				if (number.charAt(i) == '$')
				{
					countDollar++;
				}
				if (number.charAt(i) == ',')
				{
					countComma++;
				}
				if (number.charAt(i) == '.')
				{
					countDecimal++;
				}
				if (number.charAt(i) == '1' || number.charAt(i) == '2' || number.charAt(i) == '3'
						|| number.charAt(i) == '4' || number.charAt(i) == '5' || number.charAt(i) == '6'
						|| number.charAt(i) == '7' || number.charAt(i) == '8' || number.charAt(i) == '9')
				{
					countNumber++;
				}
			}
			Assert.assertEquals(countZero, Integer.parseInt(
					globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText()));
			Assert.assertEquals(countDollar, (int) localSettingData.getCellDataInt(1, 7));
			Assert.assertEquals(countComma, (int) localSettingData.getCellDataInt(1, 8));
			Assert.assertEquals(countDecimal, (int) localSettingData.getCellDataInt(2, 9));
			Assert.assertEquals(countNumber, (int) localSettingData.getCellDataInt(1, 10));
		}
		globalObj.select(defaultCurrencySignificantDigits).selectByVisibleText("3");
		if (Integer.parseInt(
				globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText()) == 3)
		{
			number = exampleTextbox.getAttribute("value");
			countZero = 0;
			countDollar = 0;
			countComma = 0;
			countDecimal = 0;
			countNumber = 0;
			for (int i = 0; i < number.length(); i++)
			{
				if (number.charAt(i) == '0')
				{
					countZero++;
				}
				if (number.charAt(i) == '$')
				{
					countDollar++;
				}
				if (number.charAt(i) == ',')
				{
					countComma++;
				}
				if (number.charAt(i) == '.')
				{
					countDecimal++;
				}
				if (number.charAt(i) == '1' || number.charAt(i) == '2' || number.charAt(i) == '3'
						|| number.charAt(i) == '4' || number.charAt(i) == '5' || number.charAt(i) == '6'
						|| number.charAt(i) == '7' || number.charAt(i) == '8' || number.charAt(i) == '9')
				{
					countNumber++;
				}
			}
			Assert.assertEquals(countZero, Integer.parseInt(
					globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText()));
			Assert.assertEquals(countDollar, (int) localSettingData.getCellDataInt(1, 7));
			Assert.assertEquals(countComma, (int) localSettingData.getCellDataInt(1, 8));
			Assert.assertEquals(countDecimal, (int) localSettingData.getCellDataInt(2, 9));
			Assert.assertEquals(countNumber, (int) localSettingData.getCellDataInt(1, 10));
		}
		globalObj.select(defaultCurrencySignificantDigits).selectByVisibleText("4");
		if (Integer.parseInt(
				globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText()) == 4)
		{
			number = exampleTextbox.getAttribute("value");
			countZero = 0;
			countDollar = 0;
			countComma = 0;
			countDecimal = 0;
			countNumber = 0;
			for (int i = 0; i < number.length(); i++)
			{
				if (number.charAt(i) == '0')
				{
					countZero++;
				}
				if (number.charAt(i) == '$')
				{
					countDollar++;
				}
				if (number.charAt(i) == ',')
				{
					countComma++;
				}
				if (number.charAt(i) == '.')
				{
					countDecimal++;
				}
				if (number.charAt(i) == '1' || number.charAt(i) == '2' || number.charAt(i) == '3'
						|| number.charAt(i) == '4' || number.charAt(i) == '5' || number.charAt(i) == '6'
						|| number.charAt(i) == '7' || number.charAt(i) == '8' || number.charAt(i) == '9')
				{
					countNumber++;
				}
			}
			Assert.assertEquals(countZero, Integer.parseInt(
					globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText()));
			Assert.assertEquals(countDollar, (int) localSettingData.getCellDataInt(1, 7));
			Assert.assertEquals(countComma, (int) localSettingData.getCellDataInt(1, 8));
			Assert.assertEquals(countDecimal, (int) localSettingData.getCellDataInt(2, 9));
			Assert.assertEquals(countNumber, (int) localSettingData.getCellDataInt(1, 10));
		}
		globalObj.select(defaultCurrencySignificantDigits).selectByVisibleText("5");
		if (Integer.parseInt(
				globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText()) == 5)
		{
			number = exampleTextbox.getAttribute("value");
			countZero = 0;
			countDollar = 0;
			countComma = 0;
			countDecimal = 0;
			countNumber = 0;
			for (int i = 0; i < number.length(); i++)
			{
				if (number.charAt(i) == '0')
				{
					countZero++;
				}
				if (number.charAt(i) == '$')
				{
					countDollar++;
				}
				if (number.charAt(i) == ',')
				{
					countComma++;
				}
				if (number.charAt(i) == '.')
				{
					countDecimal++;
				}
				if (number.charAt(i) == '1' || number.charAt(i) == '2' || number.charAt(i) == '3'
						|| number.charAt(i) == '4' || number.charAt(i) == '5' || number.charAt(i) == '6'
						|| number.charAt(i) == '7' || number.charAt(i) == '8' || number.charAt(i) == '9')
				{
					countNumber++;
				}
			}
			Assert.assertEquals(countZero, Integer.parseInt(
					globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText()));
			Assert.assertEquals(countDollar, (int) localSettingData.getCellDataInt(1, 7));
			Assert.assertEquals(countComma, (int) localSettingData.getCellDataInt(1, 8));
			Assert.assertEquals(countDecimal, (int) localSettingData.getCellDataInt(2, 9));
			Assert.assertEquals(countNumber, (int) localSettingData.getCellDataInt(1, 10));
		}
		globalObj.select(defaultCurrencySignificantDigits).selectByVisibleText("6");
		if (Integer.parseInt(
				globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText()) == 6)
		{
			number = exampleTextbox.getAttribute("value");
			countZero = 0;
			countDollar = 0;
			countComma = 0;
			countDecimal = 0;
			countNumber = 0;
			for (int i = 0; i < number.length(); i++)
			{
				if (number.charAt(i) == '0')
				{
					countZero++;
				}
				if (number.charAt(i) == '$')
				{
					countDollar++;
				}
				if (number.charAt(i) == ',')
				{
					countComma++;
				}
				if (number.charAt(i) == '.')
				{
					countDecimal++;
				}
				if (number.charAt(i) == '1' || number.charAt(i) == '2' || number.charAt(i) == '3'
						|| number.charAt(i) == '4' || number.charAt(i) == '5' || number.charAt(i) == '6'
						|| number.charAt(i) == '7' || number.charAt(i) == '8' || number.charAt(i) == '9')
				{
					countNumber++;
				}
			}
			Assert.assertEquals(countZero, Integer.parseInt(
					globalObj.select(defaultCurrencySignificantDigits).getFirstSelectedOption().getText()));
			Assert.assertEquals(countDollar, (int) localSettingData.getCellDataInt(1, 7));
			Assert.assertEquals(countComma, (int) localSettingData.getCellDataInt(1, 8));
			Assert.assertEquals(countDecimal, (int) localSettingData.getCellDataInt(2, 9));
			Assert.assertEquals(countNumber, (int) localSettingData.getCellDataInt(1, 10));
		}
		Assert.assertEquals(separatorLabel.getText(), localSettingData.getCellData(0, 11));
		thousandsSeparator = sepratorTextbox.getAttribute("value");
		Assert.assertEquals(thousandsSeparator, localSettingData.getCellData(1, 11));
		Assert.assertEquals(nameDisplayFormatLabel.getText(), localSettingData.getCellData(0, 12) + " ");
		list = driver.findElements(By.xpath(".//div[@id='locale']//tbody//tr[6]//td[2]//select//option"));
		name = globalObj.select(defaultName).getFirstSelectedOption().getText();
		Assert.assertEquals(name, localSettingData.getCellData(1, 13));
		for (int i = 0; i < list.size(); i++)
		{
//			System.out.println(List.get(i).getText());
			Assert.assertEquals(list.get(i).getText(), localSettingData.getCellData(i + 1, 13));
		}
		Assert.assertEquals(decimalSymbolLabel.getText(), localSettingData.getCellData(0, 14));
		decimalSymbol = decimalSymbolTextbox.getAttribute("value");
		Assert.assertEquals(decimalSymbol, localSettingData.getCellData(1, 14));
		Assert.assertEquals(calendarOptionLabel.getText(), calendarOptionData.getCellData(0, 0));
		Assert.assertEquals(calendarOptionLabel.getCssValue("color"), calendarOptionData.getCellData(1, 0));
		Assert.assertEquals(publishKeyLabel.getText(), calendarOptionData.getCellData(0, 1));
		Assert.assertEquals(publishKeyTextbox.getText().isEmpty(), true);
		publishAtMyLocationValue = publishAtMyLocation.getText();
		Assert.assertEquals(publishAtMyLocationValue, calendarOptionData.getCellData(0, 2));
		if (!publishAtMyLocationText.getText().contains("&email="))
		{
			Assert.assertEquals(publishAtMyLocationText.getText(),
					calendarOptionData.getCellData(1, 2) + emailAddress1);
		}
		else if (publishAtMyLocationText.getText().contains("&email="))
		{
			Assert.assertEquals(publishAtMyLocationText.getText(),
					calendarOptionData.getCellData(2, 2) + emailAddress1);
		}
		Assert.assertEquals(searchLocationLabel.getText(), calendarOptionData.getCellData(0, 3));
		searchLocation = searchLocationText.getText();
		Assert.assertEquals(searchLocation, calendarOptionData.getCellData(1, 3));
		Assert.assertEquals(iCalintegrationURLLabel.getText(), calendarOptionData.getCellData(0, 4));
		iCalValue = iCalintegrationText.getText();
		Assert.assertEquals(iCalValue, calendarOptionData.getCellData(1, 4));
		Assert.assertEquals(firstDayOfWeekLabel.getText(), calendarOptionData.getCellData(0, 5));
		list = driver.findElements(By.xpath(".//div[@id='calendar_options']//tr[6]//td[2]//slot//select//option"));
		for (int i = 0; i < list.size(); i++)
		{
//			System.out.println(list13.get(i).getText());
			Assert.assertEquals(list.get(i).getText(), calendarOptionData.getCellData(i + 1, 5));
		}
		firstDayOfWeek = globalObj.select(defaultFirstdayOfWeek).getFirstSelectedOption().getText();
		Assert.assertEquals(firstDayOfWeek, calendarOptionData.getCellData(1, 5));
		globalObj.jsReturn(driver).executeScript("arguments[0].scrollIntoView();", cancelButtonFooter);
		cancelButtonFooter.click();
//		Sa.assertAll();
	}


	public void verifyDataOfAdvanced()
	{
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(editButton));
		advancedTab.click();
		Assert.assertEquals(advancedTabLabel.getText(), advancedData.getCellData(0, 7));
		Assert.assertEquals(advancedTabLabel.getCssValue("color"), advancedData.getCellData(1, 7));
		Assert.assertEquals(userSettingUserPage.getText(), advancedData.getCellData(0, 8));
		Assert.assertEquals(userSettingUserPage.getCssValue("color"), advancedData.getCellData(1, 8));
		Assert.assertEquals(notifyOnAssignmentUserPage.getText(), advancedData.getCellData(0, 9));
//		Assert.assertEquals(NotifyOnAssignmentValueUserPage.isSelected(), NotifyOnAssignmentvalue);
		Assert.assertEquals(notifyOnAssignmentTextUserPage.getText(), advancedData.getCellData(1, 9) + " ");
		Assert.assertEquals(remainderUserPage.getText(), advancedData.getCellData(0, 10));
		Assert.assertEquals(popupCheckBoxUserPage.isSelected(), remainderPopupTextbox);
		Assert.assertEquals(popupCheckBoxUserPage.isEnabled(), false);
		Assert.assertEquals(emailCheckBoxUserPage.isSelected(), remainEmailTextbox);
		Assert.assertEquals(emailCheckBoxUserPage.isEnabled(), false);
		Assert.assertEquals(popupUserPage.getText(), popupEditPage);
		Assert.assertEquals(emailUserPage.getText(), emailEditPage);
		Assert.assertEquals(remainderText.getText(), advancedData.getCellData(3, 4) + " ");
		Assert.assertEquals(mailMergeuserPage.getText(), advancedData.getCellData(0, 5));
		Assert.assertEquals(mailMergeUserPageCheckBox.isSelected(), mailMergetextBox);
		Assert.assertEquals(mailMergeUserPageCheckBox.isEnabled(), false);
		Assert.assertEquals(mailMergeTextUserPage.getText(), advancedData.getCellData(1, 5) + " ");
		Assert.assertEquals(uRLUserPage.getText(), advancedData.getCellData(0, 11));
		Assert.assertEquals(uRLUserPage2.getText(), advancedData.getCellData(1, 11));
		Assert.assertEquals(uRLUserPage3.getText(), advancedData.getCellData(2, 11) + " ");
		Assert.assertEquals(exportDelimiterUserPage.getText(), advancedData.getCellData(0, 0));
		Assert.assertEquals(exportDelimiterTextboxUserPage.getText(), exportDelimiter);
		Assert.assertEquals(exportDelimiterText.getText(), advancedData.getCellData(1, 0));
		Assert.assertEquals(importExportUserPage.getText(), advancedData.getCellData(0, 1));
		Assert.assertEquals(importExportText.getText(), advancedData.getCellData(2, 1));
		Assert.assertEquals(importExportTextUserPage.getText(), advancedData.getCellData(1, 1));
		Assert.assertEquals(showFullNamesTextUserPage.getText(), advancedData.getCellData(0, 2));
		Assert.assertEquals(showFullNameTextBox.isEnabled(), false);
		Assert.assertEquals(showFullNameUserPage.getText(), advancedData.getCellData(1, 2));

		Assert.assertEquals(localeUserPage.getText(), localSettingData.getCellData(0, 0));
		Assert.assertEquals(localeUserPage.getCssValue("color"), localSettingData.getCellData(1, 0));
		Assert.assertEquals(dataFormatUserPageLabel.getText(), localSettingData.getCellData(0, 1));
		Assert.assertEquals(dataFormatTextUserPage.getText(), localSettingData.getCellData(10, 1) + " ");
		Assert.assertEquals(timeFormatUserPage.getText(), localSettingData.getCellData(0, 3));
		Assert.assertEquals(timeFormatValueUserPage.getText(), timeFormat + " ");
		Assert.assertEquals(timeFormatText.getText(), localSettingData.getCellData(11, 3) + " ");
		Assert.assertEquals(timeZoneUserPage.getText(), localSettingData.getCellData(0, 5));
		Assert.assertEquals(timeZoneValueUserPage.getText(), localSettingData.getCellData(327 + 1, 5) + " ");
		Assert.assertEquals(currencyUserPage.getText(), localSettingData.getCellData(0, 2));
		Assert.assertEquals(currencyValueUserPage.getText().contains("USD"), true);
		Assert.assertEquals(currencyText.getText(), localSettingData.getCellData(5, 2) + " ");
		Assert.assertEquals(currencyDigitUserPage.getText(), localSettingData.getCellData(0, 4));
		Assert.assertEquals(Integer.parseInt(currencyDigitValueUserpage.getText().replace(" ", "")),
				currencySignificantDigit);
		Assert.assertEquals(currencyDigitTextUserpage.getText(), localSettingData.getCellData(8, 4) + " ");
		Assert.assertEquals(thousandsUserPage.getText(), localSettingData.getCellData(0, 11));
		Assert.assertEquals(thousandsValueUserPage.getText().replace(" ", ""), localSettingData.getCellData(1, 11));
		Assert.assertEquals(thousandsTextValueUserPage.getText().contains(localSettingData.getCellData(2, 11)), true);
		Assert.assertEquals(decimalUserPage.getText(), localSettingData.getCellData(0, 14));
		Assert.assertEquals(decilamlValueUserPage.getText().replace(" ", ""), localSettingData.getCellData(1, 14));
		Assert.assertEquals(deciamlTextUserPage.getText(), localSettingData.getCellData(2, 14) + " ");
		Assert.assertEquals(nameDisplayUserPage.getText(), localSettingData.getCellData(0, 12));
		Assert.assertEquals(nameDisplayValueOneUserPage.getText(), localSettingData.getCellData(1, 12));
		Assert.assertEquals(nameDisplayValueSecondUserPage.getText(), localSettingData.getCellData(2, 12));
		Assert.assertEquals(nameDisplayValueThirdUserPage.getText(), localSettingData.getCellData(3, 12));
		Assert.assertEquals(nameDisplayValueForthUserPage.getText(), localSettingData.getCellData(4, 12));
		Assert.assertEquals(nameDisplayValueFifthUserPage.getText(), localSettingData.getCellData(5, 12));
		Assert.assertEquals(nameDisplayValueSixthUserPage.getText(), localSettingData.getCellData(6, 12));
		Assert.assertEquals(nameDisplayTextUserPage.getText(), localSettingData.getCellData(7, 12) + " ");
		Assert.assertEquals(calendarOption.getText(), calendarOptionData.getCellData(0, 0));
		Assert.assertEquals(calendarOption.getCssValue("color"), calendarOptionData.getCellData(1, 0));
		Assert.assertEquals(publishKey.getText(), calendarOptionData.getCellData(0, 1));
		Assert.assertEquals(publishKeyText.getText(), calendarOptionData.getCellData(1, 1) + " ");
		Assert.assertEquals(publishatmylocation.getText(), calendarOptionData.getCellData(0, 2));
		if (publishatmylocationtext.getText().contains("&email="))
		{
			Assert.assertEquals(publishatmylocationtext.getText(),
					calendarOptionData.getCellData(2, 2) + emailAddress1);
		}
		else
		{
			Assert.assertEquals(publishatmylocationtext.getText(), calendarOptionData.getCellData(1, 2));
		}
		Assert.assertEquals(searchLocationn.getText(), calendarOptionData.getCellData(0, 3));
		Assert.assertEquals(searchLocationText.getText(), calendarOptionData.getCellData(1, 3));
		Assert.assertEquals(iCal.getText(), calendarOptionData.getCellData(0, 4));
		Assert.assertEquals(iCalText.getText(), calendarOptionData.getCellData(1, 4));
		Assert.assertEquals(firstDayOfWeekk.getText(), calendarOptionData.getCellData(0, 5));
		Assert.assertTrue(firstDayOfWeekText.getText().contains(firstDayOfWeek));
		Assert.assertTrue(firstDayOfWeekText.getText().contains(calendarOptionData.getCellData(8, 5)));
		Assert.assertEquals(layoutOption.getText(), layoutData.getCellData(0, 0));
		Assert.assertEquals(layoutOption.getCssValue("color"), layoutData.getCellData(1, 0));
		Assert.assertEquals(moduleMenuFilter.getText(), layoutData.getCellData(0, 1));
		Assert.assertEquals(moduleMenuFiltertext.getText(), layoutData.getCellData(1, 1) + " ");
		Assert.assertEquals(subPanelTab.getText(), layoutData.getCellData(0, 5));
		Assert.assertEquals(subPanelTabText.getText(), layoutData.getCellData(1, 5) + " ");
		Assert.assertEquals(all.getText(), layoutData.getCellData(0, 8));
		Assert.assertEquals(all.getCssValue("color"), layoutData.getCellData(1, 8));
	}


	public void accessCheck()
	{
		globalObj.wait(driver).until(ExpectedConditions.visibilityOf(access));
		access.click();
		list = driver.findElements(By.xpath(".//div[@class='table-responsive-edit']//table//tbody//tr"));
//		System.out.println(List.size());
//		for (int i = 0; i < List.size(); i++)
//		{
//			System.out.println(List.get(i).getText());
//		}
		for (int i = 0; i < list.size(); i++)
		{
			if (driver.findElement(
					By.xpath(".//div[@class='table-responsive-edit']//table//tbody/tr[" + (i + 1) + "]//td[1]"))
					.getText().equals(accessData.getCellData(i, 0)) == true)
			{
				Assert.assertEquals(driver.findElement(By
						.xpath(".//div[@class='table-responsive-edit']//table//tbody/tr[" + (i + 1) + "]//td[1]"))
						.getText(), accessData.getCellData(i, 0));
			}
		}
//		List = driver
//				.findElements(By.xpath(".//div[@class='table-responsive-edit']//table//tbody//tr[1]//td"));
//		for (int i = 0; i < List.size(); i++)
//		{
//			System.out.println(Driver.findElement(
//					By.xpath(".//div[@class='table-responsive-edit']//table//tbody/tr[1]//td[" + (i + 1) + "]"))
//					.getText());
//			if (Driver.findElement(
//					By.xpath(".//div[@class='table-responsive-edit']//table//tbody/tr[1]//td[" + (i + 1) + "]"))
//					.getText().equals(" ") == true)
//			{
//				System.out.println("Blank Value");
//			}
//			else {
//				Assert.assertEquals(Driver.findElement(By
//						.xpath(".//div[@class='table-responsive-edit']//table//tbody/tr[1]//td[" + (i + 1) + "]"))
//						.getText(), AccessData.getCellData(i, 0));
//			}
//		}

//		List = Driver.findElements(By.xpath(".//div[@class='table-responsive-edit']//table//tbody//tr[2]//td[3]"));
		for (int i = 1; i < list.size(); i++)
		{
			Assert.assertEquals(driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[3]"))
					.getText(), accessData.getCellData(i, 2));
			Assert.assertEquals(driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[4]"))
					.getText(), accessData.getCellData(i, 3));
			Assert.assertEquals(driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[5]"))
					.getText(), accessData.getCellData(i, 4));
			Assert.assertEquals(driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[6]"))
					.getText(), accessData.getCellData(i, 5));
			Assert.assertEquals(driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[7]"))
					.getText(), accessData.getCellData(i, 6));
			Assert.assertEquals(driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[8]"))
					.getText(), accessData.getCellData(i, 7));
			Assert.assertEquals(driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[9]"))
					.getText(), accessData.getCellData(i, 8));
			if (driver.findElement(
					By.xpath(".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[2]"))
					.getText().equals(accessData.getCellData(0, 9)))
			{
				Assert.assertEquals(driver.findElement(By.xpath(
						".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[2]"))
						.getCssValue("color"), accessData.getCellData(1, 9));
			}
			if (driver.findElement(
					By.xpath(".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[3]"))
					.getText().equals(accessData.getCellData(0, 10)))
			{
				Assert.assertEquals(driver.findElement(By.xpath(
						".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[3]"))
						.getCssValue("color"), accessData.getCellData(1, 10));
			}
			else if (driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[3]"))
					.getText().equals(accessData.getCellData(0, 11)))
			{
				Assert.assertEquals(driver.findElement(By.xpath(
						".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[3]"))
						.getCssValue("color"), accessData.getCellData(1, 11));
			}
			else if (driver
					.findElement(By.xpath(
							".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[3]"))
					.getText().equals(accessData.getCellData(0, 12)))
			{
				Assert.assertEquals(driver.findElement(By.xpath(
						".//div[@class='table-responsive-edit']//table//tbody//tr[" + (i + 1) + "]//td[3]"))
						.getCssValue("color"), accessData.getCellData(1, 12));
			}
		}
//		System.out.println(NoneColor.getCssValue("color"));
//		System.out.println(AllColor.getCssValue("color"));
//		System.out.println(OwnerColor.getCssValue("color"));
//		System.out.println(
//				driver.findElement(By.xpath(".//div[@id='subpanel_title_aclroles']//table//tbody//h3/span[1]"))
//						.getText());
		Assert.assertEquals(roles.getText(), accessData.getCellData(0, 13));
		Assert.assertEquals(rolesName.getText(), accessData.getCellData(0, 14));
		Assert.assertEquals(rolesDescription.getText(), accessData.getCellData(0, 15));
		Assert.assertEquals(rolesFranchisee.getText(), accessData.getCellData(0, 16));
		Assert.assertEquals(rolesNotDelete.getText(), accessData.getCellData(0, 17));
		Assert.assertEquals(rolesALL.getText(), accessData.getCellData(0, 18));
//		Sa.assertAll();
	}


	public void availableLinks()
	{
		list = driver.findElements(By.tagName("a"));
		for (int i = 0; i < list.size(); i++)
		{
			System.out.println("URL Name => " + list.get(i).getText());
		}
	}


	public List<WebElement> findAllLinks(WebDriver driver)

	{

		elementList = driver.findElements(By.tagName("a"));

		elementList.addAll(driver.findElements(By.tagName("img")));

		finalList = new ArrayList<WebElement>();

		for (WebElement element : elementList)

		{

			if (element.getAttribute("href") != null)

			{

				finalList.add(element);

			}

		}

		return finalList;

	}


	public static String isLinkBroken(URL url) throws Exception

	{

		// url = new URL("https://yahoo.com");

		String response = "";

		HttpURLConnection connection = (HttpURLConnection) url.openConnection();

		try

		{

			connection.connect();

			response = connection.getResponseMessage();

			connection.disconnect();

			return response;

		}

		catch (Exception exp)

		{

			return exp.getMessage();

		}

	}


	public void brokenLink()
	{
		allLinks = findAllLinks(driver);

		System.out.println("Total Number Of Elements Found " + allLinks.size());

		for (WebElement element : allLinks)
		{

			try

			{

				System.out.println("URL: " + element.getAttribute("href") + " Returned "
						+ isLinkBroken(new URL(element.getAttribute("href"))));

				// System.out.println("URL: " + element.getAttribute("outerhtml")+ " returned "
				// + isLinkBroken(new URL(element.getAttribute("href"))));

			}

			catch (Exception exp)

			{

				System.out.println("At " + element.getAttribute("innerHTML") + " Exception Occured -&gt; "
						+ exp.getMessage());

			}

		}

	}


	public void closeBrowser()
	{
		logout.logout();
		driver.close();
	}
}

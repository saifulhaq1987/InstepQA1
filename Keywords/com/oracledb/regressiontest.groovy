package com.oracledb

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import java.util.List
import org.openqa.selenium.WebElement
import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import org.openqa.selenium.JavascriptExecutor
import org.stringtemplate.v4.compiler.CodeGenerator.region_return
import org.openqa.selenium.WebDriver
import org.openqa.selenium.By
import com.kms.katalon.core.mobile.keyword.internal.MobileDriverFactory
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.mobile.helper.MobileElementCommonHelper
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webui.exception.WebElementNotFoundException
import groovy.sql.Sql

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;///..../////


public class regressiontest {
	/**
	 * Refresh browser
	 */
	@Keyword
	def refreshBrowser() {
		KeywordUtil.logInfo("Refreshing")
		WebDriver webDriver = DriverFactory.getWebDriver()
		webDriver.navigate().refresh()
		KeywordUtil.markPassed("Refresh successfully")
	}

	/**
	 * Click element
	 * @param to Katalon test object
	 */
	@Keyword
	def clickElement(TestObject to) {
		try {
			WebElement element = WebUiBuiltInKeywords.findWebElement(to);
			KeywordUtil.logInfo("Clicking element")
			element.click()
			KeywordUtil.markPassed("Element has been clicked")
		} catch (WebElementNotFoundException e) {
			KeywordUtil.markFailed("Element not found")
		} catch (Exception e) {
			KeywordUtil.markFailed("Fail to click on element")
		}
	}

	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	// Oracle Database connection connect.
	@Keyword
	def connectDB (String ora_connt, String ora_usr,  String ora_psswrd) {

		def cnnct = Sql.newInstance(ora_connt, ora_usr, ora_psswrd,
				"oracle.jdbc.pool.OracleDataSource")
		return cnnct
	}
	// Login to Trade Funds Product Application (IDD).
	@Keyword
	def LoginTFProduct(String User, String Password) {
		WebUI.openBrowser('')

		WebUI.waitForPageLoad(5)

		WebUI.maximizeWindow()

		WebUI.navigateToUrl('https://52.6.78.242:7008/e360/com.informatica.tools.mdm.web.auth/login')

		WebUI.delay(5)

		if (WebUI.verifyElementPresent(findTestObject('Object Repository/Page_ Login/Btn_Advanced'), 5, FailureHandling.OPTIONAL))
		{
			WebUI.delay(2)

			WebUI.click(findTestObject('Object Repository/Page_ Login/Btn_Advanced'))

			WebUI.delay(2)

			WebUI.click(findTestObject('Object Repository/Page_ Login/Btn_ProceedTo'))

			WebUI.delay(2)
		}
		else
		{
			WebUI.delay(2)

			println("--------- else successfull-------------------")
		}

		WebUI.setText(findTestObject('Object Repository/Page_ Login/Txt_Username'), User)

		WebUI.delay(2)

		WebUI.setText(findTestObject('Object Repository/Page_ Login/Txt_Password'), Password)

		WebUI.click(findTestObject('Object Repository/Page_ Login/Btn_Login'))

		WebUI.waitForPageLoad(7)

		WebUI.click(findTestObject('Object Repository/Page_ Login/Project_Selection/div_Trade Funds Product'))

	}
	// Logout Trade Funds Product Application (IDD).
	@Keyword
	def logoutTFProduct() {

		WebUI.waitForPageLoad(GlobalVariable.G_Timeout, FailureHandling.STOP_ON_FAILURE)

		WebUI.mouseOverOffset(findTestObject('TF_Product_Open_Pages/Page_Informatica MDM/td_Jiwani DS'), 5, 5)

		WebUI.delay(3)

		WebUI.click(findTestObject('TF_Product_Open_Pages/Page_Informatica MDM/a_Log Out'))

		WebUI.delay(3)
	}

	// Verify JMS Sales Organization from record Database.
	@Keyword
	def verifyJMSSalesOrg(String ora_connt, String ora_usr, String ora_psswrd, String ora_schema, String input_Sales_Org_Description) {
		def cnnct = Sql.newInstance(ora_connt, ora_usr, ora_psswrd,
				"oracle.jdbc.pool.OracleDataSource")
		def str_Query = "SELECT JMS_SALES_ORG_NAME FROM "+ora_schema+".C_MSB_BO_JMS_SALES_ORG WHERE JMS_SALES_ORG_NAME = ?" as String
		def vrfy_JMSSO = cnnct.firstRow(str_Query, [input_Sales_Org_Description])
		cnnct.close()
		return vrfy_JMSSO
	}

	@Keyword
	//generating a random Name for any subject area.

	def genName(int length) {

		String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"

		Random rand = new Random();

		StringBuilder sb = new StringBuilder();

		for (int i=0; i<length; i++) {

			sb.append(chars.charAt(rand.nextInt(chars.length()))); }

		return sb.toString(); }

	@Keyword
	//generating a random Name for any subject area.

	def genCode(int length) {

		String chars = "0123456789"

		Random rand = new Random();

		StringBuilder sb = new StringBuilder();

		for (int i=0; i<length; i++) {

			sb.append(chars.charAt(rand.nextInt(chars.length()))); }

		return sb.toString(); }

	@Keyword
	//get current date
	def returnDate(int Days){
		DateFormat dateFormat = new SimpleDateFormat("d/MMM/yyyy");
		dateFormat.setTimeZone(new SimpleTimeZone(SimpleTimeZone.UTC_TIME, "UTC"));
		Date date = new Date();
		return dateFormat.format(date+1);
	}


}

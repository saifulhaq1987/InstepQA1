package com.oralcedatabase
import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testcase.TestCaseFactory
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testdata.TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords
import org.openqa.selenium.JavascriptExecutor
import internal.GlobalVariable
import MobileBuiltInKeywords as Mobile
import WSBuiltInKeywords as WS
import WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebElement
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




class tfregressiontest {
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

	/**
	 * Get all rows of HTML table
	 * @param table Katalon test object represent for HTML table
	 * @param outerTagName outer tag name of TR tag, usually is TBODY
	 * @return All rows inside HTML table
	 */
	@Keyword
	def List<WebElement> getHtmlTableRows(TestObject table, String outerTagName) {
		WebElement mailList = WebUiBuiltInKeywords.findWebElement(table)
		List<WebElement> selectedRows = mailList.findElements(By.xpath("./" + outerTagName + "/tr"))
		return selectedRows
	}

	@Keyword
	def LoginTFCustomer(String User, String Password) {
		WebUI.openBrowser('')

		WebUI.waitForPageLoad(10)

		WebUI.maximizeWindow()

		WebUI.navigateToUrl('https://52.6.78.242:7008/e360/com.informatica.tools.mdm.web.auth/login')

		WebUI.setText(findTestObject('Object Repository/Page_ Login/Txt_Username'), User)

		WebUI.setText(findTestObject('Object Repository/Page_ Login/Txt_Password'), Password)

		WebUI.click(findTestObject('Object Repository/Page_ Login/Btn_Login'))

		WebUI.waitForPageLoad(5)

		WebUI.click(findTestObject('Object Repository/Page_ Login/Project_Selection/div_Trade Funds Customer'))

		WebUI.delay(1)
	}

	@Keyword
	def verifyBanner(String ora_connt, String ora_usr,  String ora_psswrd, String ora_schema, String Inpt_Banner_Name) {
		def cnnct = Sql.newInstance(ora_connt, ora_usr, ora_psswrd,
				"oracle.jdbc.pool.OracleDataSource")
		def str_Query = "SELECT BANNER_NAME FROM "+ora_schema+".C_MSB_BO_BANNER WHERE BANNER_NAME = ?" as String
		def row_MTCH = cnnct.firstRow(str_Query, [Inpt_Banner_Name])
		cnnct.close()
		return row_MTCH
	}
}
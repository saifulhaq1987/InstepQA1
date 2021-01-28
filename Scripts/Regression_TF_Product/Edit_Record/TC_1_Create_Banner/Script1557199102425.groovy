import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import org.openqa.selenium.Keys as Keys

WebUI.delay(6)

WebUI.mouseOver(findTestObject('TF_Product_Create/1_Menu_Navigation_To_Open_All_Pages/0_Menu_Create_In_Data_View'))

WebUI.waitForPageLoad(GlobalVariable.G_Timeout)

WebUI.mouseOver(findTestObject('TF_Product_Create/1_Menu_Navigation_To_Open_All_Pages/1_Menu_Create_Master_Data'))

WebUI.waitForPageLoad(GlobalVariable.G_Timeout)

WebUI.click(findTestObject('TF_Product_Create/2_Select_Menu_Options(All)/1_Menu_JMS_Sales_Organisation'))

WebUI.waitForPageLoad(GlobalVariable.G_Timeout)

WebUI.delay(4)

def bname = CustomKeywords.'com.oracledb.regressiontest.genName'(10)

/*
//generating a random bannerName.

def bannerName(int length) {
	
	String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789"
	
	Random rand = new Random();
	
	StringBuilder sb = new StringBuilder();
	
	for (int i=0; i<length; i++) {
	
	sb.append(chars.charAt(rand.nextInt(chars.length()))); }
	
	return sb.toString(); }
//Saving random generated bannerName into a variable naming bname here
def bname = bannerName(10) 
*/
//using bannerName as input. 
WebUI.setText(findTestObject('null'), 
    bname)

WebUI.delay(3)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Apply_Button/td_Apply'))

WebUI.delay(2)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Save_Button/btn_Save'))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Verify_Success_Message/Success_Message'), 
    'Record has been saved successfully.', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Data_Tab/span_Data_Tab'))

WebUI.delay(1)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Close_Button/btn_Close'))

WebUI.delay(1)

vrfy_BNR = CustomKeywords.'com.oracledb.regressiontest.verifyBanner'(GlobalVariable.ora_connt, GlobalVariable.ora_usr, GlobalVariable.ora_psswrd, 
    GlobalVariable.ora_schema, bname)

// Check for correct result
println('BANNER_NAME')

//WS.verifyEqual(java.lang.Class<row.Inpt_Banner_Name> )
WS.verifyEqual(vrfy_BNR.BANNER_NAME, bname)


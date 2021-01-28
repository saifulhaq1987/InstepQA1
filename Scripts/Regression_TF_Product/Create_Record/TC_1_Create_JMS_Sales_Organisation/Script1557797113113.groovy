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

WebUI.waitForPageLoad(GlobalVariable.G_Timeout)

WebUI.mouseOver(findTestObject('TF_Product_Create/1_Menu_Navigation_To_Open_All_Pages/0_Menu_Create_In_Data_View'))

WebUI.delay(3)

WebUI.mouseOver(findTestObject('TF_Product_Create/1_Menu_Navigation_To_Open_All_Pages/1_Menu_Create_Master_Data'))

WebUI.delay(5)

WebUI.click(findTestObject('TF_Product_Create/2_Select_Menu_Options(All)/1_Menu_JMS_Sales_Organisation'))

WebUI.waitForPageLoad(GlobalVariable.G_Timeout)

WebUI.delay(3)

Sales_Org_Code = CustomKeywords.'com.oracledb.regressiontest.genCode'(4)

Sales_Org_Description = CustomKeywords.'com.oracledb.regressiontest.genName'(15)

WebUI.delay(3)

WebUI.setText(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/1_Create_JMS_Sales_Organization/input_Sales_Org_Code'), 
    Sales_Org_Code)

WebUI.setText(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/1_Create_JMS_Sales_Organization/input_Sales_Org_Description'), 
    Sales_Org_Description)

WebUI.delay(2)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Apply_Button/td_Apply'))

WebUI.delay(2)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Save_Button/btn_Save'))

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Verify_Success_Message/Success_Message'), 
    'Record has been saved successfully.', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(5)

if (true) {
    WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Close_Button/btn_Close'), FailureHandling.CONTINUE_ON_FAILURE)
} else {
    WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Close_Button/btn_Close'), FailureHandling.CONTINUE_ON_FAILURE)
}

WebUI.delay(5)

not_run: WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Close_Button/btn_Close'), FailureHandling.OPTIONAL)

WebUI.waitForPageLoad(GlobalVariable.G_Timeout)

not_run: vrfy_JMSSO = CustomKeywords.'com.oracledb.regressiontest.verifyJMSSalesOrg'(GlobalVariable.ora_connt, GlobalVariable.ora_usr, 
    GlobalVariable.ora_psswrd, GlobalVariable.ora_schema, Sales_Org_Description)

not_run: println('JMS_SALES_ORG_NAME')

not_run: WebUI.verifyEqual(vrfy_JMSSO.JMS_SALES_ORG_NAME, Sales_Org_Description)

WebUI.delay(5)

WebUI.click(findTestObject('Edit_Record_Queries/Common_Action_Buttons/Pen_button'))

Sales_Org_Code = CustomKeywords.'com.oracledb.regressiontest.genCode'(4)

Sales_Org_Description = CustomKeywords.'com.oracledb.regressiontest.genName'(15)

WebUI.delay(3)

WebUI.setText(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/1_Create_JMS_Sales_Organization/input_Sales_Org_Code'), 
    Sales_Org_Code)

WebUI.setText(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/1_Create_JMS_Sales_Organization/input_Sales_Org_Description'), 
    Sales_Org_Description)

WebUI.delay(2)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Apply_Button/td_Apply'))

WebUI.delay(2)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Save_Button/btn_Save'))

WebUI.delay(2)

WebUI.verifyElementText(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Verify_Success_Message/Success_Message'), 
    'Record has been saved successfully.', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Close_Button/btn_Close'))


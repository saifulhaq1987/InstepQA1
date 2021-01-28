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

WebUI.delay(2)

WebUI.click(findTestObject('Edit_Record_Queries/Common_Action_Buttons/btn_Queries'))

WebUI.waitForPageLoad(GlobalVariable.G_Timeout)

WebUI.delay(3)

WebUI.click(findTestObject('Edit_Record_Queries/edit_Baner/link_Banner_fldr'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.click(findTestObject('Edit_Record_Queries/edit_Baner/lnk_banner_qry'), FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(1)

WebUI.click(findTestObject('Edit_Record_Queries/Common_Action_Buttons/opn_Qry'))

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Data_Tab/span_Data_Tab'))

WebUI.delay(1)

WebUI.setText(findTestObject('Edit_Record_Queries/edit_Baner/inpt_Banner_Nm'), Inpt_Banner_Name)

WebUI.click(findTestObject('Edit_Record_Queries/Common_Action_Buttons/run_Search'))

WebUI.click(findTestObject('Edit_Record_Queries/edit_Baner/open_s_result/td_Open'))

not_run: WebUI.verifyElementText(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Verify_Success_Message/Success_Message'), 
    'Record has been saved successfully.', FailureHandling.CONTINUE_ON_FAILURE)

not_run: if (text.contains('Record has been saved successfully.', FailureHandling.CONTINUE_ON_FAILURE)) {
    not_run: println('Record has been created successfully.')
}

not_run: WebUI.delay(1)

not_run: WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Close_Button/btn_Close'))

not_run: WebUI.delay(1)

not_run: vrfy_BNR = CustomKeywords.'com.oracledb.regressiontest.verifyBanner'(GlobalVariable.ora_connt, GlobalVariable.ora_usr, 
    GlobalVariable.ora_psswrd, GlobalVariable.ora_schema, Inpt_Banner_Name)

// Check for correct result
not_run: println('BANNER_NAME')

//WS.verifyEqual(java.lang.Class<row.Inpt_Banner_Name> )
not_run: WS.verifyEqual(vrfy_BNR.BANNER_NAME, Inpt_Banner_Name)


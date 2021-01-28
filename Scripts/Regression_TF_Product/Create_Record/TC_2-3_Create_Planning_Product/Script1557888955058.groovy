import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable

WebUI.waitForPageLoad(GlobalVariable.G_Timeout)

WebUI.mouseOver(findTestObject('TF_Product_Create/1_Menu_Navigation_To_Open_All_Pages/0_Menu_Create_In_Data_View'))

WebUI.delay(3)

WebUI.mouseOver(findTestObject('TF_Product_Create/1_Menu_Navigation_To_Open_All_Pages/1_Menu_Create_Master_Data'))

WebUI.delay(3)

WebUI.mouseOver(findTestObject('TF_Product_Create/1_Menu_Navigation_To_Open_All_Pages/2_Product_Hierarchy_Level_Hoverover_Option'))

WebUI.delay(2)

WebUI.click(findTestObject('TF_Product_Create/2_Select_Menu_Options(All)/Product Hierarchy Level/td_Planning_product'))

WebUI.waitForPageLoad(GlobalVariable.G_Timeout)

WebUI.delay(3)

PP_name = CustomKeywords.'com.oracledb.regressiontest.genName'(10)

WebUI.setText(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/2-3- Planning_Product/input_Total_Planning_Product_Name'), 
    PP_name)

WebUI.delay(5)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Apply_Button/td_Apply'))

WebUI.delay(5)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Save_Button/btn_Save'))

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Verify_Success_Message/Success_Message'), 
    'Record has been saved successfully.', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(5)

if (true) {
    WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Close_Button/btn_Close'))
} else {
    WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Close_Button/btn_Close'))
}

WebUI.delay(5)

WebUI.click(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/2-3- Planning_Product/Click_ToggleImageCheck_Sub_Planning-Product'))

WebUI.delay(3)

WebUI.click(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/2-3- Planning_Product/Click_addbttn_Sub_Planning-Product'))

WebUI.delay(3)

WebUI.click(findTestObject('Edit_Record_Queries/Common_Action_Buttons/run_Search'))

WebUI.delay(3)

WebUI.doubleClick(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/2-3- Planning_Product/td_dblclick_SelectData_SubPlanning-Product'))

WebUI.delay(3)

date = CustomKeywords.'com.oracledb.regressiontest.returnDate'(0)

WebUI.setText(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/Set_Effective_Dates/input_Effective_Start_Date'), 
    date)

WebUI.setText(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/Set_Effective_Dates/input_Effective_End_Date'), 
    date)

WebUI.delay(3)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Apply_Button/td_Apply'))

WebUI.delay(6)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Save_Button/btn_Save'))

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Verify_Success_Message/Success_Message'), 
    'Record has been saved successfully.', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Close_Button/btn_Close'))

WebUI.delay(5)

WebUI.click(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/2-3- Planning_Product/Click_ToggleImageCheck_Promoted_Product_Group'))

WebUI.delay(3)

WebUI.click(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/2-3- Planning_Product/Click_addbttn_Promoted-Product_Group'))

WebUI.delay(3)

WebUI.click(findTestObject('Edit_Record_Queries/Common_Action_Buttons/run_Search'))

WebUI.delay(3)

WebUI.doubleClick(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/2-3- Planning_Product/td_dblclick_SelectData_SubPlanning-Product'))

WebUI.delay(3)

date = CustomKeywords.'com.oracledb.regressiontest.returnDate'(0)

WebUI.setText(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/Set_Effective_Dates/input_Effective_Start_Date'), 
    date)

WebUI.setText(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/Set_Effective_Dates/input_Effective_End_Date'), 
    date)

WebUI.delay(3)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Apply_Button/td_Apply'))

WebUI.delay(6)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Save_Button/btn_Save'))

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Verify_Success_Message/Success_Message'), 
    'Record has been saved successfully.', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Close_Button/btn_Close'))

WebUI.delay(5)

WebUI.click(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/2-3- Planning_Product/Click_ToggleImageCheck_Product_Summary'))

WebUI.delay(3)

WebUI.click(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/2-3- Planning_Product/Click_addbttn_Product_Summary'))

WebUI.delay(3)

WebUI.click(findTestObject('Edit_Record_Queries/Common_Action_Buttons/run_Search'))

WebUI.delay(3)

WebUI.doubleClick(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/2-3- Planning_Product/td_dblclick_SelectData_Product_Summary'))

WebUI.delay(3)

date = CustomKeywords.'com.oracledb.regressiontest.returnDate'(0)

WebUI.setText(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/Set_Effective_Dates/input_Effective_Start_Date'), 
    date)

WebUI.setText(findTestObject('TF_Product_Create/4_Create_Objects_And_Save/Set_Effective_Dates/input_Effective_End_Date'), 
    date)

WebUI.delay(3)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Apply_Button/td_Apply'))

WebUI.delay(6)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Save_Button/btn_Save'))

WebUI.delay(3)

WebUI.verifyElementText(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Verify_Success_Message/Success_Message'), 
    'Record has been saved successfully.', FailureHandling.CONTINUE_ON_FAILURE)

WebUI.delay(3)

WebUI.click(findTestObject('TF_Product_Create/3_Common_Action_Buttons/Click_Close_Button/btn_Close'))

WebUI.delay(3)


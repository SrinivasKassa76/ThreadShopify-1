import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys
import java.time.LocalDateTime as LocalDateTime
import java.time.format.DateTimeFormatter as DateTimeFormatter

WebUI.openBrowser('')

WebUI.navigateToUrl('https://threads0.myshopify.com/password')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/My Contact/Page_Threads/div_Enter using password'))

WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/My Contact/Page_Threads/input_Enter store using password_password'), 
    'gnzTAVlujIw+lTr0To6+Cg==')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/My Contact/Page_Threads/button_Enter'))

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Thread_Webshop/My Contact/Page_Threads/svg_Search_icon icon-account'))

//Verify login page
WebUI.verifyTextPresent('Login', false)

//Enter login details
WebUI.setText(findTestObject('Object Repository/Thread_Webshop/My Contact/Page_Account  Threads/input_Login_customeremail'), 
    'cenaalice1234@mailinator.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/My Contact/Page_Account  Threads/input_Email_customerpassword'), 
    'UDMlkmqWREzH+mr49N5wRw==')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/My Contact/Page_Account  Threads/button_Sign in'))

//Verify my Account
WebUI.verifyTextPresent('Account', false)

WebUI.click(findTestObject('Object Repository/Thread_Webshop/My Contact/Page_Account  Threads/a_View addresses (1)'))

//Verify Address Page
WebUI.verifyTextPresent('Addresses', false)

WebUI.verifyTextPresent('Default', false)

//Click on edit
WebUI.click(findTestObject('Object Repository/Thread_Webshop/My Contact/Page_Addresses  Threads/button_Edit'))

//Changing the address
WebUI.setText(findTestObject('Object Repository/Thread_Webshop/My Contact/Page_Addresses  Threads/input_Company_addressaddress1'), 
    'abc apartment, xyz road')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/My Contact/Page_Addresses  Threads/button_Update address'))

//Verify new address
WebUI.verifyTextPresent('abc apartment, xyz road', false)

WebUI.click(findTestObject('Object Repository/Thread_Webshop/My Contact/Page_Addresses  Threads/span_Home'))

WebUI.closeBrowser()


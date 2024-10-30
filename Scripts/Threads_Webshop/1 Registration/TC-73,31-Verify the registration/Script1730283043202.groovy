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

// Generate current date and time to append to the email and folder name
LocalDateTime currentDateTime = LocalDateTime.now()

DateTimeFormatter formatter = DateTimeFormatter.ofPattern('yyyyMMddHHmmss')

String dateTimeString = currentDateTime.format(formatter)

// Create unique email ID by appending dateTimeString
String uniqueEmail = ('tester_' + dateTimeString) + '@mailinator.com'

println('Generated unique email: ' + uniqueEmail)

// Define a unique folder path for screenshots
String screenshotFolderPath = ('screenshots/regestration_' + dateTimeString) + '/'

// Ensure the folder is created before taking screenshots
new File(screenshotFolderPath).mkdirs()

//Calling Reusable Testcases
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot(screenshotFolderPath + 'enter_password.png')

WebUI.click(findTestObject('Object Repository/Page_Threads/button_Enter'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Threads/svg_Search_icon icon-account'))

WebUI.takeScreenshot(screenshotFolderPath + 'home_page.png')

WebUI.click(findTestObject('Object Repository/Page_Threads/svg_Search_icon icon-account'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Account  Threads/a_Create account'))

WebUI.takeScreenshot(screenshotFolderPath + 'create_account_page.png')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Account  Threads/a_Create account'))

WebUI.takeScreenshot(screenshotFolderPath + 'account_page.png')

// Verify Empty Fields
WebUI.verifyElementClickable(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/button_Create'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/button_Create'))

WebUI.verifyTextPresent(error_msg1, false)

WebUI.verifyTextPresent(error_msg2, false)

WebUI.verifyTextPresent(error_msg3, false)

WebUI.takeScreenshot(screenshotFolderPath + 'blank_fields.png')

// Verify Without Password
WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/input_Create account_customerfirst_name'), 
    f_name)

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/input_First name_customerlast_name'), 
    l_name)

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/input_Last name_customeremail'), 
    uniqueEmail)

WebUI.takeScreenshot(screenshotFolderPath + 'without_passwordBefore.png')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/button_Create'))

WebUI.verifyTextPresent(error_msg1, false)

WebUI.verifyTextPresent(error_msg2, false)

WebUI.takeScreenshot(screenshotFolderPath + 'without_passwordAfter.png')

// Verify Wrong Email ID
WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/input_Create account_customerfirst_name'), 
    f_name)

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/input_First name_customerlast_name'), 
    l_name)

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/input_Last name_customeremail'), 
    'tester1234mailinator.com')

WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/input_Email_customerpassword'), 
    'UDMlkmqWREzH+mr49N5wRw==')

WebUI.takeScreenshot(screenshotFolderPath + 'wrong_emailBefore.png')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/button_Create'))

WebUI.verifyTextPresent(error_msg1, false)

WebUI.verifyTextPresent(error_msg4, false)

WebUI.takeScreenshot(screenshotFolderPath + 'wrong_emailAfter.png')

// Correct Email and Password
WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/input_Create account_customerfirst_name'), 
    l_name)

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/input_First name_customerlast_name'), 
    'Sing')

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/input_Last name_customeremail'), 
    uniqueEmail)

WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/input_Email_customerpassword'), 
    'UDMlkmqWREzH+mr49N5wRw==')

WebUI.takeScreenshot(screenshotFolderPath + 'correctBefore.png')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Create Account  Threads/button_Create'))

WebUI.takeScreenshot(screenshotFolderPath + 'correctAfter.png')

// Verifying the Home page
WebUI.verifyTextPresent(verify_home_page, false)

WebUI.takeScreenshot(screenshotFolderPath + 'home_page_post_login.png')

WebUI.click(findTestObject('Object Repository/Page_Threads/svg_Search_icon icon-account'))

WebUI.takeScreenshot(screenshotFolderPath + 'logout.png')

// WebUI.verifyTextPresent('Logout', false)
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Register_/Page_Account  Threads/a_Log out'))

WebUI.verifyTextPresent(verify_home_page, false)

WebUI.closeBrowser()


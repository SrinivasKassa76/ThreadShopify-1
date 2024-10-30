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

// Generate current date and time for unique folder creation
LocalDateTime currentDateTime = LocalDateTime.now()
DateTimeFormatter formatter = DateTimeFormatter.ofPattern('yyyyMMddHHmmss')
String dateTimeString = currentDateTime.format(formatter)

// Define unique folder path for screenshots
String screenshotFolderPath = 'screenshots/login_' + dateTimeString + '/'

// Ensure the folder is created before taking screenshots
new File(screenshotFolderPath).mkdirs()

// Open Browser 
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.click(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Threads/svg_Search_icon icon-account'))

// Verify login page 
WebUI.verifyTextPresent(login_page, false)
WebUI.takeScreenshot(screenshotFolderPath + 'login_page.png')

// Verify with Blank spaces 
WebUI.click(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Account  Threads/button_Sign in'))
WebUI.takeScreenshot(screenshotFolderPath + 'login_page_after.png')
WebUI.verifyTextPresent(error_msg1, false)
WebUI.verifyTextPresent(error_msg2, false)

// Verify with Invalid Email and Valid Password 
WebUI.setText(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Account  Threads/input_Login_customeremail'), invalidemail)
WebUI.setEncryptedText(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Account  Threads/input_Email_customerpassword'), validpassword)
WebUI.takeScreenshot(screenshotFolderPath + 'invalid_email_before.png')

WebUI.click(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Account  Threads/button_Sign in'))
WebUI.verifyTextPresent(error_msg1, false)
WebUI.verifyTextPresent(error_msg2, false)
WebUI.takeScreenshot(screenshotFolderPath + 'invalid_email_after.png')

// Verify with valid Email and invalid password 
WebUI.setText(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Account  Threads/input_Login_customeremail'), validemail)
WebUI.setEncryptedText(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Account  Threads/input_Email_customerpassword'), invalidpass)
WebUI.takeScreenshot(screenshotFolderPath + 'invalid_password_before.png')

WebUI.click(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Account  Threads/button_Sign in'))
WebUI.verifyTextPresent(error_msg1, false)
WebUI.verifyTextPresent(error_msg2, false)
WebUI.takeScreenshot(screenshotFolderPath + 'invalid_password_after.png')

// Verify Valid password and valid Email 
WebUI.setText(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Account  Threads/input_Login_customeremail'), validemail)
WebUI.setEncryptedText(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Account  Threads/input_Email_customerpassword'), validpassword)
WebUI.takeScreenshot(screenshotFolderPath + 'valid_before.png')

WebUI.click(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Account  Threads/button_Sign in'))
WebUI.takeScreenshot(screenshotFolderPath + 'valid_after.png')

// Verify Account page
WebUI.verifyTextPresent(account_page, false)
WebUI.verifyTextPresent(name, false)
WebUI.takeScreenshot(screenshotFolderPath + 'account_page.png')

WebUI.click(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Account  Threads/span_Home'))
WebUI.click(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Threads/svg_Search_icon icon-account'))

// Log out
WebUI.takeScreenshot(screenshotFolderPath + 'logout_page.png')
WebUI.click(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Account  Threads/a_Log out'))
WebUI.click(findTestObject('Object Repository/Login_An/Login with Invalid Credentials/Page_Threads/span_Search_svg-wrapper'))

WebUI.takeScreenshot(screenshotFolderPath + 'login_page_after_logout.png')
WebUI.verifyTextPresent(login_page, false)

// Close browser
WebUI.closeBrowser()

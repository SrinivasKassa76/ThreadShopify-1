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

// Create a unique email ID
LocalDateTime currentDateTime = LocalDateTime.now()

DateTimeFormatter formatter = DateTimeFormatter.ofPattern('yyyyMMddHHmmss')

String dateTimeString = currentDateTime.format(formatter)

String uniqueEmail = ('tester_' + dateTimeString) + '@mailinator.com'

println('Generated unique email: ' + uniqueEmail)

// Define a unique folder path for screenshots
String screenshotFolderPath = ('screenshots/product_details' + dateTimeString) + '/'

new File(screenshotFolderPath).mkdirs()

// Call reusable test cases and take screenshots with unique paths
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot(screenshotFolderPath + 'enter_password.png')

// Click on 'Enter' button and take screenshot
WebUI.click(findTestObject('Object Repository/Page_Threads/button_Enter'))

WebUI.takeScreenshot(screenshotFolderPath + 'click_enter_button.png')

// Proceed through steps with screenshots saved in the unique folder
WebUI.click(findTestObject('Object Repository/Page_Threads/a_Catalog'))

WebUI.takeScreenshot(screenshotFolderPath + 'catalog_page.png')

WebUI.click(findTestObject('Object Repository/Page_Products  Threads/a_ADIDAS  CLASSIC BACKPACK  LEGEND INK MULTICOLOUR'))

WebUI.takeScreenshot(screenshotFolderPath + 'product_page.png')

WebUI.click(findTestObject('Object Repository/Page_ADIDAS  CLASSIC BACKPACK  LEGEND INK M_ff53f1/button_Add to cart'))

WebUI.takeScreenshot(screenshotFolderPath + 'add_to_cart.png')

WebUI.click(findTestObject('Object Repository/Page_ADIDAS  CLASSIC BACKPACK  LEGEND INK M_ff53f1/button_Check out'))

WebUI.takeScreenshot(screenshotFolderPath + 'checkout.png')

// Verification steps with screenshots
WebUI.verifyTextPresent('Contact', false)

WebUI.takeScreenshot(screenshotFolderPath + 'verify_contact_text.png')

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Checkout - Threads/a_Log in'))

WebUI.takeScreenshot(screenshotFolderPath + 'verify_login_clickable.png')

WebUI.verifyTextPresent('Delivery', false)

WebUI.takeScreenshot(screenshotFolderPath + 'verify_delivery_text.png')

WebUI.verifyTextPresent('Payment', false)

WebUI.takeScreenshot(screenshotFolderPath + 'verify_payment_text.png')

WebUI.verifyTextPresent('Total', false)

WebUI.takeScreenshot(screenshotFolderPath + 'verify_total_text.png')

WebUI.closeBrowser()


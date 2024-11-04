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

// Generate a unique timestamped folder path for screenshots
LocalDateTime currentDateTime = LocalDateTime.now()
DateTimeFormatter formatter = DateTimeFormatter.ofPattern('yyyyMMddHHmmss')
String dateTimeString = currentDateTime.format(formatter)
String screenshotFolderPath = 'screenshots/credit_card' + dateTimeString + '/'
new File(screenshotFolderPath).mkdirs() // Create the folder

// Begin test execution and screenshot steps
// Step 1: Enter password
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.takeScreenshot(screenshotFolderPath + 'enter_password.png')

// Step 2: Navigate to catalog
WebUI.click(findTestObject('Object Repository/Page_Threads/a_Catalog'))
WebUI.takeScreenshot(screenshotFolderPath + 'catalog_page.png')

// Step 3: Select product "ADIDAS KIDS STAN SMITH"
WebUI.click(findTestObject('Object Repository/Page_Products  Threads/a_ADIDAS  KIDS STAN SMITH'))
WebUI.takeScreenshot(screenshotFolderPath + 'select_product.png')

// Step 4: Click "Buy it now"
WebUI.click(findTestObject('Object Repository/Page_ADIDAS  KIDS STAN SMITH  Threads/button_Buy it now'))
WebUI.takeScreenshot(screenshotFolderPath + 'buy_now.png')

// Step 5: Enter email or phone number (Invalid case)
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Email or mobile phone number_email'), '1234567890')
WebUI.takeScreenshot(screenshotFolderPath + 'enter_email.png')

// Step 6: Choose delivery method
WebUI.click(findTestObject('Object Repository/Page_Checkout - Threads/input_Choose a delivery method_delivery_strategies'))
WebUI.takeScreenshot(screenshotFolderPath + 'delivery_method.png')

// Step 7: Enter customer details
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_First name (optional)_firstName'), 'John')
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Last name_lastName'), 'Cena')
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Address_address1'), 'ABC Street')
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_City_city'), 'Kolkata')
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_PIN code_postalCode'), '700001')
WebUI.takeScreenshot(screenshotFolderPath + 'customer_details.png')

// Step 8: Attempt payment (Invalid case)
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Card number_number (1)'), '3')
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Expiration date (MM  YY)_expiry (1)'), '02 27')
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Security code_verification_value (1)'), '345')
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Name on card_name'), 'John Cena')
WebUI.click(findTestObject('Object Repository/Page_Checkout - Threads/button_Pay now'))
WebUI.takeScreenshot(screenshotFolderPath + 'attempt_payment_invalid_case_1.png')
WebUI.delay(3)

// Step 9: Attempt second invalid payment
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Card number_number (2)'), '2')
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Expiration date (MM  YY)_expiry (2)'), '02 27')
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Security code_verification_value (2)'), '456')
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Name on card_name (1)'), 'John Cena')
WebUI.click(findTestObject('Object Repository/Page_Checkout - Threads/button_Pay now'))
WebUI.takeScreenshot(screenshotFolderPath + 'attempt_payment_invalid_case_2.png')

// Step 10: Attempt valid payment
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Card number_number (3)'), '1')
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Expiration date (MM  YY)_expiry (3)'), '02 27')
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Security code_verification_value (3)'), '456')
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Name on card_name (2)'), 'John Cena')
WebUI.click(findTestObject('Object Repository/Page_Checkout - Threads/button_Pay now'))
WebUI.takeScreenshot(screenshotFolderPath + 'attempt_payment_valid_case.png')

// Step 11: Verify order confirmation
WebUI.verifyTextPresent('Your order is confirmed', false)
WebUI.takeScreenshot(screenshotFolderPath + 'order_confirmation.png')

// Step 12: Close the browser
WebUI.closeBrowser()

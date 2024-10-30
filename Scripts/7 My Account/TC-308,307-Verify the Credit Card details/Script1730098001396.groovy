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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://threads0.myshopify.com/password')

WebUI.click(findTestObject('Object Repository/Page_Threads/div_Enter using password'))

WebUI.setEncryptedText(findTestObject('Object Repository/Page_Threads/input_Enter store using password_password'), 'gnzTAVlujIw+lTr0To6+Cg==')

WebUI.click(findTestObject('Object Repository/Page_Threads/button_Enter'))

//Verify Home page
WebUI.verifyTextPresent('Home', false)

//Selecting an item for checkout
WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Threads/a_ADIDAS  CLASSIC BACKPACK'))

WebUI.click(findTestObject('Object Repository/Page_Threads/a_ADIDAS  CLASSIC BACKPACK'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_ADIDAS  CLASSIC BACKPACK  Threads/button_Buy it now'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_ADIDAS  CLASSIC BACKPACK  Threads/button_Buy it now'))

WebUI.verifyTextPresent('Threads', false)

//Providing the nessary details
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Email or mobile phone number_email'), 'johndeere@mailinator.com')

WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_First name (optional)_firstName'), 'John')

WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Last name_lastName'), 'Deere')

WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Address_address1'), 'abc Apartment, xyz Road')

WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_City_city'), 'Kolkata')

WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_PIN code_postalCode'), '700007')

//Verify payment section
WebUI.verifyTextPresent('Payment', false)

WebUI.verifyTextPresent('Credit card', false)

//Providing invalid credentials 
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Card number_number'), '2222 2222 2222 2222')

WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Expiration date (MM  YY)_expiry'), '02 /               34')

WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Security code_verification_value'), '123')

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Checkout - Threads/button_Pay now'))

WebUI.click(findTestObject('Object Repository/Page_Checkout - Threads/button_Pay now'))

WebUI.delay(3)

WebUI.verifyTextPresent('Your payment details couldn’t be verified.', false)

WebUI.verifyTextPresent('Enter a valid card number', false)

//Provide the valid information
WebUI.setText(findTestObject('Object Repository/Page_Checkout - Threads/input_Card number_number'), '1')

WebUI.click(findTestObject('Object Repository/Page_Checkout - Threads/button_Pay now'))

WebUI.delay(3)

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Thank you for your purchase - Threads _893876/h2_Thank you, John'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Thank you for your purchase - Threads _893876/h2_Your order is confirmed'))

WebUI.closeBrowser()


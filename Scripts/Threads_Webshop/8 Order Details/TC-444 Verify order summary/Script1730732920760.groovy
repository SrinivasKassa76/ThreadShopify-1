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

// Open browser and maximize window
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot('screenshots/after_login.png')

// Navigate to Catalog
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Threads/a_Catalog'))

WebUI.takeScreenshot('screenshots/catalog_page.png')

// Select Product and proceed
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Products  Threads/a_ASICS TIGER  GEL-LYTE V 30 YEARS OF GEL PACK'))

WebUI.takeScreenshot('screenshots/selected_product.png')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_ASICS TIGER  GEL-LYTE V 30 YEARS OF GE_209da4/button_Buy it now'))

WebUI.takeScreenshot('screenshots/buy_it_now.png')

// Enter user details
WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Email or mobile phone number_email'), 
    '1234567890')

WebUI.takeScreenshot('screenshots/enter_contact.png')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Choose a delivery method_delivery_strategies'))

// Fill address information
WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_First name (optional)_firstName'), 
    'Celine')

WebUI.takeScreenshot('screenshots/enter_first_name.png')

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Last name_lastName'), 
    'Cena')

WebUI.takeScreenshot('screenshots/enter_last_name.png')

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Address_address1'), 
    'XYZ Street')

WebUI.takeScreenshot('screenshots/enter_address.png')

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Apartment, suite, etc. (optional)_address2'), 
    'ABC apartment')

WebUI.takeScreenshot('screenshots/enter_apartment.png')

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_City_city'), 
    'Kolkata')

WebUI.takeScreenshot('screenshots/enter_city.png')

WebUI.selectOptionByValue(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/select_Andaman and Nicobar IslandsAndhra Pr_2effd7'), 
    'WB', true)

WebUI.takeScreenshot('screenshots/select_state.png')

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_PIN code_postalCode'), 
    '700053')

WebUI.takeScreenshot('screenshots/enter_pin.png')

// Choose shipping method and enter payment info
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Choose a shipping method_shipping_methods'))

WebUI.takeScreenshot('screenshots/choose_shipping.png')

//WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Card number_number'), 
//    '2')
//
//WebUI.takeScreenshot('screenshots/enter_card_number.png')
//
//WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Expiration date (MM  YY)_expiry'), 
//    '12      26')
//
//WebUI.takeScreenshot('screenshots/enter_expiry.png')
//
//WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Security code_verification_value'), 
//    '567')
//
//WebUI.takeScreenshot('screenshots/enter_security_code.png')

// Apply discount code
WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Discount code_reductions'), 
    'WINTER10')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/button_Apply'))

WebUI.takeScreenshot('screenshots/apply_discount.png')

// Calculate and validate prices
float ordertotal = parsePrice(WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/span_220.00')))

float discount = parseDisc(WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/span_22.00')))

float shipping = parsePrice(WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/span_10.00')))

float tax = parsePrice(WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/span_35.64')))

float finalPrice = parsePrice(WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/strong_243.64')))

if ((((ordertotal - discount) + shipping) + tax) == finalPrice) {
    println('Match')
} else {
    println('No match')
}

WebUI.takeScreenshot('screenshots/validate_prices.png')

// Confirm order
//WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/button_Pay now'))

WebUI.takeScreenshot('screenshots/order_confirmation.png')

WebUI.closeBrowser() // Parsing functions

float parsePrice(String price) {
    String cleanText = price.replaceAll('[^\\d.]', '').trim()

    return Float.parseFloat(cleanText)
}

float parseDisc(String price) {
    String cleanText = price.replaceAll('[^\\d.-]', '').trim()

    return Float.parseFloat(cleanText)
}


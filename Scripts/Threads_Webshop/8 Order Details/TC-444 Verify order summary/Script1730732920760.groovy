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
import java.text.SimpleDateFormat

// Get unique folder path based on the current timestamp
String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date())
String screenshotFolder = "screenshots/summary_" + timestamp + "/"

// Open browser and maximize window
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)
WebUI.takeScreenshot(screenshotFolder + "after_login.png")

// Navigate to Catalog
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Threads/a_Catalog'))
WebUI.takeScreenshot(screenshotFolder + "catalog_page.png")

// Select Product and proceed
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Products  Threads/a_ASICS TIGER  GEL-LYTE V 30 YEARS OF GEL PACK'))
WebUI.takeScreenshot(screenshotFolder + "selected_product.png")

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_ASICS TIGER  GEL-LYTE V 30 YEARS OF GE_209da4/button_Buy it now'))
WebUI.takeScreenshot(screenshotFolder + "buy_it_now.png")

// Enter user details
WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Email or mobile phone number_email'), '1234567890')
WebUI.takeScreenshot(screenshotFolder + "enter_contact.png")

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Choose a delivery method_delivery_strategies'))

// Fill address information
WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_First name (optional)_firstName'), 'Celine')
WebUI.takeScreenshot(screenshotFolder + "enter_first_name.png")

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Last name_lastName'), 'Cena')
WebUI.takeScreenshot(screenshotFolder + "enter_last_name.png")

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Address_address1'), 'XYZ Street')
WebUI.takeScreenshot(screenshotFolder + "enter_address.png")

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Apartment, suite, etc. (optional)_address2'), 'ABC apartment')
WebUI.takeScreenshot(screenshotFolder + "enter_apartment.png")

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_City_city'), 'Kolkata')
WebUI.takeScreenshot(screenshotFolder + "enter_city.png")

WebUI.selectOptionByValue(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/select_Andaman and Nicobar IslandsAndhra Pr_2effd7'), 'WB', true)
WebUI.takeScreenshot(screenshotFolder + "select_state.png")

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_PIN code_postalCode'), '700053')
WebUI.takeScreenshot(screenshotFolder + "enter_pin.png")

// Choose shipping method and apply discount code
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Choose a shipping method_shipping_methods'))
WebUI.takeScreenshot(screenshotFolder + "choose_shipping.png")

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/input_Discount code_reductions'), 'WINTER10')
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/button_Apply'))
WebUI.takeScreenshot(screenshotFolder + "apply_discount.png")

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

WebUI.takeScreenshot(screenshotFolder + "validate_prices.png")

// Confirm order
//WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/button_Pay now'))
WebUI.takeScreenshot(screenshotFolder + "order_confirmation.png")

WebUI.closeBrowser()

// Parsing functions
float parsePrice(String price) {
    String cleanText = price.replaceAll('[^\\d.]', '').trim()
    return Float.parseFloat(cleanText)
}

float parseDisc(String price) {
    String cleanText = price.replaceAll('[^\\d.-]', '').trim()
    return Float.parseFloat(cleanText)
}

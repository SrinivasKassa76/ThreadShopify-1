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

// Generate a unique folder path based on the current date and time
LocalDateTime currentDateTime = LocalDateTime.now()
DateTimeFormatter formatter = DateTimeFormatter.ofPattern('yyyyMMdd_HHmmss')
String dateTimeString = currentDateTime.format(formatter)

// Define the screenshot folder path with a unique timestamp
String screenshotFolderPath = 'screenshots/checkout_' + dateTimeString + '/'

// Ensure the folder is created before taking screenshots
new File(screenshotFolderPath).mkdirs()

WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Login to an Account'), [('validemail') : 'cenaalice1234@mailinator.com'
        , ('password') : 'UDMlkmqWREzH+mr49N5wRw=='], FailureHandling.STOP_ON_FAILURE)

WebUI.verifyTextPresent('Home', false)

WebUI.takeScreenshot(screenshotFolderPath + 'home.png')

//Select a product and Checkout
WebUI.verifyElementClickable(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/a_ADIDAS  CLASSIC BACKPACK'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Threads/a_ADIDAS  CLASSIC BACKPACK'))

WebUI.takeScreenshot(screenshotFolderPath + 'item.png')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_ADIDAS  CLASSIC BACKPACK  Threads/button_Buy it now'))

WebUI.verifyTextPresent('Threads', false)

WebUI.takeScreenshot(screenshotFolderPath + 'checkout_screen.png')

//Storing Product Price
String productText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/span_56.00'))

String clothWithoutDollar = productText.substring(1).replace(',', '').trim()

float productPrice = Float.parseFloat(clothWithoutDollar)

println("$productPrice")

//Storing Shipping Price
String shippinfText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/span_10.00'))

String ShippinfTextW$ = shippinfText.substring(1).replace(',', '').trim()

float shippingPrice = Float.parseFloat(ShippinfTextW$)

println("$shippingPrice")

String taxText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/span_10.08'))

String taxText$ = taxText.substring(1).replace(',', '').trim()

float taxPrice = Float.parseFloat(taxText$)

println("$taxPrice")

String totalText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/strong_76.08'))

String totalText$ = totalText.substring(1).replace(',', '').trim()

float totalPrice = Float.parseFloat(totalText$)

println(totalPrice)

float total = (taxPrice + shippingPrice) + productPrice

println("$total")

//Compare between cost total and product total
if (total == totalPrice) {
    println('The price has matched')
} else {
    println('Price not matched ERROR')
}

//Edit the address and saved it
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/div_Ship to__1fragemfz _1fragemeo _1fragemh_6626dd'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/button_Bob Chen, Pursuit Software, abc apar_ab85f8'))

WebUI.takeScreenshot(screenshotFolderPath + 'information_before.png')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/button_Edit'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/input_Address_address1'))

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/input_Apartment, suite, etc. (optional)_address2'), 
    'abc')
WebUI.takeScreenshot(screenshotFolderPath + 'changed.png')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/button_Save'))

WebUI.takeScreenshot(screenshotFolderPath + 'information_after.png')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Checkout/Page_Checkout - Threads/a_Threads'))

WebUI.closeBrowser()
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
String screenshotFolderPath = 'screenshots/shopping_cart_' + dateTimeString + '/'

// Ensure the folder is created before taking screenshots
new File(screenshotFolderPath).mkdirs()

// Open Browser and Enter Password
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.takeScreenshot(screenshotFolderPath + 'home.png')

// Go to Catalog and Select Items
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Threads/span_Catalog'))
WebUI.takeScreenshot(screenshotFolderPath + 'catalog.png')

// Select First Item
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Products  Threads/a_ADIDAS  CLASSIC BACKPACK'))
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_ADIDAS  CLASSIC BACKPACK  Threads/button_Add to cart'))
WebUI.delay(2)
WebUI.takeScreenshot(screenshotFolderPath + 'addToCart1.png')
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_ADIDAS  CLASSIC BACKPACK  Threads/button_Continue shopping'))
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_ADIDAS  CLASSIC BACKPACK  Threads/span_Catalog'))

// Select Second Item
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Products  Threads/a_ADIDAS  CLASSIC BACKPACK  LEGEND INK MULTICOLOUR'))
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_ADIDAS  CLASSIC BACKPACK  LEGEND INK M_ff53f1/button_Add to cart'))
WebUI.delay(2)
WebUI.takeScreenshot(screenshotFolderPath + 'addToCart2.png')
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_ADIDAS  CLASSIC BACKPACK  LEGEND INK M_ff53f1/button_Continue shopping'))
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_ADIDAS  CLASSIC BACKPACK  LEGEND INK M_ff53f1/span_Catalog'))

// Select Third Item
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Products  Threads/a_CONVERSE  CHUCK TAYLOR ALL STAR II HI'))
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_CONVERSE  CHUCK TAYLOR ALL STAR II HI _4a158e/button_Add to cart'))
WebUI.delay(2)
WebUI.takeScreenshot(screenshotFolderPath + 'addToCart3.png')
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_CONVERSE  CHUCK TAYLOR ALL STAR II HI _4a158e/button_Continue shopping'))
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_CONVERSE  CHUCK TAYLOR ALL STAR II HI _4a158e/span_Home'))

// Go to Cart Section and Verify
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Threads/svg_Log in_icon icon-cart'))
WebUI.scrollToPosition(0, 150)
WebUI.takeScreenshot(screenshotFolderPath + 'verify_cart.png')

// Store and Print Item Prices
String abbText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Your Shopping Cart  Threads/span_Rs. 140.00'))
float abbPrice = parsePrice(abbText)
println("$abbPrice")

String ambText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Your Shopping Cart  Threads/span_Rs. 40.00'))
float ambPrice = parsePrice(ambText)
println("$ambPrice")

String shoeText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Your Shopping Cart  Threads/span_Rs. 56.00'))
float shoePrice = parsePrice(shoeText)
println("$shoePrice")

// Store Total Price
String totalText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Your Shopping Cart  Threads/p_Rs. 236.00'))
float totalPrice = parsePrice(totalText)
println("Total Price: $totalPrice")

float total = (abbPrice + ambPrice) + shoePrice
println("Calculated Total: $total")

// Compare Total Value with the Cart Total Price
if (total == totalPrice) {
    println('The price has matched')
} else {
    println('Price not matched ERROR')
}

WebUI.closeBrowser()

// Function to Parse and Clean Price Text
float parsePrice(String priceText) {
    String cleanText = priceText.replace('Rs.', '').replace(',', '').trim()
    return Float.parseFloat(cleanText)
}

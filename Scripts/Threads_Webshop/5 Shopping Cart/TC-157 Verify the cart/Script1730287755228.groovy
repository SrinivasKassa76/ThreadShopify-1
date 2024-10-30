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

//Open Browser and Give password
WebUI.openBrowser('')

WebUI.navigateToUrl('https://threads0.myshopify.com/password')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Threads/div_Enter using password'))

WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Threads/input_Enter store using password_password'), 
    'gnzTAVlujIw+lTr0To6+Cg==')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Threads/button_Enter'))

//Go to Catalog for different item
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Threads/span_Catalog'))

//Select one item
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Products  Threads/a_ADIDAS  CLASSIC BACKPACK'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_ADIDAS  CLASSIC BACKPACK  Threads/button_Add to cart'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_ADIDAS  CLASSIC BACKPACK  Threads/button_Continue shopping'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_ADIDAS  CLASSIC BACKPACK  Threads/span_Catalog'))

//Select another item
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Products  Threads/a_ADIDAS  CLASSIC BACKPACK  LEGEND INK MULTICOLOUR'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_ADIDAS  CLASSIC BACKPACK  LEGEND INK M_ff53f1/button_Add to cart'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_ADIDAS  CLASSIC BACKPACK  LEGEND INK M_ff53f1/button_Continue shopping'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_ADIDAS  CLASSIC BACKPACK  LEGEND INK M_ff53f1/span_Catalog'))

//Select another item
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Products  Threads/a_CONVERSE  CHUCK TAYLOR ALL STAR II HI'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_CONVERSE  CHUCK TAYLOR ALL STAR II HI _4a158e/button_Add to cart'))

WebUI.delay(2)

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_CONVERSE  CHUCK TAYLOR ALL STAR II HI _4a158e/button_Continue shopping'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_CONVERSE  CHUCK TAYLOR ALL STAR II HI _4a158e/span_Home'))

//Go to cart section
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Threads/svg_Log in_icon icon-cart'))

//Store all the price of the item from cart section
// Extract and parse each price text, then print it as a float
String abbText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Your Shopping Cart  Threads/span_Rs. 140.00'))

float abbPrice = parsePrice(abbText)

println("$abbPrice")

String ambText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Your Shopping Cart  Threads/span_Rs. 40.00'))

float ambPrice = parsePrice(ambText)

println("$ambPrice")

String shoeText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Your Shopping Cart  Threads/span_Rs. 56.00'))

float shoePrice = parsePrice(shoeText)

println("$shoePrice")

//Store total price
String totalText = WebUI.getText(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Page_Your Shopping Cart  Threads/p_Rs. 236.00'))

float totalPrice = parsePrice(totalText)

println("Total Price: $totalPrice")

float total = (abbPrice + ambPrice + shoePrice)

println("$total")

//Comparing total value and the total of every item added to the cart
if (total == totalPrice) {
    println('The price has matched')
} else {
    println('Price not matched ERROR')
}

WebUI.closeBrowser()

//Fuction to clear the trim item
float parsePrice(String priceText) {
    String cleanText = priceText.replace('Rs.', '').replace(',', '').trim()

    return Float.parseFloat(cleanText)
}


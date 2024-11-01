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
// Open Browser and enter password by calling a reusable test case
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)

// Take a screenshot of the home page after login
WebUI.takeScreenshot(screenshotFolderPath + 'home.png')

// Navigate to the catalog section
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Threads/span_Catalog'))

// Select an item (Converse Chuck Taylor) from the catalog
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Products  Threads/a_CONVERSE  CHUCK TAYLOR ALL STAR LO'))

// Take a screenshot of the selected item page
WebUI.takeScreenshot(screenshotFolderPath + 'item.png')

// Delay to ensure elements are loaded
WebUI.delay(2)

// Select a specific item variant (size/color) and add it to the cart
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_CONVERSE  CHUCK TAYLOR ALL STAR LO  Threads/label_4Variant sold out or unavailable'))
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_CONVERSE  CHUCK TAYLOR ALL STAR LO  Threads/button_Add to cart'))

// Take a screenshot to verify the cart after adding the item
WebUI.takeScreenshot(screenshotFolderPath + 'verify_cart.png')

// View the cart to proceed with checkout
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_CONVERSE  CHUCK TAYLOR ALL STAR LO  Threads/a_View cart (1)'))

// Proceed to the checkout page
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Your Shopping Cart  Threads/button_Check out'))

// Take a screenshot of the checkout page
WebUI.takeScreenshot(screenshotFolderPath + 'checkout.png')

// Apply a discount code (WINTER10)
WebUI.setText(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Checkout - Threads/input_Discount code_reductions'), 'WINTER10')

// Delay to allow discount application
WebUI.delay(3)

// Take a screenshot of the page showing the applied promo code
WebUI.takeScreenshot(screenshotFolderPath + 'promo.png')

// Apply the promo code
WebUI.click(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Checkout - Threads/button_Apply'))

// Retrieve the product's original price and convert it to a float
String prodPrice = WebUI.getText(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Checkout - Threads/span_100.00'))
float originalPrice = parsePrice(prodPrice)
println("Original Price: $originalPrice")

// Calculate the expected discounted price (10% discount)
float discountedPrice = (originalPrice / 100) * 10

// Retrieve the displayed discount value and parse it to a float
float discount = parseDisc(WebUI.getText(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Checkout - Threads/span_10.00')))

// Verify if the applied discount matches the calculated discount
if (discount == discountedPrice) {
    println('Discounted price matches')
} else {
    println('Discounted price does not match')
}

// Retrieve and parse the tax amount from the checkout page
float taxAmt = parsePrice(WebUI.getText(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Checkout - Threads/span_8.10')))

// Calculate the total price after applying the discount and adding tax
float totalPrice = (originalPrice - discount) + taxAmt

// Retrieve the final total price displayed on the checkout page and parse it to a float
String finalPriceStr = WebUI.getText(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Checkout - Threads/strong_98.10'))
float finalPrice = parsePrice(finalPriceStr)

// Compare calculated total price with the displayed final price
if (totalPrice == finalPrice) {
    println('Final price matches')
} else {
    println('Final price does not match')
    WebUI.closeBrowser()
}

// Verify if the "TOTAL SAVINGS" text is displayed
WebUI.verifyTextPresent('TOTAL SAVINGS', false)

// Retrieve and parse the savings amount displayed on the page
float savings = parsePrice(WebUI.getText(findTestObject('Object Repository/Shopping cart_An/PROMO CODE/Page_Checkout - Threads/strong_10.00')))

// Check if the displayed savings match the calculated discount amount
if (savings == discountedPrice) {
    println('Savings match')
} else {
    println('Savings do not match')
}

// Take a final screenshot to verify the price details
WebUI.takeScreenshot(screenshotFolderPath + 'verify_price.png')

// Close the browser at the end of the test
WebUI.closeBrowser()

// Helper function to parse and clean price text by removing currency symbols or non-numeric characters
float parsePrice(String price) {
    String cleanText = price.replaceAll('[^\\d.]', '').trim()
    return Float.parseFloat(cleanText)
}

// Helper function to parse and clean discount text by removing non-numeric characters
float parseDisc(String price) {
    String cleanText = price.replaceAll('[^\\d.-]', '').trim()
    return Float.parseFloat(cleanText)
}

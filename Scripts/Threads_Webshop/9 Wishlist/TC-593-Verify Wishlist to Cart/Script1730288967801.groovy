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
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

// Generate a unique folder path using the current timestamp
String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"))
String screenshotFolder = "screenshots/wishlist_" + timestamp + "/"

// Call the reusable test case for entering the password
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)

// Take and save a screenshot of the homepage after logging in
WebUI.takeScreenshot(screenshotFolder + 'home.png')

// Navigate to the catalog section
WebUI.click(findTestObject('Object Repository/Wishlist to cart_An/Page_Threads/span_Catalog'))

// Take a screenshot of the catalog page
WebUI.takeScreenshot(screenshotFolder + 'catalog.png')

// Select the "ADIDAS CLASSIC BACKPACK" product
WebUI.click(findTestObject('Object Repository/Wishlist to cart_An/Page_Products  Threads/a_ADIDAS  CLASSIC BACKPACK'))

// Add the product to the wishlist
WebUI.click(findTestObject('Object Repository/Wishlist to cart_An/Page_ADIDAS  CLASSIC BACKPACK  Threads/span_Add To Wishlist'))

// Capture a screenshot showing the item added to the wishlist
WebUI.takeScreenshot(screenshotFolder + 'wishlist.png')

// Verify that the "ADDED TO WISHLIST" confirmation message appears
WebUI.verifyTextPresent('ADDED TO WISHLIST', false)

// Navigate back to the wishlist
WebUI.click(findTestObject('Object Repository/Wishlist to cart_An/Page_ADIDAS  CLASSIC BACKPACK  Threads/svg'))

// Add the item to the cart from the wishlist
WebUI.click(findTestObject('Object Repository/Wishlist to cart_An/Page_Wishlist  Threads/button_Add To Cart'))

// Verify that the item was successfully added to the cart
WebUI.verifyTextPresent('ADDED TO CART', false)

// Take a screenshot of the cart confirmation
WebUI.takeScreenshot(screenshotFolder + 'addCart.png')

// Open the cart to view its contents
WebUI.click(findTestObject('Object Repository/Wishlist to cart_An/Page_Wishlist  Threads/div_22 items'))

// Confirm "Your cart" page is displayed and take a screenshot
WebUI.verifyTextPresent('Your cart', false)
WebUI.takeScreenshot(screenshotFolder + 'cart.png')

// Select an item in the cart to verify details and capture the checkout page
WebUI.click(findTestObject('Object Repository/Wishlist to cart_An/Page_Your Shopping Cart  Threads/div_Rs. 56.00'))
WebUI.takeScreenshot(screenshotFolder + 'checkout.png')

// Close the browser after the test completes
WebUI.closeBrowser()

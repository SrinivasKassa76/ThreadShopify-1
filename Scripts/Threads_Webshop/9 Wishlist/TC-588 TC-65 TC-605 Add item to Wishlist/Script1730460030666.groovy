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

// Generate a unique folder name based on the current timestamp
String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"))
String screenshotFolder = "screenshots/wishlist_" + timestamp + "/"

// Log in to the shop using a reusable test case for entering password
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)

// Take screenshot of the home page after logging in
WebUI.takeScreenshot(screenshotFolder + 'home.png')

// Navigate to the catalog section
WebUI.click(findTestObject('Object Repository/Wishlist_An/Page_Threads/span_Catalog'))

// Take screenshot of the catalog page
WebUI.takeScreenshot(screenshotFolder + 'catalog.png')

// Select the product "ADIDAS CLASSIC BACKPACK"
WebUI.click(findTestObject('Object Repository/Wishlist_An/Page_Products  Threads/a_ADIDAS  CLASSIC BACKPACK'))

// Take screenshot of the product page
WebUI.takeScreenshot(screenshotFolder + 'item1.png')

// Get and store the product name and price for later verification
String prodname = WebUI.getText(findTestObject('Object Repository/Wishlist_An/Page_ADIDAS  CLASSIC BACKPACK  Threads/h1_ADIDAS  CLASSIC BACKPACK'))
String price = WebUI.getText(findTestObject('Object Repository/Wishlist_An/Page_ADIDAS  CLASSIC BACKPACK  Threads/span_Rs. 56.00'))

// Add the product to the wishlist
WebUI.click(findTestObject('Object Repository/Wishlist_An/Page_ADIDAS  CLASSIC BACKPACK  Threads/button_Add To Wishlist'))

// Take screenshot of the wishlist after adding the product
WebUI.takeScreenshot(screenshotFolder + 'wishlist.png')

// Go to the wishlist page to verify the product was added
WebUI.click(findTestObject('Object Repository/Wishlist_An/Page_ADIDAS  CLASSIC BACKPACK  Threads/div_ADIDAS  CLASSIC BACKPACK - OS  black ha_7c7ea2'))

// Verify the presence of "My Wishlist" text on the page
WebUI.verifyTextPresent('My Wishlist', false)

// Click on the product in the wishlist to view details
WebUI.click(findTestObject('Object Repository/Wishlist_An/Page_Wishlist  Threads/h2_ADIDAS  CLASSIC BACKPACK'))

// Take screenshot of the checkout page after clicking the product
WebUI.takeScreenshot(screenshotFolder + 'checkout.png')

// Verify the product name and price are displayed in the wishlist
WebUI.verifyTextPresent(prodname, false)
WebUI.verifyTextPresent(price, false)

// Close the browser after completing the test
WebUI.closeBrowser()

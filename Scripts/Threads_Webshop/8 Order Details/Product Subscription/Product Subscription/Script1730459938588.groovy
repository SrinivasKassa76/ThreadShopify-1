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

// Generate unique folder name using timestamp
String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"))
String screenshotFolder = "screenshots/order_" + timestamp

// Open the browser and navigate to login page using reusable test case
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)

// Take initial screenshot
WebUI.takeScreenshot(screenshotFolder + "/home.png")

// Navigate to the shop's main page
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_Threads/a_Explore Threads'))

// Select the product "ADIDAS SUPERSTAR 80S"
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_Products  Threads/a_ADIDAS  SUPERSTAR 80S'))

// Take screenshot of the item page
WebUI.takeScreenshot(screenshotFolder + "/item.png")

// Select "One-time purchase" option
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_ADIDAS  SUPERSTAR 80S  Threads/span_One-time purchase_sls-custom-radio'))

// Choose a subscription plan with a 3-month interval
WebUI.selectOptionByValue(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_ADIDAS  SUPERSTAR 80S  Threads/select_month3 months'), 
    '3 month', true)

// Click to view details of the subscription
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_ADIDAS  SUPERSTAR 80S  Threads/div_See details'))

// Verify message indicating a manual payment link will be sent
WebUI.verifyTextPresent('You will receive a payment link and won\'t be charged automatically', false)

// Add the product to the cart
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_ADIDAS  SUPERSTAR 80S  Threads/button_Add to cart'))

// Take screenshot of the checkout page
WebUI.takeScreenshot(screenshotFolder + "/checkout.png")

// View the shopping cart
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_ADIDAS  SUPERSTAR 80S  Threads/a_View cart (1)'))

// Proceed to checkout
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_Your Shopping Cart  Threads/button_Check out'))

// Finalize purchase by clicking "Pay now" on the checkout page
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Shopping Cart/Order Summary/Page_Checkout - Threads/Page_Checkout - Threads/button_Pay now'))

// Take screenshot of the subscription confirmation
WebUI.takeScreenshot(screenshotFolder + "/subscription.png")

// Close the browser after completing the purchase
WebUI.closeBrowser()

 // Import necessary Katalon libraries and classes
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

// Call reusable test case to log into an account with specified credentials
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Login to an Account'), [('validemail') : 'cenaalice1234@mailinator.com'
        , ('password') : 'UDMlkmqWREzH+mr49N5wRw=='], FailureHandling.STOP_ON_FAILURE)

// Select a specific product (ADIDAS CLASSIC BACKPACK) to view its details
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_Threads/a_ADIDAS  CLASSIC BACKPACK  LEGEND INK MULTICOLOUR'))

// Attempt to select a variant option (OS) that is sold out
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_ADIDAS  CLASSIC BACKPACK  LEGEND INK M_ff53f1/label_OSVariant sold out or unavailable'))

// Verify that the specified color is displayed on the page
WebUI.verifyTextPresent(color1, false)

// Attempt to select another variant option (blue) that is sold out
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_ADIDAS  CLASSIC BACKPACK  LEGEND INK M_ff53f1/label_blueVariant sold out or unavailable'))

// Go back to the catalog page
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_ADIDAS  CLASSIC BACKPACK  LEGEND INK M_ff53f1/span_Catalog'))

// Select a different product (ADIDAS KIDS STAN SMITH)
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_Products  Threads/a_ADIDAS  KIDS STAN SMITH'))

// Attempt to select size variants that are sold out (size 1)
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_ADIDAS  KIDS STAN SMITH  Threads/label_1Variant sold out or unavailable'))

// Attempt to select another size variant that is sold out (size 2)
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_ADIDAS  KIDS STAN SMITH  Threads/label_2Variant sold out or unavailable'))

// Verify that the specified color is displayed on the page
WebUI.verifyTextPresent(color2, false)

// Attempt to select another color variant (white) that is sold out
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_ADIDAS  KIDS STAN SMITH  Threads/label_whiteVariant sold out or unavailable'))

// Go back to the catalog page
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_ADIDAS  KIDS STAN SMITH  Threads/span_Catalog'))

// Select another product (CONVERSE CHUCK TAYLOR ALL STAR II HI)
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_Products  Threads/a_CONVERSE  CHUCK TAYLOR ALL STAR II HI'))

// Attempt to select multiple size variants that are sold out
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_CONVERSE  CHUCK TAYLOR ALL STAR II HI _4a158e/label_4Variant sold out or unavailable'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_CONVERSE  CHUCK TAYLOR ALL STAR II HI _4a158e/label_5Variant sold out or unavailable'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_CONVERSE  CHUCK TAYLOR ALL STAR II HI _4a158e/label_6Variant sold out or unavailable'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_CONVERSE  CHUCK TAYLOR ALL STAR II HI _4a158e/label_9Variant sold out or unavailable'))

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_CONVERSE  CHUCK TAYLOR ALL STAR II HI _4a158e/label_11Variant sold out or unavailable'))

// Verify that the specified color is displayed on the page
WebUI.verifyTextPresent(color3, false)

// Attempt to select another color variant (black) that is sold out
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Product Details Page/Page_CONVERSE  CHUCK TAYLOR ALL STAR II HI _4a158e/label_blackVariant sold out or unavailable'))

WebUI.closeBrowser()


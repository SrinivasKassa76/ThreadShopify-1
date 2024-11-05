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
String screenshotFolder = "screenshots/cancle_order_" + timestamp + "/"


// Call a reusable test case to log in to an account with specified email and password
WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Login to an Account'), [('validemail') : 'cenaalice1234@mailinator.com'
        , ('password') : 'UDMlkmqWREzH+mr49N5wRw=='], FailureHandling.STOP_ON_FAILURE)

// Click on the account icon to view account details
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Account/Page_Threads/svg_Search_icon icon-account'))

// Verify that the account information text is present on the page
WebUI.verifyTextPresent(account, false)

WebUI.takeScreenshot(screenshotFolder + 'account.png')

// Verify that the summary text is displayed on the account page
WebUI.verifyTextPresent(summary, false)

// Click on the "Cancel" button to return or exit account details
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Account/Page_Account  Threads/button_Cancel'))

WebUI.takeScreenshot(screenshotFolder + 'cancle_before.png')

// Delay for 2 seconds to ensure page stability before proceeding
WebUI.delay(2)

WebUI.takeScreenshot(screenshotFolder + 'cancle_after.png')

// Click on the "Proceed" button to continue with the next steps after canceling
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Account/Page_Account  Threads/button_Proceed'))

WebUI.closeBrowser()


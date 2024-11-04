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

// Open a browser instance
WebUI.openBrowser('')

// Navigate to the specified URL (MyShopify store login page)
WebUI.navigateToUrl('https://threads0.myshopify.com/password')

// Click on the 'Enter using password' button
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Account/Page_Threads/div_Enter using password'))

// Enter the store password (encrypted for security)
WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Account/Page_Threads/input_Enter store using password_password'), 
    'gnzTAVlujIw+lTr0To6+Cg==')

WebUI.takeScreenshot('screenshots/account/login.png')

// Click on the 'Enter' button to log in to the store
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Account/Page_Threads/button_Enter'))

// Click on the account icon to navigate to the login section
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Account/Page_Threads/svg_Search_icon icon-account'))

// Enter the email address for the login (in this case, a temporary Mailinator address)
WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Account/Page_Account  Threads/input_Login_customeremail'), 
    'alaxjoan@mailinator.com')

// Enter the encrypted password for the account login
WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Account/Page_Account  Threads/input_Email_customerpassword'), 
    'UDMlkmqWREzH+mr49N5wRw==')

// Click the 'Sign in' button to log in to the account
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Account/Page_Account  Threads/button_Sign in'))

WebUI.takeScreenshot('screenshots/account/account.png')

// Verify the presence of the text 'account' on the page to confirm successful login
WebUI.verifyTextPresent('account', false)

// Verify the presence of 'order history' text to ensure the section loads correctly
WebUI.verifyTextPresent('order_history', false)

// Click on a specific order (with ID 1042) to view details
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Account/Page_Account  Threads/a_1042'))

// Scroll to the desired position on the page (200 pixels down, horizontally centered)
WebUI.scrollToPosition(200, 0)

WebUI.takeScreenshot('screenshots/account/summary.png')

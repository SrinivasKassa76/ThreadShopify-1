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

WebUI.openBrowser('')

WebUI.navigateToUrl('https://threads0.myshopify.com/password')

WebUI.maximizeWindow()

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/div_Enter using password'))

WebUI.setEncryptedText(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/input_Enter store using password_password'), 
    'gnzTAVlujIw+lTr0To6+Cg==')

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/button_Enter'))

//Verify the Home page
WebUI.verifyTextPresent('Home', false)

//Verify the banner
WebUI.verifyElementPresent(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/div_Uncover your wardrobe essentials       _66e2bc'), 
    0)

//Verify the Text written on the Banner
WebUI.verifyTextPresent('Uncover your wardrobe essentials', false)

// Verify Featured section
boolean isFeaturedPresent = WebUI.verifyTextPresent('Featured', false, FailureHandling.OPTIONAL)

//Verify If the featured section present then only the lower element will be clickable
if (isFeaturedPresent) {
    WebUI.verifyElementClickable(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/a_ADIDAS  CLASSIC BACKPACK'))

    WebUI.verifyElementClickable(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/a_ADIDAS  CLASSIC BACKPACK  LEGEND INK MULTICOLOUR'))

    WebUI.verifyElementClickable(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/a_ADIDAS  KIDS STAN SMITH'))

    WebUI.verifyElementClickable(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/a_ADIDAS  SUPERSTAR 80S'))
}

WebUI.closeBrowser()


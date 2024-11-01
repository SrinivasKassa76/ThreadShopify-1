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
String screenshotFolderPath = ('screenshots/home_page_' + dateTimeString) + '/'

// Ensure the folder is created before taking screenshots
new File(screenshotFolderPath).mkdirs()

WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)

WebUI.maximizeWindow()

//Scroll to bottom
WebUI.scrollToPosition(0, 10000)

//Take screen shot
WebUI.takeScreenshot(screenshotFolderPath + 'social_media_icon.png')

//Verify Facebook icon
WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Threads/a_Facebook'))

//Verify Instagram icon
WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Threads/a_Instagram'))

//Verify Youtube icon
WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Threads/a_YouTube'))

//Verify twitter icon
WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Threads/a_X (Twitter)'))

WebUI.closeBrowser()


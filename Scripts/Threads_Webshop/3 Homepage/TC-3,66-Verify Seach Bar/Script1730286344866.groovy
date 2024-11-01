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

WebUI.callTestCase(findTestCase('Threads_Webshop/ReUsable Testcases/Enter Password'), [:], FailureHandling.STOP_ON_FAILURE)

//Verify the Home Page
WebUI.verifyTextPresent(home_page, false)

WebUI.takeScreenshot('screenshots/home_page/home.png')

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Threads/svg_Contact_icon icon-search'))

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Threads/svg_Contact_icon icon-search'))

WebUI.click(findTestObject('Object Repository/Page_Threads/svg_Contact_icon icon-search'))

//Search Blank Bar
WebUI.verifyTextPresent('', false)

WebUI.verifyElementClickable(findTestObject('Object Repository/Page_Threads/svg_Search_icon icon-search'))

WebUI.click(findTestObject('Object Repository/Page_Threads/svg_Search_icon icon-search'))

WebUI.takeScreenshot('screenshots/home_page/blank_bar.png')

//Verify invalid search
WebUI.setText(findTestObject('Object Repository/Page_Threads/input_Contact_q'), invalid_search)

WebUI.takeScreenshot('screenshots/home_page/invalid_before.png')

WebUI.click(findTestObject('Object Repository/Page_Threads/svg_Search_icon icon-search'))

WebUI.verifyTextPresent(search_result, false)

WebUI.verifyTextPresent(no_result, false)

WebUI.takeScreenshot('screenshots/home_page/invalid_after.png')

//Search for Shoe
WebUI.click(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/Page_Search 0 results found for Verify inva_0640af/svg_Contact_icon icon-search'))

WebUI.setText(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/Page_Search 0 results found for Verify inva_0640af/input_Contact_q'), 
    search_item)

WebUI.takeScreenshot('screenshots/home_page/search_item_before.png')

WebUI.delay(3)

//Verify the element present in the shoe
WebUI.verifyElementPresent(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/Page_Search 0 results found for Verify inva_0640af/p_DR MARTENS  CAVENDISH 3-EYE SHOE BLACK'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/Page_Search 0 results found for Verify inva_0640af/p_DR MARTENS  1461 DMC 3-EYE SHOE  BLACK SMOOTH'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/Page_Search 0 results found for Verify inva_0640af/p_DR MARTENS  1460Z DMC 8-EYE BOOT  CHERRY SMOOTH'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/Page_Search 0 results found for Verify inva_0640af/p_TIMBERLAND  MENS 6 INCH PREMIUM BOOT'), 
    0)

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/Page_Search 0 results found for Verify inva_0640af/svg_Search_icon icon-search'))

WebUI.takeScreenshot('screenshots/home_page/search_item_after.png')

//Verify the search Results 
WebUI.verifyTextPresent(search_result, false)

WebUI.takeScreenshot('screenshots/home_page/search_result.png')

WebUI.verifyElementPresent(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/Page_Search 24 results found for Shoe  Threads/a_DR MARTENS  CAVENDISH 3-EYE SHOE BLACK'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/Page_Search 24 results found for Shoe  Threads/a_DR MARTENS  1461 DMC 3-EYE SHOE  BLACK SMOOTH'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/Page_Search 24 results found for Shoe  Threads/a_ADIDAS  SUPERSTAR 80S'), 
    0)

WebUI.verifyElementPresent(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/Page_Search 24 results found for Shoe  Threads/a_NIKE  TODDLER ROSHE ONE'), 
    0)

WebUI.click(findTestObject('Object Repository/Thread_Webshop/Home_Page/Page_Threads/Page_Search 24 results found for Shoe  Threads/span_Home'))

WebUI.takeScreenshot('screenshots/home_page/home.png')

WebUI.closeBrowser()


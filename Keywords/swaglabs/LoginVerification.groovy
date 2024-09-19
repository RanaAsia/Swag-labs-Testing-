package swaglabs

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.WebDriver
import com.kms.katalon.core.testobject.ConditionType
import internal.GlobalVariable

public class LoginVerification {
	//	static final TestObject PRODUCT_PAGE_TITLE = new TestObject().addProperty('xpath', ConditionType.EQUALS, "//span[@class='title' and text()='Products']")
	//	static final TestObject ERROR_MESSAGE = new TestObject().addProperty('css', ConditionType.EQUALS, 'div[class="error-message-container error"]')

	static final def PRODUCT_PAGE_TITLE() {
		return findTestObject("Object Repository/Product_page/product_title")
	}

	static final def ERROR_MESSAGE() {
		return findTestObject("Object Repository/Login_page/error_message")
	}

	public static void verifyStandardUserLogin() {
		boolean isProductPageDisplayed = WebUI.verifyElementPresent(PRODUCT_PAGE_TITLE(), 10)
		if (isProductPageDisplayed) {
			WebUI.comment('Successfully navigated to the Product page.')
		} else {
			WebUI.comment('Failed to navigate to the Product page.')
		}
		//WebUI.closeBrowser()
	}

	public static void verifyLockedOutUserLogin() {
		boolean isErrorMessageDisplayed = WebUI.verifyElementText(ERROR_MESSAGE(),'Epic sadface: Sorry, this user has been locked out.')
		if (isErrorMessageDisplayed) {
			WebUI.comment('Locked out error message is displayed as expected.')
		} else {
			WebUI.comment('Locked out error message is not displayed.')
		}
		//	WebUI.closeBrowser()
	}
}

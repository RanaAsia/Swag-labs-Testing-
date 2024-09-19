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

public class LoginActions {

	//	static final TestObject USERNAME = new TestObject().addProperty('css', ConditionType.EQUALS, 'input[id="user-name"]')
	//	static final TestObject PASSWORD = new TestObject().addProperty('css', ConditionType.EQUALS, 'input[id="password"]')
	//	static final TestObject LOGIN_BUTTON = new TestObject().addProperty('css', ConditionType.EQUALS, 'input[id="login-button"]')

	static final def LOGIN_BUTTON() {
		return findTestObject('Object Repository/Login_page/button_login')
	}

	static final def PASSWORD() {
		return findTestObject('Object Repository/Login_page/password')
	}

	static final def USERNAME() {
		return findTestObject('Object Repository/Login_page/username')
	}

	public static void login(String username, String password) {
		WebUI.openBrowser(GlobalVariable.URL)
		WebUI.waitForPageLoad(20)
		WebUI.maximizeWindow()
		WebUI.setText(USERNAME(), username)
		WebUI.setText(PASSWORD(), password)
		WebUI.click(LOGIN_BUTTON())
	}

	public static void StandardUserLogin() {
		login(GlobalVariable.username, GlobalVariable.password)
		WebUI.waitForPageLoad(10)
	}

	public static void LockedOutUserLogin() {
		login(GlobalVariable.locked_out_username, GlobalVariable.password)
		WebUI.waitForPageLoad(10)
	}
}

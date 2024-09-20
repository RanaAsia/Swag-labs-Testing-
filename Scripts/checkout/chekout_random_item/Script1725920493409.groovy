import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase


import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI 

import swaglabs.CheckoutActions
import swaglabs.CheckoutVerification
import swaglabs.LoginActions
import swaglabs.LoginVerification

// Step 1: Login
def loginTestCase = findTestCase('Test Cases/Login/standard_user_login')
WebUI.callTestCase(loginTestCase, [:], FailureHandling.STOP_ON_FAILURE)

// Step 2: Select Random Item
int selectedItemIndex = CheckoutActions.SelectRandomItem()

// Step 3: Add selected item to cart
CheckoutActions.clickAddToCartAtIndex(selectedItemIndex)

// Step 4: Compare items between Product Page and Cart Page
CheckoutVerification.compareItems(selectedItemIndex)

WebUI.closeBrowser()

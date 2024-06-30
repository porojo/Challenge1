package org.porojo.moneyswift.features

import androidx.compose.ui.Modifier
import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import org.junit.Rule
import org.junit.Test
import org.porojo.moneyswift.features.screens.confirmation.ConfirmationScreenContent

class ConfirmationScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testConfirmationScreen() {
        with(composeTestRule) {
            setContent {
                ConfirmationScreenContent(modifier = Modifier, onHomeClicked = {})
            }

            // Assertions using tags...
            onNodeWithTag(testTag = "ConfirmationScreenColumn").assertExists()
            onNodeWithTag(testTag = "ConfirmationScreenText").assertExists()
            onNodeWithTag(testTag = "ConfirmationScreenButton").assertExists()

            // Assertions using text...
            onNodeWithText(text = "Your payment is successful!").assertIsDisplayed()

            // Actions...
            onNodeWithTag(testTag = "ConfirmationScreenButton").performClick()
        }
    }
}
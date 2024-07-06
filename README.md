# Challenge #1 🤑

- [Problem](#problem)
    - [Description](#description)
    - [Requirements](#requirements)
    - [Evaluation](#evaluation-criteria)
- [Solution](#solution)
  - [Architecture](#architecture-)
  - [Tools & Libraries](#tools--libraries)
  - [Look & Feel](#look--feel-)

## Problem

### Description:
MoneySwift is a (fictitious) Fintech company that provides an e-commerce solution. You are tasked with creating a basic Android app that simulates a simple e-commerce platform. The app should display a list of products (at least 3-5 items) and allow the user to select products and proceed to a checkout screen where they can enter payment information via Stripe.

### Requirements:
**Product List Screen:**
- Display a list of products. Each product should have a name, price, and a "Buy" button.
- You can hardcode the product data in the app.

**Checkout Screen:**
- Once a user selects a product, navigate to the checkout screen.
- The checkout screen should display the selected product's name and price and include a Stripe payment form for the user to enter their credit card information.

**Confirmation Screen:**
After a successful "payment," display a confirmation screen with a success message.

**Stripe Integration:**
- Integrate the [Stripe Android SDK](https://stripe.com/docs/mobile/android) to handle payments.
- When the user submits their payment information, use Stripe to process the transaction.
- You **do not** need to complete the backend implementation for Stripe. Just simulate the payment process.

### Evaluation Criteria:
- **Functionality:** The app should meet the basic requirements outlined above.
- **Testability:** The app should be testable with included unit tests.
- **Code Quality:** The code should be clean, well-organized, and easy to understand.
- **Error Handling:** The app should gracefully handle and display any errors during the payment process.
- **UI/UX:** While advanced UI/UX is not the main focus, the app should have a basic, user-friendly interface.

## Solution
- This is an Android app that uses the Stripe SDK (Android) to simulate digital payments...

### Architecture 🏗️

This app is based on the MVVM Architectural Pattern which follows a modularisation structure outlined [here](/docs/Modularisation.md) which features (pun intended) the following modules:

| module      | description                                                                                                                                                                      |
|-------------|----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------|
| `:app`      | This module contains MainActivity (the entry point of the app), MoneySwiftApplication (it contains the app's global configurations), and Theme files (Color, Theme, and Type)... |
| `:sources`  | This module contains the app's source(s) of data, which in this case is a list of products...                                                                                    |
| `:data`     | This module abstracts the data sources by use of repositories...                                                                                                                 |
| `:features` | This module hosts the Screens, relevant UI Components, and Navigation all of which work together to constitute the app's features...                                             |
| `:ui`       | This module provides the reusable UI Components...                                                                                                                               |

### Tools & Libraries
This app has been powered by the following Tools and Libraries:

| library   | usage                                                             | link                                                                |
|-----------|-------------------------------------------------------------------|---------------------------------------------------------------------|
| `compose` | ui framework that was used to build the app's User Interface (UI) | [Jetpack Compose](https://developer.android.com/develop/ui/compose) |
| `voyager` | responsible for the app's Navigation functionalities              | [Voyager](https://voyager.adriel.cafe/)                             |
| `koin`    | used for Dependency Injection within the app                      | [Koin](https://insert-koin.io/)                                     |
| `timber`  | used for comprehensive logging                                    | [Timber](https://github.com/JakeWharton/timber)                     |

## Look & Feel 📱
| Light Mode                                                                                                                         | Dark Mode                                                                                                                         |
|------------------------------------------------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------------------------|
| <img width="200" alt="Light Mode" src="https://github.com/porojo/Challenge1/assets/55001497/8a3b3155-d997-4a7e-a184-ccee53b57b87"> | <img width="200" alt="Dark Mode" src="https://github.com/porojo/Challenge1/assets/55001497/0b8d25eb-2632-4e15-a28c-b57bbedc862f"> |

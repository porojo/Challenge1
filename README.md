# Challenge #1 🤑
- This is an Android app that uses the Stripe SDK (Android) to simulate digital payments...

## The Architecture
- This app is based on the MVVM Architectural Pattern which follows a modularisation structure outlined in /docs/Modularisation.md which features (pun intended) the following modules:

### :app
- This module contains MainActivity (the entry point of the app), MoneySwiftApplication (it contains the app's global configurations), and Theme files (Color, Theme, and Type)...

### :sources
- This module contains the app's source(s) of data, which in this case is a list of products...

### :data
- This module abstracts the data sources by use of repositories...

### :features
- This module hosts the Screens, relevant UI Components, and Navigation all of which work together to constitute the app's features...

### :ui
- This module provides the reusable UI Components...

## The Libraries
- This app has been powered by the following Tools and Libraries:

### Jetpack Compose
- [Jetpack Compose](https://developer.android.com/develop/ui/compose) is the UI framework that was used to build the app's User Interface (UI)...

### Voyager
- [Voyager](https://voyager.adriel.cafe/) is responsible for the app's Navigation functionalities...

### Koin
- [Koin](https://insert-koin.io/) has been used for Dependency Injection within the app...

### Timber
- [Timber](https://github.com/JakeWharton/timber) is used for comprehensive logging based on idiomatic Kotlin...

## The Screenshots 📱
| Light Mode | Dark Mode |
|------------|-----------|
| ![Light Mode](https://github.com/porojo/Challenge1/assets/55001497/8a3b3155-d997-4a7e-a184-ccee53b57b87) | ![Dark Mode](https://github.com/porojo/Challenge1/assets/55001497/0b8d25eb-2632-4e15-a28c-b57bbedc862f) |

## The Test Results 🧪
| UI Tests | Unit Tests | Name of Test |
|----------|------------|--------------|

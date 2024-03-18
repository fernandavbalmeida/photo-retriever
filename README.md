
### Task
The assignment is to develop an image fetching application using the UnSplash API. This application should enable the users to add a random image to a list, that is persisted across sessions.

#### API documentation
The UnSplash API requires a key. It can be obtained through this [url](https://unsplash.com/documentation#creating-a-developer-account) by creating a developer account.

The full documentation of the API can be found [here](https://unsplash.com/documentation).
The random image endpoint documentation can also be found [here](https://unsplash.com/documentation#get-a-random-photo)

#### Requirements

- On first start, the user sees a single image in a list coming from the API.
- When the user clicks a button, a new random image from the API is appended to the list.
- When the user taps on an image, the image details (description, location, number of likes etc.) are displayed (It's up to you to decide how, where and how many of these details you want to show).
- When the app is reopened, the list from the previous session is displayed.


### Dev comments
I have implemented most of what was asked, just missing to save the photo after added.
Gradle implemented with kotlin. I have also tried out u sing version catalog and build-logic(instead of buildSrc). Based on this article https://developer.squareup.com/blog/herding-elephants/
By setting up convention plugins in build-logic, we can avoid duplicated build script setup, messy subproject configurations, without the pitfalls of the buildSrc directory.
helloclue.android.application, helloclue.android.library, helloclue.android.test: Configures common Android and Kotlin options.
helloclue.android.application.compose, helloclue.android.library.compose: Configures Jetpack Compose options

#### Architecture
MVVM was chosen due to its lifecycle awareness, separation os concerns layers, testability and reusability.
Hilt is being used to make it easier

#### TODO
- Hide Unsplash API key in gradle.properties and using build.config. In case we would be using different keys for different flavor, it could also be set different keys for each.
- More Modularization.If this would be just the start of a bigger project and the pros of modularization are many (reduced build time, scalability, encapsulation...)  The packages defined in app would be transformed into modules. Eg: feature/photos would go under core or could be a completely separate module. Same for network
- More unit tests needed to cover all classes. Missing ones for Daos, Usecases, ViewModel and Composables
- Caching
- Better looking UI following material guidelines
- UI more granularized into smaller composables
- Design System/Theming - 
- Localization
- Instrumented and UI tests
- Improve architecture and viewmodel

#### UI
Screens using Jetpack Compose and Material3.
The idea of core:DesignSystem is to keep the atoms(https://atomicdesign.bradfrost.com/chapter-2/) in place according to your design system in figma.
Themes and basic components can be wrapped according to your app.
core:ui implements your specific components (molecules,templates) making use of the deisgnsystem. All components should be tested

#### Tests
Some unit tests and compose test in place. Using dagger Hilt for easier testing.
AAA pattern followed. Would use page object one for e2e implementation

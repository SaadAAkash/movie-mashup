# Movie Mashup
## The personal feed for movie buffs

[![GitHub license](https://img.shields.io/cran/l/devtools.svg)](https://github.com/me-shaon/GLWTPL/blob/master/NSFW_LICENSE) [![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)]()  [![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://github.com/SaadAAkash/MovieMashup/graphs/commit-activity) [![Open Source Love svg1](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badges/) [![made-with-love](https://img.shields.io/badge/Made%20with-Love-1f425f.svg)](https://saad.ninja)

An app with a simple feed for exploring the world of silver screen in your Android smartphone and much more (currrently in development).
The whole app is developed using Kotlin in MVVM architecture, with Dagger for Dependency Injection and RxAndroid as Reactive Extension. The codebase also contains data binding, layers-by-features and other standard practices.

## Features

* A Simple App with a Feed
* Discovering Trending and Upcoming Movies
* A short movie plot as an appetizer to your hunger for movies

## Requirement Analysis

### Thought Process & MVVM Architecture Implementation 

![App-using-MVVM](https://github.com/SaadAAkash/MovieMashup/blob/master/Resources/mvvm-architecture-moviemashup.jpg "MVVM in MovieMashup")

### Requirement Specifications

* A Native Android Application using Kotlin as the only and primary language
* An app using the APIs available at [TMDB](https://developers.themoviedb.org/3) (The Movie DB)
* [A possible full version web demo](https://shahaparan.herokuapp.com/)
* Responsiveness in layout designs 

## Design Choices

* Easy & Quick ways:
    * A Simple ListView inside ViewHolder
    * Recylarview+CardView
    * Expandable item layout if possible
* More Complicated ways:
	* Tabbed Layouts with each of the categories & data associated with it
	* Grid Recycler Layout style for adapting a continuing number of features in the layout

The last option has been chosen and implemented in the app.

## Development Resources Used

### Technology Used

* Kotlin
* Android Jetpack
* Libraries (AndroidX) and Android Architecture Componenets
    * [Foundation][0] - Components for core system capabilities, Kotlin extensions and support for
      multidex and automated testing.
      * [AppCompat][1] - Degrade gracefully on older versions of Android.
      * [Android KTX][2] - Write more concise, idiomatic Kotlin code.
    * [Architecture][10] - A collection of libraries that help you design robust, testable, and
      maintainable apps. Start with classes for managing your UI component lifecycle and handling data
      persistence.
      * [Lifecycles][12] - Create a UI that automatically responds to lifecycle events.
      * [LiveData][13] - Build data objects that notify views when the underlying database changes.
      * [ViewModel][17] - Store UI-related data that isn't destroyed on app rotations. Easily schedule
         asynchronous tasks for optimal execution.
    * [UI][30] - Details on why and how to use UI Components in your apps - together or separate
      * [Fragment][34] - A basic unit of composable UI.
      * [Layout][35] - Lay out widgets using different algorithms.
      	* [ConstraintLayout][3]
  	  * Scalable Size Unit
  	  	* [For Size][7]
  	  	* [For Text][8]
  	* Dependency Injection
  	  * [Dagger](https://google.github.io/dagger/)
  	* Reactive Extensions
  	  * [RxAndroid][9]

[0]: https://developer.android.com/jetpack/foundation/
[1]: https://developer.android.com/topic/libraries/support-library/packages#v7-appcompat
[2]: https://developer.android.com/kotlin/ktx
[3]: https://developer.android.com/reference/android/support/constraint/ConstraintLayout#summary
[4]: https://developer.android.com/training/testing/
[5]: https://developer.android.com/training/testing/espresso/
[6]: http://robolectric.org/
[7]: https://github.com/intuit/sdp
[8]: https://github.com/intuit/ssp
[9]: https://github.com/ReactiveX/RxAndroid
[10]: https://developer.android.com/jetpack/arch/
[12]: https://developer.android.com/topic/libraries/architecture/lifecycle
[13]: https://developer.android.com/topic/libraries/architecture/livedata
[16]: https://developer.android.com/topic/libraries/architecture/room
[17]: https://developer.android.com/topic/libraries/architecture/viewmodel
[30]: https://developer.android.com/jetpack/ui/
[31]: https://developer.android.com/training/animation/
[34]: https://developer.android.com/guide/components/fragments
[35]: https://developer.android.com/guide/topics/ui/declaring-layout

## Build Instructions

This project uses the Gradle build system. To build this project, use the `gradlew build` command or use "Import Project" in Android Studio.

### Prerequisites

* Android Studio 3.4. The latest version can be downloaded from [here](https://developer.android.com/studio/)
* Build gradle 3.4.0+
* Android SDK 28
* JDK 8
* Kotlin Version 1.3.30

### Install the apk

Head over to ```Releases``` in the repo and download the apk file from the latest release.

## App Screenshots

![MovieMashup App](https://github.com/SaadAAkash/MovieMashup/blob/master/Resources/Screenshots/1.png "MovieMashup") ![MovieMashup App](https://github.com/SaadAAkash/MovieMashup/blob/master/Resources/Screenshots/2.png "MovieMashup")
![MovieMashup App](https://github.com/SaadAAkash/MovieMashup/blob/master/Resources/Screenshots/3.png "MovieMashup") ![MovieMashup App](https://github.com/SaadAAkash/MovieMashup/blob/master/Resources/Screenshots/4.png "MovieMashup")
![MovieMashup App](https://github.com/SaadAAkash/MovieMashup/blob/master/Resources/Screenshots/5.png "MovieMashup") ![MovieMashup App](https://github.com/SaadAAkash/MovieMashup/blob/master/Resources/Screenshots/6.png "MovieMashup") ![MovieMashup App](https://github.com/SaadAAkash/MovieMashup/blob/master/Resources/Screenshots/7.png "MovieMashup")

## Contributing

### Directory Structure

The following is a high level overview of relevant files and folders.

```
MovieMashup/
├── app/
│   ├── build/
│   ├── libs/
│   ├── src/
│   ├── build.gradle
│   ├── proguard-rules.pro
│   └── ...
├── build/ 
│   └── kotlin/      
│       └── sessions/
│           └── ...
├── gradle/ 
│   └── wrapper/      
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── Resources/
│   ├── Screenshots
│   │   └── ... 
│   └── mvvm-architecture-lyst
├── build.gradle
├── _config.yml
├── gradle.properties
├── local.properties
├── settings.gradle
├── README.md
└── ...

```

### File Uses

* ```<PROJECT_ROOT>\build.gradle``` : Top-level build file with configuration options common to all sub-projects/modules
* ```<PROJECT_ROOT>\app\build.gradle``` : Gradle specific for app module with libraries used
    * If you use another module in your project, as a local library, you would have another build.gradle file: ```<PROJECT_ROOT>\module\build.gradle```
* ```_config.yml``` for setting up jekyll environment
* Change ```<PROJECT_ROOT>\app\proguard-rules.pro``` if you add Java codes, guard for kotline codes have been added. Uncomment lines if you want to preserve the line number information for debugging stack traces

### Create a branch

1.  `git checkout master` from any folder in your local `MovieMashup`
    repository
1.  `git pull origin master` to ensure you have the latest main code
1.  `git checkout -b the-name-of-my-branch` (replacing `the-name-of-my-branch`
    with a suitable name) to create a branch

### Make the change

1.  Change/Add the codes
1.  Save the files and check the codes if it has successfl build config.

### Test the change

1.  If possible, test the codes the way you want.

### Push it

1.  `git add -A && git commit -m "My message"` (replacing `My message` with a
    commit message, such as `Fixed App Crash` or `Added App Crash 28 Fix`) to stage and commit
    your changes
1.  `git push my-fork-name the-name-of-my-branch`
1.  Go to the
    [`MovieMashup`](https://github.com/SaadAAkash/MovieMashup)
    and you should see recently pushed branches.
1.  Follow GitHub's instructions and open up a pull request.
1.  If possible, include screenshots of visual changes.

## License

The code base is [GNU GENERAL PUBLIC LICENSE v3.0 (GNU GPLv3)](https://github.com/SaadAAkash/MovieMashup/LICENSE)
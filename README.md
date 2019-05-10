# Movie Mashup
## The personal feed for movie buffs

[![GitHub license](https://img.shields.io/cran/l/devtools.svg)](https://github.com/me-shaon/GLWTPL/blob/master/NSFW_LICENSE) [![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)]()  [![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://github.com/SaadAAkash/LYST/graphs/commit-activity) [![Open Source Love svg1](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badges/) [![made-with-love](https://img.shields.io/badge/Made%20with-Love-1f425f.svg)](https://saad.ninja)

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
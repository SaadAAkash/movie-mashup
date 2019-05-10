# Movie Mashup
## The personal feed for movie buffs

[![GitHub license](https://img.shields.io/cran/l/devtools.svg)](https://github.com/me-shaon/GLWTPL/blob/master/NSFW_LICENSE) [![PRs Welcome](https://img.shields.io/badge/PRs-welcome-brightgreen.svg)]()  [![Maintenance](https://img.shields.io/badge/Maintained%3F-yes-green.svg)](https://github.com/SaadAAkash/LYST/graphs/commit-activity) [![Open Source Love svg1](https://badges.frapsoft.com/os/v1/open-source.svg?v=103)](https://github.com/ellerbrock/open-source-badges/) [![made-with-love](https://img.shields.io/badge/Made%20with-Love-1f425f.svg)](https://saad.ninja)

An app with a simple feed for exploring the world of silver screen in your Android smartphone and much more (currrently in development)

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



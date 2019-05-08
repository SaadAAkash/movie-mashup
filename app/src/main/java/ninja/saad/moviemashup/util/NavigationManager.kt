package com.anythingintellect.themoviedb.util

import android.content.Context
import android.content.Intent
import ninja.saad.moviemashup.data.model.Movie

class NavigationManager(val context: Context): Navigator {

    override fun openMovieDetails(movie: Movie) {
        /*val detailIntent = Intent(context, MovieDetailActivity::class.java)
        val bundle = MovieDetailActivity.Builder.getArgs(movie.title, movie.backdrop ?: "", movie.overview, movie.vote)
        detailIntent.putExtras(bundle)
        context.startActivity(detailIntent)*/
    }

}
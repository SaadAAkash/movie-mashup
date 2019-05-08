package ninja.saad.moviemashup.util

import ninja.saad.moviemashup.data.model.Movie

interface Navigator {

    fun openMovieDetails(movie: Movie)

}
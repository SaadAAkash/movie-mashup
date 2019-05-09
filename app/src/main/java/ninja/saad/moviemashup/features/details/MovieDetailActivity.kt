package ninja.saad.moviemashup.features.details

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import ninja.saad.moviemashup.R
import ninja.saad.moviemashup.data.model.Movie
import ninja.saad.moviemashup.databinding.ActivityMovieDetailBinding

class MovieDetailActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val movie = Builder.getMovie(intent.extras)
        // Not using ViewModel, as this screen is not supposed to have any behaviour
        val binding = DataBindingUtil
            .setContentView<ActivityMovieDetailBinding>(this,
                R.layout.activity_movie_detail)
        binding.movie = movie
        setTitle(movie.title)

    }

    object Builder {
        val KEY_TITLE: String = "title"
        val KEY_POSTER: String = "poster"
        val KEY_OVERVIEW: String = "overView"
        val KEY_RATING: String = "rating"

        fun getArgs(title: String, poster: String, overView: String, rating: Float): Bundle {
            val args = Bundle()
            args.putString(KEY_TITLE, title)
            args.putString(KEY_OVERVIEW, overView)
            args.putString(KEY_POSTER, poster)
            args.putFloat(KEY_RATING, rating)
            return args
        }

        fun getMovie(bundle: Bundle): Movie {
            return Movie(0, bundle.getString(KEY_TITLE),
                bundle.getString(KEY_OVERVIEW), bundle.getFloat(KEY_RATING),
                "", bundle.getString(KEY_POSTER), "")
        }
    }
}

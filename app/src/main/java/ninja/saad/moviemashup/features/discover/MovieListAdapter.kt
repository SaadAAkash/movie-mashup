package ninja.saad.moviemashup.features.discover

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ObservableList
import androidx.recyclerview.widget.RecyclerView
import ninja.saad.moviemashup.R
import ninja.saad.moviemashup.data.model.Movie
import ninja.saad.moviemashup.databinding.ItemMovieBinding
import ninja.saad.moviemashup.util.Navigator

class MovieListAdapter(val movies: ObservableList<Movie>, val navigator: Navigator) : RecyclerView.Adapter<MovieListAdapter.MovieItemViewHolder>() {

    init {
        movies.addOnListChangedCallback(Listener(this))
    }

    override fun onBindViewHolder(holder: MovieItemViewHolder, position: Int) {
        holder.bind(movies[position], navigator)
    }

    override fun getItemCount(): Int {
        return  movies.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieItemViewHolder {
        val binding = DataBindingUtil.inflate<ItemMovieBinding>(
            LayoutInflater.from(parent.context),
            R.layout.item_movie, parent, false)
        return MovieItemViewHolder(binding)
    }


    class Listener(val adapter: MovieListAdapter): ObservableList.OnListChangedCallback<ObservableList<Movie>>() {

        override fun onItemRangeRemoved(p0: ObservableList<Movie>?, p1: Int, p2: Int) = adapter.notifyItemRangeRemoved(p1, p2)

        override fun onItemRangeInserted(p0: ObservableList<Movie>?, p1: Int, p2: Int) = adapter.notifyItemRangeInserted(p1, p2)

        override fun onItemRangeChanged(p0: ObservableList<Movie>?, p1: Int, p2: Int) = adapter.notifyItemRangeChanged(p1, p2)

        override fun onItemRangeMoved(p0: ObservableList<Movie>?, p1: Int, p2: Int, p3: Int) {}

        override fun onChanged(p0: ObservableList<Movie>?) = adapter.notifyDataSetChanged()
    }

    class MovieItemViewHolder(val binding: ItemMovieBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(movie: Movie, navigator: Navigator) {
            binding.vm = binding.vm ?: MovieItemViewModel(navigator)
            binding.vm!!.movie = movie
            binding.executePendingBindings()
        }

    }

}
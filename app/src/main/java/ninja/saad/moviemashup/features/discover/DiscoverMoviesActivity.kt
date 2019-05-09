package ninja.saad.moviemashup.features.discover

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.backends.pipeline.Fresco
import ninja.saad.moviemashup.App
import ninja.saad.moviemashup.R
import ninja.saad.moviemashup.databinding.FragmentMainBinding
import ninja.saad.moviemashup.di.*
import ninja.saad.moviemashup.util.Constant
import ninja.saad.moviemashup.util.Navigator
import java.util.*
import javax.inject.Inject

class DiscoverMoviesActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MovieListViewModel
    @Inject
    lateinit var navigator: Navigator

    lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(this)
        /*initAppComponent()
        appComponent.plusContext(ContextModule(this)).inject(this)
        val binding = DataBindingUtil.setContentView<FragmentMainBinding>(
            this,
            R.layout.fragment_main
        )

        binding.vm = viewModel
        viewModel.loadMovies(Date())
        setupRV(binding.rvList)*/
    }

    private fun setupRV(rvList: RecyclerView) {
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = MovieListAdapter(viewModel.movies, navigator)
        rvList.addItemDecoration(
            DividerItemDecoration(
                this,
                DividerItemDecoration.VERTICAL
            )
        )
        rvList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                val lastItem = (rvList.layoutManager as LinearLayoutManager)
                    .findLastVisibleItemPosition()
                val totalItem = (rvList.layoutManager as LinearLayoutManager).itemCount
                if (totalItem - 2 <= lastItem) {
                    viewModel.loadMovies()
                }
            }
        })
    }

}
package ninja.saad.moviemashup.features.dashboard

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.facebook.drawee.backends.pipeline.Fresco
import kotlinx.android.synthetic.main.fragment_main.view.*
import ninja.saad.moviemashup.App
import ninja.saad.moviemashup.R
import ninja.saad.moviemashup.databinding.FragmentMainBinding
import ninja.saad.moviemashup.di.*
import ninja.saad.moviemashup.features.discover.DiscoverMoviesActivity
import ninja.saad.moviemashup.features.discover.MovieListAdapter
import ninja.saad.moviemashup.features.discover.MovieListViewModel
import ninja.saad.moviemashup.util.Constant
import ninja.saad.moviemashup.util.Navigator
import java.util.*
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class PlaceholderFragment : Fragment() {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    @Inject
    lateinit var navigator: Navigator

    lateinit var appComponent: AppComponent

    lateinit var mContext : Context

    @Inject
    lateinit var pageViewModel : PageViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Fresco.initialize(mContext)
        val binding = DataBindingUtil.setContentView<FragmentMainBinding>(
            mContext as Activity,
             R.layout.fragment_main
         )
        /*pageViewModel = ViewModelProviders.of(this, factory).get(PageViewModel::class.java).apply {
            setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
        }
        binding.vm = pageViewModel
        pageViewModel.loadMovies(Date())
*/
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_main, container, false)
        val textView: TextView = root.findViewById(R.id.section_label)
        val rv: RecyclerView = root.findViewById(R.id.rvList)
        pageViewModel.text.observe(this, Observer<String> {
            textView.text = it
        })
        pageViewModel._index.observe(this, Observer<Int> {
            if (it == 1) {
                setupRV(rv)
                //startActivity(Intent(activity, DiscoverMoviesActivity::class.java))
            }
        })
        pageViewModel.loadMovies(Date())
        return root
    }

    private fun setupRV(rvList: RecyclerView) {
        rvList.layoutManager = LinearLayoutManager(activity)
        rvList.adapter = MovieListAdapter(pageViewModel.movies, navigator)
        rvList.addItemDecoration(
            DividerItemDecoration(
                activity,
                DividerItemDecoration.VERTICAL
            )
        )
        rvList.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                val lastItem = (rvList.layoutManager as LinearLayoutManager)
                    .findLastVisibleItemPosition()
                val totalItem = (rvList.layoutManager as LinearLayoutManager).itemCount
                if (totalItem - 2 <= lastItem) {
                    pageViewModel.loadMovies()
                }
            }
        })
    }

    companion object {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private const val ARG_SECTION_NUMBER = "section_number"

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        @JvmStatic
        fun newInstance(context: Context, sectionNumber: Int): PlaceholderFragment {
            return PlaceholderFragment().apply {
                arguments = Bundle().apply {
                    putInt(ARG_SECTION_NUMBER, sectionNumber)
                }
                mContext = context
            }
        }
    }
}
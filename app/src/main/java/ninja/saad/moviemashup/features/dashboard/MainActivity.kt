package ninja.saad.moviemashup.features.dashboard

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.multidex.MultiDex
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.facebook.drawee.backends.pipeline.Fresco
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayout
import ninja.saad.moviemashup.di.*
import ninja.saad.moviemashup.util.Navigator
import kotlinx.android.synthetic.main.activity_main.*
import ninja.saad.moviemashup.App
import ninja.saad.moviemashup.R
import ninja.saad.moviemashup.databinding.ActivityMainBinding
import ninja.saad.moviemashup.databinding.FragmentMainBinding
import ninja.saad.moviemashup.features.discover.DiscoverMoviesActivity
import ninja.saad.moviemashup.features.discover.MovieListAdapter
import ninja.saad.moviemashup.features.discover.MovieListViewModel
import ninja.saad.moviemashup.util.Constant
import java.util.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModel: MovieListViewModel
    @Inject
    lateinit var navigator: Navigator

    //lateinit var appComponent: AppComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MultiDex.install(this)
        /*(application as App).appComponent
            .plusContext(ContextModule(this))
            .inject(this)*/
        /*Fresco.initialize(this)
        initAppComponent()*/

        /*val binding = DataBindingUtil.setContentView<FragmentMainBinding>(this,
            R.layout.fragment_main)*/

        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter =
            SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)
        val fab: FloatingActionButton = findViewById(R.id.fab)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }

        //startActivity(Intent(this, DiscoverMoviesActivity::class.java))

       /* binding.vm = viewModel
        viewModel.loadMovies(Date())
        setupRV(binding.rvList)*/


       /* setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = SectionsPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)
        tabs.setupWithViewPager(viewPager)

        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }*/
    }

   /* private fun initAppComponent() {
        this.appComponent = DaggerAppComponent
            .builder()
            .baseModule(BaseModule(this))
            .networkModule(NetworkModule(Constant.BASE_URL))
            .build()
    }

    private fun setupRV(rvList: RecyclerView) {
        rvList.layoutManager = LinearLayoutManager(this)
        rvList.adapter = MovieListAdapter(viewModel.movies, navigator)
        rvList.addItemDecoration(
            DividerItemDecoration(this,
            DividerItemDecoration.VERTICAL)
        )
        rvList.addOnScrollListener(object  : RecyclerView.OnScrollListener(){
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                val lastItem = (rvList.layoutManager as LinearLayoutManager)
                    .findLastVisibleItemPosition()
                val totalItem = (rvList.layoutManager as LinearLayoutManager).itemCount
                if (totalItem - 2 <= lastItem) {
                    viewModel.loadMovies()
                }
            }
        })
    }*/
}
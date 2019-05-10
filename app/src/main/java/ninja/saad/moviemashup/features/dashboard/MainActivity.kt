package ninja.saad.moviemashup.features.dashboard

import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.multidex.MultiDex
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import ninja.saad.moviemashup.R
import ninja.saad.moviemashup.core.BaseActivity
import ninja.saad.moviemashup.features.discover.DiscoverMoviesActivity
import ninja.saad.moviemashup.features.popularandtoprated.SortedMovieListActivity
import ninja.saad.moviemashup.features.trending.TrendingMoviesActivity

class MainActivity : BaseActivity(), GridRecyclerAdapter.RecyclerAdapterOnClickHandler {

    companion object {
        private val POPULARITY = "popularity.desc"
        private val TOP_RATED = "vote_average.desc"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MultiDex.install(this)

        setContentView(R.layout.activity_main)
        window.setFlags(
            WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
            WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED
        )
        initViews()
        //setuptabs()

    }

    private fun initViews() {

        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)
        toolbar.title = "Movie Mashup"
        setupRecyclerCardGrid()
    }

    private fun setupRecyclerCardGrid() {
        val mainView = findViewById<RecyclerView>(R.id.dashboard_rv)
        mainView.setHasFixedSize(true)
        mainView.layoutManager = GridLayoutManager(this, 2) as RecyclerView.LayoutManager?
        mainView.adapter = GridRecyclerAdapter(this, DashboardFeatureList.getFeatureListOfDashboard(applicationContext))
    }


    override fun onClick(target: String) {
        val i = Intent()

        when {
            target === applicationContext.resources.getString(R.string.feature01) -> {
                i.setClass(this@MainActivity, DiscoverMoviesActivity::class.java)
                startActivity(i)
            }
            target === applicationContext.resources.getString(R.string.feature02) -> {
                i.setClass(this@MainActivity, TrendingMoviesActivity::class.java)
                startActivity(i)
            }
            target === applicationContext.resources.getString(R.string.feature03) -> {
                i.setClass(this@MainActivity, SortedMovieListActivity::class.java)
                i.putExtra("SortBy", POPULARITY)
                i.putExtra("minVote", 1000)
                startActivity(i)
            }
            target === applicationContext.resources.getString(R.string.feature04) -> {
                i.setClass(this@MainActivity, SortedMovieListActivity::class.java)
                i.putExtra("SortBy", TOP_RATED)
                i.putExtra("minVote", 1000)
                startActivity(i)
            }
            target === applicationContext.resources.getString(R.string.feature05) -> {
                i.setClass(this@MainActivity, DiscoverMoviesActivity::class.java)
                startActivity(i)
            }
            target === applicationContext.resources.getString(R.string.feature06) -> {
                showLongToast("To be implemented")
            }
            else -> {
            }
        }
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Exit Confirmation")
            .setMessage("Are you sure you want to exit?")
            .setNegativeButton(
                android.R.string.no, null
            )
            .setPositiveButton(
                android.R.string.yes

            ) { _, _ -> super.onBackPressed() }
            .create().show()
    }

    private fun setuptabs() {
        /*val sectionsPagerAdapter =
            SectionsPagerAdapter(this, supportFragmentManager)
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

}
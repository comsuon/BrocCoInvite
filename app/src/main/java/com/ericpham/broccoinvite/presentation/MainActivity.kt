package com.ericpham.broccoinvite.presentation

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.os.bundleOf
import androidx.core.view.WindowCompat
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.ericpham.broccoinvite.R
import com.ericpham.broccoinvite.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityMainBinding

    private val viewModel: UserViewModel by viewModels()

    companion object {
        const val USER_BUNDLE_KEY = "userBundle"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_main) as NavHostFragment

        val navController = navHostFragment.navController

        setUpGraph(navController)
    }

    private fun setUpGraph(navController: NavController) {
        val user = viewModel.getUser()
        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
        if (user != null) {
            navGraph.startDestination = R.id.AddedFragment
            navController.setGraph(
                navGraph,
                bundleOf(USER_BUNDLE_KEY to  user)
            )
        } else {
            navGraph.startDestination = R.id.InviteFragment
            navController.graph = navGraph
        }
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)
    }

}
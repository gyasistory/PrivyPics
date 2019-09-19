package com.story_tail.privypics.ui


import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.navigation.NavigationView
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes
import com.story_tail.privypics.R
import com.story_tail.privypics.model.Category
import com.story_tail.privypics.viewmodel.MainActivityViewModel


class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private val mainActivityViewModel by lazy {
        ViewModelProviders.of(this).get(MainActivityViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        AppCenter.start(
            application, "c7a91285-1aee-40c4-ab84-5712bd5fe87b",
            Analytics::class.java, Crashes::class.java
        )
        val fab: FloatingActionButton = findViewById(R.id.fab)
        fab.setOnClickListener { takePictureIntent() }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        val navView: NavigationView = findViewById(R.id.nav_view)
        navView.menu?.getItem(0)?.subMenu?.let { categoriesMenu ->
            mainActivityViewModel.getAllCategories().observe(this, Observer { categories ->
                categories.forEach { cat ->
                    categoriesMenu.add(cat.name)
                }
            })
        }
        val toggle = ActionBarDrawerToggle(
            this, drawerLayout, toolbar,
            R.string.navigation_drawer_open,
            R.string.navigation_drawer_close
        )
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        navView.setNavigationItemSelectedListener(this)
        updateCategoryMenu()
    }

    override fun onBackPressed() {
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.main, menu)

        return true
    }


//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
////        return when (item.itemId) {
//////            R.id.action_settings -> true
////            else -> super.onOptionsItemSelected(item)
////        }
//        return super.onOptionsItemSelected(item)
//    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        // Handle navigation view item clicks here.
        when (item.itemId) {
            R.id.nav_take_pic -> {
                takePictureIntent()
            }
            R.id.nav_gallery -> {

            }
        }
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == Activity.RESULT_OK) {
            Toast.makeText(this, "You got an image", Toast.LENGTH_LONG).show()
        }
        super.onActivityResult(requestCode, resultCode, data)
    }
    private fun takePictureIntent() {
        Intent(MediaStore.ACTION_IMAGE_CAPTURE).also { intent ->
            intent.resolveActivity(packageManager)?.also {
                startActivityForResult(intent,
                    REQUEST_IMAGE_CAPTURE
                )
            }
        }
    }

    // Temporary
    private fun updateCategoryMenu() {
        if(mainActivityViewModel.getAllCategories().value.isNullOrEmpty()) {
            val category = Category()
            category.name = getString(R.string.category_all)
            category.priority = 0
            mainActivityViewModel.insertCategory(category)
        }
    }

    companion object {
        private const val REQUEST_IMAGE_CAPTURE = 1
    }
}

package id.ac.unhas.infocovid19

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView
import id.ac.unhas.infocovid19.ui.harian.HarianListFragment
import id.ac.unhas.infocovid19.ui.perkasus.PerkasusListFragment
import id.ac.unhas.infocovid19.ui.provinsi.ProvinsiListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        Log.d("MainActivity", "Test2")
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ProvinsiListFragment.newInstance())
                .commitNow()
        }

        val navView = findViewById<BottomNavigationView>(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        navView.selectedItemId = R.id.provinsi

    }

    //For Options Menu
    /*
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    fun setMode(selectedMode: Int) {
        when (selectedMode) {
            R.id.provinsi -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, ProvinsiListFragment.newInstance())
                    .commitNow()
            }
            R.id.perkasus -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, PerkasusListFragment.newInstance())
                    .commitNow()
            }
            R.id.harian -> {
                supportFragmentManager.beginTransaction()
                    .replace(R.id.container, HarianListFragment.newInstance())
                    .commitNow()
            }
        }
    }
     */

    //For Bottom Navigation
    private val mOnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.provinsi -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, ProvinsiListFragment.newInstance())
                        .commitNow()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.perkasus -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, PerkasusListFragment.newInstance())
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.harian -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.container, HarianListFragment.newInstance())
                        .commit()
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }
}

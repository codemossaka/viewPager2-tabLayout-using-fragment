package ru.godsonpeya.viewpager2tablayout

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        val mainFragment = HomeFragment()
        fragmentTransaction.add(R.id.nav_host_fragment, mainFragment)
            .commit()
    }
}


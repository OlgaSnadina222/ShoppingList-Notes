package com.shopinglist.settings

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.preference.PreferenceManager
import com.shopinglist.R

class SettingsActivity : AppCompatActivity() {

    private lateinit var defPref: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        defPref = PreferenceManager.getDefaultSharedPreferences(this)
        setTheme(getSelectedTheme())
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_settings)
        if (savedInstanceState == null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.placeHolder, SettingsFragment())
                .commit()
        }
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) finish()
        return super.onOptionsItemSelected(item)
    }

    private fun getSelectedTheme(): Int{
        return when {
            defPref.getString("theme_key", "blue") == "blue" -> {
                R.style.Theme_ShopingListBlue
            }
            defPref.getString("theme_key", "green") == "green" -> {
                R.style.Theme_ShopingListGreen
            }
            defPref.getString("theme_key", "red") == "red" -> {
                R.style.Theme_ShopingListRed
            }
            else -> {
                R.style.Theme_ShopingListPurple
            }
        }
    }
}
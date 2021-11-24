package com.herdaynote.devstore.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.herdaynote.devstore.R

class AboutActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.title = "About"
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()

        return true
    }
}
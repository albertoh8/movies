package com.albertoherjim.movies

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.albertoherjim.movies.data.ApiClient
import com.albertoherjim.movies.data.local.xml.FilmXmlLocalDataSource
import com.albertoherjim.movies.domain.Film

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)


    }

}
package org.ieselcaminas.cristina.proyectoclase.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import org.ieselcaminas.cristina.proyectoclase.R
import org.ieselcaminas.cristina.proyectoclase.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    //private lateinit var viewModel:MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this,
            R.layout.activity_main
        )

    }

}

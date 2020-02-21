package org.ieselcaminas.cristina.proyectoclase.ui.registro

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import org.ieselcaminas.cristina.proyectoclase.R

class RegistroFragment : Fragment() {

    companion object {
        fun newInstance() = RegistroFragment()
    }

    private lateinit var viewModel: RegistroViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.registro_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(RegistroViewModel::class.java)
        // TODO: Use the ViewModel
    }

}

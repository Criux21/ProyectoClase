package org.ieselcaminas.cristina.proyectoclase.ui.registro

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider

import org.ieselcaminas.cristina.proyectoclase.R
import org.ieselcaminas.cristina.proyectoclase.ui.login.LoginViewModel

class RegistroFragment : Fragment() {

    companion object {
        fun newInstance() = RegistroFragment()
    }

    private val viewModel by lazy{
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.registro_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // TODO: Use the ViewModel
    }

}

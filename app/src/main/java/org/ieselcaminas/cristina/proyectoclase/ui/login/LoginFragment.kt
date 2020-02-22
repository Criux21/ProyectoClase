package org.ieselcaminas.cristina.proyectoclase.ui.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider

import org.ieselcaminas.cristina.proyectoclase.R

class LoginFragment : Fragment() {

    companion object {
        fun newInstance() = LoginFragment()
    }
    private lateinit var binding: LoginFragment
    private val viewModel by lazy{
        ViewModelProvider(this).get(LoginViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<LoginFragment>(
            inflater, R.layout.login_fragment, container, false
        )

       // binding.authButton.setOnClickListener { launchSignInFlow() }

        return binding.root

    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        // TODO: Use the ViewModel
    }

}

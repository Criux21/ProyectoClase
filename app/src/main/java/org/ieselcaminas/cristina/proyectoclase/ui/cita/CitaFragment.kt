package org.ieselcaminas.cristina.proyectoclase.ui.cita

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI

import org.ieselcaminas.cristina.proyectoclase.R
import org.ieselcaminas.cristina.proyectoclase.databinding.CitaFragmentBinding
import org.ieselcaminas.cristina.proyectoclase.databinding.MenuFragmentBinding

class CitaFragment : Fragment() {

    companion object {
        fun newInstance() = CitaFragment()
    }

    private val viewModel by lazy{
        ViewModelProvider(this).get(CitaViewModel::class.java)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<CitaFragmentBinding>(
            inflater, R.layout.cita_fragment, container, false
        )
        setHasOptionsMenu(true)



        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean
    {
        // handle the up button here
        return NavigationUI.onNavDestinationSelected(item!!,
            view!!.findNavController())
                || super.onOptionsItemSelected(item)
    }

}

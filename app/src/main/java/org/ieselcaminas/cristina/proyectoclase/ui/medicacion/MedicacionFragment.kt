package org.ieselcaminas.cristina.proyectoclase.ui.medicacion

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
import org.ieselcaminas.cristina.proyectoclase.databinding.MedicacionFragmentBinding

class MedicacionFragment : Fragment() {

    companion object {
        fun newInstance() = MedicacionFragment()
    }

    private val viewModel by lazy{
        ViewModelProvider(this).get(MedicacionViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<MedicacionFragmentBinding>(
            inflater, R.layout.medicacion_fragment, container, false
        )


       // val adapter = MainAdapter()
       // binding.recylerView.adapter = adapter

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

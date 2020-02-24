package org.ieselcaminas.cristina.proyectoclase.ui.cita

import android.app.DatePickerDialog
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
import java.text.SimpleDateFormat
import java.util.*

class CitaFragment : Fragment() {


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

        viewModel.solicitarDatos()

        binding.button5.setOnClickListener{
            var c = Calendar.getInstance()
            val year = c.get(Calendar.YEAR)
            val month = c.get(Calendar.MONTH)
            val day = c.get(Calendar.DAY_OF_MONTH)




            context?.let {
                val dpd = DatePickerDialog(it, DatePickerDialog.OnDateSetListener { datePicker, mYear, mMonth, mDay ->
                    //set to TextView
                    var dateString = "" + mDay + "-" + (mMonth + 1) + "-" + mYear
                    //var dateStringNext = "" + mDay + "-" + (mMonth + 1) + "-" + (mYear + 5)
                    viewModel.introducirCita(dateString)
//                    val dateLastRevisionFormat = SimpleDateFormat("dd-MM-yyyy").parse(dateString)
//                    val dateNextRevisionFormat = SimpleDateFormat("dd-MM-yyyy").parse(dateStringNext)
//                    dateLastRevision = dateLastRevisionFormat.time
//                    dateNextRevision = dateNextRevisionFormat.time
                }, year, month, day)
                dpd.show()
            }
        }


        viewModel.nextCita.observe(this, androidx.lifecycle.Observer {
            binding.cita.text = viewModel.nextCita.value
        })


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

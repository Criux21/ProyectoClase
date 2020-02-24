package org.ieselcaminas.cristina.proyectoclase.ui.respiraciones

import android.os.Bundle
import android.text.format.DateUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

import org.ieselcaminas.cristina.proyectoclase.R
import org.ieselcaminas.cristina.proyectoclase.databinding.RespiracionesFragmentBinding

class RespiracionesFragment : Fragment() {

    companion object {
        fun newInstance() = RespiracionesFragment()
    }

    private val viewModel by lazy{
        ViewModelProvider(this).get(RespiracionesViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<RespiracionesFragmentBinding>(
            inflater, R.layout.respiraciones_fragment, container, false
        )


        viewModel.currentTimeTotal.observe(this, Observer { newTime ->
            binding.textTimerTotal.text = DateUtils.formatElapsedTime(newTime)
        })

        viewModel.currentBreathe.observe(this, Observer { breath ->
            binding.textBreath.text = breath
        })

        binding.buttonStart.setOnClickListener{
            viewModel.startTimers()
        }

        return binding.root
    }


}

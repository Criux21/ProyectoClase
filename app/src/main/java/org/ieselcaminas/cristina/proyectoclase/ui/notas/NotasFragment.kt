package org.ieselcaminas.cristina.proyectoclase.ui.notas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.keepnotes.NotasAdapter
import org.ieselcaminas.cristina.proyectoclase.R
import org.ieselcaminas.cristina.proyectoclase.databinding.NotasFragmentBinding


class NotasFragment : Fragment() {


    private val viewModel by lazy{
        ViewModelProvider(this).get(NotasViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<NotasFragmentBinding>(
            inflater, R.layout.notas_fragment, container, false
        )


        binding.button.setOnClickListener{
            var titulo: String = binding.editTextTitulo.text.toString()
            var contenido: String = binding.editTextContenido.text.toString()

            viewModel.introducirNota(titulo, contenido)

        }




        viewModel.listaNotas.observe(this, Observer{lista ->
            val adaptador = NotasAdapter(lista)
            binding.recyclerView.adapter = adaptador
            binding.recyclerView.layoutManager = StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        })

        binding.button2.setOnClickListener{
            viewModel.solicitarDatos()
        }

        return binding.root
    }



}

package org.ieselcaminas.cristina.proyectoclase.ui.notas

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import org.ieselcaminas.cristina.proyectoclase.R
import org.ieselcaminas.cristina.proyectoclase.databinding.NotasFragmentBinding
import org.ieselcaminas.cristina.proyectoclase.ui.login.FirebaseUserLiveData


class NotasFragment : Fragment() {

    companion object {
        fun newInstance() = NotasFragment()

    }

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

        var  mRootReference : DatabaseReference = FirebaseDatabase.getInstance().reference
        binding.button.setOnClickListener{
            var titulo: String = binding.editTextTitulo.text.toString()
            var contenido: String = binding.editTextContenido.toString()

            var child : MutableMap<String, Any> = HashMap<String, Any>()
            child.put("Title", titulo)
            child.put("Content", contenido)

            mRootReference.child("Users").child(FirebaseUserLiveData().toString()).updateChildren(child)


        }
        return binding.root
    }



}

package org.ieselcaminas.cristina.proyectoclase.ui.menu

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import com.firebase.ui.auth.AuthUI
import com.google.firebase.auth.FirebaseUser

import org.ieselcaminas.cristina.proyectoclase.R
import org.ieselcaminas.cristina.proyectoclase.databinding.MenuFragmentBinding
import org.ieselcaminas.cristina.proyectoclase.ui.login.LoginViewModel

class MenuFragment : Fragment() {

    companion object {
        fun newInstance() = MenuFragment()
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<MenuFragmentBinding>(
            inflater, R.layout.menu_fragment, container, false
        )
        val navController = this.findNavController()
        binding.button1.setOnClickListener{
            this.findNavController().navigate(R.id.action_menuFragment_to_notasFragment)
        }
        binding.button2.setOnClickListener{
            this.findNavController().navigate(R.id.action_menuFragment_to_citaFragment)
        }
        binding.button3.setOnClickListener{
            this.findNavController().navigate(R.id.action_menuFragment_to_medicacionFragment)
        }
        binding.button4.setOnClickListener{
            this.findNavController().navigate(R.id.action_menuFragment_to_respiracionesFragment)
        }

        return binding.root

    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.menu_menu, menu);

        super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var logout = false
        when(item.itemId){
           R.id.action_menu_logout ->  logout = true
           else -> return NavigationUI.onNavDestinationSelected(item,
               view!!.findNavController())
        }
        if(logout){
            AuthUI.getInstance().signOut(requireContext())
            this.findNavController().navigate(R.id.action_menuFragment_to_loginFragment)
        }

        return true

    }

}

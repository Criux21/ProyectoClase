package org.ieselcaminas.cristina.proyectoclase.ui.cita

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.keepnotes.NotasItem
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class CitaViewModel : ViewModel() {

    val mRootReference = FirebaseDatabase.getInstance().getReference("Users")

    private val _nextCita = MutableLiveData<String>()
    val nextCita: LiveData<String>
        get() = _nextCita

    fun introducirCita(cita: String){
        var child : MutableMap<String, Any> = HashMap<String, Any>()
        child.put("Cita", cita)

        mRootReference.child(FirebaseAuth.getInstance().currentUser?.uid.toString()).updateChildren(child)
    }

    fun solicitarDatos() {
        val postListener = object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                _nextCita.value = p0.child("Cita").value.toString()


            }
            override fun onCancelled(p0: DatabaseError) {
            }

        }
        mRootReference.child(FirebaseAuth.getInstance().currentUser?.uid.toString()).addValueEventListener(postListener)
    }


}

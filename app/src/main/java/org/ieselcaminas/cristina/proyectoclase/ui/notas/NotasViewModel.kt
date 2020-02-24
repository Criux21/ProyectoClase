package org.ieselcaminas.cristina.proyectoclase.ui.notas

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.keepnotes.NotasItem
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener


class NotasViewModel : ViewModel() {

    val mRootReference = FirebaseDatabase.getInstance().getReference("Users")

    fun introducirNota(titulo: String, contenido: String){
            var child : MutableMap<String, Any> = HashMap<String, Any>()
            child.put("Title", titulo)
            child.put("Content", contenido)

            mRootReference.child(FirebaseAuth.getInstance().currentUser?.uid.toString()).child("notas").push().updateChildren(child)

    }
    private val _listaNotas = MutableLiveData<ArrayList<NotasItem>>()
    val listaNotas: LiveData<ArrayList<NotasItem>>
        get() = _listaNotas

    fun solicitarDatos(){
        val postListener = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {

                for (snapshot in dataSnapshot.children) {

                    val postListener1 = object : ValueEventListener {
                        override fun onDataChange(dataSnapshot: DataSnapshot) {
                            //CAN'T TRY THIS BECAUSE OF THIS ERROR----------------------V
                           // var nota: NotasPojo = dataSnapshot.getValue(NotasPojo.class)

                            var titulo : String =  dataSnapshot.child("Titulo").value.toString()
                            var contenido: String = dataSnapshot.child("Contenido").value.toString()

                            _listaNotas.value?.add(NotasItem(titulo, contenido))
                            Log.i("HOLAAAAA", _listaNotas.value?.get(0).toString())
                        }
                        override fun onCancelled(databaseError: DatabaseError) {

                        }
                    }
                    mRootReference.child(FirebaseAuth.getInstance().currentUser?.uid.toString()).addValueEventListener(postListener1)
                }
            }
                override fun onCancelled(databaseError: DatabaseError) {

                }

        }
        mRootReference.child(FirebaseAuth.getInstance().currentUser?.uid.toString()).addValueEventListener(postListener)
    }

}

package com.example.ventilationcontrol

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.ventilationcontrol.Models.Ventilador
import com.google.firebase.database.*

class ViewVentilatorsActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var ventilatorAdapter: VentilatorAdapter
    private lateinit var ventilatorsList: ArrayList<Ventilador>
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_ventilators)

        recyclerView = findViewById(R.id.recyclerViewVentiladores)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.setHasFixedSize(true)

        ventilatorsList = ArrayList()
        ventilatorAdapter = VentilatorAdapter(ventilatorsList)
        recyclerView.adapter = ventilatorAdapter

        database = FirebaseDatabase.getInstance().getReference("ventiladores")

        fetchVentilators()
    }

    private fun fetchVentilators() {
        database.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                ventilatorsList.clear()
                if (snapshot.exists()) {
                    for (ventilatorSnapshot in snapshot.children) {
                        val ventilador = ventilatorSnapshot.getValue(Ventilador::class.java)
                        if (ventilador != null) {
                            ventilatorsList.add(ventilador)
                        }
                    }
                    ventilatorAdapter.notifyDataSetChanged()
                }
            }

            override fun onCancelled(error: DatabaseError) {
                Toast.makeText(this@ViewVentilatorsActivity, "Error: ${error.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}

package com.example.ventilationcontrol

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.ventilationcontrol.Models.Ventilador
import com.google.firebase.database.FirebaseDatabase

class AddVentilatorActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_ventilator)

        val etNombre = findViewById<EditText>(R.id.etNombre)
        val etEstado = findViewById<EditText>(R.id.etEstado)
        val etTemperatura = findViewById<EditText>(R.id.etTemperatura)
        val etCalidadAire = findViewById<EditText>(R.id.etCalidadAire)
        val btnAgregarVentilador = findViewById<Button>(R.id.btnAgregarVentilador)

        btnAgregarVentilador.setOnClickListener {
            val nombre = etNombre.text.toString().trim()
            val estado = etEstado.text.toString().trim()
            val temperatura = etTemperatura.text.toString().trim()
            val calidadAire = etCalidadAire.text.toString().trim()

            if (nombre.isEmpty() || estado.isEmpty() || temperatura.isEmpty()) {
                Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            agregarVentilador(nombre, estado, temperatura, calidadAire)
        }
    }

    private fun agregarVentilador(nombre: String, estado: String, temperatura: String, calidadAire: String) {
        val database = FirebaseDatabase.getInstance()
        val ventiladorRef = database.getReference("ventiladores")

        val ventiladorId = ventiladorRef.push().key // Genera una clave única
        if (ventiladorId != null) {
            val ventilador = Ventilador(ventiladorId, nombre, estado, temperatura, calidadAire)
            ventiladorRef.child(ventiladorId).setValue(ventilador)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(this, "Ventilador agregado exitosamente", Toast.LENGTH_SHORT).show()
                        finish() // Cierra la actividad
                    } else {
                        Toast.makeText(this, "Error al agregar ventilador", Toast.LENGTH_SHORT).show()
                    }
                }
        } else {
            Toast.makeText(this, "No se pudo generar un ID para el ventilador", Toast.LENGTH_SHORT).show()
        }
    }
}

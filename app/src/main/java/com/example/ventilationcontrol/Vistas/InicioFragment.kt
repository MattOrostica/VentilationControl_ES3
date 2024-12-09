package com.example.ventilationcontrol.Vistas

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import com.example.ventilationcontrol.AddVentilatorActivity
import com.example.ventilationcontrol.R
import com.example.ventilationcontrol.ViewVentilatorsActivity

class InicioFragment : Fragment(R.layout.fragment_inicio) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Botón: Agregar Ventilador
        val btnAgregarVentilador = view.findViewById<Button>(R.id.btnAgregarVentilador)
        btnAgregarVentilador.setOnClickListener {
            val intent = Intent(requireContext(), AddVentilatorActivity::class.java)
            startActivity(intent)
        }

        // Botón: Ver Ventiladores
        val btnVerVentiladores = view.findViewById<Button>(R.id.btnVerVentiladores)
        btnVerVentiladores.setOnClickListener {
            val intent = Intent(requireContext(), ViewVentilatorsActivity::class.java)
            startActivity(intent)
        }
    }
}

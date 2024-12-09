package com.example.ventilationcontrol

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.ventilationcontrol.Vistas.AcercaFragment
import com.example.ventilationcontrol.Vistas.InicioFragment
import com.example.ventilationcontrol.Vistas.PerfilFragment
import com.example.ventilationcontrol.databinding.ActivityPostLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class PostLogin : AppCompatActivity() {



    // Configurar ViewBinding
    private lateinit var binding: ActivityPostLoginBinding
    // Configurar Firebase
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()


        // Inicializar ViewBinding
        binding = ActivityPostLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


        // Cargar un fragment por defecto
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.fragment_container, InicioFragment()).commit()
        }

        binding.bottomNavegation.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.item_1 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, InicioFragment())
                        .commit()
                    true
                }

                R.id.item_2 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, AcercaFragment())
                        .commit()
                    true
                }

                R.id.item_3 -> {
                    supportFragmentManager.beginTransaction()
                        .replace(R.id.fragment_container, PerfilFragment())
                        .commit()
                    true
                }

                else -> false
            }
        }
    }}





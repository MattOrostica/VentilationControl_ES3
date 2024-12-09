package com.example.ventilationcontrol.Models

data class Ventilador(
    val id: String? = null, // Identificador único del ventilador
    val nombre: String? = null, // Nombre del ventilador
    val estado: String? = "", // Estado del ventilador (ejemplo: "On" o "Off")
    val temperatura: String? = null, // Temperatura medida en formato String
    val calidadAire: String? = null // Calidad del aire medida en formato String
)

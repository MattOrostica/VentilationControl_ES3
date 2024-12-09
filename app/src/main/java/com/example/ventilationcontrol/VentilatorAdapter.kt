package com.example.ventilationcontrol

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.ventilationcontrol.Models.Ventilador

class VentilatorAdapter(private val ventilatorsList: ArrayList<Ventilador>) :
    RecyclerView.Adapter<VentilatorAdapter.VentilatorViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VentilatorViewHolder {
        val itemView = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_ventilator, parent, false)
        return VentilatorViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: VentilatorViewHolder, position: Int) {
        val ventilador = ventilatorsList[position]
        holder.nombre.text = ventilador.nombre
        holder.estado.text = "Estado: ${ventilador.estado}"
        holder.temperatura.text = "Temperatura: ${ventilador.temperatura}"
        holder.calidadAire.text = "Calidad del Aire: ${ventilador.calidadAire}"
    }

    override fun getItemCount(): Int = ventilatorsList.size

    class VentilatorViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre: TextView = itemView.findViewById(R.id.tvNombre)
        val estado: TextView = itemView.findViewById(R.id.tvEstado)
        val temperatura: TextView = itemView.findViewById(R.id.tvTemperatura)
        val calidadAire: TextView = itemView.findViewById(R.id.tvCalidadAire)
    }
}

package com.pmdm.virgen.dogapi.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.santi.pmdm.virgen.dogapicleanarchitecture.R
import com.santi.pmdm.virgen.dogapicleanarchitecture.domain.models.Repository
import com.santi.pmdm.virgen.dogapicleanarchitecture.domain.models.Dog


class DogAdapter : RecyclerView.Adapter<ViewHDog>() {

    var dogRepository: List<Dog> = Repository.dogs //de momento, que sólo sean las imágenes.


    /*
    Método que devuelve la vista del item ViewHDog.
    El viewType no lo utilizamos, porque todas las vistas a inflar son iguales.
    Al inflar, le pasarmos el parent, porque la vista estár dentro del recyclerView
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHDog {
        val layoutInflater = LayoutInflater.from(parent.context)  //Objeto para crear la vista.
        val layoutDogItem = R.layout.item_dog  //accedo al xml del item a crear.
        return ViewHDog(
            layoutInflater.inflate(layoutDogItem, parent, false)
        )
    }


    /*
    Método que se llama por cada uno de los item a mostrar. Renderiza todos los datos
    de cada perro con su vista ViewHDog.
     */
    override fun onBindViewHolder(holder: ViewHDog, position: Int) {
        //LO QUE HARÉ ES SETEAR LOS DATOS.
        holder.rendereize(dogRepository.get(position), position)
    }

    /*
    Método que devuelve el número de perros.
     */
    override fun getItemCount() = dogRepository.size
}
package com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.mem.service

import com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.mem.models.Dogs
import javax.inject.Inject

/*
Esta clase, simula el servicio de acceso a los datos nativos.
IMAGINAMOS QUE PAIR, SERÍA LO MÁS PARECIDO A UN REGISTRO DE LA BASE DE DATOS.
 */

class DogService @Inject constructor(): DogServiceInterface {
    override fun getDogs(): List<Pair<String, String>> {
        return Dogs.dogs
    }

    /*
    Aquí, estoy filtrando por raza. Simulo un acceso por filtro.
     */
    override fun getBreedDogs(breed: String): List<Pair<String,String>> {
        val newDogs = Dogs.dogs.filter {
            it.first.equals(breed)
        }
        return newDogs
    }

    override fun deleteDog(breed: String) {

    }


}
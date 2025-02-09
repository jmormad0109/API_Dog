package com.santi.pmdm.virgen.dogapicleanarchitecture.domain.models


/*
Este será nuestro repositorio en memoria.
Puesto que no vamos a modificarlo, no es necesario un MutableList.
 */
class Repository {
    companion object{
        var dogs:List<Dog> = emptyList()
    }
}
package com.santi.pmdm.virgen.dogapicleanarchitecture.domain.mapper

import com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.database.entities.DogEntity
import com.santi.pmdm.virgen.dogapicleanarchitecture.domain.models.Dog


/*
Funciones de extensión, para convertir objetos de Tipo DogEntity/Pair a Dog
 */


//Necesitamos mapear un DogEntity a DogModel BBDD  --> IU
fun DogEntity.toDog(): Dog {
    return Dog(breed = this.breed, image = this.image)
}



//Necesitamos mapear un DogModel a DogEntity para persistir  IU --> BBDD
fun Dog.toDogEntity(): DogEntity{
    return DogEntity(breed = breed, image = image)
}

//Necesitamos mapear un Pair<String,String> a Dog  Pair --> IU
fun Pair<String, String>.toDog(): Dog {
    return Dog(breed = first, image = second)
}

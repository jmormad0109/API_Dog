package com.santi.pmdm.virgen.dogapicleanarchitecture.domain.usercase

import com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.database.entities.DogEntity
import com.santi.pmdm.virgen.dogapicleanarchitecture.data.repository.DogRepository
import com.santi.pmdm.virgen.dogapicleanarchitecture.domain.mapper.toDogEntity
import com.santi.pmdm.virgen.dogapicleanarchitecture.domain.models.Dog
import com.santi.pmdm.virgen.dogapicleanarchitecture.domain.models.Repository
import javax.inject.Inject

/*
Con @Inyect constructor(), estamos diciendo que esa clase ya se puede inyectar.
También inyectaremos el repositorio
 */

/*
Modificaremos nuestro caso de uso, para que haga lo siguiente:
1.- Si los datos de la BBDD están vacíos, lo que haremos es cargarlos directamente
a partir de nuestra otra fuentes de datos.
2.- Si existen datos en la BBDD, lo que haremos es cargarlos directamente y utilizarlos.
 */
class GetDogsUseCase @Inject constructor(
    private val dogRepositoryDao: DogRepository
) {
    suspend operator fun invoke(): List<Dog>?{
       Repository.dogs = dogRepositoryDao.getDogsEntity()  //Aquí tengo los datos.

       /*
          1.- Si no tengo nada en la BBDD, lo que haremos es cargarlos de memoria
          e insertarlo directamente en la BBDD.
          2.- Para ello, tengo que insertarlos en la BBDD, pero no como DogModel, sino como DogEntity, por tanto
          utilizo otro mapper.
          3.- Con los datos mapeados a DogEntity, ahora lo insertaremos en la BBDD.
           */
       if (Repository.dogs.isEmpty()){

           Repository.dogs = dogRepositoryDao.getDogs() //Aquí tengo los datos de memoria.
           val dataDogEntity : List<DogEntity> = Repository.dogs.map { it.toDogEntity() }  //lo mapeamos a Entity.
           dogRepositoryDao.insertBreedEntitytoDatabase(dataDogEntity)
       }
       return Repository.dogs

    }
}
package com.santi.pmdm.virgen.dogapicleanarchitecture.data.repository

import com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.database.dao.DogDao
import com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.database.entities.DogEntity
import com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.mem.service.DogService
import com.santi.pmdm.virgen.dogapicleanarchitecture.domain.mapper.toDog
import com.santi.pmdm.virgen.dogapicleanarchitecture.domain.models.Dog
import com.santi.pmdm.virgen.dogapicleanarchitecture.domain.models.Repository
import com.santi.pmdm.virgen.dogapicleanarchitecture.domain.repository.DogRepositoryInterface
import javax.inject.Inject

/*
Repositorio con todos los métodos de acceso a los datos.
1.- De forma nativa.
2.- De forma BBDD con Room
3.- Hilt, nos proporcionará tanto el Servicio para forma nativa, como el dao DogDao.

 */


class DogRepository @Inject constructor(
    private val service : DogService,
    private val dogDao : DogDao
) : DogRepositoryInterface {
    //private val service : DogService = DogService()

    /*
    Método que a partir de los datos nativos, devuelve la lista
    de objetos que necesita el modelo.
     */
    override fun getDogs(): List<Dog> {
        val dataSource = service.getDogs()

        Repository.dogs = dataSource.map { it.toDog() }
        return Repository.dogs
    }

    override fun getBreedDogs(breed: String): List<Dog> {
        val dataSource = service.getBreedDogs(breed)

        Repository.dogs = dataSource.map { it.toDog() }
        return Repository.dogs
    }

    override suspend fun getDogsEntity(): List<Dog> {
        val listEntity : List<DogEntity> = dogDao.getAll()  //aquí tengo todos los datos Dog
        Repository.dogs = listEntity.map { it.toDog()}  //convertimos a Dog (dominio) y lo cargamos en memoria
       return Repository.dogs

    }

    override suspend fun getBreedDogsEntity(breed: String): List<Dog> {
        val listEntity : List<DogEntity> = dogDao.getDogsByBreed(breed)  //aquí tengo todos los datos Entity filtrados
        Repository.dogs = listEntity.map { it.toDog()}  //convertimos a DogModel (dominio) y lo cargamos en memoria
        return Repository.dogs

    }

    /*
    Necesito un método que inserte una lista de Entity en la BBDD.
     */
    override suspend fun insertBreedEntitytoDatabase(listEntity : List<DogEntity>) {
        dogDao.insertAllDog(listEntity)
    }



    override suspend fun deleteDog(breed: String) {
        dogDao.deleteDog(breed)
    }

    override suspend fun deleteDatabase() {
        dogDao.deleteAll()
    }

}
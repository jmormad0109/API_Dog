package com.santi.pmdm.virgen.dogapicleanarchitecture.domain.usercase

import com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.database.entities.DogEntity
import com.santi.pmdm.virgen.dogapicleanarchitecture.data.repository.DogRepository
import com.santi.pmdm.virgen.dogapicleanarchitecture.domain.mapper.toDogEntity
import com.santi.pmdm.virgen.dogapicleanarchitecture.domain.models.Dog
import com.santi.pmdm.virgen.dogapicleanarchitecture.domain.models.Repository
import javax.inject.Inject

/*
Con @Inyect constructor(), estamos diciendo que esa clase ya se puede inyectar.
Necesito la raza.
 */
class GetDogsBreedUseCase @Inject constructor(
    private val dogRepositoryDao: DogRepository
){
    private var breed: String = ""
    fun setBreed(breed: String){
        this.breed = breed
    }


    suspend operator fun invoke() : List<Dog>{
        Repository.dogs = dogRepositoryDao.getBreedDogsEntity(breed)  //Aquí tengo los datos.

        if (Repository.dogs.isEmpty()){
            Repository.dogs  = dogRepositoryDao.getBreedDogs(breed) //Aquí tengo los datos de memoria.
            val dataDogEntity : List<DogEntity> = Repository.dogs.map { it.toDogEntity() }  //lo mapeamos a Entity.
            dogRepositoryDao.insertBreedEntitytoDatabase(dataDogEntity)
        }
        return  return Repository.dogs

    }

}
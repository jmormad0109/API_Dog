package com.santi.pmdm.virgen.dogapicleanarchitecture.domain.usercase

import com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.database.dao.DogDao
import com.santi.pmdm.virgen.dogapicleanarchitecture.data.repository.DogRepository
import javax.inject.Inject

class DeleteDogUseCase @Inject constructor(
    private val dogRepositoryDao: DogDao
) {
    suspend operator fun invoke(breed: String){
        dogRepositoryDao.deleteDog(breed)
    }
}
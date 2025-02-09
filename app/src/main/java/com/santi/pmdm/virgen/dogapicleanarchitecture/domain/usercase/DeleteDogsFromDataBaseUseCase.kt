package com.santi.pmdm.virgen.dogapicleanarchitecture.domain.usercase

import com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.database.dao.DogDao
import com.santi.pmdm.virgen.dogapicleanarchitecture.domain.models.Repository
import javax.inject.Inject

class DeleteDogsFromDataBaseUseCase @Inject constructor(
    private val dogRepositoryDao : DogDao
){

    //Me cargo la base de datos y en memoria también.
    suspend operator fun invoke(){
        dogRepositoryDao.deleteAll()
    }
}
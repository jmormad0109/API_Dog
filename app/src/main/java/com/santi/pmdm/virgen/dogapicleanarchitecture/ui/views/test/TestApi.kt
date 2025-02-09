/*
package com.pmdm.virgen.dogapi.test


class TestApi @Inject constructor(
    private val useCaseList:GetDogsUseCase,
    private val getDogsBreedUseCaseProvider : Provider<GetDogsBreedUseCase>
){



    suspend fun testDogApi() {
        var listDogs: List<DogModel>? = useCaseList()  //aquí se invoca y se obtienen los datos.
            listDogs?.forEach() {
                Log.i("TAG-DOGS", it.image)
            }


        val useCaseBreedList = getDogsBreedUseCaseProvider.get()
        useCaseBreedList.setBreed("raza1") //invoca a su método definido como operator fun invoke()
        var listDogsBreed : List<DogModel> ? = useCaseBreedList()
        listDogsBreed?.forEach() {
            Log.i("TAG-DOGS", it.image)
        }

    }

}

 */
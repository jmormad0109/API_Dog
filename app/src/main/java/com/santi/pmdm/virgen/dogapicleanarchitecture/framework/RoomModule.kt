package com.santi.pmdm.virgen.dogapicleanarchitecture.framework

import android.content.Context
import androidx.room.Room
import com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.database.DatabaseDogs
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton
/*
Módulo que nos inyecta la BBDD y el Dao.

1.- Queremos que nuestro módulo sea un síngleton. Lo creará Hilt y las dependencias que genere a otras clases, serán síngleton. Para ello,  el módulo debe ser un OBJECT. Si no lo ponemos como Singleton, Hilt creará tantas instancias como veces inyecte.
Con @InstallIn(SingletonComponent::class), estamos diciendo que este componente que crea Hilt, vivirá todo el ciclo de vida de la app y sus dependencias también.
2.- Con @Singleton en el método provideRoom, estamos diciendo que la instancia que devuelve dicho método, será un
singletón y por tanto, durará todo el tiempo. Es lo mismo que con el módulo.
todo el tiempo en el que la aplicación esté funcionando, hagamos lo que hagamos.
4.- Con @Provides, porque le indicamos a Hilt, que el método va a proveer una dependencia que será la conexión
con la base de datos y la podrá solicitar/inyectar cualquier otra clase. Si no le ponemos Provides,
Hilt no controlará la dependencia a otras clases, cuando éstas la requieran. Lo necesitamos como agua de mayo, ya que indica a Hilt como crear el objeto.
5.- Necesitamos otro método, que Hilt nos provea del objeto Dao que necesitaremos para realizar nuestras operaciones Dao. Estamos en el mismo caso del punto 4. El método aceptará el objeto ya inyectado por Hilt de tipo DatabaseDogs y devolverá el database.dogDao,
que es donde tendremos los métodos dao con la BBDD. Una pregunta que podemos hacernos es.
Si el parámetro database lo crea Hilt, porqué no le ponemos la anotación @Inyect? @Inyect se utiliza en constructores....
*/

/*
@Author santi
@Email srodher115@g.educaand.es
*/

/*
@Author santi
@Email srodher115@g.educaand.es
*/

@Module  //Hilt, que este object contiene métodos de cómo crear dependencias, ehhhhhh
@InstallIn(SingletonComponent::class)  //Hilt, que estos objetos duren hasta el cierre de la app.
object RoomModule {

    private const val NAME_DATABASE = "database_dogs"


    @Singleton   //Hilt, que quiero que me crees una sola instancia, por eso te digo que es singleton.
    @Provides   //Hilt, que quiero darte información a cómo instanciar DatabaseDogs
    fun provideRoom(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, DatabaseDogs::class.java, NAME_DATABASE).build()



    @Singleton  //Hilt, que quiero que me crees una sola instancia, por eso te digo que es singleton.
    @Provides   //Hilt, que quiero darte información a cómo debes instanciar el dao.
    fun provideDao(database: DatabaseDogs) = database.dogDao()
}
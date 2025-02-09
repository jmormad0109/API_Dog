package com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.database.dao.DogDao
import com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.database.entities.DogEntity

/*
Esta clase, sirve de acceso a la base de datos.
Room es un conjunto de clases, que nos proporciona una abstracción a una base de datos SQLLite y para ello,
nos ofrece la posibilidad de interactuar con ella, sin saber cómo puñetas recorremos los registros dada una Query, o como
mapeamos un insert dado un objeto Dog, etc. Room ya se encarga directamente de todo. Para ello, necesitamos:

1.- Nuestras entidades. DogEntity. Nos aseguramos que estén bien anotadas con @Entity, junto
a las claves primarias que necesitemos.
2.- Un Dao donde definimos las operaciones con la Base de datos y trabajando sólo con Clases que serán entidades y al mismo tiempo
serán tablas en la BBDD. Esto lo abstraemos. Recordar que tenemos @Insert, @Delete, @Update y @Query es para especificar alguna operación
que no esté cubierta con las anotaciones anteriores.
3.- Una Base de datos, que contenga un método que nos proporcione un objeto al que podamos llamar a nuestros métodos definidos en la
interfaz Dao.

¿A que queda todo claro, verdad???

Con @Database, utilizamos la denotación de una base de datos a partir de una clase. Increible!!!!!
Sus propiedades son:
        1.- entities = [DogEntity::class] es la tabla que creará a partir de la entidad. Se pasan en forma de Array.
        2.- version = 1 es la versión. Importante para tener controlada las versiones de nuestra BBDD. Útil para las
        migraciones en las actualizaciones de la APP.

Para cada DAO que tengamos, Room creará él mismo todos los métodos abstractos que definamos. Si nos damos cuenta, el método
dogDao, devuelve un objeto que implemente de DogDao (define los métodos de acceso a la BBDD)

En resumida cuentas. Lo que hacemos con abstract fun dogDao(): DogDao, es decirle a Room, que nos implemente él mismo los métodos
que hemos definido en la interfaz DogDao, para que podamos acceder a realizar las consultas. El objeto que nos devolverá, lo crea
automáticamente Room del tipo DogDao.
 */

/*
@author santiago rodenas herráiz
@Email srodher115@g.educaand.es
 */
@Database(entities = [DogEntity::class], version = 1)

abstract class DatabaseDogs : RoomDatabase(){
    abstract fun dogDao(): DogDao
}
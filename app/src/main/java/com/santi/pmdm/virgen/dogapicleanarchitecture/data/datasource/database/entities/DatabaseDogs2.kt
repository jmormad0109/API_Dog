package com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.database.entities

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.database.dao.DogDao

@Database(entities = [DogEntity::class], version = 1)
abstract class DatabaseDog2 : RoomDatabase() {
    abstract fun dogDao(): DogDao

    companion object {
        // La inicialización perezosa asegura que la base de datos se crea solo una vez
        private var INSTANCE: DatabaseDog2? = null

        // Método para inicializar la base de datos
        fun initialize(context: Context) {
            if (INSTANCE == null) {
                synchronized(this) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(
                            context.applicationContext,
                            DatabaseDog2::class.java,
                            "dog_database"
                        ).build()
                    }
                }
            }
        }

        // Método para obtener la instancia de la base de datos
        fun getDatabase(): DatabaseDog2 {
            return INSTANCE
                ?: throw IllegalStateException("Database must be initialized")
        }
    }


}
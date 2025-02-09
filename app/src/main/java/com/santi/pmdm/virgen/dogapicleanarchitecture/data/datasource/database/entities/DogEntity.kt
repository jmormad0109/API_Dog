package com.santi.pmdm.virgen.dogapicleanarchitecture.data.datasource.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

/*
Utilizaré una nueva entidad. No modificará la de mem, porque tienen que convivir.
Añadimos un nuevo atributo específico para Room llamado id. La opción autoGenerate = true indica
que Room generará la clave primaria automáticamente. No hace falta que se lo insertemos nosotros.
*/
/*
@author santiago rodenas herráiz
@Email srodher115@g.educaand.es
*/

@Entity
data class DogEntity(
        @PrimaryKey(autoGenerate = true)
        @ColumnInfo(name = "id") val id: Int=0,  //por defecto ponemos el id a 0.
        @ColumnInfo(name = "breed") val breed: String,
        @ColumnInfo (name="image") val image: String
    )


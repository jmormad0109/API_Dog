package com.santi.pmdm.virgen.dogapicleanarchitecture.application

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

/*
Será la primera en llamarse al iniciarse.
Con el tag HiltAndroidApp.

Necesitamos esta clase, en cualquier parte de nuestra aplicación y para ello,
debemos con la anotación Dagger nos crea todo lo necesario para que desde cualquier parte
de nuestro proyecto, podamos hacer uso de la inyección de dependencias.

 */
@HiltAndroidApp
class DogApiApplication : Application() {

}
package com.santi.pmdm.virgen.dogapicleanarchitecture.domain.models


/*
Este será nuestro modelo en el dominio. Este modelo es totalmente independiente a los dos modos de
acceso a datos.
 */
data class Dog (val breed: String, val image: String)
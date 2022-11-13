package br.com.desafio.api.model

import java.util.*

data class ClientResponse(
    val id: Long? = null,
    val name: String? = null,
    val phone: String? = null,
    val mail: String? = null,
    val createat: Date? = null,
    val updateat: Date? = null
)

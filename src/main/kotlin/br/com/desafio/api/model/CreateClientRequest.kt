package br.com.desafio.api.model

import javax.validation.constraints.NotBlank

data class CreateClientRequest(

    @field:NotBlank
    val name: String?,

    @field:NotBlank
    val phone: String?,

    @field:NotBlank
    val mail: String?
)

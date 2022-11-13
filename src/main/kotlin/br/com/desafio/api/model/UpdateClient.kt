package br.com.desafio.api.model

import javax.validation.constraints.NotBlank

data class UpdateClient(

    @field:NotBlank
    val name: String,

    @field:NotBlank
    val phone: String
)

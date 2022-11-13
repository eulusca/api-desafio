package br.com.desafio.api.entity

import java.util.*
import javax.persistence.*

@Table(name = "app_client")
@Entity

data class Client(
    @Id @GeneratedValue(strategy = GenerationType.SEQUENCE)
    val id: Long? = null,

    @Column(name = "name")
    var name: String? = null,

    @Column(name = "phone")
    var phone: String? = null,

    @Column(name = "mail")
    var mail: String? = null,

    @Column(name = "createat")
    var createat: Date? = null,

    @Column(name = "updateat")
    var updateat: Date? = null
)

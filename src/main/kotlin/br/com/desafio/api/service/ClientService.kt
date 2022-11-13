package br.com.desafio.api.service

import br.com.desafio.api.model.*
import br.com.desafio.api.repository.ClientRepository
import org.springframework.data.repository.findByIdOrNull
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException


interface ClientService{

    fun create(createClientRequest: CreateClientRequest): ClientResponse

    fun get(id: Long): ClientResponse

    fun update(id: Long, updateClient: UpdateClient): ClientResponse

    fun delete(id: Long)

    fun list(listClientRequest: ListClientRequest): List<ClientResponse>

}
/*
    fun getAll(): List<Client> = repository.findAll()

    fun getById(id: String): Client = repository.findByIdOrNull(id) ?: throw ResponseStatusException(HttpStatus.NOT_FOUND)

    fun create(createClient: CreateClient): CreateClient = repository.save(createClient)

    fun remove(id: String) {
        if (repository.existsById(id)) repository.deleteById(id)
        else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }

    fun update(id: String, createClient: CreateClient): CreateClient {
        return if (repository.existsById(id)) {
            createClient.id = id
            repository.save(createClient)
        } else throw ResponseStatusException(HttpStatus.NOT_FOUND)
    }
}
/*@Service
class ClientService (
    private val clientRepository : ClientRepository
){
    fun findAll() : List<Client> =
        clientRepository.findAll()

    /*fun findById(id: Long) : List<Client> =
        clientRepository.findById(id)
            .switchIfEmpty(
                Mono.error(
                    NotFoundException("Usuário $id não encontrado.")
                )
            )*/

    fun createClient(clientRequest: ClientRequest) : List<Client> =
        clientRepository.save(
            Client(
                name = clientRequest.name,
                mail = clientRequest.mail,
                phone = clientRequest.phone,
                createat = clientRequest.createat,
                updateat = clientRequest.updateat
            )
        )

}*/
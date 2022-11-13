package br.com.desafio.api.service.impl

import br.com.desafio.api.entity.Client
import br.com.desafio.api.model.*
import br.com.desafio.api.repository.ClientRepository
import br.com.desafio.api.service.ClientService
import br.com.desafio.api.validation.ValidationUtil
import org.springframework.data.domain.PageRequest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service
import java.util.*
import java.util.stream.Collectors

@Service
class ClientServiceImpl(
    val clientRepository: ClientRepository,
    val validationUtil: ValidationUtil
) : ClientService {

    override fun create(createClientRequest: CreateClientRequest): ClientResponse {
        validationUtil.validate(createClientRequest)

        val client = Client(
            name = createClientRequest.name!!,
            mail = createClientRequest.mail!!,
            phone = createClientRequest.phone!!,
            createat = Date(),
            updateat = null
        )

        clientRepository.save(client)

        return convertClientToResponse(client)
    }

    override fun get(id: Long): ClientResponse {
        val client = findClientByIdOrThrowNotFound(id)
        return convertClientToResponse(client)
    }

    override fun update(id: Long, updateClient: UpdateClient): ClientResponse {
        val client = findClientByIdOrThrowNotFound(id)

        validationUtil.validate(updateClient)

        client.apply {
            name = updateClient.name
            phone = updateClient.phone
            updateat = Date()
        }

        clientRepository.save(client)

        return convertClientToResponse(client)
    }

    override fun delete(id: Long) {
        val client = findClientByIdOrThrowNotFound(id)
        clientRepository.delete(client)
    }

    override fun list(listClientRequest: ListClientRequest): List<ClientResponse> {
        val page = clientRepository.findAll(PageRequest.of(listClientRequest.page, listClientRequest.size))
        val clients: List<Client> = page.get().collect(Collectors.toList())
        return clients.map { convertClientToResponse(it) }
    }

    private fun findClientByIdOrThrowNotFound(id: Long): Client {
        val client = clientRepository.findByIdOrNull(id)
        if (client == null) {
            throw NotFoundException("sad")
        } else {
            return client;
        }
    }

    private fun convertClientToResponse(client: Client): ClientResponse {
        return ClientResponse(
            id = client.id,
            name = client.name,
            phone = client.phone,
            mail = client.mail,
            createat = client.createat,
            updateat = client.updateat
        )
    }
}
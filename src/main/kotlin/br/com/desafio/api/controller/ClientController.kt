package br.com.desafio.api.controller

import br.com.desafio.api.model.*
import br.com.desafio.api.service.ClientService
import org.springframework.web.bind.annotation.*

@RestController
class ClientController(val clientService: ClientService) {
    @PostMapping(
        value = ["/api/clients"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun createProduct(@RequestBody body: CreateClientRequest): WebResponse<ClientResponse> {
        val clientResponse = clientService.create(body)
        return WebResponse(
            code = 200,
            status = "OK",
            data = clientResponse
        )
    }

    @GetMapping(
        value = ["/api/clients/{id}"],
        produces = ["application/json"]
    )
    fun getClient(@PathVariable("id") id: Long): WebResponse<ClientResponse> {
        val clientResponse = clientService.get(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = clientResponse
        )
    }

    @PutMapping(
        value = ["/api/clients/{id}"],
        produces = ["application/json"],
        consumes = ["application/json"]
    )
    fun updateClient(@PathVariable("id") id: Long,
                      @RequestBody updateClient: UpdateClient): WebResponse<ClientResponse> {
        val cLientResponse = clientService.update(id, updateClient)
        return WebResponse(
            code = 200,
            status = "OK",
            data = cLientResponse
        )
    }

    @DeleteMapping(
        value = ["/api/products/{idProduct}"],
        produces = ["application/json"]
    )
    fun deteleClient(@PathVariable("id") id: Long): WebResponse<Long> {
        clientService.delete(id)
        return WebResponse(
            code = 200,
            status = "OK",
            data = id
        )
    }

    @GetMapping(
        value = ["/api/clients"],
        produces = ["application/json"]
    )
    fun listClients(@RequestParam(value = "size", defaultValue = "10") size: Int,
                     @RequestParam(value = "page", defaultValue = "0") page: Int): WebResponse<List<ClientResponse>> {
        val request = ListClientRequest(page = page, size = size)
        val responses = clientService.list(request)
        return WebResponse(
            code = 200,
            status = "OK",
            data = responses
        )
    }}
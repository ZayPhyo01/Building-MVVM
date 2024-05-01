package com.building.data.service

import io.ktor.client.HttpClient
import io.ktor.client.engine.cio.CIO
import io.ktor.client.request.get
import io.ktor.client.request.post
import io.ktor.client.statement.bodyAsText


suspend fun main() {

    val httpClient = HttpClient(CIO)

    val response = httpClient.get("https://jsonplaceholder.typicode.com/posts")
    print(response.bodyAsText())
}
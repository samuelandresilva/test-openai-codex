package com.example

import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import io.ktor.server.plugins.contentnegotiation.*
import kotlinx.serialization.Serializable

@Serializable
data class Person(val name: String, val age: Int, val gender: String)

fun main() {
    val people = mutableListOf<Person>()

    embeddedServer(Netty, port = 8080) {
        install(ContentNegotiation) {
            json()
        }
        routing {
            get("/people") {
                call.respond(people)
            }
            post("/people") {
                val person = call.receive<Person>()
                people.add(person)
                call.respond(HttpStatusCode.Created, person)
            }
        }
    }.start(wait = true)
}

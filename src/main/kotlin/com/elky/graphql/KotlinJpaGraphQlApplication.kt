package com.elky.graphql

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class KotlinJpaGraphQlApplication

fun main(args: Array<String>) {
    runApplication<KotlinJpaGraphQlApplication>(*args)
}

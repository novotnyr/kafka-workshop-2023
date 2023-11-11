package com.github.novotnyr.consumer

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.kafka.listener.DefaultErrorHandler
import org.springframework.util.backoff.FixedBackOff


@SpringBootApplication
class ConsumerApplication {
    @Bean
    fun kafkaErrorHandler() = DefaultErrorHandler(FixedBackOff(5000L, 2L))
}

fun main(args: Array<String>) {
    runApplication<ConsumerApplication>(*args)
}

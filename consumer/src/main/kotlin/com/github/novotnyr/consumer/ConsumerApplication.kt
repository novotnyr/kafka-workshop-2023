package com.github.novotnyr.consumer

import org.apache.kafka.clients.consumer.ConsumerRecord
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.kafka.listener.DefaultErrorHandler
import org.springframework.util.backoff.FixedBackOff
import org.springframework.kafka.listener.ConsumerRecordRecoverer
import java.lang.Exception
import java.lang.IllegalArgumentException


@SpringBootApplication
class ConsumerApplication {
    @Bean
    fun kafkaErrorHandler(): DefaultErrorHandler {
        val recoverer = ConsumerRecordRecoverer { record, exception -> System.err.println(exception) } //<3>
        return DefaultErrorHandler(recoverer, FixedBackOff(5000L, 2L)).apply {
            addNotRetryableExceptions(IllegalArgumentException::class.java) //<1>
        }  //<2>
    }
}

fun main(args: Array<String>) {
    runApplication<ConsumerApplication>(*args)
}

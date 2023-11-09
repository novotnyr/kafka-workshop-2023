package com.github.novotnyr.consumer

import com.github.novotnyr.car.Car
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Component

@Component
class CarConsumer {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    @KafkaListener(topics = ["car"])
    fun consumeCar(car: Car) {
        logger.info("Consuming {}", car)
    }
}
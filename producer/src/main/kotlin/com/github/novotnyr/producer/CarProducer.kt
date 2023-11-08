package com.github.novotnyr.producer

import com.github.novotnyr.car.Car
import com.github.novotnyr.car.CarRandomizer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import java.util.concurrent.TimeUnit.SECONDS

@Component
class CarProducer(private val kafka: KafkaTemplate<String, Car>) {
    private val logger: Logger = LoggerFactory.getLogger(javaClass)

    private val carRandomizer = CarRandomizer()

    @Scheduled(fixedDelay = 2, timeUnit = SECONDS)
    fun publishCar() {
        val car = carRandomizer.randomCar()
        logger.info("Publishing car {}", car)
        kafka.send("car", car)
    }
}
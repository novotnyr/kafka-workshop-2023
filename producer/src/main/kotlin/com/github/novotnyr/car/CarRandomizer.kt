package com.github.novotnyr.car

class CarRandomizer {
    private val segmentA = listOf(
        car("Chevrolet Spark", CarSegment.A),
        car("Fiat 500", CarSegment.A),
        car("Kia Picanto", CarSegment.A),
        car("Renault Twingo", CarSegment.A)
    )

    private val segmentC = listOf(
        car("VW Golf", CarSegment.C),
        car("Honda Civic", CarSegment.C),
        car("Toyota Corolla", CarSegment.C),
        car("Mazda 3", CarSegment.C)
    )

    private val segmentJ = listOf(
        car("Toyota RAV4", CarSegment.J),
        car("Honda CR-V", CarSegment.J),
        car("Kia Sportage", CarSegment.J),
        car("VW Tiguan", CarSegment.J)
    )

    fun randomCar(): Car {
        return (segmentA + segmentC + segmentJ).random()
    }
}
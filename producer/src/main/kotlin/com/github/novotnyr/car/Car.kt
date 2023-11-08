package com.github.novotnyr.car

import java.io.Serializable

data class Car(var make: String, var model: String, var segment: CarSegment) : Serializable {
    override fun toString(): String {
        return "$make $model"
    }
}

fun car(specification: String, segment: CarSegment): Car {
    val components = specification.split(" ")
    require(components.size == 2) { "Cannot parse car specification. Expecting 2 arguments in: '$specification'" }
    return Car(components[0], components[1], segment)
}

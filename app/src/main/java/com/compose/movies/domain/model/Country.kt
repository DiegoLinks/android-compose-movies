package com.compose.movies.domain.model

import java.util.Objects

class Country(val name: String, val flagUrl: String) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Country) return false

        return name == other.name && flagUrl == other.flagUrl
    }

    override fun hashCode(): Int {
        return Objects.hash(name, flagUrl)
    }
}
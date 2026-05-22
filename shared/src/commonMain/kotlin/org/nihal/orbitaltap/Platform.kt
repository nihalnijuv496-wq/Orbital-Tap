package org.nihal.orbitaltap

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
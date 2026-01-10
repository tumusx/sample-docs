package com.tumusx.multiplatform

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform
package com.igormeira.hearthstonecards.core.network

import com.igormeira.hearthstonecards.core.extensions.loggerDebug

sealed class Failure {

    open class NetworkFailure(val code: Int, val message: String) : Failure() {
        init {
            this.loggerDebug()
        }
    }

    object GenericFailure: Failure()

    data class ParseFailure(val message: String): Failure()
}
package com.redolf.exceptions

import java.io.PrintWriter

class CountryNotFoundException(message: String?) : Exception(message) {
    override fun printStackTrace(s: PrintWriter?) {
        super.printStackTrace(s)
    }
}
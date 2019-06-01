package com.incwelltechnology.nres.data

internal class Envelope<T> {
    var status: Boolean = false
    var data: T? = null
}
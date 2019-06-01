package com.incwelltechnology.nres.data.converter

import com.incwelltechnology.nres.data.Envelope
import okhttp3.ResponseBody
import retrofit2.Converter

import java.io.IOException

internal class EnvelopeConverter<T>(val delegate: Converter<ResponseBody, Envelope<T>>) : Converter<ResponseBody, T> {
    @Throws(IOException::class)
    override fun convert(responseBody: ResponseBody): T? {
        val envelope = delegate.convert(responseBody)
        return envelope!!.data
    }
}
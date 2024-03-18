package com.helloclue.androidassignment.network.interceptor

import com.helloclue.androidassignment.network.PhotoApiService.Companion.API_KEY

import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * A [Interceptor] that adds the authorization key to each request.
 */
@Singleton
class AuthInterceptor
@Inject
constructor() : Interceptor {

    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val newRequest = request.newBuilder()
            .header(AUTH, "Client-ID $API_KEY")
            .build()
        return chain.proceed(newRequest)
    }
}

private const val AUTH = "Authorization"

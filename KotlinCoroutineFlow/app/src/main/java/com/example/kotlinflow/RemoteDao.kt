package com.example.kotlinflow

import retrofit2.http.Body
import retrofit2.http.POST

interface RemoteDao {

    @POST("/login")
    suspend fun login(
        @Body credentials: LoginAndRegisterRequestModelClass
    ): LoginResponseModelClass

    @POST("/register")
    suspend fun register(
        @Body details: LoginAndRegisterRequestModelClass
    ): RegisterUserResponseModelClass
}

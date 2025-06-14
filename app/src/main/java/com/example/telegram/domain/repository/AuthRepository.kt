package com.example.telegram.domain.repository

import com.example.authflow.domain.model.PersonData
import com.example.authflow.domain.model.SecurityData

interface AuthRepository {
    suspend fun signIn(phoneNumber: String): Result<PersonData>
    suspend fun signUp(firstName: String, lastName: String, phoneNumber: String): Result<PersonData>
    suspend fun checkOTP(otp: String): Result<PersonData>
    suspend fun logOut(): Result<Unit>
    suspend fun isUserLoggedIn(): Boolean
    suspend fun getToken(): SecurityData
}
package com.example.authflow.domain.usecase

import com.example.authflow.domain.model.PersonData
import com.example.authflow.domain.model.SecurityData
import com.example.telegram.domain.repository.AuthRepository

class SignInUseCase(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(phoneNumber: String): Result<PersonData> {
        return authRepository.signIn(phoneNumber)
    }
}

class CheckUserLoggedIn(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): Boolean {
        return authRepository.isUserLoggedIn()
    }
}

class SignUp(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        firstName: String, lastName: String, phoneNumber: String
    ): Result<PersonData> {
        return authRepository.signUp(firstName, lastName, phoneNumber)
    }
}

class SignIn(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(phoneNumber: String): Result<PersonData> {
        return authRepository.signIn(phoneNumber)
    }
}

class CheckOTP(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(otp: String): Result<PersonData> {
        return authRepository.checkOTP(otp)
    }
}

class LogOut(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): Result<Unit> {
        return authRepository.logOut()
    }
}

class UpdateToken(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(): Result<SecurityData> {
        return authRepository.getToken()
    }
}
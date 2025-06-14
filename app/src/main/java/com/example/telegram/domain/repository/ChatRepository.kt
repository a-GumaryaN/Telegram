package com.example.telegram.domain.repository

interface ChatRepository {
    suspend fun blockUser(uuid:String):Result<Boolean>
    suspend fun deleteChat(uuid:String) : Result<Boolean>
}
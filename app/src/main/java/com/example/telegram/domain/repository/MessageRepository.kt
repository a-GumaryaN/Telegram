package com.example.telegram.domain.repository

import com.example.authflow.domain.model.Message


interface MessageRepository {
    suspend fun sendMessage(
        content : String,
        author : String, // => ID of sender
        sendTime : String,
        editTime : String,
        replyOf : String,
    ) : Result<Message>

    suspend fun uploadFile(fileUri: List<String?>, message: Result<Message>) : Result<Message>

    suspend fun editMessage(message: Message) : Result<Boolean>

    suspend fun deleteMessage(messageUri: String) : Result<Boolean>
}
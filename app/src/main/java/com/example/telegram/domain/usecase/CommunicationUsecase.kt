package com.example.telegram.domain.usecase

import com.example.authflow.domain.model.Message
import com.example.authflow.domain.model.PersonData
import com.example.telegram.domain.repository.ChatRepository
import com.example.telegram.domain.repository.MessageRepository


//-----------------communication-use-cases-----------------
class SendMessage(
    private val messageRepository: MessageRepository
) {
    suspend operator fun invoke(
        content: String,
        author: String, // => ID of sender
        sendTime: String,
        editTime: String,
        replyOf: String,
        fileUri : List<String?> // => list of uri of message attached files
    ): Result<Message> {
        val message = messageRepository.sendMessage(
            content = content,
            author = author, // => ID of sender
            sendTime = sendTime,
            editTime = editTime,
            replyOf = replyOf
        )
        return messageRepository.uploadFile(fileUri =fileUri, message =message)
    }
}
class EditMessage(
    private val messageRepository: MessageRepository
) {
    suspend operator fun invoke(message: Message): Result<Boolean> {
        return messageRepository.editMessage(message)
    }
}
class DeleteMessage(
    private val messageRepository: MessageRepository
) {
    suspend operator fun invoke(messageUri : String): Result<Boolean> {
        return messageRepository.deleteMessage(messageUri)
    }
}


// chat use cases
class BlockUser(
    private val chatRepository : ChatRepository,
    private val personData: PersonData
) {
    suspend operator fun invoke(uuid: String): Result<Boolean> {
        return chatRepository.blockUser(uuid)
    }
}
class DeleteChat(
private val chatRepository : ChatRepository
){
    suspend fun invoke(uuid:String): Result<Boolean>{
        return chatRepository.deleteChat(uuid)
    }
}
package com.example.authflow.domain.model

import android.net.Uri

enum class FileType{
    Image,
    Video,
    Voice,
    URL,
    Emoji
}

class File(
    val fileType: FileType,
    val fileUri: Uri // uri of file or name of emoji of URL
)

class Message(
    val uuid: String,
    val author: String, // => ID of sender
    val sendTime: String,
    val editTime: String?,
    val replyOf: String?, // => uuid of prev replied message
    val content : String?, // => text content
    val attachedFiles : List<File?> = emptyList(),
)

enum class CommunicationType{
    Chat,Group,Chanel
}

sealed class Communication (
    open val uuid : String,
    val communicationType :CommunicationType,
    val messages : List<Message> = emptyList()
)

typealias  Communications = List<Communication>

class Chat (
    override val uuid :String,
    val otherSidePerson : PersonPublicInfo,
) : Communication(uuid=uuid,communicationType = CommunicationType.Chat)

class Chanel (
    override val uuid :String,
    val owner : PersonPublicInfo
) : Communication(uuid=uuid,communicationType = CommunicationType.Chanel)

class Group (
    override val uuid :String,
    val owner : PersonPublicInfo
) : Communication(uuid=uuid,communicationType = CommunicationType.Group)
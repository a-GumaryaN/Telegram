package com.example.authflow.domain.model


enum class  MessageContentType{
    Text,Image,ShortVideo,Emoji
}

class Message(
    val contentType :MessageContentType = MessageContentType.Text,
    val content : String,
    val author : String, // => ID of sender
)


enum class CommunicationType{
    Chat,Group,Chanel
}

sealed class Communication (
    val communicationType :CommunicationType,
    val messages : List<Message> = emptyList()
)

typealias  Communications = List<Communication>

class Chat (
    val otherSidePerson : PersonPublicInfo
) : Communication(communicationType = CommunicationType.Chat)

class Chanel (
    val owner : PersonPublicInfo
) : Communication(communicationType = CommunicationType.Chanel)

class Group (
    val owner : PersonPublicInfo
) : Communication(communicationType = CommunicationType.Group)
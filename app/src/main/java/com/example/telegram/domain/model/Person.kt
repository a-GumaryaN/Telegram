package com.example.authflow.domain.model

import java.util.Date


enum class AccessorType {
    Nobody, Everybody, AllExceptSomeone
}

data class SecuritySettings(
    val whoCanSeeMyProfileImage: AccessorType = AccessorType.Everybody,
    val whoCanFindMeByPhoneNumber: AccessorType = AccessorType.Everybody,
    val whoCanSeeMyProfileInfo: AccessorType = AccessorType.Everybody
)

data class Settings(
    val appThemeMode: String, val securitySettings: SecuritySettings
)

// data of other person that user communicate with them
data class PersonPublicInfo(
    val id: String,
    val firstName: String,
    val lastName: String? = null,
    val bio: String? = null,
    val dateOfBirth: Date? = null,
    val profileImages: List<Int> = emptyList(),
    val phoneNumber: String? = null,
    val isMuted: Boolean = false,
    val isImportant: Boolean = false
)

// data of user
data class PersonData(
    val id: String,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: Date? = null,
    val phoneNumber: String,
    val profileImages: List<Int> = emptyList(),
    val bio: String? = null,
    val settings: Settings,
    val contacts: List<PersonPublicInfo> = emptyList(),
    val mutedPersonIds: List<String> = emptyList(),
    val blockList : List<String> = emptyList(),
    val securityData : SecurityData
)


data class SecurityData(
    val token:String,
    val expireTime : String,
)
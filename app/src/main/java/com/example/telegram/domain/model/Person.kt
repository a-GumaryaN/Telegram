package com.example.authflow.domain.model

import androidx.compose.ui.graphics.painter.Painter
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
    val appThemeMode: String,
    val securitySettings: SecuritySettings
)

data class ValueAccessor(
    val type: AccessorType,
    val except: List<String> = emptyList(),
    val specificPeople: List<String> = emptyList()
)

data class PersonPublicInfo(
    val id : String,
    val firstName: String,
    val lastName: String? = null,
    val bio: String? = null,
    val dateOfBirth: Date? = null,
    val profileImages: List<Int> = emptyList(),
    val phoneNumber: String? = null,
    val isMuted: Boolean = false,
    val isImportant: Boolean = false
)

data class PersonData(
    val id: String,
    val firstName: String,
    val lastName: String,
    val dateOfBirth: Date? = null,
    val phoneNumber: String,
    val profileImages: List<Int> = emptyList(),
    val bio: String? = null,
    val settings: Settings,
    val token: String,
    val contacts: List<PersonPublicInfo> = emptyList(),
    val mutedPersonIds: List<String> = emptyList()
)
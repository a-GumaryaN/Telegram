package com.example.telegram.domain.model

enum class  JobType{
    UploadFile,
}

enum class  JobStatus{
    Done, Pending, Canceled
}

data class Job (
    val typeOfJob : JobType,
    val status : JobStatus
)
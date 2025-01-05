package com.task.pulleycore.domain.user

import com.task.pulleycore.domain.enums.UserRole
import com.task.pulleycore.domain.support.EntityId

data class User(
    val seq: Long? = null,
    val userId: EntityId,
    val username: String,
    val role: UserRole
)

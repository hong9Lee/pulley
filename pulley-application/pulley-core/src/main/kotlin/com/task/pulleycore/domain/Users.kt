package com.task.pulleycore.domain

import com.task.pulleycore.domain.enums.UserRoleType
import com.task.pulleycore.domain.support.EntityId

data class Users(
    val seq: Long? = null,
    val userId: EntityId,
    val username: String,
    val role: UserRoleType
)

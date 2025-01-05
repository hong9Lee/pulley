package com.task.pulley.core.domain

import com.task.pulley.core.domain.enums.UserRoleType
import com.task.pulley.core.domain.support.EntityId

data class Users(
    val seq: Long? = null,
    val userId: EntityId,
    val username: String,
    val role: UserRoleType
)

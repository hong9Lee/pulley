package com.task.pulleycore.domain.support

import com.task.support.UUIDUtil

data class EntityId(
    val value: String = UUIDUtil.shortUUID()
)

package com.task.pulley.core.domain.support

import com.task.pulley.support.UUIDUtil

data class EntityId(
    val value: String = UUIDUtil.shortUUID()
)

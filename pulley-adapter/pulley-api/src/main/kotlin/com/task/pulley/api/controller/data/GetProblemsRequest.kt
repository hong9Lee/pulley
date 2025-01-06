package com.task.pulley.api.controller.data

import com.task.pulley.core.port.`in`.query.GetProblemsQueryRequest

data class GetProblemsRequest(
    val totalCount: Int,
    val unitCodeList: List<String>,
    val level: String,
    val problemType: String,
) {
    fun toQuery(): GetProblemsQueryRequest {
        return GetProblemsQueryRequest.of(
            totalCount = totalCount,
            unitCodeList = unitCodeList,
            level = level,
            problemType = problemType
        )
    }
}

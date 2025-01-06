package com.task.pulley.core.port.`in`.query

import com.task.pulley.core.model.query.ProblemQueryModel

interface ProblemQuery {
    fun getProblems(
        request: GetProblemsQueryRequest
    ): List<ProblemQueryModel>
}

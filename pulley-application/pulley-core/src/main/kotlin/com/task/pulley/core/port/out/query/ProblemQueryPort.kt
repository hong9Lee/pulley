package com.task.pulley.core.port.out.query

import com.task.pulley.core.domain.enums.ProblemType
import com.task.pulley.core.domain.enums.UnitCodeType
import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.core.model.query.ProblemQueryModel

interface ProblemQueryPort {
    fun getProblems(
        unitCodes: Set<UnitCodeType>,
        levels: Set<Int>,
        problemTypes: Set<ProblemType>,
        limit: Int
    ): List<ProblemQueryModel>

    fun getProblemByIds(ids: Set<EntityId>): List<ProblemQueryModel>
}

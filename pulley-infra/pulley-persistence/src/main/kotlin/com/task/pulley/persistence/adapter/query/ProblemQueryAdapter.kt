package com.task.pulley.persistence.adapter.query

import com.task.pulley.core.domain.enums.ProblemType
import com.task.pulley.core.domain.enums.UnitCodeType
import com.task.pulley.core.model.query.ProblemQueryModel
import com.task.pulley.core.port.out.query.ProblemQueryPort
import com.task.pulley.persistence.repository.query.ProblemQueryRepository
import org.springframework.stereotype.Repository

@Repository
class ProblemQueryAdapter(
    private val problemQueryRepository: ProblemQueryRepository
) : ProblemQueryPort {

    override fun getProblems(
        unitCodes: Set<UnitCodeType>,
        levels: Set<Int>,
        problemTypes: Set<ProblemType>,
        limit: Int
    ): List<ProblemQueryModel> {
        return problemQueryRepository.findProblems(
            unitCodes = unitCodes,
            levels = levels,
            problemTypes = problemTypes,
            limit = limit
        )
    }
}

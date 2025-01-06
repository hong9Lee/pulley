package com.task.pulley.core.service.query

import com.task.pulley.core.domain.Problem
import com.task.pulley.core.domain.enums.LevelType.*
import com.task.pulley.core.model.query.ProblemQueryModel
import com.task.pulley.core.port.`in`.query.GetProblemsQueryRequest
import com.task.pulley.core.port.`in`.query.ProblemQuery
import com.task.pulley.core.port.out.query.ProblemQueryPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ProblemQueryService(
    private val problemQueryPort: ProblemQueryPort
) : ProblemQuery {

    override fun getProblems(request: GetProblemsQueryRequest): List<ProblemQueryModel> {
        val levelDistributionMap = Problem.distributeProblemsByLevel(
            totalCount = request.totalCount,
            level = request.level
        )

        val problems = mutableListOf<ProblemQueryModel>()
        fetchProblemsByLevel(levelDistributionMap[LOW], setOf(1), request, problems)
        fetchProblemsByLevel(levelDistributionMap[MIDDLE], setOf(2, 3, 4), request, problems)
        fetchProblemsByLevel(levelDistributionMap[HIGH], setOf(5), request, problems)

        return problems.take(request.totalCount)
    }

    private fun fetchProblemsByLevel(
        count: Int?,
        levels: Set<Int>,
        request: GetProblemsQueryRequest,
        problems: MutableList<ProblemQueryModel>
    ) {
        count?.takeIf { it > 0 }?.let {
            problems.addAll(
                problemQueryPort.getProblems(
                    unitCodes = request.unitCodes,
                    levels = levels,
                    problemTypes = request.problemTypes,
                    limit = it
                )
            )
        }
    }
}

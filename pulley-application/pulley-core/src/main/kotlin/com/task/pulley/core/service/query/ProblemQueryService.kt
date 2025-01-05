package com.task.pulley.core.service.query

import com.task.pulley.core.port.`in`.query.ProblemQuery
import com.task.pulley.core.port.out.query.ProblemQueryPort
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
@Transactional(readOnly = true)
class ProblemQueryService(
    private val problemQueryPort: ProblemQueryPort
): ProblemQuery {

    override fun getProblems() {

    }
}

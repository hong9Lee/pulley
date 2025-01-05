package com.task.pulley.persistence.adapter.query

import com.task.pulley.core.port.out.query.ProblemQueryPort
import com.task.pulley.persistence.repository.ProblemRepository
import org.springframework.stereotype.Repository

@Repository
class ProblemQueryAdapter(
    private val problemRepository: ProblemRepository
): ProblemQueryPort {

    override fun getProblems() {

    }

}

package com.task.pulley.persistence.repository.query

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Projections
import com.querydsl.jpa.impl.JPAQueryFactory
import com.task.pulley.core.domain.enums.ProblemType
import com.task.pulley.core.domain.enums.UnitCodeType
import com.task.pulley.core.model.query.ProblemQueryModel
import com.task.pulley.persistence.entity.QProblemEntity.problemEntity
import com.task.pulley.persistence.repository.query.result.ProblemQueryResult
import com.task.pulley.persistence.supports.QuerydslSupport
import org.springframework.stereotype.Component
import kotlin.random.Random

@Component
class ProblemQueryRepository(
    private val jpaQueryFactory: JPAQueryFactory
) : QuerydslSupport() {

    fun findProblems(
        unitCodes: Set<UnitCodeType>,
        levels: Set<Int>,
        problemTypes: Set<ProblemType>,
        limit: Int
    ): List<ProblemQueryModel> {
        val builder = BooleanBuilder()
        with(builder) {
            addInCondition(unitCodes, problemEntity.unitCode)
            addInCondition(levels, problemEntity.level)
            addInCondition(problemTypes, problemEntity.problemType)
        }

        val totalProblems = jpaQueryFactory
            .select(problemEntity.problemId.count())
            .from(problemEntity)
            .where(builder)
            .fetchOne() ?: 0L

        val randomOffset = if (totalProblems > limit) {
            Random.nextLong(0, totalProblems - limit + 1)
        } else {
            0L
        }

        return jpaQueryFactory.select(
            Projections.constructor(
                ProblemQueryResult::class.java,
                problemEntity.problemId,
                problemEntity.unitCode,
                problemEntity.level,
                problemEntity.problemType,
                problemEntity.answer
            )
        ).from(problemEntity)
            .where(builder)
            .offset(randomOffset)
            .limit(limit.toLong())
            .fetch()
            .map { it.toModel() }
    }
}

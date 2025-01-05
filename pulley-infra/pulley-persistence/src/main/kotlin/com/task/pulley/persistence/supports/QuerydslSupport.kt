package com.task.pulley.persistence.supports

import com.querydsl.core.BooleanBuilder
import com.querydsl.core.types.Path
import com.querydsl.core.types.dsl.BooleanExpression
import com.querydsl.core.types.dsl.DateTimePath
import com.querydsl.core.types.dsl.EnumPath
import com.querydsl.core.types.dsl.Expressions
import com.querydsl.core.types.dsl.NumberPath
import com.querydsl.core.types.dsl.StringPath
import org.springframework.stereotype.Component
import java.time.ZonedDateTime

@Component
abstract class QuerydslSupport(
) {
    protected fun BooleanBuilder.addCondition(value: Any?, condition: (Any) -> BooleanExpression) {
        value?.let { this.and(condition(it)) }
    }

    protected fun BooleanBuilder.addCondition(condition: () -> BooleanExpression) {
        this.and(condition())
    }

    protected fun BooleanBuilder.addDateRangeCondition(
        start: ZonedDateTime?,
        end: ZonedDateTime?,
        field: DateTimePath<ZonedDateTime>
    ) {
        if (start != null && end != null) {
            this.and(field.between(start, end))
        }
    }

    protected fun <T> BooleanBuilder.addInCondition(values: Collection<T>?, path: Path<T>) {
        if (!values.isNullOrEmpty()) {
            val expression = Expressions.path(path.type, path.metadata)
            when (path) {
                is StringPath -> this.and(expression.`in`(values))
                is NumberPath<*> -> this.and(expression.`in`(values))
                is EnumPath<*> -> this.and(expression.`in`(values))
                else -> throw IllegalArgumentException("Unsupported type: ${path.javaClass}")
            }
        }
    }

    protected fun BooleanBuilder.addRangeCondition(
        min: ZonedDateTime?,
        max: ZonedDateTime?,
        field: DateTimePath<ZonedDateTime>
    ) {
        if (min != null && max != null) {
            this.and(field.between(min, max))
        }
    }

    protected fun BooleanBuilder.addOrConditions(vararg conditions: () -> BooleanExpression) {
        val orBuilder = BooleanBuilder()
        conditions.forEach { condition ->
            orBuilder.or(condition())
        }
        this.and(orBuilder)
    }

    protected fun BooleanBuilder.addConditionWithDateRange(
        start: ZonedDateTime?,
        end: ZonedDateTime?,
        field: DateTimePath<ZonedDateTime>,
        typeCondition: BooleanExpression
    ) {
        if (start != null && end != null) {
            this.and(typeCondition.and(field.between(start, end)))
        }
    }
}

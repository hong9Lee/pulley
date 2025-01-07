package com.task.pulley.persistence.repository.query

import com.querydsl.jpa.impl.JPAQueryFactory
import com.task.pulley.core.domain.Piece
import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.persistence.entity.QPieceEntity.pieceEntity
import com.task.pulley.persistence.supports.QuerydslSupport
import org.springframework.stereotype.Component

@Component
class PieceQueryRepository(
    private val jpaQueryFactory: JPAQueryFactory
) : QuerydslSupport() {

    fun findByPieceIdAndTeacherId(pieceId: EntityId, teacherId: EntityId): Piece? {
        return jpaQueryFactory
            .selectFrom(pieceEntity)
            .where(
                pieceEntity.pieceId.value.eq(pieceId.value),
                pieceEntity.teacherId.value.eq(teacherId.value)
            )
            .fetchOne()?.toDomain()
    }

    fun findByPieceId(pieceId: EntityId): Piece? {
        return jpaQueryFactory
            .selectFrom(pieceEntity)
            .where(
                pieceEntity.pieceId.value.eq(pieceId.value),
            )
            .fetchOne()?.toDomain()
    }
}

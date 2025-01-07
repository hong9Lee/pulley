package com.task.pulley.api.controller.data

import com.task.pulley.core.domain.Piece

data class CreatePieceResponse(
    val pieceId: String,
    val teacherId: String,
    val name: String,
) {
    companion object {
        fun of(model: Piece): CreatePieceResponse {
            return CreatePieceResponse(
                pieceId = model.pieceId.value,
                name = model.name,
                teacherId = model.teacherId.value,
            )
        }
    }
}

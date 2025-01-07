package com.task.pulley.api.controller.rest

import com.task.pulley.api.controller.data.AssignPieceRequest
import com.task.pulley.api.controller.data.AssignPieceResponse
import com.task.pulley.api.controller.data.CreatePieceRequest
import com.task.pulley.api.controller.data.CreatePieceResponse
import com.task.pulley.api.supports.UrlConstants
import com.task.pulley.core.port.`in`.command.AssignPieceUseCase
import com.task.pulley.core.port.`in`.command.CreatePieceUseCase
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.*

@RestController
class PieceController(
    private val createPieceUseCase: CreatePieceUseCase,
    private val assignPieceUseCase: AssignPieceUseCase
) {

    @PostMapping(UrlConstants.학습지_생성)
    fun createPiece(@Validated @RequestBody request: CreatePieceRequest): ResponseEntity<CreatePieceResponse> {
        return ResponseEntity.ok(
            CreatePieceResponse
                .of(
                    createPieceUseCase.createPiece(
                        request.toCommand()
                    )
                )
        )
    }

    @PostMapping(UrlConstants.학습지_제출)
    fun assignPiece(
        @PathVariable pieceId: String,
        @RequestParam studentIds: List<String>,
        @RequestBody request: AssignPieceRequest
    ): ResponseEntity<AssignPieceResponse> {
        val result = assignPieceUseCase.assignPiece(
            request.toCommand(pieceId, studentIds)
        )
        return ResponseEntity.ok(
            AssignPieceResponse.of(
                assigned = result.assignedStudents,
                skipped = result.skippedStudents
            )
        )
    }
}

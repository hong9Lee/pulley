package com.task.pulley.api.controller.rest

import com.task.pulley.api.controller.data.CreatePieceRequest
import com.task.pulley.api.controller.data.CreatePieceResponse
import com.task.pulley.api.supports.UrlConstants
import com.task.pulley.core.port.`in`.command.CreatePieceUseCase
import org.springframework.http.ResponseEntity
import org.springframework.validation.annotation.Validated
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class PieceController(
    private val createPieceUseCase: CreatePieceUseCase
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
}

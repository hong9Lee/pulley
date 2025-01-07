package com.task.pulley.api.controller.rest

import com.task.pulley.api.controller.data.GetPieceProblemsResponse
import com.task.pulley.api.supports.UrlConstants
import com.task.pulley.core.domain.support.EntityId
import com.task.pulley.core.port.`in`.query.PieceProblemQuery
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class PieceProblemController(
    private val pieceProblemQuery: PieceProblemQuery
) {
    @GetMapping(UrlConstants.학습지_문제_조회)
    fun getPieceProblems(
        @RequestParam pieceId: String
    ): ResponseEntity<GetPieceProblemsResponse> {
        return ResponseEntity.ok(
            GetPieceProblemsResponse.of(
                pieceProblemQuery.getPieceProblems(EntityId(pieceId))
            )
        )
    }
}

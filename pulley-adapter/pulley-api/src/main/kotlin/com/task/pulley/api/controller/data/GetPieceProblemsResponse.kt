package com.task.pulley.api.controller.data

import com.task.pulley.core.model.query.ProblemQueryModel

data class GetPieceProblemsResponse(
    val problemList: List<GetPieceProblemData>
) {
    companion object {
        fun of(models: List<ProblemQueryModel>) = GetPieceProblemsResponse(
            problemList = models.map { GetPieceProblemData.of(it) }
        )
    }

    data class GetPieceProblemData(
        val id: String,
        val unitCode: String,
        val level: Int,
        val problemType: String,
        val answer: String
    ) {
        companion object {
            fun of(model: ProblemQueryModel) = GetPieceProblemData(
                id = model.problemId.value,
                unitCode = model.unitCode.name,
                level = model.level,
                problemType = model.problemType.name,
                answer = model.answer
            )
        }
    }
}

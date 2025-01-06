package com.task.pulley.core.domain

import com.task.pulley.core.domain.enums.LevelType
import com.task.pulley.core.domain.enums.LevelType.*
import com.task.pulley.core.domain.enums.ProblemType
import com.task.pulley.core.domain.enums.UnitCodeType
import com.task.pulley.core.domain.support.EntityId

data class Problem(
    val seq: Long? = null,
    val problemId: EntityId,
    val pieceId: EntityId,
    val unitCode: UnitCodeType,
    val level: Int,
    val problemType: ProblemType,
    val answer: String,
) {
    companion object {
        fun distributeProblemsByLevel(totalCount: Int, level: String): Map<LevelType, Int> {
            val percentages = getPercentagesByLevel(level)
            val distributed = allocateProblemsByPercentage(totalCount, percentages)
            return distributeRemainingProblems(distributed, totalCount - distributed.values.sum(), percentages)
        }

        /**
         * 난이도에 따라 비율을 반환
         */
        private fun getPercentagesByLevel(level: String): Map<LevelType, Double> {
            return when (level.uppercase()) {
                "HIGH" -> mapOf(LOW to 0.2, MIDDLE to 0.3, HIGH to 0.5)
                "MIDDLE" -> mapOf(LOW to 0.25, MIDDLE to 0.5, HIGH to 0.25)
                "LOW" -> mapOf(LOW to 0.5, MIDDLE to 0.3, HIGH to 0.2)
                else -> throw IllegalArgumentException("Invalid level: $level")
            }
        }

        /**
         * 비율에 따라 문제 수를 할당
         */
        private fun allocateProblemsByPercentage(
            totalCount: Int,
            percentages: Map<LevelType, Double>
        ): MutableMap<LevelType, Int> {
            val distributed = mutableMapOf<LevelType, Int>()
            percentages.forEach { (key, percentage) ->
                distributed[key] = (totalCount * percentage).toInt()
            }
            return distributed
        }

        /**
         * 남은 문제 수를 우선순위에 따라 분배
         */
        private fun distributeRemainingProblems(
            distributed: MutableMap<LevelType, Int>,
            remainingCount: Int,
            percentages: Map<LevelType, Double>
        ): Map<LevelType, Int> {
            if (remainingCount <= 0) return distributed

            val priorityLevels = percentages.entries.sortedByDescending { it.value }.map { it.key }
            var remaining = remainingCount

            while (remaining > 0) {
                for (level in priorityLevels) {
                    if (remaining <= 0) break
                    distributed[level] = distributed.getOrDefault(level, 0) + 1
                    remaining--
                }
            }

            return distributed
        }
    }
}

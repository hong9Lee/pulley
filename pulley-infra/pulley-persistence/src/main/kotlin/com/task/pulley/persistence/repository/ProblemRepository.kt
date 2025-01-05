package com.task.pulley.persistence.repository

import com.task.pulley.persistence.entity.ProblemEntity
import org.springframework.data.repository.CrudRepository

interface ProblemRepository : CrudRepository<ProblemEntity, Long> {
}

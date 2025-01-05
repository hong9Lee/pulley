package com.task.pulleypersistence.repository

import com.task.pulleypersistence.entity.ProblemEntity
import org.springframework.data.repository.CrudRepository

interface ProblemRepository : CrudRepository<ProblemEntity, Long> {
}

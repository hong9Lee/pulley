package com.task.pulleypersistence.repository

import com.task.pulleypersistence.entity.UserEntity
import org.springframework.data.repository.CrudRepository

interface UserRepository: CrudRepository<UserEntity, Long> {
}

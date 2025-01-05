package com.task.pulleypersistence.repository

import com.task.pulleypersistence.entity.UsersEntity
import org.springframework.data.repository.CrudRepository

interface UsersRepository: CrudRepository<UsersEntity, Long> {
}

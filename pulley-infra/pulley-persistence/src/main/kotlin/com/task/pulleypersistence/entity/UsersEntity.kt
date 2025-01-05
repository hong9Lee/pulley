package com.task.pulleypersistence.entity

import com.task.pulleycore.domain.enums.UserRoleType
import com.task.pulleycore.domain.support.EntityId
import com.task.pulleycore.domain.Users
import com.task.pulleypersistence.entity.base.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "users")
class UsersEntity(
    @Embedded
    @AttributeOverride(name = "value", column = Column(name = "user_id"))
    private val userId: EntityId,

    @Column(name = "user_name")
    val userName: String,

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    val role: UserRoleType
) : BaseTimeEntity() {

    companion object {
        fun of(users: Users): UsersEntity {
            return UsersEntity(users.userId, users.username, users.role)
        }
    }

    fun toDomain(): Users {
        return Users(userId = this.userId, username = this.userName, role = this.role)
    }
}

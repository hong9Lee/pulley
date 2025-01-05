package com.task.pulleypersistence.entity

import com.task.pulleycore.domain.enums.UserRole
import com.task.pulleycore.domain.support.EntityId
import com.task.pulleycore.domain.user.User
import com.task.pulleypersistence.entity.base.BaseTimeEntity
import jakarta.persistence.*

@Entity
@Table(name = "pulley_user")
class UserEntity(
    @Embedded
    @AttributeOverride(name = "value", column = Column(name = "user_id"))
    private val userId: EntityId,

    @Column(name = "user_name")
    val userName: String,

    @Column(name = "role")
    @Enumerated(EnumType.STRING)
    val role: UserRole
) : BaseTimeEntity() {

    companion object {
        fun of(user: User): UserEntity {
            return UserEntity(user.userId, user.username, user.role)
        }
    }

    fun toDomain(): User {
        return User(userId = this.userId, username = this.userName, role = this.role)
    }
}

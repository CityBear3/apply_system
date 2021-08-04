package com.account_manager.apply_system.initialize

import com.account_manager.apply_system.model.RoleType
import com.account_manager.apply_system.repository.UserRegisterRepository
import org.springframework.batch.core.StepContribution
import org.springframework.batch.core.scope.context.ChunkContext
import org.springframework.batch.core.step.tasklet.Tasklet
import org.springframework.batch.repeat.RepeatStatus
import org.springframework.stereotype.Component

@Component
class UserInitializeTasklet(private val userRegisterRepository: UserRegisterRepository) : Tasklet {
    override fun execute(contribution: StepContribution, chunkContext: ChunkContext): RepeatStatus? {
        val id = "test00"
        val name = "John Smith"
        val password = "test-0000"
        val role = RoleType.ADMIN.toString()
        userRegisterRepository.register(id, name, password, role)
        return RepeatStatus.FINISHED
    }
}
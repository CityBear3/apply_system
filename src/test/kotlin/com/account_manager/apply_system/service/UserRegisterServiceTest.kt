package com.account_manager.apply_system.service

import com.account_manager.apply_system.model.RoleType
import com.account_manager.apply_system.repository.UserRegisterRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

internal class UserRegisterServiceTest {
    private val userRegisterRepository = mock<UserRegisterRepository>()
    private val userRegisterService = UserRegisterService(userRegisterRepository)
    private val id = "testId"
    private val name = "tester"
    private val password = "password"
    private val role = RoleType.NORMAL.toString()

    @Test
    fun `ok when registration of new user is succeed`() {
        val expected = true
        doReturn(expected).whenever(userRegisterRepository).register(id, name, password, role)
        Assertions.assertEquals(HttpStatus.OK, userRegisterService.userRegister(id, name, password, role).statusCode)
    }

    @Test
    fun `internal error when registration of new user is failed`() {
        val expected = false
        doReturn(expected).`when`(userRegisterRepository).register(id, name, password, role)
        Assertions.assertEquals(
            HttpStatus.INTERNAL_SERVER_ERROR,
            userRegisterService.userRegister(id, name, password, role).statusCode
        )
    }
}
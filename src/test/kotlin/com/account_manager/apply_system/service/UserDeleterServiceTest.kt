package com.account_manager.apply_system.service

import com.account_manager.apply_system.repository.UserDeleteRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

internal class UserDeleterServiceTest {
    private val userDeleteRepository = mock<UserDeleteRepository>()

    private val userDeleterService = UserDeleterService(userDeleteRepository)

    private val userId = "testId"

    @Test
    fun `OK when to delete user is succeed`() {
        val expected = true
        doReturn(expected).whenever(userDeleteRepository).deleter(userId)
        Assertions.assertEquals(HttpStatus.OK, userDeleterService.userDeleter(userId).statusCode)
    }

    @Test
    fun `Bad request when to delete user is failed`() {
        val expected = false
        doReturn(expected).whenever(userDeleteRepository).deleter(userId)
        Assertions.assertEquals(HttpStatus.BAD_REQUEST, userDeleterService.userDeleter(userId).statusCode)
    }
}
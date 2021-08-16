package com.account_manager.apply_system.service

import com.account_manager.apply_system.model.UserInfoModel
import com.account_manager.apply_system.repository.UserListRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity

internal class UserListServiceTest {
    private val userListRepository = mock<UserListRepository>()

    private val userListService = UserListService(userListRepository)

    @Test
    fun `INTERNAL_SERVER_ERROR when to get user list is failed`() {
        val expected = null
        doReturn(expected).whenever(userListRepository).viewAll()
        Assertions.assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, userListService.getUserList().statusCode)
    }

    @Test
    fun `OK when to get user list is succeed`() {
        val expected: MutableList<UserInfoModel>? = mutableListOf()
        doReturn(expected).whenever(userListRepository).viewAll()
        Assertions.assertEquals(HttpStatus.OK, userListService.getUserList().statusCode)
    }
}
package com.account_manager.apply_system.service

import com.account_manager.apply_system.model.NewUserInfoModel
import com.account_manager.apply_system.model.RoleType
import com.account_manager.apply_system.repository.PasswordChangeRepository
import com.nhaarman.mockitokotlin2.doReturn
import com.nhaarman.mockitokotlin2.mock
import com.nhaarman.mockitokotlin2.whenever
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test
import org.springframework.http.HttpStatus

internal class PasswordChangeServiceTest {
    private val passwordChangeRepository = mock<PasswordChangeRepository>()

    private val userInfoService = mock<UserInfoService>()

    private val passwordChangeService = PasswordChangeService(passwordChangeRepository, userInfoService)

    @Test
    fun `ok when to change password is succeed`() {
        val pass = "password"
        val checkPass = "password"
        val userInfo = NewUserInfoModel(pass, checkPass)
        val expected = true
        val applyUserDetail = ApplyUserDetail("testID", "tester", "password", RoleType.NORMAL.toString())

        doReturn(expected).whenever(passwordChangeRepository).changer(pass, applyUserDetail.id)
        doReturn(applyUserDetail).whenever(userInfoService).getUserInfo()
        Assertions.assertEquals(HttpStatus.OK, passwordChangeService.passwordChange(userInfo).statusCode)
    }

    @Test
    fun `bad request when validation of password is failed`() {
        val pass = "1234"
        val wrongPass = "1235"
        val userInfo = NewUserInfoModel(pass, wrongPass)
        val applyUserDetail = ApplyUserDetail("testID", "tester", "password", RoleType.NORMAL.toString())
        val expected = HttpStatus.BAD_REQUEST

        doReturn(applyUserDetail).whenever(userInfoService).getUserInfo()
        Assertions.assertEquals(expected, passwordChangeService.passwordChange(userInfo).statusCode)
    }
}
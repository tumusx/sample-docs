package com.github.tumusx.mv_flow.viewmodel

import com.github.tumusx.mv_flow.flow.contract.Actions
import com.github.tumusx.mv_flow.flow.contract.IFlow
import com.github.tumusx.mv_flow.flow.impl.ProfileFlowImpl
import com.github.tumusx.mv_flow.flow.impl.UserFlowImpl
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.Before
import org.junit.Test


class MvFlowViewModelTest {
    private lateinit var mvFlowViewModel: MvFlowViewModel

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setup() {
        Dispatchers.setMain(Dispatchers.Unconfined)
    }

    @Test
    fun when_call_navigate_verify_action_change_to_User() = runTest {
        val  userFlow: IFlow = UserFlowImpl()

        mvFlowViewModel = MvFlowViewModel(userFlow)

        mvFlowViewModel.goToAnotherScreen()

        val result = userFlow.infoNavigation.first()

        assert(result?.action == Actions.GoToUser)
    }

    @Test
    fun when_call_navigate_verify_action_change_to_Profile() = runTest {
        val userFlow: IFlow = ProfileFlowImpl()

        mvFlowViewModel = MvFlowViewModel(userFlow)

        mvFlowViewModel.goToAnotherScreen()

        val result = userFlow.infoNavigation.first()

        assert(result?.action == Actions.GoToProfile)
    }
}
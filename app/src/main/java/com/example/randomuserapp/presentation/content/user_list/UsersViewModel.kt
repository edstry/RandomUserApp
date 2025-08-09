package com.example.randomuserapp.presentation.content.user_list

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.randomuserapp.domain.usecase.GetUsersUseCase
import com.example.randomuserapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class UsersViewModel @Inject constructor(
    private val getUsersUseCase: GetUsersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow<UserListState>(UserListState.Initial)
    val state: StateFlow<UserListState>
        get() = _state.asStateFlow()

    init {
        getUsers()
    }

    fun getUsers() {
        getUsersUseCase().onEach { result ->
            when (result) {
                is Resource.Error<*> -> {
                    _state.value =
                        UserListState.ErrorLoading(result.message ?: "An expected error occured")
                }

                is Resource.Loading<*> -> {
                    _state.value = UserListState.Loading
                }

                is Resource.Success<*> -> {
                    _state.value = UserListState.SuccessLoaded(
                        users = result.data ?: emptyList()
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}
package com.tumusx.multiplatform.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.tumusx.multiplatform.data.model.Post
import com.tumusx.multiplatform.data.repository.PostRepositoryImpl
import com.tumusx.multiplatform.domain.usecase.GetPostsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed class UiState {
    object Loading : UiState()
    data class Success(val posts: List<Post>) : UiState()
    data class Error(val message: String) : UiState()
}

class PostViewModel : ViewModel() {
    private val repository = PostRepositoryImpl()
    private val getPostsUseCase = GetPostsUseCase(repository)

    private val _uiState = MutableStateFlow<UiState>(UiState.Loading)
    val uiState: StateFlow<UiState> = _uiState.asStateFlow()

    init {
        loadPosts()
    }

    fun loadPosts() {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            getPostsUseCase().fold(
                onSuccess = { posts ->
                    _uiState.value = UiState.Success(posts.take(10)) // Show only first 10 posts
                },
                onFailure = { error ->
                    _uiState.value = UiState.Error(error.message ?: "Unknown error")
                }
            )
        }
    }
}

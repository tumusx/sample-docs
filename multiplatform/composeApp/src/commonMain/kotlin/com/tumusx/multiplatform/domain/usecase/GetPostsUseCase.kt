package com.tumusx.multiplatform.domain.usecase

import com.tumusx.multiplatform.data.model.Post
import com.tumusx.multiplatform.data.repository.PostRepository

class GetPostsUseCase(private val repository: PostRepository) {
    suspend operator fun invoke(): Result<List<Post>> {
        return repository.getPosts()
    }
}

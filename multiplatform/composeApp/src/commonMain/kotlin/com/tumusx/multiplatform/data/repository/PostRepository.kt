package com.tumusx.multiplatform.data.repository

import com.tumusx.multiplatform.data.model.Post

interface PostRepository {
    suspend fun getPosts(): Result<List<Post>>
}

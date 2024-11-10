package facility

sealed interface ApiResponse {
    data object Loading : ApiResponse
    data class Success<T>(val contentData: T? = null, val statusCode: Int) : ApiResponse
    data class Error(val statusCode: Int) : ApiResponse
}
# HTTP Request with Clean Architecture

This implementation demonstrates a simple clean architecture pattern for making HTTP requests to a free API.

## Architecture

The application follows a simplified clean architecture with three main layers:

### 1. Data Layer (`data/`)
- **Models**: `Post.kt` - Data model representing a post from the API
- **Repository**: 
  - `PostRepository.kt` - Interface defining the data contract
  - `PostRepositoryImpl.kt` - Implementation using Ktor HTTP client

### 2. Domain Layer (`domain/`)
- **Use Case**: `GetPostsUseCase.kt` - Business logic for fetching posts

### 3. UI Layer (`ui/`)
- **ViewModel**: `PostViewModel.kt` - Manages UI state (Loading, Success, Error)
- **Composable UI**: `App.kt` - Displays the data with Material3 components

## Architecture Flow

```
UI (App.kt)
    ↓
ViewModel (PostViewModel)
    ↓
Use Case (GetPostsUseCase)
    ↓
Repository (PostRepository/PostRepositoryImpl)
    ↓
HTTP Client (Ktor) → JSONPlaceholder API
```

## API Used
- **Endpoint**: https://jsonplaceholder.typicode.com/posts
- **Method**: GET
- **Response**: List of Post objects with userId, id, title, and body

## Clean Architecture Layers

1. **Data Layer** (`data/`)
   - `model/Post.kt` - Data model with @Serializable annotation
   - `repository/PostRepository.kt` - Repository interface
   - `repository/PostRepositoryImpl.kt` - Repository implementation with Ktor HTTP client

2. **Domain Layer** (`domain/`)
   - `usecase/GetPostsUseCase.kt` - Business logic for fetching posts

3. **UI Layer** (`ui/`)
   - `PostViewModel.kt` - ViewModel with StateFlow for managing UI state
   - `App.kt` - Compose UI that displays loading, success, and error states

The architecture follows separation of concerns:
- **Data Layer**: Handles data operations and network calls
- **Domain Layer**: Contains business logic (use cases)
- **UI Layer**: Presents data to the user

Free API used: JSONPlaceholder (https://jsonplaceholder.typicode.com/posts)

package com.example.myapplication222.viewModel
import androidx.lifecycle.*
import com.example.myapplication222.Post
import com.example.myapplication222.repository.PostRepository
import com.example.myapplication222.repository.PostRepositorylnMemorylmpl
private val empty = Post(
    id = 0,
    content = "",
    author = "",
    likedByMe = false,
    published = ""
)
class PostViewModel: ViewModel() {
    private val repository: PostRepository = PostRepositorylnMemorylmpl()
    val data = repository.getAll()
    val edited = MutableLiveData(empty)
    fun save() {
        edited.value?.let {
            repository.save(it)
        }
        edited.value = empty
    }
    fun edit(post: Post) {
        edited.value = post
    }

    fun changeContent(content: String) {
        val text = content.trim()
        if (edited.value?.content == text) {
            return
        }
        edited.value = edited.value?.copy(content = text)
    }
    fun likeById(id: Long) = repository.likeById(id)
    fun removeById(id: Long) = repository.removeById(id)
}
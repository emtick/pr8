package com.example.myapplication222.repository

import androidx.lifecycle.LiveData
import com.example.myapplication222.post
interface PostRepository {
    fun getAll(): LiveData<List <post>>
    fun likeById(id: Long)
}
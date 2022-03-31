package com.karlosprojects.searchimagescompose.screens.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.karlosprojects.searchimagescompose.domain.IUnsplashRepository
import com.karlosprojects.searchimagescompose.model.UnsplashImage
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.InternalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@InternalCoroutinesApi
@HiltViewModel
class DetailViewModel @Inject constructor(
    private val unsplashRepository: IUnsplashRepository
) : ViewModel() {

    private val _selectedPhoto: MutableStateFlow<UnsplashImage?> = MutableStateFlow(null)
    val selectedPhoto: StateFlow<UnsplashImage?> = _selectedPhoto

    fun getPhotoDetails(photoId: String) {
        viewModelScope.launch {
            unsplashRepository.getPhotoDetail(photoId).collect {
                _selectedPhoto.value = it
            }
        }
    }
}
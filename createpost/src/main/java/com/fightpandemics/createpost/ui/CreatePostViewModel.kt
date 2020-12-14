package com.fightpandemics.createpost.ui

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fightpandemics.core.dagger.scope.ActivityScope
import com.fightpandemics.createpost.data.model.CreatePostRequest
import com.fightpandemics.createpost.domain.CreatePostsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject

@ActivityScope
class CreatePostViewModel @Inject constructor(private val createPostsUseCase: CreatePostsUseCase) : ViewModel() {

    var titleNotEmpty = MutableLiveData<Boolean>()
    var descriptionNotEmpty = MutableLiveData<Boolean>()
    var isTagSet = MutableLiveData<Boolean>()
    var allDataFilled = MutableLiveData<Boolean>()
    
    fun setDataFilled() {
        allDataFilled.value = titleNotEmpty.value == true && descriptionNotEmpty.value == true && isTagSet.value == true
    }

    fun postContent(createPostRequest: CreatePostRequest) {
        viewModelScope.launch {
            createPostsUseCase(createPostRequest)
        }
    }
}
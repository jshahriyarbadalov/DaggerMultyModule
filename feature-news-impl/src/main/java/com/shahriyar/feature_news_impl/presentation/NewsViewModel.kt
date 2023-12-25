package com.shahriyar.feature_news_impl.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.shahriyar.feature_news_impl.data.model.Article
import com.shahriyar.feature_news_impl.domain.NewsUseCase
import kotlinx.coroutines.launch
import javax.inject.Inject


class NewsViewModel @Inject constructor(
    private val newsUseCase: NewsUseCase
) : ViewModel() {

    private var _article = MutableLiveData<List<Article>>()
    val articles: LiveData<List<Article>> get() = _article
    private val _isLoading = MutableLiveData(false)
    val isLoading: LiveData<Boolean> get() = _isLoading

    init {
        setSearchData("tesla")
    }

    private fun setSearchData(keyword: String) {
        _isLoading.value = true
        val loadDataJob = viewModelScope.launch {
            val articlesData = newsUseCase.loadArticles(keyword)
            articlesData.articles?.let {
                _article.postValue(it)
            }

        }
        loadDataJob.invokeOnCompletion { _isLoading.postValue(false) }
    }
}
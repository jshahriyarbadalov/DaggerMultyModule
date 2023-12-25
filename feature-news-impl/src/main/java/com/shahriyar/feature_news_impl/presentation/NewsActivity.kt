package com.shahriyar.feature_news_impl.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.shahriyar.feature_news_impl.databinding.ActivityNewsBinding
import com.shahriyar.feature_news_impl.di.NewsComponentHolder
import javax.inject.Inject

class NewsActivity : AppCompatActivity() {

    lateinit var binding: ActivityNewsBinding

    @Inject
    lateinit var viewModel: NewsViewModel

    private val newsAdapter: NewsAdapter by lazy { NewsAdapter() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        NewsComponentHolder.getComponent().inject(this)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initAdapter()
    }

    override fun onPause() {
        if (isFinishing) {
            NewsComponentHolder.resetComponent()
        }
        super.onPause()
    }

    private fun initAdapter() {
        binding.rvArticles.adapter = newsAdapter
        viewModel.isLoading.observe(this) {
            binding.progressBar.isVisible = it
        }
        viewModel.articles.observe(this) {
            newsAdapter.submitList(it)
        }
    }


}
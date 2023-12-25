package com.shahriyar.feature_news_impl.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.shahriyar.feature_news_impl.data.model.Article
import com.shahriyar.feature_news_impl.databinding.ItemArticleBinding

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    companion object {
        const val START_POSITION = 0
    }

    private var articles = listOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = NewsViewHolder(
        ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        holder.onBind(articles[position])
    }

    override fun getItemCount() = articles.size

    fun submitList(articleList: List<Article>) {
        this.articles = articleList
        notifyItemRangeChanged(START_POSITION, itemCount)
    }

    inner class NewsViewHolder(private val binding: ItemArticleBinding) : ViewHolder(binding.root) {

        fun onBind(article: Article) = with(binding) {
            Glide.with(root.context).load(article.urlToImage).into(ivArticle)
            tvArticleSource.text = article.source?.name
            tvArticleAuthor.text = article.author
            tvArticleTitle.text = article.title
            tvArticleDescr.text = article.description
        }
    }


}
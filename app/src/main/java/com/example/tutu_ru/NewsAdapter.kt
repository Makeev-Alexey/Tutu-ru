package com.example.tutu_ru

import Articles
import android.content.Intent
import android.text.Html
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.tutu_ru.databinding.NewsBinding

class NewsAdapter(var articles: MutableList<Articles> ) : RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {
     class ArticleViewHolder(var binding: NewsBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = NewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        holder.binding.author.text = Html.fromHtml(article.author)
        var temp = Html.fromHtml(article.title).trim()
        holder.binding.title.text = temp
        println(temp)
        holder.binding.newsconstr.setOnClickListener{
            var intent = Intent(holder.binding.root.context, ArticleActivity::class.java)
            intent.putExtra("article", article)
            holder.binding.root.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return articles.size
    }
    fun setdata(articles: List<Articles>){
        this.articles.clear()
        this.articles.addAll(articles)
        notifyDataSetChanged()
    }
}



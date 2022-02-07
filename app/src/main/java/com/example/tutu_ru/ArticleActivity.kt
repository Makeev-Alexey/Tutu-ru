package com.example.tutu_ru

import Articles
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import com.example.tutu_ru.databinding.ActivityArticleBinding
import com.example.tutu_ru.databinding.ActivityMainBinding

class ArticleActivity : AppCompatActivity() {
    private var _binding : ActivityArticleBinding? = null
    private val binding get() = _binding!!
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var article = intent.getParcelableExtra<Articles>("article")
        if (article != null) {
            binding.textView.text = article.publishedAt
            binding.textView2.text = article.author
            binding.textView3.text = article.title
            binding.textView4.text = article.content
        }
    }
}
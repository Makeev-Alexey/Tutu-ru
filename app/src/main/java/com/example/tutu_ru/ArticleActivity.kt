package com.example.tutu_ru

import Articles
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Html
import android.webkit.WebViewClient
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
        binding.web.webViewClient = WebViewClient()
        binding.web.loadUrl(article?.url.toString())
        binding.web.settings.javaScriptEnabled = true
        binding.web.settings.setSupportZoom(true)
    }
}
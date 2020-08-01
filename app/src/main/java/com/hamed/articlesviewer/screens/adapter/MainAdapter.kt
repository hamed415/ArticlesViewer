package com.hamed.articlesviewer.screens.adapter

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.Adapter
import com.hamed.articlesviewer.R
import com.hamed.core.model.Article
import com.squareup.picasso.Picasso
import com.squareup.picasso.Transformation
import jp.wasabeef.picasso.transformations.RoundedCornersTransformation
import kotlinx.android.synthetic.main.article_item.view.*


class MainAdapter(val context: Context) :
    Adapter<MainAdapter.ViewHolder>() {
    var news = listOf<Article>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return news.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(news[position])
    }

    fun setArticles(articles: List<Article>) {
        news = articles
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView),
        View.OnClickListener {

        init {
            itemView.setOnClickListener(this)
        }

        fun bind(article: Article) {
            itemView.source.text = article.source
            itemView.title.text = article.title
            itemView.description.text = article.description
            itemView.url.text = article.url
            if (article.urlToImage.trim().isNotEmpty()) {
                val transformation: Transformation =
                    RoundedCornersTransformation(10, 0)

                Picasso.with(context)
                    .load(article.urlToImage)
                    .resize(150, 150)
                    .transform(transformation)
                    .error(R.drawable.error)
                    .into(itemView.image)
            }
        }

        override fun onClick(v: View?) {
            v?.let {
                if (v.url.text.trim().isNotEmpty()) {
                    val intent = Intent(Intent.ACTION_VIEW)
                    intent.data = Uri.parse(v.url.text.trim().toString())
                    context.startActivity(intent)
                }
            }

        }
    }
}
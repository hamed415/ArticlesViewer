package com.hamed.articlesviewer.screens.mvvm

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamed.articlesviewer.R
import com.hamed.articlesviewer.screens.adapter.Direction
import com.hamed.articlesviewer.screens.adapter.MainAdapter
import com.hamed.navigation.base.BaseCalligraphyActivity
import kotlinx.android.synthetic.main.activity_vertical_list.*
import org.koin.android.ext.android.inject
import org.koin.core.context.GlobalContext
import java.time.LocalDateTime

class VerticalListActivity : BaseCalligraphyActivity() {

    private val articlesList: ArticleViewModel by inject()
    var mainAdapter: MainAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_vertical_list)
        initiateRecyclerView()

        articlesList.articles.observe(this, Observer { list ->
            mainAdapter?.let { adaptor ->
                adaptor.setArticles(list)
                adaptor.notifyDataSetChanged()
            }
        })

        articlesList.getArticlesByDate(LocalDateTime.now())
    }

    private fun initiateRecyclerView() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        verticalRecyclerView.layoutManager = layoutManager
        verticalRecyclerView.itemAnimator = DefaultItemAnimator()
        verticalRecyclerView.addItemDecoration(
            DividerItemDecoration(
                verticalRecyclerView.context,
                DividerItemDecoration.VERTICAL
            )
        )
        mainAdapter = MainAdapter(this, Direction.Vertical)
        verticalRecyclerView.adapter = mainAdapter
    }
}
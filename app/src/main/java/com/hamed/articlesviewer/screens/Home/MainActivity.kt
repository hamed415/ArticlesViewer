package com.hamed.articlesviewer.screens.home

import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamed.articlesviewer.R
import com.hamed.articlesviewer.screens.adapter.MainAdapter
import com.hamed.core.model.Article
import com.hamed.navigation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<Main.MainPresenter>(),
    Main.MainView {

// branch3
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initiateRecyclerView()
    }


    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun createPresenter(): Main.MainPresenter {
        return MainPresenter()
    }

    override fun onResume() {
        super.onResume()
        presenter?.getArticlesList()
    }

    fun initiateRecyclerView(){
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mainRecyclerView.layoutManager =layoutManager
        mainRecyclerView.itemAnimator = DefaultItemAnimator()
    }

    override fun updateList(articles: List<Article>) {
        mainRecyclerView.adapter = MainAdapter(this, articles)
    }
}
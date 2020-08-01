package com.hamed.articlesviewer.screens.home

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.hamed.articlesviewer.R
import com.hamed.articlesviewer.screens.adapter.MainAdapter
import com.hamed.core.model.Article
import com.hamed.navigation.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity<Main.MainPresenter>(),
    Main.MainView {

    var mainAdapter:MainAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initiateRecyclerView()
        initiateButtons()
    }


    override fun getLayoutResource(): Int {
        return R.layout.activity_main
    }

    override fun createPresenter(): Main.MainPresenter {
        return MainPresenter()
    }

    private fun initiateRecyclerView() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        mainRecyclerView.layoutManager = layoutManager
        mainRecyclerView.itemAnimator = DefaultItemAnimator()

        mainAdapter = MainAdapter(this)
        mainRecyclerView.adapter = mainAdapter
    }

    private fun initiateButtons() {
        btnBefore.setOnClickListener{ v ->
            presenter?.dateDecrement()
        }

        btnAfter.setOnClickListener{ v ->
            presenter?.dateIncrement()
        }

    }

    override fun updateList(articles: List<Article>) {
        mainAdapter?.let {
            Log.d("first article", "${articles.first().title}")
            it.setArticles(articles)
            it.notifyDataSetChanged()
        }?: run {
            mainAdapter = MainAdapter(this@MainActivity)
            mainAdapter?.setArticles(articles)
            mainRecyclerView.adapter = mainAdapter
        }
    }

    override fun updateDate(date: String) {
        tbDate.text = date
    }

    override fun displayDateIncrement(visible: Boolean) {
        Log.d("hamed", "Date Inc visibility: $visible")
        btnAfter.visibility = if(visible) View.VISIBLE else View.INVISIBLE
    }

    override fun displayDateDecrement(visible: Boolean) {
        Log.d("hamed", "Date Decrement visibility: $visible")
        btnBefore.visibility = if(visible) View.VISIBLE else View.INVISIBLE
    }

    override fun onResume() {
        super.onResume()
        presenter.let {
            it?.getArticlesList()
        } ?: run {
            createPresenter()
            presenter?.getArticlesList()
        }
    }
}
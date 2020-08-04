package com.hamed.articlesviewer.screens

import com.hamed.articlesviewer.BaseKoinTest
import com.hamed.articlesviewer.screens.home.Main
import com.hamed.articlesviewer.screens.home.MainPresenter
import com.nhaarman.mockitokotlin2.times
import com.nhaarman.mockitokotlin2.verify
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito


class MainPresenterTest : BaseKoinTest() {

    @Mock
    lateinit var view: Main.MainView
    lateinit var mainPresenter: MainPresenter

    @Before
    override fun setupTests() {
        super.setupTests()

        mainPresenter = Mockito.mock(MainPresenter::class.java)
        mainPresenter.onAttach(view)
    }

    @Test
    fun getArticleListTest() {
        mainPresenter.onResume()
        mainPresenter.onPause()

        verify(mainPresenter, times(1)).onAttach(view)
        verify(mainPresenter, times(1)).onResume()
        verify(mainPresenter, times(1)).onPause()
    }
}
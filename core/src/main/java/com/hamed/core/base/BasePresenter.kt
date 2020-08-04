package com.hamed.core.base

/**
 * BasePresenter
 *
 * Basic interface for all presenters to follow
 * Mimics activity/fragment lifecycle
 *
 */
interface BasePresenter<T : BaseView?> {

    /**
     * Holds a reference to the base view model attached
     * to this presenter
     * @param view
     */
    fun onAttach(view: BaseView?)

    fun onDetach()

    fun onResume()

    fun onPause()

    fun onStop()

    fun onDestroy()
}
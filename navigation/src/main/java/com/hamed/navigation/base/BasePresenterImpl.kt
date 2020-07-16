package com.hamed.navigation.base

import android.util.Log
import androidx.annotation.CallSuper
import io.reactivex.disposables.CompositeDisposable

/**
 * BasePresenterImpl
 * Basic implementation for all presenters to follow
 *
 *
 */
abstract class BasePresenterImpl<T : BaseView?> : BasePresenter<T> {

    /**
     * The BaseView model attached to this presenter
     */
    @JvmField
    protected var view: T? = null

    /**
     * CompositeDisposable for presenter
     */
    @JvmField
    protected var composite = CompositeDisposable()

    @JvmField
    protected var backgroundComposite = CompositeDisposable()

    override fun onAttach(view: BaseView?) {
        this.view = view as T?
    }

    override fun onDetach() {
        view = null
    }

    @CallSuper
    override fun onResume() {
        Log.d("BasePresenterImpl", "onResume called")
    }

    @CallSuper
    override fun onPause() {
        Log.d("BasePresenterImpl", "onPause called")
        composite.clear()
    }

    @CallSuper
    override fun onStop() {
        Log.d("BasePresenterImpl", "onStop called")
        backgroundComposite.clear()
    }

    @CallSuper
    override fun onDestroy() {
        Log.d("BasePresenterImpl", "onDestroy called")
    }
}
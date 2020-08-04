package com.hamed.core.base

import android.app.Dialog
import android.os.Bundle

/**
 * BaseActivity
 *
 *
 */
abstract class BaseActivity<P : BasePresenter<*>> : BaseCalligraphyActivity(), BaseView {

    @JvmField
    protected var presenter: P? = null

    protected abstract fun createPresenter(): P

    private var dialogs = ArrayList<Dialog>()

    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (presenter == null) {
            presenter = createPresenter()
        }
        presenter?.onAttach(this)
        setContentView(getLayoutResource())

        if (supportActionBar != null)
            supportActionBar?.hide()
    }

    public override fun onResume() {
        super.onResume()
        presenter?.onResume()
    }

    public override fun onPause() {
        presenter?.onPause()
        super.onPause()
    }

    override fun onStop() {
        presenter?.onStop()
        super.onStop()
    }

    override fun onDestroy() {
        dismissDialogs()
        presenter?.onDetach()
        super.onDestroy()
    }

    protected fun addDialog(dialog: Dialog) {
        dialogs.add(dialog)
    }

    private fun dismissDialogs() {
        dialogs.forEach { dialog -> dialog.dismiss() }
    }
}
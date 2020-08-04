package com.hamed.core.base

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import com.hamed.core.R
import io.reactivex.disposables.CompositeDisposable
import uk.co.chrisjenx.calligraphy.CalligraphyContextWrapper

open class BaseCalligraphyActivity : AppCompatActivity() {
    @JvmField
    protected var composite = CompositeDisposable()

    override fun attachBaseContext(newBase: Context) {
        super.attachBaseContext(CalligraphyContextWrapper.wrap(newBase))
    }

    override fun onStop() {
        super.onStop()
        composite.clear()
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.short_fade_in, R.anim.short_fade_out)
    }

    override fun startActivity(intent: Intent) {
        super.startActivity(intent)
        overridePendingTransition(R.anim.short_fade_in, R.anim.short_fade_out)
    }

    override fun startActivityForResult(intent: Intent, requestCode: Int) {
        super.startActivityForResult(intent, requestCode)
        overridePendingTransition(R.anim.short_fade_in, R.anim.short_fade_out)
    }
}
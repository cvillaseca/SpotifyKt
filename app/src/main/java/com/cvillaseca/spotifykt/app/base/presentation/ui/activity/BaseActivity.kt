package com.cvillaseca.spotifykt.app.base.presentation.ui.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import android.support.v7.app.AppCompatActivity
import butterknife.ButterKnife
import com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter.BasePresenter
import com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter.PresenterFactory
import com.cvillaseca.spotifykt.app.base.presentation.mvp.view.View
import com.cvillaseca.spotifykt.app.base.presentation.ui.loader.PresenterLoader
import java.util.concurrent.atomic.AtomicInteger

abstract class BaseActivity<PRESENTER : BasePresenter<VIEW>, VIEW : View> :
        AppCompatActivity(), LoaderManager.LoaderCallbacks<PRESENTER> {

    companion object {

        private val LOADER_ID = AtomicInteger(0)

        protected fun getBaseStartIntent(context: Context, activityClass: Class<out BaseActivity<*, *>>, clearStack: Boolean): Intent {
            val intent = Intent(context, activityClass)
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            if (clearStack) {
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
            }
            return intent
        }
    }

    protected var presenter: PRESENTER? = null

    var view: VIEW? = null
        protected set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = initView()

        setContentView(layout)
        ButterKnife.bind(this)
        supportLoaderManager.initLoader(LOADER_ID.getAndIncrement(), null, this)
    }

    override fun onResume() {
        super.onResume()
        presenter?.resume()
    }

    override fun onPause() {
        presenter?.pause()
        super.onPause()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter?.detachView()
        presenter = null
    }

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<PRESENTER> {
        return PresenterLoader(this, presenterFactory())
    }

    override fun onLoadFinished(loader: Loader<PRESENTER>, presenter: PRESENTER) {
        this.presenter = presenter
        onLoadFinished()
        presenter.attachView(view!!)
    }

    open fun onLoadFinished() {}

    override fun onLoaderReset(loader: Loader<PRESENTER>) {
        onLoadReset()
    }

    fun onLoadReset() {}

    protected abstract fun presenterFactory(): PresenterFactory<PRESENTER>

    protected abstract fun initView(): VIEW

    protected abstract val layout: Int
}
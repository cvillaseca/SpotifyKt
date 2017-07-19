package com.cvillaseca.spotifykt.app.base.presentation.mvp.view

import android.app.Activity
import android.app.Service
import android.content.Context
import android.os.IBinder
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v4.widget.SwipeRefreshLayout
import android.view.inputmethod.InputMethodManager
import com.cvillaseca.spotifykt.R
import com.cvillaseca.spotifykt.app.base.presentation.mvp.presenter.BasePresenter
import com.cvillaseca.spotifykt.app.base.presentation.util.ProgressDialogHelper

abstract class ViewImpl : View {
    private var activity: Activity? = null

    private var fragment: Fragment? = null

    private var view: android.view.View? = null

    private var service: Service? = null

    private var progressDialogHelper: ProgressDialogHelper? = null

    constructor(activity: Activity) {
        this.activity = activity
        init()
    }

    constructor(fragment: Fragment) {
        this.fragment = fragment
        init()
    }

    constructor(view: android.view.View) {
        this.view = view
    }

    constructor(service: Service) {
        this.service = service
        init()
    }

    private fun init() {
        progressDialogHelper = ProgressDialogHelper()
    }

    override fun showMessage(message: String) {
        if (snackBarBackground == null) {
            return
        }
        Snackbar.make(snackBarBackground!!, message, Snackbar.LENGTH_SHORT).show()
    }

    override fun showMessage(messageResId: Int) {
        if (context == null) {
            return
        }
        showMessage(context!!.getString(messageResId))
    }

    override fun showProgress() {
        if (context == null) {
            return
        }
        progressDialogHelper!!.showProgress(context, context!!.getString(R.string.loading))
    }

    override fun showProgress(message: String) {
        progressDialogHelper!!.showProgress(context, message)
    }

    override fun showProgress(messageResId: Int) {
        if (context == null) {
            return
        }
        showProgress(context!!.getString(messageResId))
    }

    override fun showProgress(message: String, title: String) {
        progressDialogHelper!!.showProgress(context, message, title)
    }

    override fun showProgress(messageResId: Int, titleResId: Int) {
        if (context == null) {
            return
        }
        showProgress(context!!.getString(messageResId), context!!.getString(titleResId))
    }

    override fun hideProgress() {
        progressDialogHelper!!.hideProgress()
    }

    override fun hideKeyboard() {
        if (context == null || windowToken == null) {
            return
        }
        val imm = context!!.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(windowToken, 0)
    }

    fun initSwipeToRefresh(swipeRefreshLayout: SwipeRefreshLayout, presenterImpl: BasePresenter<View>) {
        swipeRefreshLayout.setOnRefreshListener {
            swipeRefreshLayout.isRefreshing = false
            presenterImpl.refreshData()
        }
    }

    private val context: Context?
        get() {
            if (activity != null) {
                return activity
            } else if (fragment != null) {
                return fragment!!.context
            } else if (view != null) {
                return view!!.context
            } else if (service != null) {
                return service
            }
            return null
        }

    private val snackBarBackground: android.view.View?
        get() {
            if (activity != null) {
                return activity!!.findViewById(android.R.id.content)
            } else if (view != null) {
                return view
            } else if (fragment != null) {
                return fragment!!.view
            }
            return null
        }

    private val windowToken: IBinder?
        get() {
            if (activity != null) {
                val view = activity!!.currentFocus
                return view?.windowToken
            } else if (fragment != null) {
                val activity = fragment!!.activity ?: return null
                val view = activity.currentFocus
                return view?.windowToken
            } else if (view != null) {
                return view!!.windowToken
            }
            return null
        }
}
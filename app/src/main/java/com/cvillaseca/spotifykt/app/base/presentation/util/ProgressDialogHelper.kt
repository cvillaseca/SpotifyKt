package com.cvillaseca.spotifykt.app.base.presentation.util

import android.app.ProgressDialog
import android.content.Context

class ProgressDialogHelper {

    var dialog: ProgressDialog? = null
        private set

    @Volatile private var progressesCount = 0

    @JvmOverloads fun showProgress(context: Context?, message: String? = null, title: String? = null) {
        if (context == null) {
            return
        }

        if (!inProgress()) {
            dialog = ProgressDialog(context)
            if (message != null) dialog!!.setMessage(message)
            if (title != null) dialog!!.setTitle(title)
            dialog!!.isIndeterminate = true
            dialog!!.setCanceledOnTouchOutside(false)
            dialog!!.show()
        }

        progressesCount++
    }

    fun hideProgress() {
        progressesCount--
        if (progressesCount <= 0) {
            if (dialog != null && dialog!!.isShowing) {
                dialog!!.dismiss()
            }
            progressesCount = 0
        }

    }

    private fun inProgress(): Boolean {
        return dialog != null && dialog!!.isShowing
    }
}

package com.cvillaseca.spotifykt.login.presentation

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.airbnb.mvrx.BaseMvRxFragment
import com.airbnb.mvrx.Loading
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.google.android.material.snackbar.Snackbar
import com.cvillaseca.spotifykt.login.R
import com.cvillaseca.spotifykt.presentation.hideKeyboard
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

@AndroidEntryPoint
class LoginFragment : BaseMvRxFragment(R.layout.activity_login) {

    @Inject
    lateinit var viewModelFactory: LoginViewModel.Factory

    private var dialog: ProgressDialog? = null

    private val viewModel: LoginViewModel by fragmentViewModel()

    override fun invalidate() = withState(viewModel) {
        if (it.loggedIn is Loading) loading()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        login_bt.setOnClickListener {
            viewModel.login(
                username.text.toString(),
                password.text.toString()
            )
        }
        subscribe()
    }

    private fun subscribe() {
        viewModel.asyncSubscribe(
            LoginState::loggedIn,
            onSuccess = { success() },
            onFail = { error(it.message!!) }
        )
    }

    private fun loading() {
        requireActivity().hideKeyboard()
        dialog = ProgressDialog.show(
            requireContext(), "",
            "Loading. Please wait...", true
        )
        dialog?.show()
    }

    private fun success() {
        dialog?.hide()
        Toast.makeText(requireContext(), "logged in!!", Toast.LENGTH_LONG).show()
    }

    private fun error(message: String) {
        dialog?.hide()
        val snackbar = Snackbar.make(login_bt, message, Snackbar.LENGTH_INDEFINITE)
        snackbar.setAction("Ok") {
            snackbar.dismiss()
        }
        snackbar.show()
    }
}
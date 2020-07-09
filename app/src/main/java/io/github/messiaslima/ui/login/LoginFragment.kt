package io.github.messiaslima.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import io.github.messiaslima.R
import io.github.messiaslima.common.event.EventObserver
import io.github.messiaslima.databinding.LoginFragmentBinding
import io.github.messiaslima.exception.LoginException
import org.koin.android.viewmodel.ext.android.viewModel

class LoginFragment : Fragment() {

    private val viewModel: LoginViewModel by viewModel()
    private lateinit var binding: LoginFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = LoginFragmentBinding.inflate(inflater, container, false)
        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupLoginButton()
        setupForgotPasswordMessage()
        setupErrorMessage()
        setupSignInEventHandler()
    }

    private fun setupSignInEventHandler() {
        viewModel.signInEvent.observe(
            viewLifecycleOwner,
            EventObserver {
                it ?: return@EventObserver
                if (it) {
                    navigateToHome()
                } else {
                    binding.signInPassTextInputLayout.helperText =
                        getString(R.string.wrong_credentials)
                }
            }
        )
    }

    private fun setupErrorMessage() = viewModel.error.observe(
        viewLifecycleOwner,
        Observer {
            binding.signInPassTextInputLayout.helperText = getErrorMessage(it)
        }
    )

    private fun getErrorMessage(throwable: Throwable?): String? {
        if (throwable == null) return null
        val textResource = when (throwable) {
            is LoginException -> R.string.error_login
            else -> R.string.error_generic
        }
        return getString(textResource)
    }

    private fun setupForgotPasswordMessage() = binding.signInForgotPassButton.setOnClickListener {
        Snackbar.make(binding.root, R.string.forgot_message, Snackbar.LENGTH_INDEFINITE).apply {
            setAction(R.string.ok) { dismiss() }
        }.show()
    }

    private fun setupLoginButton() = binding.signInLoginButton.setOnClickListener {
        viewModel.performSignIn(
            binding.signInLoginEditText.editableText.toString(),
            binding.signInPasswordEditText.editableText.toString()
        )
    }

    private fun navigateToHome() {
        val direction = LoginFragmentDirections.login(
            binding.signInLoginEditText.editableText.toString()
        )
        findNavController().navigate(direction)
    }
}

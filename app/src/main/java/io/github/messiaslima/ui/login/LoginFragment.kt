package io.github.messiaslima.ui.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import org.koin.android.viewmodel.ext.android.viewModel
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import io.github.messiaslima.R
import io.github.messiaslima.databinding.LoginFragmentBinding

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
    }

    private fun setupForgotPasswordMessage() = binding.signInForgotPassButton.setOnClickListener {
        Snackbar.make(binding.root, R.string.forgot_message, Snackbar.LENGTH_INDEFINITE).apply {
            setAction(R.string.ok) { dismiss() }
        }.show()
    }

    private fun setupLoginButton() = binding.signInLoginButton.setOnClickListener {
        viewModel.performLogin(
            binding.signInLoginEditText.editableText.toString(),
            binding.signInPasswordEditText.editableText.toString()
        )
    }

    private fun navigateToHome() {
        val direction = LoginFragmentDirections.login()
        findNavController().navigate(direction)
    }
}

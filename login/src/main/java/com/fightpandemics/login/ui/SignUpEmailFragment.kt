package com.fightpandemics.login.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.fightpandemics.login.R

class SignUpEmailFragment : Fragment() {

    /*@Inject
    lateinit var loginViewModelFactory: ViewModelFactory

    private lateinit var viewModel: LoginViewModel

    private var validEmail: Boolean = false
    private var validPassword: Boolean = false
    private var validRePassword: Boolean = false

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Obtaining the login graph from LoginActivity and instantiate
        // the @Inject fields with objects from the graph
        (activity as LoginActivity).loginComponent.inject(this)

        // Now you can access loginViewModel here and onCreateView too
        // (shared instance with the Activity and the other Fragment)
    }*/

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_sign_up_email, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        /*viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        tv_sigin_instead.setOnClickListener {
            (activity as LoginActivity).replaceFragment(SignInFragment.newInstance(), true)
        }

        et_email.validateET(
            "Please enter a valid email address",
            tilEmail
        ) { s -> s.isValidEmail() }

        et_password.validateET(
            "Please enter a valid password",
            tilPassword
        ) { s -> s.isValidPassword() }

        et_repassword.validateET("Please repeat same password", tilRePassword) { s ->
            s.isValidRePassword(
                et_password.getString()
            )
        }

        back_arrow.setOnClickListener {
            activity?.onBackPressed()
        }

        cl_btn_join.setOnClickListener {
            if (validEmail && validPassword && validRePassword) {
                executeSignUp(
                    et_email.text.toString().trim(),
                    et_password.text.toString().trim(),
                    et_repassword.text.toString().trim()
                )
            }
        }
        observeSignUp()*/
    }

    private fun executeSignUp(email: String, password: String, confirmPassword: String) {
        //viewModel.executeSignUp(email, password, confirmPassword)
    }

    /*private fun EditText.validateET(
        message: String,
        textInputLayout: TextInputLayout,
        validator: (String) -> Boolean
    ): Boolean {
        this.afterTextChanged {
            val isValid = validator(it)
            if (!isValid) {
                textInputLayout.isErrorEnabled = true
                textInputLayout.error = message
            } else {
                textInputLayout.isErrorEnabled = false
            }

            checkValidations(isValid, textInputLayout.id)
        }

        return validator(this.getString())
    }

    private fun checkValidations(boolean: Boolean, id: Int) {
        when (id) {
            tilEmail.id -> validEmail = boolean
            tilPassword.id -> {
                validPassword = boolean
                if (!et_repassword.isEmpty())
                    et_repassword.text = et_repassword.text
            }
            tilRePassword.id -> validRePassword = boolean
        }
        checkLayoutSignUpButton()
    }

    private fun checkLayoutSignUpButton() {
        if (validEmail && validPassword && validRePassword) {
            val filter: ColorFilter = PorterDuffColorFilter(
                resources.getColor(R.color.colorPrimary),
                PorterDuff.Mode.SRC_ATOP
            )
            cl_btn_join.background.colorFilter = filter
        } else {
            val filter: ColorFilter = PorterDuffColorFilter(
                resources.getColor(R.color.color_button_disabled),
                PorterDuff.Mode.SRC_ATOP
            )
            cl_btn_join.background.colorFilter = filter
        }
    }

    private fun observeSignUp() {
        viewModel.signUp.observe(viewLifecycleOwner, { result ->
            when (result) {
                Result.Loading -> {
                    progressDialog.show()
                }
                is Result.Success -> {
                    progressDialog.hide()
                    if (!result.data!!.message.isNullOrEmpty()) {
                        et_password.snack(message = result.data.message)
                    }
                    et_repassword.snack(
                            message = "Registration Successful, Check your email and verify account to login",
                            actionText = "LOGIN",
                            actionCallBack = {
                                navigateToSignIn()
                            }, length = Snackbar.LENGTH_INDEFINITE
                    )
                }
                is Result.Error -> {
                    progressDialog.hide()
                    et_repassword.snack(message = result.exception.localizedMessage)
                }
            }
        })
    }

    private fun navigateToSignIn() {
        (activity as LoginActivity).replaceFragment(SignInFragment.newInstance(), true)
    }*/
}
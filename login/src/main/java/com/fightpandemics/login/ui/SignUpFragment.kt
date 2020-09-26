package com.fightpandemics.login.ui

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.fightpandemics.login.R
import com.fightpandemics.login.dagger.LoginComponent
import com.fightpandemics.login.dagger.LoginComponentProvider
import com.fightpandemics.utils.ViewModelFactory
import javax.inject.Inject

class SignUpFragment : Fragment() {

    @Inject
    lateinit var loginViewModelFactory: ViewModelFactory

    private lateinit var viewModel: LoginViewModel
    // Reference to the Login graph
    lateinit var loginComponent: LoginComponent

    override fun onAttach(context: Context) {
        super.onAttach(context)
        // Obtaining the login graph from LoginActivity and instantiate
        // the @Inject fields with objects from the graph
        // Reference to the Login graph
        loginComponent = (requireActivity().applicationContext as LoginComponentProvider)
            .provideLoginComponent()

        loginComponent.inject(this)

        //(activity).loginComponent.inject(this)

        // Now you can access loginViewModel here and onCreateView too
        // (shared instance with the Activity and the other Fragment)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sign_up, container, false)
    }
}
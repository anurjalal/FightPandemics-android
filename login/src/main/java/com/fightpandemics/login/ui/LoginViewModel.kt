package com.fightpandemics.login.ui

import com.fightpandemics.core.data.model.login.User
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fightpandemics.core.dagger.scope.ActivityScope
import com.fightpandemics.core.data.model.login.LoginRequest
import com.fightpandemics.core.data.model.login.LoginResponse
import com.fightpandemics.core.result.Result
import com.fightpandemics.login.domain.LoginUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.async
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@ExperimentalCoroutinesApi
@ActivityScope
class LoginViewModel @Inject constructor(
    private val loginUseCase: LoginUseCase
) : ViewModel() {
    private val _login = MutableLiveData<LoginViewState>()
    val login: LiveData<LoginViewState> = _login

    @ExperimentalCoroutinesApi
    fun doLogin(email: String, password: String) {
        _login.value?.isLoading = true

        viewModelScope.launch {
            val deferredLogin = async {
                loginUseCase(LoginRequest(email, password))
            }
            deferredLogin.await().catch {

            } .collect {
                when (it) {
                    is Result.Success -> {
                        val loginResponse = it.data as LoginResponse
                        _login.value = LoginViewState(
                            false,
                            loginResponse.email,
                            loginResponse.emailVerified!!,
                            loginResponse.token,
                            loginResponse.user,
                            null
                        )
                    }
                    is Result.Error -> {
                        _login.value = LoginViewState(
                            false,
                            null,
                            false,
                            null,
                            null,
                            it.exception.message.toString()
                        )
                    }
                }
            }
        }
    }
}

/**
 * UI Models for [SignInEmailFragment].
 */
data class LoginViewState(
    var isLoading: Boolean,
    val email: String?,
    val emailVerified: Boolean,
    val token: String?,
    val user: User?,
    val error: String?
)


/*
*
* class LoginViewModel @Inject constructor(private val repository: DataRepository) : ViewModel() {

    private val _signUp = MutableLiveData<Result<SignUpModel>>()
    val signUp: LiveData<Result<SignUpModel>> = _signUp

    private val _changePassword = MutableLiveData<Result<ChangePasswordModel>>()
    val changePassword: LiveData<Result<ChangePasswordModel>> = _changePassword

    fun executeSignUp(email: String, password: String, confirmPassword: String) {
        val signUpRequest = SignUpRequest(email, password, confirmPassword)
        _signUp.postValue(Result.Loading)
        viewModelScope.launch {
            try {
                val response = repository.signUp(signUpRequest)
                if (response.isSuccessful && response.code() == 0) {
                    val model = SignUpDataMapper().transformRemoteToLocal(response.body()!!)
                    _signUp.postValue(Result.Success(model))
                    //Consume the response here - Save it to local or display to the User if needed
                } else {
                    _signUp.postValue(Result.Error(Exception(response.message())))
                }
            } catch (error: Throwable) {
                _signUp.postValue(Result.Error(error))
            }
        }
    }

    fun changePassword(email: String) {
        viewModelScope.launch {
            try {
                val response = repository.changePassword(email)
                if (response.isSuccessful && response.code() == 0) {
                    val model = ChangePasswordDataMapper().transformRemoteToLocal(response.body()!!)
                    _changePassword.postValue(Result.Success(model))
                    //Consume the response here - Save it to local or display to the User if needed
                } else {
                    _changePassword.postValue(Result.Error(Exception(response.message())))
                }
            } catch (error: Throwable) {
                _changePassword.postValue(Result.Error(error))
            }
        }
    }
}
* */
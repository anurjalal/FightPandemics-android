package com.fightpandemics.data.remote.login

import com.fightpandemics.data.api.FightPandemicsAPI
import com.fightpandemics.data.model.login.*
import retrofit2.Response
import javax.inject.Inject

class LoginRemoteDataSourceImpl @Inject constructor(
    private val fightPandemicsAPI: FightPandemicsAPI,
) : LoginRemoteDataSource {

    override suspend fun login(loginRequest: LoginRequest): Response<LoginResponse> =
        fightPandemicsAPI.login(loginRequest)



    override suspend fun signUp(signUpRequest: SignUpRequest): Response<SignUpResponse> =
        fightPandemicsAPI.signUp(signUpRequest)

    override suspend fun changePassword(email: String): Response<ChangePasswordResponse> =
        fightPandemicsAPI.changePassword(email)
}
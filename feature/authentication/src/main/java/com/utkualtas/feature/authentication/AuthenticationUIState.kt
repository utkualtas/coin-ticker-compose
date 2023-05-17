package com.utkualtas.feature.authentication

data class AuthenticationUIState(
    val authType: AuthenticationType = AuthenticationType.REGISTER,
    val email: String = "",
    val password: String = "",
    val message: String? = null,
    val navigateBack: Boolean = false,
) {
    val title: String
        get() = when (authType) {
            AuthenticationType.LOGIN -> "LOGIN"
            AuthenticationType.REGISTER -> "REGISTER"
        }

    val proceedButtonTitle: String
        get() = when (authType) {
            AuthenticationType.LOGIN -> "LOGIN"
            AuthenticationType.REGISTER -> "REGISTER"
        }

    val switchButtonTitle: String
        get() = when (authType) {
            AuthenticationType.LOGIN -> "You don't have an account? REGISTER!"
            AuthenticationType.REGISTER -> "Already registered? Click here to LOGIN!"
        }

}

enum class AuthenticationType {
    LOGIN,
    REGISTER
}
package com.tech.modularization.auth.validators

import com.tech.modularization.common.utils.validator.InputValidator
import javax.inject.Inject

enum class AuthParam{
    EMAIL,
    PASSWORD
}
class ValidatorFactory @Inject constructor(){

    private  val validators : Map<AuthParam, InputValidator> = mapOf(
        AuthParam.EMAIL to EmailValidator(),
        AuthParam.PASSWORD to PasswordValidator()
    )
    fun get(param : AuthParam) : InputValidator{
        return validators[param] ?: throw IllegalArgumentException("Incorrect parameter given,validator not found")
    }
}
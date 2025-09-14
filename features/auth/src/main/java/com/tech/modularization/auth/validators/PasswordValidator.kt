package com.tech.modularization.auth.validators

import com.tech.auth.R
import com.tech.modularization.common.utils.validator.InputValidator
import com.tech.modularization.common.utils.validator.ValidationResult

class PasswordValidator : InputValidator {
    override fun validate(input: String): ValidationResult {

        return if(input.length < 4){
            ValidationResult(R.string.password_length_error)
        }else{
            ValidationResult()
        }
    }
}
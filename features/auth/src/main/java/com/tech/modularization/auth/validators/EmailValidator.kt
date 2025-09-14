package com.tech.modularization.auth.validators

import com.tech.auth.R
import com.tech.modularization.common.utils.validator.InputValidator
import com.tech.modularization.common.utils.validator.ValidationResult

class EmailValidator : InputValidator {

    override fun validate(input: String): ValidationResult {
        val emailRegex = Regex("[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}")

        return if(input.isEmpty()){
            ValidationResult(R.string.email_empty)
        }else if(emailRegex.matches(input).not()){
            //error
            ValidationResult(R.string.invalid_email)
        }else{
            //validated
            ValidationResult()
        }
    }
}
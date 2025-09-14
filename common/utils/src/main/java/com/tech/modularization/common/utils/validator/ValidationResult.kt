package com.tech.modularization.common.utils.validator

data class ValidationResult(
    val errorMessage : Int? = null,
){
    val isValid : Boolean
        get() = errorMessage == null
}

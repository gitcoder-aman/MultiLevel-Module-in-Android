package com.tech.modularization.common.utils.validator

interface InputValidator {
    fun validate(input : String) : ValidationResult
}
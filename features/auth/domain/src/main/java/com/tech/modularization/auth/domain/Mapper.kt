package com.tech.modularization.auth.domain

interface Mapper<F,T> {
    fun map(from : F): T
}
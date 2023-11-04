package com.example.formvalidation.models.validations

import java.util.logging.ErrorManager

sealed class ValidationResult{
    data class Empty(val errorManager: String):ValidationResult()
    data class Invallied(val errorManager: String):ValidationResult()
    object Valied:ValidationResult()
}

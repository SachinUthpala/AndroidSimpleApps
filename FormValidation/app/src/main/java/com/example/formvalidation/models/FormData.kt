package com.example.formvalidation.models

import com.example.formvalidation.models.validations.ValidationResult

class FormData (
    private var studentID:String,
    private var year:String,
    private var semester:String,
    private var agree:Boolean
        ) {

    //creating validation part
    fun validationStudent():ValidationResult{

        return if(studentID.isEmpty()){
            ValidationResult.Empty("Student ID is Empty")
        }else if(studentID.startsWith("IT")){
            ValidationResult.Invallied("IT number should stats with IT")
        }else if(studentID.length != 10){
            ValidationResult.Invallied("Student ID Should contain 10 numbers")
        }else{
            ValidationResult.Valied
        }
    }

    //validate year
    fun validateYear():ValidationResult{
        return if(year.isEmpty()){
            ValidationResult.Empty("Year is Empty")
        }else{
            ValidationResult.Valied
        }
    }

    //cheacking semester
    fun validateSemester():ValidationResult{
        return  if(semester.isEmpty()){
            ValidationResult.Empty("Semester Is Empty")
        }else{
            ValidationResult.Valied
        }
    }

    //cheacking agreement

    fun validateAgree():ValidationResult{
        return if( !agree){
            ValidationResult.Invallied("You have to agree")
        }else{
            ValidationResult.Valied
        }
    }
}
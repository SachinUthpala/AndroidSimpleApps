package com.example.formvalidation

import android.icu.text.CaseMap.Title
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.formvalidation.models.FormData
import com.example.formvalidation.models.validations.ValidationResult
import kotlin.properties.Delegates

class MainActivity : AppCompatActivity() {

    //incicalising
    lateinit var studentId:EditText
    lateinit var year:Spinner
    lateinit var semester:Spinner
    lateinit var agree:CheckBox

    private var count = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        studentId = findViewById(R.id.stuid)
        year = findViewById(R.id.spyear)
        semester = findViewById(R.id.spsemester)
        agree = findViewById(R.id.cbagree)
    }

    fun displayAlert(title: String , message :String){
        var builder = AlertDialog.Builder(this)
        builder.setTitle(title)
        builder.setMessage(message)

        builder.setPositiveButton("OK"){
            dialod , which ->
        }

        var dialog = builder.create()
        dialog.show()
    }

    //for button
    fun submit(v:View){
        val myformdata = FormData(
            studentId.text.toString(),
            year.selectedItem.toString(),
            semester.selectedItem.toString(),
            agree.isChecked
        )

        val studentIdvalidation = myformdata.validationStudent()
        val yearvalidation = myformdata.validateYear()
        val semestervalidation = myformdata.validateSemester()
        val agreevalidation = myformdata.validateAgree()

        when(studentIdvalidation){
            is ValidationResult.Valied -> {
                count ++
            }

            is ValidationResult.Invallied ->{
                studentId.error = studentIdvalidation.errorManager
            }

            is ValidationResult.Empty ->{
                studentId.error = studentIdvalidation.errorManager
            }
        }

        when(yearvalidation){
            is ValidationResult.Valied -> {
                count++
            }

            is ValidationResult.Invallied ->{

            }

            is ValidationResult.Empty ->{
                val tv:TextView = year.selectedView as TextView
                tv.error =""
                tv.text = yearvalidation.errorManager
            }

        }

        when (semestervalidation){
            is ValidationResult.Valied -> {
                count++
            }

            is ValidationResult.Invallied -> {

            }

            is ValidationResult.Empty -> {
                val tv:TextView = semester.selectedView as TextView
                tv.error = ""
                tv.text = semestervalidation.errorManager
            }
        }

        when(agreevalidation){
            is ValidationResult.Empty -> {
                displayAlert("ERROR",agreevalidation.errorManager)
            }
            is ValidationResult.Invallied -> {

            }
            ValidationResult.Valied -> {
                count ++
            }
        }

        if(count == 4){
            displayAlert("SUCESS","YOU HAVE SUCESSFULLY REGISTERD")
        }else{
            count = 0
        }
    }
}
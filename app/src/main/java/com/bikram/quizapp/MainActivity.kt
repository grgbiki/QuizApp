package com.bikram.quizapp

import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.RadioButton
import android.widget.RadioGroup
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

class MainActivity : AppCompatActivity() {

    private lateinit var radioGroup: RadioGroup
    private lateinit var radioGoogle: RadioButton
    private lateinit var radioIdea: RadioButton
    private lateinit var radioJetBrains: RadioButton

    private lateinit var checkScore: CheckBox
    private lateinit var checkEncapsulation: CheckBox
    private lateinit var checkLiveData: CheckBox

    private lateinit var clearButton: Button
    private lateinit var submitButton: Button


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        radioGroup = findViewById(R.id.question_one_options)
        radioGoogle = findViewById(R.id.radio_google)
        radioIdea = findViewById(R.id.radio_idea)
        radioJetBrains = findViewById(R.id.radio_jetbrains)

        checkScore = findViewById(R.id.check_score)
        checkEncapsulation = findViewById(R.id.check_Encapsulation)
        checkLiveData = findViewById(R.id.check_LiveData)

        clearButton = findViewById(R.id.button_clear)
        submitButton = findViewById(R.id.button_submit)

        clearButton.setOnClickListener { clear() }

        submitButton.setOnClickListener {
            var totalScore = 0;
            if(radioJetBrains.id == radioGroup.checkedRadioButtonId){
                totalScore+=50
            }
            if(checkEncapsulation.isChecked && !checkLiveData.isChecked && !checkScore.isChecked ){
                totalScore+=50
            }
            val current = LocalDateTime.now()
            val formatter = DateTimeFormatter.ofPattern("d MMM yyyy hh:mm a")
            val alertDialogBuilder = AlertDialog.Builder(this)
            alertDialogBuilder.setTitle("Your Result")
            alertDialogBuilder.setMessage("Congratulations! You submitted on ${formatter.format(current)}, Your achieved $totalScore%")
            alertDialogBuilder.setPositiveButton("Close") { dialog, _ ->
                dialog.dismiss()
            }
            alertDialogBuilder.show()
        }
    }

    private fun clear() {
        radioGoogle.isChecked = false
        radioIdea.isChecked = false
        radioJetBrains.isChecked = false

        checkScore.isChecked = false
        checkEncapsulation.isChecked = false
        checkLiveData.isChecked = false
    }
}
package com.example.bmi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonCalc.setOnClickListener(this@MainActivity)
    }

    @SuppressLint("ShowToast")
    override fun onClick(v: View?) {





        if(bmiWeight.text?.isNotEmpty() == true && bmiHeight.text?.isNotEmpty() == true) {

            val weightBMI = bmiWeight.text.toString().toFloat()
            val heightBMI = bmiHeight.text.toString().toFloat()
            val myBMI = weightBMI / (heightBMI*heightBMI)

            showBMI.text = myBMI.toString()



            if(myBMI < 18.5){

                imageBMI.setImageResource(R.drawable.ic_underweight)
            }else if(myBMI >= 18.5 && myBMI < 24.9){

                imageBMI.setImageResource(R.drawable.ic_healthy)
            }else if(myBMI >= 24.9 && myBMI < 29.9){
                imageBMI.setImageResource(R.drawable.ic_overweight)
            }else if(myBMI >= 29.9){
                imageBMI.setImageResource(R.drawable.ic_obesity)
            }
        }else{
            Toast.makeText(this,"Do not leave fields blank", Toast.LENGTH_SHORT).show()
        }


    }
}
package com.example.widgets1_edittext_and_button

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AlertDialog

class MainActivity : AppCompatActivity() {


    //5) AlertDialog
    private lateinit var exitButton: Button
    private lateinit var builder: AlertDialog.Builder


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //1) Edittext and button widgets

        val e1 = findViewById(R.id.et1) as EditText
        val e2 = findViewById(R.id.et2) as EditText
        val e3= findViewById(R.id.et3) as EditText
        val btn: Button = findViewById(R.id.bt1)

        btn.setOnClickListener {
            val s1 = e1.text.toString().toInt()
            val s2 = e2.text.toString().toInt()

            val sum = s1 + s2
            Toast.makeText(applicationContext,sum.toString(), Toast.LENGTH_LONG).show()
            e3.setText(sum.toString())
        }

        //2)Checkboxes
        val cb1=findViewById<CheckBox>(R.id.cb1)
        val cb2=findViewById<CheckBox>(R.id.cb2)
        val cb3=findViewById<CheckBox>(R.id.cb3)
        val bt2:Button=findViewById(R.id.bt2)
        bt2.setOnClickListener{
            if(cb1.isChecked){
                Toast.makeText(this,"Kotlin is selected",Toast.LENGTH_LONG).show()
            }
            if(cb2.isChecked){
                Toast.makeText(this,"Java is selected",Toast.LENGTH_LONG).show()
            }
            if(cb3.isChecked){
                Toast.makeText(this,"Flutter is selected",Toast.LENGTH_LONG).show()
            }
        }

        //3) RadioButtons
        val rb1=findViewById<RadioButton>(R.id.rb1)
        val rb2=findViewById<RadioButton>(R.id.rb2)
        rb1.setOnClickListener{
            if(rb1.isChecked){
                Toast.makeText(this,"Male",Toast.LENGTH_LONG).show()
            }
        }
        rb2.setOnClickListener{
            if(rb2.isChecked){
                Toast.makeText(this,"Female",Toast.LENGTH_LONG).show()
            }
        }

        //4) Toggle Button
        val toggle=findViewById(R.id.toggleButton) as ToggleButton
        val imageView=findViewById(R.id.imageView) as ImageView
        toggle.setOnClickListener{
            if(toggle.text.toString()=="ON"){
                imageView.setImageResource(R.drawable.onimage)
            }else{
                imageView.setImageResource(R.drawable.offimage)
            }
        }

        //5) AlertDialog
        exitButton= findViewById(R.id.extbtn)
        //we have simple button,on click on that we will get dialog box
        builder=AlertDialog.Builder(this)
        exitButton.setOnClickListener{
            builder.setTitle("Alert!")
                .setMessage("Do you want to exit?")
                .setCancelable(true) //dialog box in cancellable
                .setPositiveButton("Yes"){dialogInterface,it->  //set positive buttn with 2 parameters dialogInterface and it
                    finish()  //close the app when yes clicked
                }
                .setNegativeButton("No"){dialogInterface,it->
                    //cancel the dialog
                    dialogInterface.cancel()
                }
                .setNeutralButton("Help"){dialogInterface,it->
                    Toast.makeText(this@MainActivity,"Help has been clicked",Toast.LENGTH_LONG).show()
                }.show() //show the builder
        }
    }
}

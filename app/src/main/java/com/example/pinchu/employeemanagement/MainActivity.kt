package com.example.pinchu.employeemanagement

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_employee_details.*

class MainActivity : AppCompatActivity() {


    val TAG: String = "MainActivity"
    var empList = ArrayList<Employee>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_employee_details)

        btnAdd.setOnClickListener{
            Toast.makeText(this, "Add Form", Toast.LENGTH_LONG).show()
            val i = Intent(this, SampleActivity::class.java)
            startActivity(i)

        }


        btnLV.setOnClickListener{
            Log.d(TAG,"--------------------------LISTVIEW")
            val i  = Intent(this, ListView::class.java)
            Toast.makeText(this, "List View", Toast.LENGTH_LONG).show()
            startActivity(i)
        }
    }


}

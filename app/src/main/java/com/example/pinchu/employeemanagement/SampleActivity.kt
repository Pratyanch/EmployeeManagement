package com.example.pinchu.employeemanagement

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_sample.*


class SampleActivity : AppCompatActivity() {

    var empList = ArrayList<Employee>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sample)

        btnMain.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        btnsubmit.setOnClickListener {
            Toast.makeText(this, "Added", Toast.LENGTH_LONG).show()
            val name = sampleName.text.toString().toUpperCase()
            val id = sampleID.text.toString().toUpperCase()
            val dept = sampleDept.text.toString().toUpperCase()
            val address = sampleAddress.text.toString().toUpperCase()
            //val isManager = sampleManager.text.toString().toLowerCase() as Boolean
            textViewMessage.text = "$name + $id + $dept+ $address"

            val i = Intent(this, ListView::class.java)
            i.putExtra("name", name)
            i.putExtra("id", id)
            i.putExtra("dept", dept)
            i.putExtra("address", address)
            //i.putExtra("manager", isManager)
            startActivity(i)

        }

    }


}
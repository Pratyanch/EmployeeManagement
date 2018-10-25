package com.example.pinchu.employeemanagement

import android.os.Bundle
import android.support.v7.app.AppCompatActivity;

import kotlinx.android.synthetic.main.activity_detail__des.*

class Detail_Des : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail__des)
        val bundle=intent.extras as Bundle
        var name = bundle.getString ("name")
        var id = bundle.getString("id")
        var dept = bundle.getString("dept")
        var address = bundle.getString("address")
        var image:Int = bundle.getInt("image")

        tvDetName.text = name
        tvDetid.text = id
        tvDetAdd.text = address
        tvDetDept.text = dept
        ivDetImage.setImageResource(image)



        }
    }



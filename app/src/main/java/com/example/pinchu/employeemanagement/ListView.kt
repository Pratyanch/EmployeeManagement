package com.example.pinchu.employeemanagement

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_list_view.*
import kotlinx.android.synthetic.main.employee_description.view.*
import kotlinx.android.synthetic.main.manager_description.view.*

class ListView : AppCompatActivity() {
    var empList = ArrayList<Employee>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_view)
        empList.add(Employee("raj", "4518", "delhi", "computer", false, R.drawable.male2))
        empList.add(Employee("raman", "4517", "bangalore", "account", false, R.drawable.mohawk))

        var listie = findViewById<android.widget.ListView>(R.id.listview)
        var lv = findViewById<Button>(R.id.btnAdd)
        listie.adapter = MyAdapter(this, empList)

        if(intent != null && intent.extras != null) {
            val bundle = intent.extras as Bundle
            var newName = bundle.getString("name")
            var newID = bundle.getString("id")
            var newDept = bundle.getString("dept")
            var newAddress = bundle.getString("address")
            var newManager = bundle.getBoolean("manager")
            empList.add(Employee(newName!!.toString(), newID!!.toString(), newAddress!!.toString(), newDept!!.toString(), newManager, R.drawable.sardar))
        }

        btnHome.setOnClickListener {
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

        btnAdd.setOnClickListener {
            val i = Intent(this, SampleActivity::class.java)
            startActivity(i)
        }

        btnSearch.setOnClickListener {
            val strValue = editTextSearch.text.toString()
            Log.d("Button Click", empList.toString())
            for (i in 0 until empList.size) {
                if (strValue.equals(empList[i].id)) {
                    var searchName = empList[i].name
                    Toast.makeText(this, "The Employee is $searchName", Toast.LENGTH_LONG).show()
                    break
                }
            }
        }

        btnDelete.setOnClickListener{
            val strValue = editTextSearch.text.toString()
            for (i in 0 until empList.size){
                if ((strValue.equals(empList[i].id) )|| (empList[i].id.equals(strValue))){
                    empList.remove(empList[i])
                }
            }
        }
    }

}

class MyAdapter : BaseAdapter {
    private var empList = ArrayList<Employee>()
    var context: Context? = null

    constructor(context: Context, emp_List: ArrayList<Employee>) : super() {
        this.context = context
        this.empList = emp_List
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        var employee = empList[position]
        if (employee.isManager) {
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myview = inflater.inflate(R.layout.manager_description, null)
            myview.tvNameMan.text = employee.name
            myview.tvIDMan.text = employee.id
            myview.tvDeptMan.text = employee.dept
            myview.tvAddressMan.text = employee.address
            myview.imageViewMan.setImageResource(employee.image!!)
            myview.imageViewMan.setOnClickListener {
                val intent = Intent(context, Detail_Des::class.java)
                intent.putExtra("name", employee.name)
                intent.putExtra("id", employee.id)
                intent.putExtra("address", employee.address)
                intent.putExtra("dept", employee.dept)
                intent.putExtra("image", employee.image!!)
                context!!.startActivity(intent)

            }
            return myview
        } else {
            var inflater = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            var myview = inflater.inflate(R.layout.employee_description, null)
            myview.tvName.text = employee.name
            myview.tvID.text = employee.id
            myview.tvDept.text = employee.dept
            myview.tvAddress.text = employee.address
            myview.ivEm.setImageResource(employee.image!!)
            myview.ivEm.setOnClickListener {
                val intent = Intent(context, Detail_Des::class.java)
                intent.putExtra("name", employee.name!!)
                intent.putExtra("id", employee.id!!)
                intent.putExtra("address", employee.address!!)
                intent.putExtra("dept", employee.dept!!)
                intent.putExtra("image", employee.image!!)
                context!!.startActivity(intent)

            }
            return myview

        }
    }

    override fun getItem(position: Int): Any {
        return empList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return empList.size
    }

}



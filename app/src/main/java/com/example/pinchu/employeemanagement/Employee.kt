package com.example.pinchu.employeemanagement



class  Employee {
    var id: String? = null
    var name: String? = null
    var address: String? = null
    var dept: String? = null
    var isManager: Boolean = false
    var image: Int? = null

    constructor (name: String, id: String, address: String, dept: String, isManager: Boolean, image: Int) {
        this.name = name.toUpperCase()
        this.address = address.toUpperCase()
        this.dept = dept.toUpperCase()
        this.id = id.toUpperCase()
        this.isManager = isManager
        this.image = image

    }
}

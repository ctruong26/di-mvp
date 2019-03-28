package com.parrot.ctruong.diexample

interface SayHelloContract {

    interface View {
        fun showMessage(message: String)
        fun showError(error: String)
    }

    interface Presenter {
        fun loadMessage()
        fun saveName(firstName: String, lastName: String)
    }
}